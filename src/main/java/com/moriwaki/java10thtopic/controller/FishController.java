package com.moriwaki.java10thtopic.controller;

import com.moriwaki.java10thtopic.entity.Fish;
import com.moriwaki.java10thtopic.entity.FishView;
import com.moriwaki.java10thtopic.exception.FishAlreadyExistsException;
import com.moriwaki.java10thtopic.exception.FishNotFoundException;
import com.moriwaki.java10thtopic.request.FishRequest;
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

    //全件表示
    @GetMapping("/fishes")
    public List<FishView> getFishes(){
        return fishService.findAll();
    }

    //検索表示
    @GetMapping("/fishes/{id}")
    public FishView getFish(@PathVariable("id") int id) {
        return fishService.findById(id);
    }

    //対象が存在しない場合の例外処理
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

    //登録処理時、Nameが既に存在している物の場合の例外処理
    @ExceptionHandler(value = FishAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleFishAlreadyExistsException(
            FishAlreadyExistsException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
                "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
    }

    //登録処理
    @PostMapping("/fishes")
    public ResponseEntity<FishResponse> insert(@RequestBody FishRequest fishRequest, UriComponentsBuilder uriBuilder) {
        Fish fish = fishService.insert(fishRequest.convertToFish());
        URI location = uriBuilder.path("/fishes/{id}").buildAndExpand(fish.getId()).toUri();
        FishResponse body = new FishResponse("fish　date created");
        return ResponseEntity.created(location).body(body);
    }

    //更新処理
    @PatchMapping("/fishes")
    public ResponseEntity<String> update(@RequestBody FishUpdateRequest fishUpdateRequest) {
        fishService.update(fishUpdateRequest.updateToFish());
        return ResponseEntity.ok("fish date updated");
    }

}
