package com.moriwaki.java10thtopic.service;

import com.moriwaki.java10thtopic.entity.Fish;
import com.moriwaki.java10thtopic.exception.FishAlreadyExistsException;
import com.moriwaki.java10thtopic.exception.FishNotFoundException;
import com.moriwaki.java10thtopic.mapper.FishMapper;
import com.moriwaki.java10thtopic.request.FishRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FishService {
    private final FishMapper fishMapper;
    private FishRequest fishRequest;
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
    public Fish insert(List<String> convertToFish) {
        String fishName = convertToFish.get(0);
        String fishWeight = convertToFish.get(1);
        String fishPrice = convertToFish.get(2);
        Optional<Fish> fishOptional = this.fishMapper.findByName(fishName);
        if(fishOptional.isPresent()){
            throw new FishAlreadyExistsException("name :" + fishName + "already exists");
        }
        Fish fish = new Fish(null, fishName, fishWeight,fishPrice);
        fishMapper.insert(fish);
        return fish;
    }

}
