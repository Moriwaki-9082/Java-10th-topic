package com.moriwaki.java10thtopic.exception;

public class FishNotFoundException extends RuntimeException {
    public FishNotFoundException(String message) {
        super(message);
    }

    public FishNotFoundException() {

    }
}
