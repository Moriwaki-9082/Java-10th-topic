package com.Moriwaki.Java10thtopic.service;



import com.Moriwaki.Java10thtopic.entity.Fish;
import com.Moriwaki.Java10thtopic.mapper.FishMapper;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FishServiceTest {
    @InjectMocks
    FishService fishService;

    @Mock
    FishMapper fishMapper;
    @Test
    public void 存在するユーザーのIDを指定したときに正常にユーザーが返されること() {
        doReturn(Optional.of(new Fish(1, "タイ", "2200g", "￥1400"))).when(fishMapper).findById(1);
        Fish actual = fishService.findFish(1);
        assertThat(actual).isEqualTo(new Fish(1, "タイ", "2200g", "￥1400"));
        verify(fishMapper, times(1)).findById(1);
    }
}
