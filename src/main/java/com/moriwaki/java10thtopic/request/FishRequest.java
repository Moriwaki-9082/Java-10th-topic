package com.moriwaki.java10thtopic.request;

import java.util.List;

public class FishRequest {

    private static String name;
    private static String weight;
    private static String price;

    public FishRequest(String name, String weight, String price) {
        FishRequest.name = name;
        FishRequest.weight = weight;
        FishRequest.price = price;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getPrice() {
        return price;
    }

    public static List<String> convertToFish() {
        return List.of(name,weight,price);
    }
}
