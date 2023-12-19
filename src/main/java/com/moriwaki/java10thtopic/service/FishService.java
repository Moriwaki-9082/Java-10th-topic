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

    public List<Fish> findAll(){
        return this.fishMapper.findAll();
    }

    public Fish findById(int id) {
        Optional<Fish> fish = this.fishMapper.findById(id);
        if (fish.isPresent()) {
            return fish.get();
        } else {
            throw new FishNotFoundException("fish not found");
        }
    }
}
