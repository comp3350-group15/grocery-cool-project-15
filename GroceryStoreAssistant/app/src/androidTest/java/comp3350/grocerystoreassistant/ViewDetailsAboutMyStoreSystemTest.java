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
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.allOf;

public class ViewDetailsAboutMyStoreSystemTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void seeStoreDetails(){
        onView(withId(R.id.card_view_findstore)).perform(click());
        // verify store details show for store
        onView(withId(R.id.store_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
        // check for details that should be present
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_photo)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_name)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_address_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_website_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_phone_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_rating_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_hours_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_address_text)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_website_text)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_phone_text)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_rating_text)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_hours_text)))));

        Espresso.pressBack();
        // do for 3 total stores

        onView(withId(R.id.store_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(7, click()));
        // check for details that should be present
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_photo)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_name)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_address_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_website_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_phone_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_rating_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_hours_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_address_text)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_website_text)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_phone_text)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_rating_text)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_hours_text)))));

        Espresso.pressBack();
        onView(withId(R.id.store_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(11, click()));
        // check for details that should be present
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_photo)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_name)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_address_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_website_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_phone_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_rating_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_hours_icon)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_address_text)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_website_text)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_phone_text)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_rating_text)))));
        onView(withId(R.id.form_layout)).check(matches(allOf(withChild(withId(R.id.layout_store_page_hours_text)))));
    }
}
