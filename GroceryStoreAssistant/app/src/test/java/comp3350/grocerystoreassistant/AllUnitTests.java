package comp3350.grocerystoreassistant;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.grocerystoreassistant.location.GooglePlacesUtilitiesTest;
import comp3350.grocerystoreassistant.business.SearchTests;
import comp3350.grocerystoreassistant.business.GroceryListTest;
import comp3350.grocerystoreassistant.business.ItemListTest;
import comp3350.grocerystoreassistant.business.StoreItemListTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SearchTests.class,
        GroceryListTest.class,
        ItemListTest.class,
        StoreItemListTest.class,
        GooglePlacesUtilitiesTest.class

})
public class AllUnitTests { }
