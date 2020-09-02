package comp3350.grocerystoreassistant.presentation.suggestedRecipeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.objects.RecipeItem;
import comp3350.grocerystoreassistant.persistence.stubs.RecipePersistenceStub;
import comp3350.grocerystoreassistant.presentation.HomeActivity;
import comp3350.grocerystoreassistant.presentation.SearchActivity;
import comp3350.grocerystoreassistant.presentation.listActivity.GroceryListActivity;

public class SuggestedRecipeActivity extends AppCompatActivity {

    private MaterialCardView allRecipesCardView;
    private MaterialCardView breakfastRecipesCardView;
    private MaterialCardView lunchRecipesCardView;
    private MaterialCardView dinnerRecipesCardView;
    private MaterialCardView dessertSidesExtrasCardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_recipes);
        allRecipesCardView = (MaterialCardView) this.findViewById(R.id.all_suggested_recipes_card_view);
        breakfastRecipesCardView = (MaterialCardView) this.findViewById(R.id.breakfast_recipes_card_view);
        lunchRecipesCardView = (MaterialCardView) this.findViewById(R.id.lunch_recipes_card_view);
        dinnerRecipesCardView = (MaterialCardView) this.findViewById(R.id.dinner_recipes_card_view);
        dessertSidesExtrasCardView = (MaterialCardView) this.findViewById(R.id.dessertsidesextras_card_view);

        allRecipesCardView.setOnClickListener(allRecipesCallback);
        breakfastRecipesCardView.setOnClickListener(breakfastRecipesCallback);
        lunchRecipesCardView.setOnClickListener(lunchRecipesCallback);
        dinnerRecipesCardView.setOnClickListener(dinnerRecipesCallback);
        dessertSidesExtrasCardView.setOnClickListener(dessertSidesExtrasCallback);
    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent newHomeIntent = new Intent(this, HomeActivity.class);
                    newHomeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(newHomeIntent);
                    return true;
                case R.id.navigation_search:
                    Intent newSearchIntent = new Intent(this, SearchActivity.class);
                    newSearchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(newSearchIntent);
                    return true;
                case R.id.navigation_list:
                    Intent newListIntent = new Intent(this, GroceryListActivity.class);
                    newListIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(newListIntent);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        View.OnClickListener allRecipesCallback = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent allSuggestedRecipesIntent = new Intent(getApplicationContext(), SuggestedRecipeListActivity.class);
                String category = "all";
                allSuggestedRecipesIntent.putExtra("Category", category);
                startActivity(allSuggestedRecipesIntent);

            }
        };

        View.OnClickListener breakfastRecipesCallback = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent breakfastRecipesIntent = new Intent(getApplicationContext(), SuggestedRecipeListActivity.class);
                String category = "Breakfast";
                breakfastRecipesIntent.putExtra("Category", category);
                startActivity(breakfastRecipesIntent);

            }
        };

        View.OnClickListener lunchRecipesCallback = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent lunchRecipesIntent = new Intent(getApplicationContext(), SuggestedRecipeListActivity.class);
                String category = "Lunch";
                lunchRecipesIntent.putExtra("Category", category);
                startActivity(lunchRecipesIntent);
            }
        };

        View.OnClickListener dinnerRecipesCallback = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent dinnerRecipesIntent = new Intent(getApplicationContext(), SuggestedRecipeListActivity.class);
                String category = "Dinner";
                dinnerRecipesIntent.putExtra("Category", category);
                startActivity(dinnerRecipesIntent);

            }
        };

        View.OnClickListener dessertSidesExtrasCallback = new View.OnClickListener () {
            @Override
            public void onClick(View view){
                Intent dessertRecipesIntent = new Intent(getApplicationContext(), SuggestedRecipeListActivity.class);
                String category = "Dessert";
                dessertRecipesIntent.putExtra("Category", category);
                startActivity(dessertRecipesIntent);
            }
        };
}
