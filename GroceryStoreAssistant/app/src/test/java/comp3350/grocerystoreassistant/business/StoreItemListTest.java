package comp3350.grocerystoreassistant.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import comp3350.grocerystoreassistant.business.itemList.StoreItemList;
import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.persistence.ItemPersistence;
import comp3350.grocerystoreassistant.persistence.stubs.ItemPersistenceStub;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

public class StoreItemListTest {

    private StoreItemList storeItemList;
    private ItemPersistence itemPersistence;
    private List<GroceryItem> itemList;
    private AccessItems accessItems;

    @Before
    public void setUp(){
        System.out.println("**Starting Store Item List Test**");
        itemPersistence = new ItemPersistenceStub();
        accessItems = new AccessItems(itemPersistence);
        itemList = accessItems.getAllItems();
    }
    @Test
    public void testConstructor() {
        storeItemList = new StoreItemList();
        assertNotNull(storeItemList);
    }

    @Test
    public void testConstructorList() {
        storeItemList = new StoreItemList(itemList);
        for (int i = 0; i < itemList.size(); i++) {
            assertEquals(storeItemList.getItem(i), itemList.get(i));
        }
    }

    @Test
    public void testGetItemsInStore() {
        storeItemList = new StoreItemList(itemList);

        StoreItemList compareList = new StoreItemList();
        compareList.addItem(itemList.get(0));
        compareList.addItem(itemList.get(1));
        compareList.addItem(itemList.get(2));

        List<GroceryItem> result = compareList.getItemsInStore(storeItemList);

        for (int i = 0; i < 3; i++) {
            assertEquals(result.get(i), storeItemList.getItem(i));
        }
    }

    @After
    public void tearDown(){
        System.out.println("**Finished Store Item List Test**");
    }
}
