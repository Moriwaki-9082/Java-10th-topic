package com.Moriwaki.Java10thtopic.service;

import com.Moriwaki.Java10thtopic.entity.Fish;
import com.Moriwaki.Java10thtopic.exception.FishNotFoundException;
import com.Moriwaki.Java10thtopic.mapper.FishMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FishService {
    private final FishMapper fishMapper;
    public FishService(FishMapper fishMapper) {
        this.fishMapper = fishMapper;
    }

    public List<Fish> findAll(){
        return this.fishMapper.findAll();
    }

    public Fish findFish(int id) {
        Optional<Fish> fish = this.fishMapper.findById(id);
        if (fish.isPresent()) {
            return fish.get();
        } else {
            throw new FishNotFoundException("fish not found");
        }
    }
}
