package com.moriwaki.java10thtopic.request;

import com.moriwaki.java10thtopic.entity.Fish;

public class FishInsertRequest {

    private String name;
    private String weight;
    private String price;

    public FishInsertRequest(String name, String weight, String price) {
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
