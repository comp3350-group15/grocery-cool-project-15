package comp3350.grocerystoreassistant;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        SearchActivityTest.class,
        SuggestedRecipeSystemTest.class,
        AddToListSystemTest.class,
        LookUpWhatAisleItemIsOnSystemTest.class,
        LookUpItemPricesSystemTest.class,
        ViewListSystemTest.class,
        LookUpNutritionFactsSystemTest.class,
        FindClosestStoreSystemTest.class,
        FindItemByCategorySystemTest.class,
        ViewDetailsAboutMyStoreSystemTest.class,
        ViewMoreInformationSystemTest.class,
        SortSystemTest.class
})



public class AllSystemTest {
}
