package comp3350.grocerystoreassistant;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import comp3350.grocerystoreassistant.R;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;

import comp3350.grocerystoreassistant.presentation.listActivity.GroceryListActivity;

import androidx.test.espresso.contrib.RecyclerViewActions;

public class LookUpWhatAisleItemIsOnSystemTest {

    @Rule
    public ActivityTestRule<GroceryListActivity> activityRule = new ActivityTestRule<>(GroceryListActivity.class);

    // check that you can view what aisle an item is on from searching and clicking view more information
    @Test
    public void seeInfoAboutAisleFromSearch(){
        String itemTest = "Potatoes";
        String aisleCheck = "Aisle: 2";
        String aisleDescriptionCheck = "Aisle Description: Between Aisle 1 and Frozen Aisle";
        onView(withId(R.id.navigation_search)).perform(click());
        onView(withId(R.id.SearchView)).perform(typeText(itemTest));
        onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(0).perform(click());
        onView(withText("VIEW MORE INFORMATION")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(aisleCheck), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(aisleDescriptionCheck), isDisplayed())));
        onView(withText("OK")).perform(click());
    }

    // check that you can view what aisle an item is on from the list
    @Test
    public void seeInfoAboutItemAisleAfterAddingToList(){
        String itemTest = "Potatoes";
        String aisleCheck = "Aisle: 2";
        String aisleDescriptionCheck = "Aisle Description: Between Aisle 1 and Frozen Aisle";
        onView(withId(R.id.navigation_search)).perform(click());
        onView(withId(R.id.SearchView)).perform(typeText(itemTest));
        onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(0).perform(click());
        onView(withText("ADD TO LIST")).perform(click());
        onView(withId(R.id.navigation_list)).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withText("YES")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(aisleCheck), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(aisleDescriptionCheck), isDisplayed())));
    }

    // able to see aisle information when viewing item from department view
    @Test
    public void seeInfoAboutItemAisleFromDepartmentView() {
        String itemTest = "Bell Peppers";
        String aisleCheck = "Aisle: 2";
        String aisleDescriptionCheck = "Aisle Description: Between Aisle 1 and Frozen Aisle";
        onView(withId(R.id.navigation_home)).perform(click());
        onView(withId(R.id.card_view_department)).perform(click());
        onView(withText("Produce")).perform(click());
        onView(withId(R.id.department_items_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(16, click()));
        onView(withText("VIEW MORE INFORMATION")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(aisleCheck), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(aisleDescriptionCheck), isDisplayed())));
    }
}
