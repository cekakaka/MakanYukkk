package com.dwicandra.makanyukkk.Domain;

import java.io.Serializable;

public class FoodDomain implements Serializable {
    private String title;
    private String pict;
    private String description;
    private double price;
    private int numberCardId;

    public FoodDomain(String title, String pict, String description, double price) {
        this.title = title;
        this.pict = pict;
        this.description = description;
        this.price = price;
    }

    public FoodDomain(String title, String pict, String description, double price, int numberCardId) {
        this.title = title;
        this.pict = pict;
        this.description = description;
        this.price = price;
        this.numberCardId = numberCardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPict() {
        return pict;
    }

    public void setPict(String pict) {
        this.pict = pict;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getprice() {
        return price;
    }

    public void setprice(double price) {
        this.price = price;
    }

    public int getNumberCardId() {
        return numberCardId;
    }

    public void setNumberCardId(int numberCardId) {
        this.numberCardId = numberCardId;
    }
}
