package com.moriwaki.java10thtopic.entity;

import java.util.Objects;

public class FishView {
    private Integer id;
    private String name;
    private String priceInYen;
    private String inventoryQuantity;

    public FishView(Integer id, String name, String priceInYen, String inventoryQuantity) {
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

    public String getPriceInYen() {
        return priceInYen;
    }

    public void setPriceInYen(String priceInYen) {
        this.priceInYen = priceInYen;
    }

    public String getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(String price) {
        this.inventoryQuantity = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FishView fish = (FishView) o;
        return id == fish.id && Objects.equals(name, fish.name) && Objects.equals(priceInYen, fish.priceInYen) && Objects.equals(inventoryQuantity, fish.inventoryQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, priceInYen, inventoryQuantity);
    }

}
