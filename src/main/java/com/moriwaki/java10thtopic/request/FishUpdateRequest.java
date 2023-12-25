package com.moriwaki.java10thtopic.request;

public class FishUpdateRequest {

    private Integer id;
    private String name;
    private String weight;
    private String price;

    public FishUpdateRequest(Integer id, String name, String weight, String price) {
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
}
