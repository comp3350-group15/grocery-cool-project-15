package comp3350.grocerystoreassistant;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import androidx.test.rule.ActivityTestRule;

import java.util.List;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.objects.GroceryItem;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.anything;

import comp3350.grocerystoreassistant.persistence.stubs.ItemPersistenceStub;
import comp3350.grocerystoreassistant.presentation.HomeActivity;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ViewListSystemTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    // first add an item to the list
    @Test
    public void test1_addToList(){
        String itemTest = "Pineapple";
        ItemPersistenceStub itemPersistenceStub = new ItemPersistenceStub();
        List<GroceryItem> list = itemPersistenceStub.getAllItems();
        onView(withId(R.id.navigation_search)).perform(click());
        onView(withId(R.id.SearchView)).perform(typeText(itemTest));
        onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(0).perform(click());
        onView(withText("ADD TO LIST")).perform(click());
    }

    // Verify that a list shows
    @Test
    public void test2_verifyListShows(){
        onView(withId(R.id.navigation_list)).perform(click());
        onView(withId(R.id.item_list_recycler_view)).check(matches(isDisplayed()));
    }
}
