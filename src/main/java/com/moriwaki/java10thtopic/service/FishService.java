package com.moriwaki.java10thtopic.service;

import com.moriwaki.java10thtopic.entity.Fish;
import com.moriwaki.java10thtopic.entity.FishView;
import com.moriwaki.java10thtopic.exception.FishAlreadyExistsException;
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
    public List<FishView> findAll(){
        return this.fishMapper.findAll();
    }

    //Read処理　検索表示 Mapper呼び出し
    public FishView findById(int id) {
        Optional<FishView> fish = this.fishMapper.findById(id);
        if (fish.isPresent()) {
            return fish.get();
        } else {
            throw new FishNotFoundException("fish not found");
        }
    }

    //POST処理　登録処理 Mapper呼び出し
    public Fish insert(Fish fish) {
        Optional<Fish> fishOptional = this.fishMapper.findByName(fish.getName());
        if(fishOptional.isPresent()){
            throw new FishAlreadyExistsException("name :" + fish.getName() + " already exists");
        }
        fishMapper.insert(fish);
        return fish;
    }

}
