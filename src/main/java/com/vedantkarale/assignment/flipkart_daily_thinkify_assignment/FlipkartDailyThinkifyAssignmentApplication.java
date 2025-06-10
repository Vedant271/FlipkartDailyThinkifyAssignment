package com.vedantkarale.assignment.flipkart_daily_thinkify_assignment;

import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.model.Item;
import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.pojo.SearchCriteria;
import com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.service.InventoryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FlipkartDailyThinkifyAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlipkartDailyThinkifyAssignmentApplication.class, args);

		InventoryService service = new InventoryService();

		// Add Items
		service.addItem("Amul", "Milk", 100);
		service.addItem("Amul", "Curd", 50);
		service.addItem("Nestle", "Milk", 60);
		service.addItem("Nestle", "Curd", 90);

		// Add Inventory
		service.addInventory("Amul", "Milk", 10);
		service.addInventory("Nestle", "Milk", 5);
		service.addInventory("Nestle", "Curd", 10);
		service.addInventory("Amul", "Milk", 10);
		service.addInventory("Amul", "Curd", 5);

		service.printInventory();

		// Search Examples
		System.out.println("\nSearch: brand = Nestle");
		printResults(service.searchItems(new SearchCriteria(Arrays.asList("Nestle"), null, null, null, "price", true)));

		System.out.println("\nSearch: category = Milk");
		printResults(service.searchItems(new SearchCriteria(null, Arrays.asList("Milk"), null, null, "price", true)));

		System.out.println("\nSearch: price range 70 to 100");
		printResults(service.searchItems(new SearchCriteria(null, null, 70, 100, "price", true)));

		System.out.println("\nSearch: category=Milk, price=70-100, orderBy=price desc");
		printResults(service.searchItems(new SearchCriteria(null, Arrays.asList("Milk"), 70, 100, "price", false)));
	}

	private static void printResults(List<Item> items) {
		for (Item i : items) {
			System.out.println(i);
		}
	}
}
