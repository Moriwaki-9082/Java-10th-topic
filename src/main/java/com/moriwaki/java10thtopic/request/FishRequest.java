package com.moriwaki.java10thtopic.request;

import com.moriwaki.java10thtopic.entity.Fish;

public class FishRequest {

    private String name;
    private int priceInYen;
    private int inventoryQuantity;

    public FishRequest(String name, int priceInYen, int inventoryQuantity) {
        this.name = name;
        this.priceInYen = priceInYen;
        this.inventoryQuantity = inventoryQuantity;
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

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public Fish convertToFish() {
        return new Fish(null,this.name,this.priceInYen,this.inventoryQuantity);
    }
}
