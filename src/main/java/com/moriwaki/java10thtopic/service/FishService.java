package com.moriwaki.java10thtopic.service;

import com.moriwaki.java10thtopic.entity.Fish;
import com.moriwaki.java10thtopic.exception.FishNotFoundException;
import com.moriwaki.java10thtopic.mapper.FishMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FishService {
    private final FishMapper fishMapper;
    public FishService(FishMapper fishMapper) {
        this.fishMapper = fishMapper;
    }

    //Read処理　全件表示 Mapper呼び出し
    public List<Fish> findAll(){
        return this.fishMapper.findAll();
    }

    //Read処理　検索表示 Mapper呼び出し
    public Fish findById(int id) {
        Optional<Fish> fish = this.fishMapper.findById(id);
        if (fish.isPresent()) {
            return fish.get();
        } else {
            throw new FishNotFoundException("fish not found");
        }
    }

    //POST処理　登録処理 Mapper呼び出し
    public Fish insert(String name, String weight, String price) {
        Fish fish = new Fish(null, name, weight, price);
        fishMapper.insert(fish);
        return fish;
    }

}
