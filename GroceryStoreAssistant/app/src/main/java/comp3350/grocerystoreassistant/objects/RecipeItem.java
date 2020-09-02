package comp3350.grocerystoreassistant.objects;

import java.util.ArrayList;
import java.util.List;

/**Class RecipeItem -- to store information about suggested recipes which will be suggested to the
user and will have information such as ingredients directions etc
 */
public class RecipeItem {
    private String recipeName; /** the name of the recipe **/
    private List<GroceryItem> items; /** the GroceryItems that are in the list, stored as
     a list of GroceryItems so that they can be added to a grocery list if necessary**/
    private List<String> ingredientsDisplay; /**An array list of Strings to store the ingredients.
     While there is already a list of GroceryItems being stored, displaying the physical GroceryItem
     itself will not be as useful when displaying to the user in the recipe, as for example the
     GroceryItem may say "Milk, White, 1L jug". However, in the display to the user, it would simply
     just say "Milk", for example, as this is more useful in terms of a recipe and understanding, etc,
     as well as for purposes such as quantities of ingredients, if the actual GroceryItem was displayed
     would cause for "unusual" quantities of ingredients, depending on the item. So essentially, it is
     stored as GroceryItems as well as Strings so that it is easy to be able to add items from a recipe
     to a GroceryList, but, to also maintain a "good"/understandable display for the user.**/
     private List<String> ingredientQuantities; /** Quantities of the ingredients needed for the recipe **/
     private List<String> directions; /** Cooking directions **/
     private String yields; /** How many servings this recipe yields**/
     private String category; /** Category of the recipe e.g. Dinner, etc**/


     public RecipeItem(String recipeName, List<GroceryItem> groceryItems, List<String> ingredients, List<String> quantities,
                       List<String> directions, String servings, String category){
         this.recipeName = recipeName;
         items = groceryItems;
         ingredientsDisplay = ingredients;
         ingredientQuantities = quantities;
         this.directions = directions;
         yields = servings;
         this.category = category;
     }

     public String getName(){
         return recipeName;
     }

     public List<GroceryItem> getGroceryItems(){
         return items;
     }

     public List<String> getIngredientsToDisplay(){
         return ingredientsDisplay;
     }

     public List<String> getIngredientQuantities(){
         return ingredientQuantities;
     }

     public List<String> getDirections(){
         return directions;
     }

     public String getYields(){
         return yields;
     }

     public String getRecipeCategory(){
         return category;
     }
}


