package com.Moriwaki.Java10thtopic.controller;

import com.Moriwaki.Java10thtopic.entity.Fish;
import com.Moriwaki.Java10thtopic.exception.FishNotFoundException;
import com.Moriwaki.Java10thtopic.mapper.FishMapper;
import com.Moriwaki.Java10thtopic.service.FishService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class FishController {
    private final FishService fishService;
    public FishController(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping("/fishes")
    public List<Fish> getFishes(){
        return fishService.findAll();
    }

    @GetMapping("/fishes/{id}")
    public Fish getFish(@PathVariable("id") int id) {
        return fishService.findFish(id);
    }
    @ExceptionHandler(value = FishNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleFishNotFoundException(
            FishNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }
}
