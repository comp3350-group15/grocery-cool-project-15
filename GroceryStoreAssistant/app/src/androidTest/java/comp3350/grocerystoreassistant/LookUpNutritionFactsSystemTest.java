package comp3350.grocerystoreassistant;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.presentation.HomeActivity;

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

public class LookUpNutritionFactsSystemTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    // from departmnet view
    @Test
    public void viewNutritionInfoWhenDepartmentView(){
        String nutritionMessage = "Nutritional Info";
        String nutritionTest2 = "Calories:";
        String nutritionTest3 = "Sugar";
        onView(withId(R.id.card_view_department)).perform(click());
        onView(withText("Produce")).perform(click());
        onView(withId(R.id.department_items_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
        onView(withText("VIEW MORE INFORMATION")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(nutritionMessage), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(nutritionTest2), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(nutritionTest3), isDisplayed())));
    }

    // from search view
    @Test
    public void viewNutritionInfoFromSearchView(){
        String nutritionMessage = "Nutritional Info";
        String nutritionTest2 = "Fat:";
        String nutritionTest3 = "Sodium:";
        onView(withId(R.id.navigation_search)).perform(click());
        onView(withId(R.id.SearchView)).perform(typeText("Milk"));
        onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(0).perform(click());
        onView(withText("VIEW MORE INFORMATION")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(nutritionMessage), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(nutritionTest2), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(nutritionTest3), isDisplayed())));
    }

    @Test
    public void viewNutritionInfoAfterAddingItemToList(){
        String nutritionMessage = "Nutritional Info";
        String nutritionTest2 = "Cholesterol:";
        String nutritionTest3 = "Fiber:";
        onView(withId(R.id.navigation_search)).perform(click());
        onView(withId(R.id.SearchView)).perform(typeText("Green Beans"));
        onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(0).perform(click());
        onView(withText("ADD TO LIST")).perform(click());
        onView(withId(R.id.navigation_list)).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(5, click()));
        onView(withText("YES")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(nutritionMessage), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(nutritionTest2), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(nutritionTest3), isDisplayed())));
    }
}
