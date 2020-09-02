package comp3350.grocerystoreassistant.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.persistence.stubs.ItemPersistenceStub;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SearchTests {
    private SearchItems searchItems;
    private ItemPersistenceStub itemPersistenceStub;
    private List<GroceryItem> items;

    @Before
    public void setUp() {
        System.out.println("**Starting Search Items Test**");
        itemPersistenceStub = new ItemPersistenceStub();
        searchItems = new SearchItems(itemPersistenceStub);
        items = itemPersistenceStub.getAllItems();
        assertNotNull(searchItems);
        assertNotNull(items);
    }

    @Test
    public void testSearchItemByNameSuccess() {
        int randomIndex = (int)Math.random() * items.size();
        GroceryItem randomItem = items.get(randomIndex);
        boolean check = searchItems.searchByItemName(randomItem.getName());
        assertTrue(check);
    }

    @Test
    public void testSearchItemByNameFail() {

        GroceryItem noItem = new GroceryItem("ItemNotInStore", 1.99, "per lb", false, 1.99, 80, 0, 0, 0, 0, 0, 22, 5,
                16, 0, 170, "1 medium apple", 1, "", "Produce");
        boolean check = searchItems.searchByItemName(noItem.getName());
        assertFalse(check);
    }

    @After
    public void takeDown() {
        System.out.println("**Finished Search Items Test**");
    }
}
