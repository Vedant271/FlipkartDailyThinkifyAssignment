package com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.repository;

import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.model.Item;

import java.util.*;

public class InventoryRepository {
    private final Map<String, Item> inventory = new HashMap<>();

    private String getKey(String brand, String category) {
        return brand + "#" + category;
    }

    public void saveItem(Item item) {
        String key = getKey(item.getBrand(), item.getCategory());
        inventory.putIfAbsent(key, item);
    }

    public Item getItem(String brand, String category) {
        return inventory.get(getKey(brand, category));
    }

    public Collection<Item> getAllItems() {
        return inventory.values();
    }
}

