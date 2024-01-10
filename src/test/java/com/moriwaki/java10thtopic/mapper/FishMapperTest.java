package com.moriwaki.java10thtopic.mapper;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.moriwaki.java10thtopic.entity.FishView;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FishMapperTest {

    @Autowired
    FishMapper fishMapper;

    @Test
    @DataSet(value = "datasets/fishView.yml")
    @Transactional
    void すべてのデータが取得できること() {
        List<FishView> fishes = fishMapper.findAll();
        assertThat(fishes)
                .hasSize(3)
                .contains(
                        new FishView(1, "タイ", "1036円/kg", "5kg"),
                        new FishView(2, "カニ", "1026円/kg", "7kg"),
                        new FishView(3, "マグロ", "4333円/kg","10kg")
                );
    }

    @Test
    @DataSet(value = "datasets/fishView.yml")
    @Transactional
    public void 存在するデータのIDを指定したときに正常にデータが返されること() {
        Optional<FishView> actual = fishMapper.findById(1);
        assertThat(actual).contains(new FishView(1, "タイ", "1036円/kg", "5kg"));
    }

}
