package com.moriwaki.java10thtopic.exception;

public class FishAlreadyExistsException  extends RuntimeException {
    public FishAlreadyExistsException(String message) {
        super(message);
    }
}
