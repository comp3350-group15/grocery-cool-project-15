package comp3350.grocerystoreassistant.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLPermission;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import comp3350.grocerystoreassistant.business.SearchItems;
import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.objects.RecipeItem;
import comp3350.grocerystoreassistant.persistence.ItemPersistenceException;
import comp3350.grocerystoreassistant.persistence.RecipePersistence;

public class RecipePersistenceHSQLDB implements RecipePersistence {
    private final String dbPath;

    public RecipePersistenceHSQLDB(final String dbPath) { this.dbPath = dbPath; }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file" + dbPath + ";shutdown=true", "SA", "");
    }

    private RecipeItem fromResultSet(final ResultSet rs) throws SQLException {
        final String recipeName = rs.getString("name");
        final String groceryItemsTemp = rs.getString("items");
        final String ingredientsTemp = rs.getString("ingredients");
        final String quantitiesTemp = rs.getString("quantities");
        final String directionsTemp = rs.getString("directions");
        final String servings = rs.getString("servings");
        final String category = rs.getString("category");
        List<GroceryItem> groceryItems = getGroceryItems(groceryItemsTemp);
        List<String> ingredients = parseItems(ingredientsTemp);
        List<String> quantities = parseItems(quantitiesTemp);
        List<String> directions = parseItems(directionsTemp);
        System.out.println("GITEMS: "+groceryItems.get(0));
        return new RecipeItem(recipeName,groceryItems,ingredients,quantities,directions,servings,category);
    }

    @Override
    public List<RecipeItem> getAllRecipes() {
        final List<RecipeItem> items = new ArrayList<>();

        System.out.println("HERE1: ");
        try(final Connection c = connection()){
            System.out.println("HERE2: ");
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM recipes");
            while(rs.next()){
                final RecipeItem item = fromResultSet(rs);
                items.add(item);
            }
            rs.close();
            st.close();

            return items;
        }
        catch(final SQLException e){
            throw new ItemPersistenceException(e);
        }
    }

    @Override
    public RecipeItem insertRecipe(RecipeItem item){
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO recipes VALUES(?, ?, ?, ?, ?, ?, ?)");

            st.setString(1,item.getName());
            st.setString(2,item.getIngredientsToDisplay().get(0));
            st.setString(3,item.getIngredientsToDisplay().get(1));
            st.setString(4,item.getIngredientQuantities().get(0));
            st.setString(5,item.getDirections().get(0));
            st.setString(6,item.getYields());
            st.setString(7,item.getRecipeCategory());

            st.executeUpdate();

            return item;
        }
        catch(final SQLException e){
            throw new ItemPersistenceException(e);
        }
    }

    @Override
    public RecipeItem updateRecipe(RecipeItem item){
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("UPDATE recipes SET items = ?, ingredients = ?, quantities = ?, directions = ?, servings = ?, category = ? WHERE name = ?");
            st.setString(1,item.getIngredientsToDisplay().get(0));
            st.setString(2,item.getIngredientsToDisplay().get(1));
            st.setString(3,item.getIngredientQuantities().get(0));
            st.setString(4,item.getDirections().get(0));
            st.setString(5,item.getYields());
            st.setString(6,item.getRecipeCategory());
            st.setString(7,item.getName());

            st.executeUpdate();

            return item;
        }
        catch(final SQLException e){
            throw new ItemPersistenceException(e);
        }
    }

    @Override
    public void deleteRecipe(RecipeItem item) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("DELETE FROM recipes WHERE name = ?");
            st.setString(1, item.getName());
            st.executeUpdate();
        } catch (final SQLException e) {
            throw new ItemPersistenceException(e);
        }
    }

    private List<String> parseItems(String list){
        String[] array = list.split("k");
        return Arrays.asList(array);
    }

    private List<GroceryItem> getGroceryItems(String recipeList){
        List<String> recipesStrings = parseItems(recipeList);
        List<GroceryItem> groceryItemList = new ArrayList<>();
        SearchItems searchItems = new SearchItems();
        for(String recipe: recipesStrings){
            GroceryItem groceryItem = searchItems.getItemByName(recipe);
            if(groceryItem != null){
                groceryItemList.add(groceryItem);
            }
        }
        return groceryItemList;
    }
}
