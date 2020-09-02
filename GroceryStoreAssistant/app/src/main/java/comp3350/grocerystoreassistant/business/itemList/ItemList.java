package comp3350.grocerystoreassistant.business.itemList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import comp3350.grocerystoreassistant.business.AccessItems;
import comp3350.grocerystoreassistant.objects.GroceryItem;

/**
 * ItemDisplayList
 * This is the super class for all List classes like GroceryLIst, ItemList, and RecipeList (Future)
 * The purpose is to have an organized code.
 *
 * This class will contains all the base operations that are required for a 'List'.
 * any class that extends this will have all the functionality of a 'List' class, which includes:
 * - Getting all items (this is useful if we want to render them to the GUI)
 * - Add new GroceryItems
 * - Get GroceryItems by name, index
 * - Remove GroceryItems by name, object, index
 * - Check whether it contains some items
 *
 * You can add other method that you might need in the future, such as filter or sort in this class.
 */

public abstract class ItemList {

    
    protected List<GroceryItem> itemList;

    protected ItemList() {
        itemList = new ArrayList<GroceryItem>();
    }

    protected ItemList(List<GroceryItem> list) {
        this.itemList = list;
    }

    public List<GroceryItem> getAllItems() {
        return this.itemList;
    }

    public void addItem(GroceryItem newItem) {
        if (newItem != null && !itemList.contains(newItem)) {
            itemList.add(newItem);
        }
    }

    public boolean contains(GroceryItem item) {
        return this.itemList.contains(item);
    }

    public GroceryItem getItem(String name) {
        GroceryItem item = null;

        for (int i = 0; i < itemList.size(); i++) {
            GroceryItem curr = itemList.get(i);
            if (curr.getName().compareTo(name) == 0) {
                item = curr;
                break;
            }
        }

        return item;
    }

    public GroceryItem getItem(int index) {
        if (index > -1 == index < this.itemList.size()) {
            return this.itemList.get(index);
        } else {
            return null;
        }
    }

    public GroceryItem removeItem(String name) {
        GroceryItem item = null;

        for (int i = 0; i < itemList.size(); i++) {
            GroceryItem curr = itemList.get(i);
            if (curr.getName().compareTo(name) == 0) {
                item = curr;
                itemList.remove(curr);
                break;
            }
        }

        return item;
    }

    public GroceryItem removeItem(GroceryItem item) {
        GroceryItem removed = null;

        for (int i = 0; i < itemList.size(); i++) {
            GroceryItem curr = itemList.get(i);
            if (curr.equals(item)) {
                removed = curr;
                itemList.remove(curr);
                break;
            }
        }

        return removed;
    }

    public GroceryItem removeItem(int index) {
        if (index > -1 == index < itemList.size()) {
            return this.itemList.remove(index);
        } else {
            return null;
        }
    }

    public void setItemList(List<GroceryItem> items) {
        this.itemList = items;
    }
}
