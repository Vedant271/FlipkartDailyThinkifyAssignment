package com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.service;

import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.repository.InventoryRepository;
import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.constant.FilterConstants;
import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.model.Item;
import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.pojo.SearchCriteria;
import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.repository.InventoryRepository;
import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.utils.SortUtils;

import java.util.*;
import java.util.stream.Collectors;

public class InventoryService {
    private final InventoryRepository repository = new InventoryRepository();

    public void addItem(String brand, String category, int price) {
        repository.saveItem(new Item(brand, category, price));
        System.out.println("AddItem(" + brand + ", " + category + ", " + price + ")");
    }

    public void addInventory(String brand, String category, int quantity) {
        Item item = repository.getItem(brand, category);
        if (item != null) {
            item.addQuantity(quantity);
            System.out.println("AddInventory(" + brand + ", " + category + ", " + quantity + ")");
        } else {
            System.out.println("Item not found for: " + brand + ", " + category);
        }
    }

    public List<Item> searchItems(SearchCriteria criteria) {
        return repository.getAllItems().stream()
                .filter(item -> {
                    if (criteria.getBrands() != null && !criteria.getBrands().contains(item.getBrand())) return false;
                    if (criteria.getCategories() != null && !criteria.getCategories().contains(item.getCategory())) return false;
                    if (criteria.getPriceFrom() != null && item.getPrice() < criteria.getPriceFrom()) return false;
                    if (criteria.getPriceTo() != null && item.getPrice() > criteria.getPriceTo()) return false;
                    return true;
                })
                .sorted(SortUtils.getComparator(criteria.getOrderBy(), criteria.isAscending()))
                .collect(Collectors.toList());
    }

    public void printInventory() {
        System.out.println("\nInventory :");
        repository.getAllItems().forEach(System.out::println);
    }
}


