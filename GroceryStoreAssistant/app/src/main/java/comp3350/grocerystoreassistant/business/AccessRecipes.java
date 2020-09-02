package comp3350.grocerystoreassistant.business;

import java.util.List;

import comp3350.grocerystoreassistant.application.Services;
import comp3350.grocerystoreassistant.objects.RecipeItem;
import comp3350.grocerystoreassistant.persistence.RecipePersistence;

public class AccessRecipes {
    private RecipePersistence recipePersistence;

    public AccessRecipes() { recipePersistence = Services.getRecipePersistence(); }

    public AccessRecipes(final RecipePersistence recipePersistence){
        this.recipePersistence = recipePersistence;
    }

    public List<RecipeItem> getAllRecipes(){ return recipePersistence.getAllRecipes(); }
    public RecipeItem insertRecipe(RecipeItem item){ return recipePersistence.insertRecipe(item); }
    public RecipeItem updateRecipe(RecipeItem item){ return recipePersistence.updateRecipe(item); }
    public void deleteRecipe(RecipeItem item){ recipePersistence.deleteRecipe(item); }

}
