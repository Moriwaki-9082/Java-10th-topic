package com.Moriwaki.Java10thtopic.exception;

public class FishNotFoundException extends RuntimeException {
    public FishNotFoundException(String message) {
        super(message);
    }
}
