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

		// Defining items in the inventory with Category and brand along with the price
		System.out.println("\n*************** Add Items ***************");
		service.addItem("Lays", "Potato Chips", 20);
		service.addItem("Balaji", "Bhujiya", 50);
		service.addItem("Dabur", "Honey", 120);
		service.addItem("Dabur", "Shampoo", 80);
		service.addItem("Patanjali", "Honey", 110);
		service.addItem("Patanjali", "Toothpaste", 90);
		service.addItem("Fortune", "Oil", 140);
		service.addItem("Saffola", "Oil", 150);
		service.addItem("Tata", "Salt", 70);
		service.addItem("Aashirvaad", "Salt", 90);

		// Filling items to inventory with available quantity for each of them
		System.out.println("\n*************** Add Inventory ***************");
		service.addInventory("Lays", "Potato Chips", 10);
		service.addInventory("Balaji", "Bhujiya", 13);
		service.addInventory("Dabur", "Honey", 43);
		service.addInventory("Dabur", "Shampoo", 10);
		service.addInventory("Patanjali", "Honey", 11);
		service.addInventory("Patanjali", "Toothpaste", 29);
		service.addInventory("Fortune", "Oil", 41);
		service.addInventory("Saffola", "Oil", 24);
		service.addInventory("Tata", "Salt", 15);
		service.addInventory("Aashirvaad", "Salt", 20);

		service.printInventory();

		// Searching items in inventory using different filters
		// Brand or Category (search can be on multiple categories / brands)
		System.out.println("\n=> Search: brand = Balaji, Patanjali");
		printResults(service.searchItems(new SearchCriteria(Arrays.asList("Balaji","Patanjali"), null, null, null, "price", true)));

		// Price range (price From , price To) etc. (from and to price parameters can be optional)
		System.out.println("\n=> Search: price range 70 to 100");
		printResults(service.searchItems(new SearchCriteria(null, null, 70, 100, "price", true)));

		System.out.println("\n=> Search: price range from 50 to all");
		printResults(service.searchItems(new SearchCriteria(null, null, 50, null, "price", true)));

		// Searched items / results order criterias
		// Items with lowest price first (default criteria)
		System.out.println("\n=> Search: price range from 50 to all");
		printResults(service.searchItems(new SearchCriteria(null, null, 50, null, null, true)));

		// Items with highest price first
		System.out.println("\n=> Search: price range from 50 to all");
		printResults(service.searchItems(new SearchCriteria(null, null, 50, null, "price", false)));

		// Items with least no of quantity
		System.out.println("\n=> Search: category = Oil");
		printResults(service.searchItems(new SearchCriteria(null, Arrays.asList("Oil"), null, null, "quantity", true)));

		// BONUS
		// Search by both Brand and Category
		System.out.println("\n=> Search: brand = Patanjali, category = Honey");
		printResults(service.searchItems(new SearchCriteria(Arrays.asList("Patanjali"), Arrays.asList("Honey"), null, null, "price", true)));

		// Search by both Brand and Price Range
		System.out.println("\n=> Search: brand=Dabur, price=60-100, orderBy=price desc");
		printResults(service.searchItems(new SearchCriteria(Arrays.asList("Dabur"), null, 70, 100, "price", false)));

		// Search by both Category and Price Range
		System.out.println("\n=> Search: category=Salt, price=70-100, orderBy=price desc");
		printResults(service.searchItems(new SearchCriteria(null, Arrays.asList("Salt"), 70, 100, "price", false)));
	}

	private static void printResults(List<Item> items) {
		for (Item i : items) {
			System.out.println(i);
		}
	}
}
