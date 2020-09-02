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
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;

import comp3350.grocerystoreassistant.persistence.stubs.ItemPersistenceStub;
import comp3350.grocerystoreassistant.presentation.SearchActivity;

import	androidx.test.espresso.contrib.RecyclerViewActions;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddToListSystemTest {
    @Rule
    public ActivityTestRule<SearchActivity> activityRule
            = new ActivityTestRule<>(
            SearchActivity.class);



    @Test
    public void test1_verifySearchAndAddToEmptyList() {
        // verify that a search happens and then it adds it to the list,
        String itemTest = "Oranges";
        ItemPersistenceStub itemPersistenceStub = new ItemPersistenceStub();
        List<GroceryItem> list = itemPersistenceStub.getAllItems();
        onView(withId(R.id.SearchView)).perform(typeText(itemTest));
        onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(0).perform(click());
        onView(withText("ADD TO LIST")).perform(click());
    }


    @Test
    public void test2_verifyCorrectItemAdded(){
        String itemTest = "Oranges";
        onView(withId(R.id.navigation_list)).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withText("YES")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(itemTest), isDisplayed())));
    }

    @Test
    public void test3_addToListWithItemInIt(){
        String itemTest = "Chocolate";
        ItemPersistenceStub itemPersistenceStub = new ItemPersistenceStub();
        List<GroceryItem> list = itemPersistenceStub.getAllItems();
        onView(withId(R.id.SearchView)).perform(typeText(itemTest));
        onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(2).perform(click());
        onView(withText("ADD TO LIST")).perform(click());
    }

    @Test
    public void test4_verifyCorrectItemAddedWhenAddingToListWithItemsInIt(){
        String itemTest = "Chocolate";
        onView(withId(R.id.navigation_list)).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(withText("YES")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(itemTest), isDisplayed())));
    }

    @Test
    public void test5_addFromSearchByDepartment(){
        onView(withId(R.id.navigation_home)).perform(click());
        onView(withId(R.id.card_view_department)).perform(click());
        onView(withText("Produce")).perform(click());
        onView(withId(R.id.department_items_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withText("ADD TO LIST")).perform(click());
    }

    @Test
    public void test6_verifyAddedToListFromDepartmentView(){
        String itemTest = "Apples";
        onView(withId(R.id.navigation_list)).perform(click());
        onView(withId(R.id.item_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
        onView(withText("YES")).perform(click());
        onView(withId(android.R.id.message)).check(matches(allOf(withSubstring(itemTest), isDisplayed())));
    }
}
