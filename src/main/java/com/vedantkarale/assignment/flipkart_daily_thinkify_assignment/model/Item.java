package com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String brand;
    private String category;
    private int price;
    private int quantity;

    public Item(String brand, String category, int price) {
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = 0;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return brand + ", " + category + ", " + quantity;
    }

    public void addQuantity(int qty) {
        this.quantity += qty;
    }
}

