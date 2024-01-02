package com.moriwaki.java10thtopic.entity;

import java.util.Objects;

public class Fish {
    private Integer id;
    private String name;
    private int priceInYen;
    private int inventoryQuantity;

    public Fish(Integer id, String name, int priceInYen, int inventoryQuantity) {
        this.id = id;
        this.name = name;
        this.priceInYen = priceInYen;
        this.inventoryQuantity = inventoryQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setInventoryQuantity(int price) {
        this.inventoryQuantity = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fish fish = (Fish) o;
        return id == fish.id && Objects.equals(name, fish.name) && Objects.equals(priceInYen, fish.priceInYen) && Objects.equals(inventoryQuantity, fish.inventoryQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, priceInYen, inventoryQuantity);
    }

}
