package comp3350.grocerystoreassistant;

import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.PerformException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import java.util.List;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.objects.GroceryItem;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;

import comp3350.grocerystoreassistant.persistence.stubs.ItemPersistenceStub;
import comp3350.grocerystoreassistant.presentation.SearchActivity;


@RunWith(AndroidJUnit4.class)
@LargeTest

public class SearchActivityTest {

    @Rule
    public ActivityTestRule<SearchActivity> activityRule
            = new ActivityTestRule<>(
            SearchActivity.class);



    @Test
    public void verifyDialogBoxShows(){
        ItemPersistenceStub itemPersistenceStub = new ItemPersistenceStub();
        List<GroceryItem> list = itemPersistenceStub.getAllItems();
        onView(withId(R.id.SearchView)).perform(typeText("Apples"));
        onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(0).perform(click());
        onView(withText("VIEW MORE INFORMATION")).perform(click());
        onView(withId(android.R.id.message)).check(matches(withSubstring("Apples"))); // Verify correct one
    }


    @Test
    public void verifyContainsSubstring() {
        ItemPersistenceStub itemPersistenceStub = new ItemPersistenceStub();
        List<GroceryItem> list = itemPersistenceStub.getAllItems();
        onView(withId(R.id.SearchView)).perform(typeText("Milk"));

        for (int i = 0; i < list.size(); i++) {
            try {
                onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(i).check(matches(withText(containsString("Milk"))));
            } catch (PerformException p) {
                Log.d("Done", "No more clickable buttons in the list.");
                break;
            }
        }
    }

    @Test (expected = java.lang.NullPointerException.class)
    public void verifySearchFail(){
        ItemPersistenceStub itemPersistenceStub = new ItemPersistenceStub();
        List<GroceryItem> list = itemPersistenceStub.getAllItems();
        onView(withId(R.id.SearchView)).perform(typeText("uherguuwer9fwbwue9bhweug9fwbu9egb"));
        onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(0).check(matches(null));
    }
}
