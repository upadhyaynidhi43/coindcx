package com.coindcx.pojos;

import com.google.gson.annotations.SerializedName;

public class CoinDcxData {

    private String generation;
    private String price;
    private String capacity;

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

}
