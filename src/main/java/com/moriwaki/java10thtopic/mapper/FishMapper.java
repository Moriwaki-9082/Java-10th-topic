package com.moriwaki.java10thtopic.mapper;
import com.moriwaki.java10thtopic.entity.Fish;
import com.moriwaki.java10thtopic.entity.FishView;
import org.apache.ibatis.annotations.*;

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
    @Insert("INSERT INTO fishes (name, priceInYen, inventoryAmount) VALUES (#{name}, #{priceInYen}, #{inventoryAmount})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Fish fish);

    //POST処理時に、既に存在しているNameか確認
    @Select("SELECT * FROM fishes WHERE name = #{name}")
    Optional<Fish> checkByName(String name);

    //PATCH処理　更新処理
    @Update("UPDATE fishes SET name = #{name}, priceInYen = #{priceInYen}, inventoryAmount = #{inventoryAmount} WHERE id = #{id}")
    void update(Fish fish);

    //PATCH処理時に、既に存在しているIDか確認
    @Select("SELECT * FROM fishes WHERE id = #{id}")
    Optional<Fish> checkById(int id);

}
