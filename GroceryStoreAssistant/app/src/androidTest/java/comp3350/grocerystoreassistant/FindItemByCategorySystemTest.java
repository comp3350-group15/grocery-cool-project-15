package comp3350.grocerystoreassistant;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.presentation.HomeActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

public class FindItemByCategorySystemTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void verifyDepartmentsAreClickable(){
        onView(withId(R.id.card_view_department)).perform(click());
        assert(onView(withText("Produce")).perform(click()) != null);
        assert(onView(withText("Deli")).perform(click()) != null);
        assert(onView(withText("Dairy")).perform(click()) != null);
        assert(onView(withText("Frozen")).perform(click()) != null);
        assert(onView(withText("Meat")).perform(click()) != null);
        assert(onView(withText("Other")).perform(click()) != null); // ensure all buttons are clickable
    }

    @Test
    public void clickOnItemInDepartmentAndVerifyItIsOfTheRightCategory(){
        // click on an item in the list and then verify that it is of the right category
        onView(withId(R.id.card_view_department)).perform(click());
        onView(withText("Produce")).perform(click());
        onView(withId(R.id.department_items_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(5, click()));
        onView(withText("VIEW MORE INFORMATION")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Department: Produce"), isDisplayed())));
        onView(withText("OK")).perform(click());
        Espresso.pressBack();

        onView(withText("Deli")).perform(click());
        onView(withId(R.id.department_items_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(7, click()));
        onView(withText("VIEW MORE INFORMATION")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Department: Deli"), isDisplayed())));
        onView(withText("OK")).perform(click());
        Espresso.pressBack();

        onView(withText("Dairy")).perform(click());
        onView(withId(R.id.department_items_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(withText("VIEW MORE INFORMATION")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Department: Dairy"), isDisplayed())));
        onView(withText("OK")).perform(click());
        Espresso.pressBack();

        onView(withText("Frozen")).perform(click());
        onView(withId(R.id.department_items_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(4, click()));
        onView(withText("VIEW MORE INFORMATION")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Department: Frozen"), isDisplayed())));
        onView(withText("OK")).perform(click());
        Espresso.pressBack();

        onView(withText("Meat")).perform(click());
        onView(withId(R.id.department_items_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withText("VIEW MORE INFORMATION")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Department: Meat"), isDisplayed())));
        onView(withText("OK")).perform(click());
        Espresso.pressBack();

        onView(withText("Other")).perform(click());
        onView(withId(R.id.department_items_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(6, click()));
        onView(withText("VIEW MORE INFORMATION")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Department: Other"), isDisplayed())));
        onView(withText("OK")).perform(click());
        Espresso.pressBack();
    }
}
