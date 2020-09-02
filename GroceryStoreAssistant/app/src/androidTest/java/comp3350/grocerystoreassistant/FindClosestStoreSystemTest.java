package comp3350.grocerystoreassistant;

import android.util.Log;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.presentation.HomeActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class FindClosestStoreSystemTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void findClosestStoreToMe(){
        onView(withId(R.id.card_view_home)).perform(click());
        try {
            onView(withText("ALLOW")).perform(click());
        } catch(NoMatchingViewException nmve) {
            Log.d("System test", "Already gave permission.");
        }
        assert(isDisplayed() != null);
    }
}
