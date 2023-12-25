package com.moriwaki.java10thtopic.controller;

import com.moriwaki.java10thtopic.entity.Fish;
import com.moriwaki.java10thtopic.exception.FishNotFoundException;
import com.moriwaki.java10thtopic.request.FishInsertRequest;
import com.moriwaki.java10thtopic.request.FishUpdateRequest;
import com.moriwaki.java10thtopic.response.FishResponse;
import com.moriwaki.java10thtopic.service.FishService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
        return fishService.findById(id);
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

    @PostMapping("/fishes")
    public ResponseEntity<FishResponse> insert(@RequestBody FishInsertRequest fishInsertRequest, UriComponentsBuilder uriBuilder) {
        Fish fish = fishService.insert(fishInsertRequest.getName(), fishInsertRequest.getWeight(), fishInsertRequest.getPrice());
        URI location = uriBuilder.path("/fishes/{id}").buildAndExpand(fish.getId()).toUri();
        FishResponse body = new FishResponse("fish created");
        return ResponseEntity.created(location).body(body);
    }

    @PatchMapping("/fishes")
    public ResponseEntity<String> update(@RequestBody FishUpdateRequest fishUpdateRequest) {
        fishService.update(fishUpdateRequest.getId(), fishUpdateRequest.getName(), fishUpdateRequest.getWeight(), fishUpdateRequest.getPrice());
        return ResponseEntity.ok("fish updated");
    }

}
