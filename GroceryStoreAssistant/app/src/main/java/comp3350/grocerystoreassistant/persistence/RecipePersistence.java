package comp3350.grocerystoreassistant.persistence;

import java.util.List;

import comp3350.grocerystoreassistant.objects.RecipeItem;
public interface RecipePersistence {
    List<RecipeItem> getAllRecipes();
    RecipeItem insertRecipe(RecipeItem item);
    RecipeItem updateRecipe(RecipeItem item);
    void deleteRecipe(RecipeItem item);
}
