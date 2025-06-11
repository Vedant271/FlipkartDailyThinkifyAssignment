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



//package com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.service;
//
//import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.repository.InventoryRepository;
//import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.constant.FilterConstants;
//import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.model.Item;
//import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.pojo.SearchCriteria;
//import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.repository.InventoryRepository;
//import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.utils.SortUtils;
//
//import java.util.*;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//public class InventoryService {
//    Map<String, Item> inventory = new HashMap<>();
//
//    private String getKey(String brand, String category) {
//        return brand + "#" + category;
//    }
//
//    public void addItem(String brand, String category, int price) {
//        String key = getKey(brand, category);
//        inventory.putIfAbsent(key, new Item(brand, category, price));
//        System.out.println("AddItem(" + brand + ", " + category + ", " + price + ")");
//    }
//
//    public void addInventory(String brand, String category, int quantity) {
//        String key = getKey(brand, category);
//        if (inventory.containsKey(key)) {
//            inventory.get(key).addQuantity(quantity);
//            System.out.println("AddInventory(" + brand + ", " + category + ", " + quantity + ")");
//        } else {
//            System.out.println("Item not found: " + brand + ", " + category);
//        }
//    }
//
//    public List<Item> searchItems(SearchCriteria criteria) {
//        List<Predicate<Item>> filters = new ArrayList<>();
//
//        if (criteria.getBrands() != null && !criteria.getBrands().isEmpty()) {
//            filters.add(item -> criteria.getBrands().contains(item.getBrand()));
//        }
//
//        if (criteria.getCategories() != null && !criteria.getCategories().isEmpty()) {
//            filters.add(item -> criteria.getCategories().contains(item.getCategory()));
//        }
//
//        if (criteria.getPriceFrom() != null) {
//            filters.add(item -> item.getPrice() >= criteria.getPriceFrom());
//        }
//
//        if (criteria.getPriceTo() != null) {
//            filters.add(item -> item.getPrice() <= criteria.getPriceTo());
//        }
//
//        // Combine all filters
//        Predicate<Item> combinedFilter = filters.stream()
//                .reduce(x -> true, Predicate::and);
//
//        Comparator<Item> comparator = switch (criteria.getOrderBy().toLowerCase()) {
//            case "itemqty" -> Comparator.comparingInt(Item::getQuantity);
//            case "price" -> Comparator.comparingInt(Item::getPrice);
//            default -> Comparator.comparingInt(Item::getPrice); // Default
//        };
//
//        if (!criteria.isAscending()) {
//            comparator = comparator.reversed();
//        }
//
//        List<Item> result = inventory.values().stream()
//                .filter(combinedFilter)
//                .sorted(comparator)
//                .collect(Collectors.toList());
//
//        result.forEach(System.out::println);
//        return result;
//    }
//
//    public void printInventory() {
//        System.out.println("\nInventory:");
//        inventory.values().forEach(System.out::println);
//    }
//}

