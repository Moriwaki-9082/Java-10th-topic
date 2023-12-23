package com.moriwaki.java10thtopic.mapper;
import com.moriwaki.java10thtopic.entity.Fish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FishMapper {

    //Read処理　全件表示
    @Select("SELECT * FROM fishes")
    List<Fish> findAll();

    //Read処理　検索表示
    @Select("SELECT * FROM fishes WHERE id = #{id}")
    Optional<Fish> findById(int id);

}
