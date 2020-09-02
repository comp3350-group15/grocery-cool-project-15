package comp3350.grocerystoreassistant.persistence;

import java.util.List;

import comp3350.grocerystoreassistant.objects.GroceryItem;

public interface ItemPersistence {
    List<GroceryItem> getAllItems();
    GroceryItem insertItem(GroceryItem item);
    GroceryItem updateItem(GroceryItem item);
    void deleteItem(GroceryItem item);
}
