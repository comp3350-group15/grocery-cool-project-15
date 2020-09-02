package comp3350.grocerystoreassistant.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import comp3350.grocerystoreassistant.business.itemList.ItemList;
import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.persistence.stubs.ItemPersistenceStub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ItemListTest {
    class StubList extends ItemList {
        public StubList() {
            super();
        }
    }

    private ItemPersistenceStub itemPersistenceStub;
    private List<GroceryItem> itemList;
    private StubList list;

    @Before
    public void setup() {
        System.out.println("**Starting Item List Test**");
        itemPersistenceStub = new ItemPersistenceStub();
        list = new StubList();
        itemList = itemPersistenceStub.getAllItems();
    }

    @Test
    public void testInit() {
        assertTrue(list != null);
    }

    // Test addItem()
    @Test
    public void testAddItem() {
        list = new StubList();

        GroceryItem item = itemList.get(0);
        list.addItem(item);
        assertTrue(list.contains(item));
        list.addItem(item);
        assertEquals(1, list.getAllItems().size());
    }

    @Test
    public void testContains() {
        list = new StubList();

        GroceryItem item = itemList.get(0);
        list.addItem(item);
        assertTrue(list.contains(item));
        assertFalse(list.contains(itemList.get(1)));
    }

    // Test getItem(String)
    @Test
    public void testGetItemByName() {
        list = new StubList();

        GroceryItem item = itemList.get(0);
        GroceryItem item2 = itemList.get(1);
        list.addItem(item);

        GroceryItem getItem = list.getItem(item.getName());
        assertTrue(getItem.equals(item));
        assertEquals(null, list.getItem(item2.getName()));
    }

    // Test getItem(int)
    @Test
    public void testGetItemByIndex() {
        list = new StubList();

        int i_0 = 0;
        int i_1 = 1;

        GroceryItem item = itemList.get(i_0);
        GroceryItem item2 = itemList.get(i_1);
        list.addItem(item);

        GroceryItem getItem = list.getItem(i_0);
        assertTrue(getItem.equals(item));
        assertEquals(null, list.getItem(i_1));
    }

    // Test removeItem(String)
    @Test
    public void testRemoveItemByName() {
        list = new StubList();

        GroceryItem item = itemList.get(0);
        GroceryItem item2 = itemList.get(1);
        list.addItem(item);

        GroceryItem getItem = list.removeItem(item.getName());
        assertTrue(getItem.equals(item));
        assertEquals(null, list.removeItem(item2.getName()));
    }

    // Test removeItem(GroceryItem)
    @Test
    public void testRemoveItemByItem() {
        list = new StubList();

        GroceryItem item1 = itemList.get(0);
        GroceryItem item2 = itemList.get(1);
        list.addItem(item1);

        GroceryItem getItem = list.removeItem(item1);
        assertTrue(getItem.equals(item1));
        assertEquals(null, list.removeItem(item2));
    }

    // Test removeItem(int)
    @Test
    public void testRemoveItemByIndex() {
        list = new StubList();

        GroceryItem item1 = itemList.get(0);
        GroceryItem item2 = itemList.get(1);
        list.addItem(item1);

        GroceryItem getItem = list.removeItem(0);
        assertTrue(getItem.equals(item1));
        assertEquals(null, list.removeItem(1));
    }

    // Test getAllItems()
    @Test
    public void testGetAllItems() {
        list = new StubList();

        int numOfItem = 10;

        for(int i = 0; i < numOfItem; i++) {
            list.addItem(itemList.get(i));
        }

        assertEquals(numOfItem, list.getAllItems().size());
    }

    // Test setItemList
    @Test
    public void testSetItemList() {
        list = new StubList();
        list.setItemList(itemList);

        for(int i = 0; i < itemList.size(); i++) {
            assertTrue((itemList.get(i)).equals(list.getItem(i)));
        }
    }

    @After
    public void tearDown(){
        System.out.println("**Finished Item List Test**");
    }
}
