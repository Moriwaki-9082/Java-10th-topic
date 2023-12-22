package com.moriwaki.java10thtopic.entity;

import java.util.Objects;

public class Fish {
    private Integer id;
    private String name;
    private String weight;
    private String price;

    public Fish(Integer id, String name, String weight, String price) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fish fish = (Fish) o;
        return id == fish.id && Objects.equals(name, fish.name) && Objects.equals(weight, fish.weight) && Objects.equals(price, fish.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight, price);
    }

}
