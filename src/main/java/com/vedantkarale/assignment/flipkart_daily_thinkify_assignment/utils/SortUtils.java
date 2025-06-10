package com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.utils;

import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.model.Item;

import java.util.Comparator;

public class SortUtils {
    public static Comparator<Item> getComparator(String orderBy, boolean asc) {
        Comparator<Item> comparator;

        switch (orderBy.toLowerCase()) {
            case "quantity":
                comparator = Comparator.comparing(Item::getQuantity);
                break;
            case "price":
            default:
                comparator = Comparator.comparing(Item::getPrice);
        }

        return asc ? comparator : comparator.reversed();
    }
}

