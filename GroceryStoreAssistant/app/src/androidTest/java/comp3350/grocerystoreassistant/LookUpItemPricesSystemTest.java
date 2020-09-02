package comp3350.grocerystoreassistant;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import comp3350.grocerystoreassistant.R;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;

import comp3350.grocerystoreassistant.presentation.listActivity.GroceryListActivity;

public class LookUpItemPricesSystemTest {

    @Rule
    public ActivityTestRule<GroceryListActivity> activityRule = new ActivityTestRule<>(GroceryListActivity.class);

    // look up price from a recycler view list
    @Test
    public void lookUpPriceFromRecyclerView(){
        onView(withId(R.id.navigation_home)).perform(click());
        onView(withId(R.id.card_view_department)).perform(click());
        onView(withText("Produce")).perform(click());
        // verify for certain item
        onView(withId(R.id.department_items_list_recycler_view)).perform(actionOnItem(withChild(withSubstring("$4.77")), click()));
    }

    @Test
    // look up by clicking view more information from a department list view item
    public void lookUpPriceFromDepartmentView2(){
        onView(withId(R.id.navigation_home)).perform(click());
        onView(withId(R.id.card_view_department)).perform(click());
        onView(withText("Produce")).perform(click());
        onView(withId(R.id.department_items_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withText("VIEW MORE INFORMATION")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Price:"), isDisplayed())));
    }

    // verify that after you look up an item when searching, you are able to view the price
    @Test
    public void lookUpPriceFromSearching(){
        String itemTest = "Apples";
        String priceCheck = "1.99";
        onView(withId(R.id.navigation_search)).perform(click());
        onView(withId(R.id.SearchView)).perform(typeText(itemTest));
        onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(0).perform(click());
        onView(withText("VIEW MORE INFORMATION")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(itemTest), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(priceCheck), isDisplayed())));
        onView(withText("OK")).perform(click());
    }

    // check the right message shows up with the price on it after adding item to a list and clicking on it from there
    @Test
    public void lookUpPriceAfterAddingToList() {
        String itemTest = "Apples";
        String priceCheck = "1.99";
        onView(withId(R.id.navigation_search)).perform(click());
        onView(withId(R.id.SearchView)).perform(typeText(itemTest));
        onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(0).perform(click());
        onView(withText("ADD TO LIST")).perform(click());
        onView(withId(R.id.navigation_list)).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(4, click()));
        onView(withText("YES")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(itemTest), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(priceCheck), isDisplayed())));
    }
}
