package com.moriwaki.java10thtopic.request;

import com.moriwaki.java10thtopic.entity.Fish;

public class FishRequest {

    private String name;
    private int priceInYen;
    private int inventoryAmount;

    public FishRequest(String name, int priceInYen, int inventoryAmount) {
        this.name = name;
        this.priceInYen = priceInYen;
        this.inventoryAmount = inventoryAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceInYen() {
        return priceInYen;
    }

    public void setPriceInYen(int priceInYen) {
        this.priceInYen = priceInYen;
    }

    public int getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(int inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public Fish convertToFish() {
        return new Fish(null,this.name,this.priceInYen,this.inventoryAmount);
    }
}
