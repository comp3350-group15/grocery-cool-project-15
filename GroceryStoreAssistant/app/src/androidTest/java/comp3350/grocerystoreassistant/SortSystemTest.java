package comp3350.grocerystoreassistant;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import androidx.test.rule.ActivityTestRule;

import comp3350.grocerystoreassistant.R;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;

import comp3350.grocerystoreassistant.presentation.suggestedRecipeActivity.SuggestedRecipeActivity;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortSystemTest {

    @Rule
    public ActivityTestRule<SuggestedRecipeActivity> activityRule = new ActivityTestRule<>(SuggestedRecipeActivity.class);

    @Test
    public void test1_SortingAlphabetical(){
        onView(withId(R.id.navigation_list)).perform(click());
        onView(withId(R.id.filter_items_drop_down_list)).perform(click());
        onData(anything()).atPosition(2).perform(click()); // Alphabetical
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(0, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Apples"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(1, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Apples"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(2, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Green Beans"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(3, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Milk, Chocolate"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(4, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Navel Oranges"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(5, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Pineapple"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(6, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Potatoes"), isDisplayed())));
    }

    @Test
    public void test2_SortingByPrice(){
        onView(withId(R.id.navigation_list)).perform(click());
        onView(withId(R.id.filter_items_drop_down_list)).perform(click());
        onData(anything()).atPosition(3).perform(click()); // Price
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(0, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Potatoes"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(1, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Green Beans"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(2, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Apples"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(3, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Apples"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(4, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Navel Oranges"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(5, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Pineapple"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(6, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Milk, Chocolate"), isDisplayed())));
    }

    @Test
    public void test3_SortingTimeAdded(){
        onView(withId(R.id.navigation_list)).perform(click());
        onView(withId(R.id.filter_items_drop_down_list)).perform(click());
        onData(anything()).atPosition(1).perform(click()); // Time Added(oldest to newest)(default)
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(0, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Navel Oranges"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(1, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Milk, Chocolate"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(2, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Apples"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(3, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Potatoes"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(4, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Apples"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(5, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Pineapple"), isDisplayed())));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(actionOnItemAtPosition(6, click()));
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring("Green Beans"), isDisplayed())));
    }
}
