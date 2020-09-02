package comp3350.grocerystoreassistant.business;

import java.util.List;

import comp3350.grocerystoreassistant.application.Services;
import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.persistence.ItemPersistence;

/**Class SearchItems -- this class will allow for search of items that are at the store
// There are two ways that it can search. 
// First, it takes in the name of an item and it will search to see if that item is located in the store
// From the search query it takes in, it will produce and items which have words that match words in the
// name of the item. 
// Secondly, is a search by department. That is, it takes in the name of a department, and, it will display
// all items that are located in that department. 
// It has a method displayInfo that will display all info about an item to the user (i.e. name, price, 
// nutritional information, etc.)*/
public class SearchItems {
	private ItemPersistence itemPersistence;
	private List<GroceryItem> items;

	public SearchItems(){
		itemPersistence = Services.getItemPersistence();
		items = null;
	}

	public SearchItems(ItemPersistence itemPersistence) {
		this.itemPersistence = itemPersistence;
		this.items = itemPersistence.getAllItems();
	}
	
	public boolean searchByItemName(String name) {
		boolean found = false;
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getName().equalsIgnoreCase(name)) {
				printInfo(items.get(i));
				found = true;
			} else {
				String[] query = items.get(i).getName().split("[, ]");
				for(int j = 0; j < query.length; j++) { 
					if(query[j].equalsIgnoreCase(name)) { 
						printInfo(items.get(i));
						found = true;
					}
				}
			}
		}
		return found;
	}

	public GroceryItem getItemByName(String name){
		GroceryItem item = null;
		for(int i = 0; i < items.size(); i++){
			if(items.get(i).getName().equalsIgnoreCase(name)){
				item = items.get(i);
			}
		}
		return item;
	}

	public static void printInfo(GroceryItem i) {
		System.out.println("-------GroceryItem Info-------");
		System.out.println("GroceryItem Name: " + i.getName());
		System.out.println("GroceryItem Price: " + i.getPrice());
		
		if(i.getPricePerWeight() != null && !(i.getPricePerWeight().equals(""))) {
		    System.out.println("Price Per: " + i.getPricePerWeight());
		} else { 
			System.out.println("Price Per: each");
		}
		
		if(i.isOnSale() == true) { 
			System.out.println("This item is on sale.");
			System.out.println(("Sale Price: "+i.getOnSalePrice()));
		} else { 
			System.out.println("This item is regular price.");
		}
		
		System.out.println();

		System.out.println("-------Nutritional Info-------");
		System.out.println("Serving Size: " + i.getPerAmount());
		System.out.println("Calories: " + i.getCalories());
		System.out.println("Fat: " + i.getFat() + " g ");
		System.out.println("Saturated Fat: " + i.getSaturatedFat() + " g ");
		System.out.println("Trans Fat: " + i.getTransFat() + " g ");
		System.out.println("Cholesterol: " + i.getCholesterol() + " mg ");
		System.out.println("Sodium: " + i.getSodium() + " mg ");
		System.out.println("Carbohydrates: " + i.getCarbohydrates() + " g ");
		System.out.println("Fiber: " + i.getFiber() + " g ");
		System.out.println("Sugar: " + i.getSugar() + " g ");
		System.out.println("Protein: " + i.getProtein() + " g ");
		System.out.println("Potassium: " + i.getPotassium() + " mg ");
		
		System.out.println();
		System.out.println("-------Location Info-------");
		System.out.println("Aisle Number: " + i.getAisle());
		System.out.println("Aisle Location Info: " + i.getAisleDescription());
		
	
		System.out.println();
		System.out.println();
		System.out.println();
	}
}
