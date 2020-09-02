package comp3350.grocerystoreassistant.business;

import java.util.List;

import comp3350.grocerystoreassistant.application.Services;
import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.persistence.ItemPersistence;
import comp3350.grocerystoreassistant.persistence.stubs.ItemPersistenceStub;

public class AccessItems {
    private ItemPersistence itemPersistence;

    public AccessItems(){
        itemPersistence = Services.getItemPersistence();
    }

    public AccessItems(final ItemPersistence itemPersistence){
        this.itemPersistence = itemPersistence;
    }

    public List<GroceryItem> getAllItems(){ return itemPersistence.getAllItems();}
    public GroceryItem insertItem(GroceryItem item){ return itemPersistence.insertItem(item); }
    public GroceryItem updateItem(GroceryItem item){
        return itemPersistence.updateItem(item);
    }
    public void deleteItem(GroceryItem item){ itemPersistence.deleteItem(item); }
}
