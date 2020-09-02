package comp3350.grocerystoreassistant;

import org.junit.Rule;
import org.junit.Test;

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

public class ViewMoreInformationSystemTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void viewMoreInformation(){
        onView(withId(R.id.navigation_search)).perform(click());
        onView(withId(R.id.SearchView)).perform(typeText("Apples"));
        onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(1).perform(click());
        onView(withText("VIEW MORE INFORMATION")).perform(click());

        // Make sure the information that is supposed to be displayed is displayed
        // Other system tests ensure that you see correct item
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Name:"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Price:"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("On Sale"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Nutritional Info"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Calories:"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Fat:"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Cholesterol:"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Sodium:"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Fiber:"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Sugar:"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Protein:"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Potassium:"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Serving Size:"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Location Info"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Aisle:"), isDisplayed())));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Department:"), isDisplayed())));
    }
}
