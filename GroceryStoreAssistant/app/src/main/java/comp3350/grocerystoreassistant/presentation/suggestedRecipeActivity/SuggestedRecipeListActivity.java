package comp3350.grocerystoreassistant.presentation.suggestedRecipeActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.business.AccessRecipes;
import comp3350.grocerystoreassistant.objects.RecipeItem;
import comp3350.grocerystoreassistant.persistence.stubs.RecipePersistenceStub;
import comp3350.grocerystoreassistant.presentation.HomeActivity;
import comp3350.grocerystoreassistant.presentation.SearchActivity;
import comp3350.grocerystoreassistant.presentation.listActivity.GroceryListActivity;

public class SuggestedRecipeListActivity extends AppCompatActivity {

    private ListView myListView;
    private List<RecipeItem> list;
    private ArrayList<String> recipes;
    private ArrayAdapter<String> adapter;
    private AccessRecipes accessRecipes;
    String category;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_recipes_list);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            category = extras.getString("Category");
        }
        accessRecipes = new AccessRecipes(new RecipePersistenceStub());
        myListView = (ListView) findViewById(R.id.myList);
        list = accessRecipes.getAllRecipes();
        recipes = new ArrayList<String>();

        if(category != null) {
            if (category.equalsIgnoreCase("All")) {
                for (int itemToAdd = 0; itemToAdd < list.size(); itemToAdd++) {
                    recipes.add(list.get(itemToAdd).getName());
                }
            } else if (category.equalsIgnoreCase("Lunch")) {
                for (int itemToAdd = 0; itemToAdd < list.size(); itemToAdd++) {
                    if (list.get(itemToAdd).getRecipeCategory().equalsIgnoreCase("Lunch")) {
                        recipes.add(list.get(itemToAdd).getName());
                    }
                }
            } else if (category.equalsIgnoreCase("Dinner")) {
                for (int itemToAdd = 0; itemToAdd < list.size(); itemToAdd++) {
                    if (list.get(itemToAdd).getRecipeCategory().equalsIgnoreCase("Dinner")) {
                        recipes.add(list.get(itemToAdd).getName());
                    }
                }
            } else if (category.equalsIgnoreCase("Breakfast")) {
                for (int itemToAdd = 0; itemToAdd < list.size(); itemToAdd++) {
                    if (list.get(itemToAdd).getRecipeCategory().equalsIgnoreCase("Breakfast")) {
                        recipes.add(list.get(itemToAdd).getName());
                    }
                }
            } else if (category.equalsIgnoreCase("Dessert") || category.equalsIgnoreCase("Salad")) {
                for (int itemToAdd = 0; itemToAdd < list.size(); itemToAdd++) {
                    if (list.get(itemToAdd).getRecipeCategory().equalsIgnoreCase("Dessert") || list.get(itemToAdd).
                            getRecipeCategory().equalsIgnoreCase("Salad")) {
                        recipes.add(list.get(itemToAdd).getName());
                    }
                }
            }
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recipes);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> li, View v, int i, long l) {

                for(int itemSearch = 0; itemSearch < recipes.size(); itemSearch++) {
                    if (myListView.getAdapter().getItem(i).equals(recipes.get(itemSearch))) {
                        displayOptionButton(itemSearch);
                    }
                }
            }
        });

    }

    private void displayOptionButton(int i) {
        Context context = SuggestedRecipeListActivity.this;
        final int j = i;
        AlertDialog.Builder alert = new AlertDialog.Builder(context);

        alert.setTitle("View recipe?");

        alert.setMessage("Would you like to view more information about: " + recipes.get(i) + " ? ");

        alert.setCancelable(true);

        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog.Builder newAlert = new AlertDialog.Builder(SuggestedRecipeListActivity.this);
                List ingredients = new ArrayList<>();
                List quantities = new ArrayList<>();
                List directions = new ArrayList<>();
                String ingredientsQuantitiesMessage = "\n";
                String directionsMessage = "\n";
                String servings = "\n";
                String category = "\n";
                for(int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().equals(recipes.get(j))) {
                        ingredients = list.get(i).getIngredientsToDisplay();
                        quantities = list.get(i).getIngredientQuantities();
                        directions = list.get(i).getDirections();
                        servings = list.get(i).getYields();
                        category = list.get(i).getRecipeCategory();
                        for(int k = 0; k < list.get(i).getIngredientsToDisplay().size(); k++) {
                            Log.d("STUB", String.valueOf(list.get(i).getIngredientsToDisplay().size() + " , " + quantities.size() + " , " + ingredients.size()));
                            ingredientsQuantitiesMessage += quantities.get(k) + " " + ingredients.get(k) + "\n";
                        }
                        for(int dir = 0; dir < list.get(i).getDirections().size(); dir++) {
                            directionsMessage += directions.get(dir) + "\n";
                        }
                    }
                }
                newAlert.setMessage("\nName: " + recipes.get(j) + "\n\nIngredients: " + ingredientsQuantitiesMessage + "\nCooking Directions: "
                + directionsMessage + "\nServings: " + servings + "\nRecipe Category: " + category);
                newAlert.setPositiveButton("ADD INGREDIENTS TO LIST", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent newAddToListIntent = new Intent(getApplicationContext(), GroceryListActivity.class);
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getName().equals(recipes.get(j))) {
                                Bundle extras = new Bundle(list.get(i).getGroceryItems().size() + 1);
                                extras.putString("add", "addToList");
                                for(int x = 0; x < list.get(i).getGroceryItems().size(); x++) {
                                    String key = "item"+x;
                                    extras.putString(key, list.get(i).getGroceryItems().get(x).getName());
                                }
                                newAddToListIntent.putExtras(extras);
                            }
                        }

                        startActivity(newAddToListIntent);
                    }
                });
                newAlert.setNeutralButton("CANCEL", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which){
                        dialogInterface.cancel();
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = newAlert.create();
                alertDialog.show();
            }
        });

        alert.setNeutralButton("CANCEL", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int which){
                    dialogInterface.cancel();
                    dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
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
}