package comp3350.grocerystoreassistant.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import comp3350.grocerystoreassistant.business.itemList.GroceryList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GroceryListTest {

    private GroceryList groceryList;

    @Before
    public void testSetUp() {
        System.out.println("**Starting Grocery List Test**");
    }

    @Test
    public void testConstructor() {
        groceryList = new GroceryList();
        assertTrue(groceryList != null);
        assertTrue(groceryList.getID() >= 0);
    }

    @Test
    public void testUniqueness() {
        groceryList = new GroceryList();

        GroceryList l1 = new GroceryList();
        GroceryList l2 = new GroceryList();

        assertTrue(l1.getID() != l2.getID());
    }

    @Test
    public void testSetName() {
        groceryList = new GroceryList();
        groceryList.setListName("list_1");
        assertEquals(0, groceryList.getListName().compareTo("list_1"));
    }

    @Test
    public void testConstructorName() {
        groceryList = new GroceryList("list_1");
        assertEquals(0, groceryList.getListName().compareTo("list_1"));
    }

    @After
    public void tearDown(){
        System.out.println("**Finished Grocery List Test**");
    }
}
