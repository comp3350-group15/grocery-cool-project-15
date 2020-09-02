package comp3350.grocerystoreassistant;

import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import java.util.List;

import comp3350.grocerystoreassistant.R;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;

import comp3350.grocerystoreassistant.objects.RecipeItem;
import comp3350.grocerystoreassistant.persistence.stubs.RecipePersistenceStub;
import comp3350.grocerystoreassistant.presentation.suggestedRecipeActivity.SuggestedRecipeActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class SuggestedRecipeSystemTest {

    @Rule
    public ActivityTestRule<SuggestedRecipeActivity> activityRule = new ActivityTestRule<>(SuggestedRecipeActivity.class);


    @Test
    public void verifyContainsSubstring() {
        RecipePersistenceStub recipePersistenceStub = new RecipePersistenceStub();
        List<RecipeItem> list = recipePersistenceStub.getAllRecipes();

        onView(withId(R.id.all_suggested_recipes_card_view)).perform(click());

        for (int i = 0; i < list.size(); i++) {
            RecipeItem r = list.get(i);
            onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(i).check(matches(withText(containsString(r.getName()))));
            onData(anything()).inAdapterView(withId(R.id.myList)).atPosition(i).perform(click());
            onView(withText("YES")).perform(click());
            onView(withText("CANCEL")).perform(click());
        }
    }

}
