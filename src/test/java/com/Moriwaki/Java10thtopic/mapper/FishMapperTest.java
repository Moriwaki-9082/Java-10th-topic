package com.Moriwaki.Java10thtopic.mapper;

import com.Moriwaki.Java10thtopic.entity.Fish;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FishMapperTest {

    @Autowired
    FishMapper fishMapper;

    @Test
    @DataSet(value = "datasets/fishes.yml")
    @Transactional
    void すべてのユーザーが取得できること() {
        List<Fish> fishes = fishMapper.findAll();
        assertThat(fishes)
                .hasSize(3)
                .contains(
                        new Fish(1, "タイ", "2200g","￥1400"),
                        new Fish(2, "カニ", "500g","￥10000"),
                        new Fish(3, "マグロ", "30000g","￥93510")
                );
    }
}
