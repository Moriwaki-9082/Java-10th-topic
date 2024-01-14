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
        fish.orElseThrow(() -> new FishNotFoundException("fish not found"));
        return fish.get();
    }

    //POST処理　登録処理 Mapper呼び出し
    public Fish insert(Fish fish) {
        this.fishMapper.checkByName(fish.getName()).ifPresent(foundFish -> {
            throw new FishAlreadyExistsException("name :" + fish.getName() + " already exists");
        });
        fishMapper.insert(fish);
        return fish;
    }

    //PATCH処理 更新処理 Mapper呼び出し
    public Fish update(Fish fish) {
        this.fishMapper.checkById(fish.getId()).orElseThrow(() -> new FishNotFoundException("id does not exist"));
        fishMapper.update(fish);
        return fish;
    }

    //DELETE処理　削除処理 Mapper呼び出し
    public int delete(int id) {
        this.fishMapper.checkById(id).orElseThrow(() -> new FishNotFoundException("id does not exist"));
        fishMapper.delete(id);
        return id;
    }

}
