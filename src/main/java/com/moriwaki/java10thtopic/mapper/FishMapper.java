package com.moriwaki.java10thtopic.mapper;
import com.moriwaki.java10thtopic.entity.Fish;
import com.moriwaki.java10thtopic.entity.FishView;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FishMapper {

    //Read処理　全件表示
    @Select("SELECT * FROM fish_view")
    List<FishView> findAll();

    //Read処理　検索表示
    @Select("SELECT * FROM fish_view WHERE id = #{id}")
    Optional<FishView> findById(int id);

    //POST処理　登録処理
    @Insert("INSERT INTO fishes (name, priceInYen, inventoryQuantity) VALUES (#{name}, #{priceInYen}, #{inventoryQuantity})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Fish fish);

    //POST処理時に、既に存在しているNameではないか確認
    @Select("SELECT * FROM fishes WHERE name = #{name}")
    Optional<Fish> findByName(String Name);

}
