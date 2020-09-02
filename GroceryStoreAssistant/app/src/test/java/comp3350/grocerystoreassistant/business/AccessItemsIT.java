package comp3350.grocerystoreassistant.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.persistence.ItemPersistence;
import comp3350.grocerystoreassistant.persistence.hsqldb.ItemPersistenceHSQLDB;
import comp3350.grocerystoreassistant.utils.TestUtils;

import static org.junit.Assert.assertEquals;

public class AccessItemsIT {
    private File tempDB;
    private AccessItems accessItems;

    @Before
    public void setUp() throws Exception {
        System.out.println("**Starting Access Items Integration Test**");
        this.tempDB = TestUtils.copyDB();
        final ItemPersistence itemPersistence = new ItemPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessItems = new AccessItems(itemPersistence);
    }

    @Test
    public void testGetAllItems(){
        final List<GroceryItem> items = accessItems.getAllItems();
        assertEquals(232, items.size());
    }

    @Test
    public void testDeleteItem(){
        final GroceryItem item = new GroceryItem("Apples", 1.99, "per lb", false, 1.99, 80, 0, 0, 0, 0, 0, 22, 5,
                16, 0, 170, "1 medium apple", 1, "Leftmost Aisle", "Produce");
        List<GroceryItem> items = accessItems.getAllItems();
        assertEquals(232, items.size());
        accessItems.deleteItem(item);
        items = accessItems.getAllItems();
        assertEquals(231, items.size());
    }

    @Test
    public void testInsertItem(){
        final GroceryItem item = new GroceryItem("NotApples", 1.99, "per lb", false, 1.99, 80, 0, 0, 0, 0, 0, 22, 5,
                16, 0, 170, "1 medium apple", 1, "Leftmost Aisle", "Produce");
         accessItems.insertItem(item);
         assertEquals(233, accessItems.getAllItems().size());
    }

    @Test
    public void testUpdateItem(){
        //price of apples just went way up
        final GroceryItem item = new GroceryItem("Apples", 100.00, "per lb", false, 1.99, 80, 0, 0, 0, 0, 0, 22, 5,
                16, 0, 170, "1 medium apple", 1, "Leftmost Aisle", "Produce");
        accessItems.updateItem(item);
        assertEquals(232, accessItems.getAllItems().size());
    }

    @After
    public void tearDown(){
        System.out.println("**Finished Access Items Integration Test**");
        this.tempDB.delete();
    }
}
