package com.moriwaki.java10thtopic.mapper;

import com.moriwaki.java10thtopic.entity.Fish;
import org.apache.ibatis.annotations.*;

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

    //POST処理　登録処理
    @Insert("INSERT INTO fishes (name, weight, price) VALUES (#{name}, #{weight}, #{price})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Fish fish);

    //PATCH処理　更新処理
    @Update("UPDATE fishes SET (id, name, weight, price) VALUES (#{id}, #{name}, #{weight}, #{price})")
    void update(Optional<Fish> fish);

}
