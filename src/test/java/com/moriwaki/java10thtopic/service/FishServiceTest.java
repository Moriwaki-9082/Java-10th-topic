package com.moriwaki.java10thtopic.service;

import com.moriwaki.java10thtopic.entity.Fish;
import com.moriwaki.java10thtopic.exception.FishNotFoundException;
import com.moriwaki.java10thtopic.mapper.FishMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FishServiceTest {

    @InjectMocks
    FishService fishService;

    @Mock
    FishMapper fishMapper;

    @Test
    public void 存在するユーザーのIDを指定したときに正常にユーザーが返されること() {
        doReturn(Optional.of(new Fish(1, "タイ", "2200g", "￥1400"))).when(fishMapper).findById(1);
        Fish actual = fishService.findById(1);
        assertThat(actual).isEqualTo(new Fish(1, "タイ", "2200g", "￥1400"));
        verify(fishMapper, times(1)).findById(1);
    }

    @Test
    public void 存在しないユーザーのIDを指定したときに例外処理が返されること() throws FishNotFoundException {
        doReturn(Optional.empty()).when(fishMapper).findById(100);
        assertThrows(FishNotFoundException.class, () -> {
                    fishService.findById(100);
                });
        verify(fishMapper, times(1)).findById(100);
    }

    @Test
    void すべてのユーザーが取得できること() {
        List<Fish> fishList = Arrays.asList(
                new Fish(1, "タイ", "2200g", "￥1400"),
                new Fish(2, "カニ", "500g","￥10000"),
                new Fish(3, "マグロ", "30000g","￥93510"));
        doReturn(fishList).when(fishMapper).findAll();
        List<Fish> fishes = fishService.findAll();
        assertThat(fishes)
                .hasSize(3)
                .contains(
                        new Fish(1, "タイ", "2200g","￥1400"),
                        new Fish(2, "カニ", "500g","￥10000"),
                        new Fish(3, "マグロ", "30000g","￥93510"));
        verify(fishMapper, times(1)).findAll();
    }
    
}
