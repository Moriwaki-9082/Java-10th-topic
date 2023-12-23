package com.moriwaki.java10thtopic.request;

public class FishRequest {

    private String name;
    private String weight;
    private String price;

    public FishRequest(String name, String weight, String price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
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

}
