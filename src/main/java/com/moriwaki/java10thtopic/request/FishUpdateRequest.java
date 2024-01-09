package com.moriwaki.java10thtopic.request;

import com.moriwaki.java10thtopic.entity.Fish;

public class FishUpdateRequest {

    private int id;
    private String name;
    private int priceInYen;
    private int inventoryAmount;

    public FishUpdateRequest(int id, String name, int priceInYen, int inventoryAmount) {
        this.id = id;
        this.name = name;
        this.priceInYen = priceInYen;
        this.inventoryAmount = inventoryAmount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriceInYen() {
        return priceInYen;
    }

    public int getInventoryAmount() {
        return inventoryAmount;
    }

    public Fish updateToFish() {
        return new Fish(this.id,this.name,this.priceInYen,this.inventoryAmount);
    }
}
