package com.moriwaki.java10thtopic.service;

import com.moriwaki.java10thtopic.entity.Fish;
import com.moriwaki.java10thtopic.entity.FishView;
import com.moriwaki.java10thtopic.exception.FishAlreadyExistsException;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FishServiceTest {

    @InjectMocks
    FishService fishService;

    @Mock
    FishMapper fishMapper;

    @Test
    public void 指定したIDデータの検索表示テスト() {
        doReturn(Optional.of(new FishView(1, "タイ", "1036円/kg", "5kg"))).when(fishMapper).findById(1);
        FishView actual = fishService.findById(1);
        assertThat(actual).isEqualTo(new FishView(1, "タイ", "1036円/kg", "5kg"));
        verify(fishMapper, times(1)).findById(1);
    }

    @Test
    public void 指定したIDが存在しない場合の例外処理テスト() throws FishNotFoundException {
        doReturn(Optional.empty()).when(fishMapper).findById(100);
        assertThrows(FishNotFoundException.class, () -> {
            fishService.findById(100);
        });
        verify(fishMapper, times(1)).findById(100);
    }

    @Test
    void 全データの表示テスト() {
        List<FishView> fishList = Arrays.asList(
                new FishView(1, "タイ", "1036円/kg", "5kg"),
                new FishView(2, "カニ", "1026円/kg", "7kg"),
                new FishView(3, "マグロ", "4333円/kg", "10kg"));
        doReturn(fishList).when(fishMapper).findAll();
        List<FishView> fishes = fishService.findAll();
        assertThat(fishes)
                .hasSize(3)
                .contains(
                        new FishView(1, "タイ", "1036円/kg", "5kg"),
                        new FishView(2, "カニ", "1026円/kg", "7kg"),
                        new FishView(3, "マグロ", "4333円/kg", "10kg"));
        verify(fishMapper, times(1)).findAll();
    }

    @Test
    public void データの新規登録テスト() {
        Fish fish = new Fish(null, "カキ", 1003, 15);
        doNothing().when(fishMapper).insert(fish);
        Fish actual = fishService.insert(fish);
        assertThat(actual).isEqualTo(new Fish(null, "カキ", 1003, 15));
        verify(fishMapper, times(1)).insert(fish);
    }

    @Test
    public void 新規登録しようとしたデータ名が既に存在した場合の例外処理テスト() throws FishAlreadyExistsException {
        Fish fish = new Fish(1, "カキ", 1003, 15);
        doReturn(Optional.of(fish)).when(fishMapper).checkByName("カキ");
        assertThrows(FishAlreadyExistsException.class, () -> {
            fishService.insert(fish);
        });
        verify(fishMapper, times(1)).checkByName("カキ");
    }

    @Test
    public void データの更新処理テスト() {
        Fish fish = new Fish(1, "ウナギ", 5322, 13);
        doNothing().when(fishMapper).update(fish);
        doReturn(Optional.of(fish)).when(fishMapper).checkById(1);
        Fish actual = fishService.update(fish);
        assertThat(actual).isEqualTo(new Fish(1, "ウナギ", 5322, 13));
        verify(fishMapper, times(1)).update(fish);
    }

    @Test
    public void 存在しないデータを更新か削除しようした際の例外処理テスト() throws FishNotFoundException {
        Fish fish = new Fish(999, "ウナギ", 5322, 13);
        doReturn(Optional.empty()).when(fishMapper).checkById(999);
        assertThrows(FishNotFoundException.class, () -> {
            fishService.update(fish);
        });
        verify(fishMapper, times(1)).checkById(999);
    }

    @Test
    public void データの削除処理テスト() {
        Fish fish = new Fish(1, "ウナギ", 5322, 13);
        doNothing().when(fishMapper).delete(1);
        doReturn(Optional.of(fish)).when(fishMapper).checkById(1);
        int actual = fishService.delete(1);
        assertThat(actual).isEqualTo(1);
        verify(fishMapper, times(1)).delete(1);
    }
}
