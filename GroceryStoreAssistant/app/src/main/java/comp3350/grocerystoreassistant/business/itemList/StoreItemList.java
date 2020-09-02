package comp3350.grocerystoreassistant.business.itemList;

import java.util.ArrayList;
import java.util.List;

import comp3350.grocerystoreassistant.objects.GroceryItem;

/** StoreItemList
 * Class that stores GroceryItems for a store (or anything)
 * Use this class if you want to create a list of GroceryItem that are sold in a store.
 */
public class StoreItemList extends ItemList {

    // We can add some the store that is related to this ItemList.

    public StoreItemList() {
        super();
    }

    public StoreItemList(List<GroceryItem> list) {
        super(list);
    }

    /**
     * **NOTE**
     * This might also be appropriate to be put inside the Store class.
     *
     * get all the items/elements that are IN other list and this item list.
     * this might be useful if the user want to see if the store contains all
     * the items that they need.
     *
     * @param otherList contains all items that need to be check.
     * @return
     */
    public List<GroceryItem> getItemsInStore(ItemList otherList) {

        List<GroceryItem> intersect = new ArrayList<>();
        List<GroceryItem> storeItems = otherList.getAllItems();

        for(int i = 0; i < storeItems.size(); i++) {
            GroceryItem itemFromOtherList = otherList.getItem(i);
            GroceryItem itemFromStore = this.getItem(i);
            if(itemFromOtherList.equals(itemFromStore)) {
                intersect.add(itemFromStore);
            }
        }

        return intersect;
    }
}
