package comp3350.grocerystoreassistant.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.persistence.ItemPersistence;
import comp3350.grocerystoreassistant.persistence.ItemPersistenceException;

public class ItemPersistenceHSQLDB implements ItemPersistence {
    private final String dbPath;

    public ItemPersistenceHSQLDB(final String dbPath){
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException{
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private GroceryItem fromResultSet(final ResultSet rs) throws SQLException {
        final String name = rs.getString("name");
        final double price = rs.getDouble("price");
        final String pricePerWeight = rs.getString("pricePerWeight");
        final boolean onSale = rs.getInt("onSale")!=0;
        final double onSalePrice = rs.getDouble("onSalePrice");
        final int calories = rs.getInt("calories");
        final int fat = rs.getInt("fat");
        final int saturatedFat = rs.getInt("saturatedFat");
        final int transFat = rs.getInt("transFat");
        final int cholesterol = rs.getInt("cholesterol");
        final int sodium = rs.getInt("sodium");
        final int carbohydrates = rs.getInt("carbohydrates");
        final int fiber = rs.getInt("fiber");
        final int sugar = rs.getInt("sugar");
        final int protein = rs.getInt("protein");
        final int potassium = rs.getInt("potassium");
        final String perAmount = rs.getString("perAmount");
        final int aisle = rs.getInt("aisle");
        final String aisleDescription = rs.getString("aisleDescription");
        final String department = rs.getString("department");
        return new GroceryItem(name,price,pricePerWeight,onSale,onSalePrice,calories,fat,saturatedFat,transFat,cholesterol,sodium,carbohydrates,fiber,sugar,protein,potassium,perAmount,aisle,aisleDescription,department);
    }

    @Override
    public List<GroceryItem> getAllItems() {
        final List<GroceryItem> items = new ArrayList<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM items");
            while(rs.next()){
                final GroceryItem item = fromResultSet(rs);
                items.add(item);
            }
            rs.close();
            st.close();

            return items;
        }
        catch (final SQLException e){
            throw new ItemPersistenceException(e);
        }
    }

    @Override
    public GroceryItem insertItem(GroceryItem item) {
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO items VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            st.setString(1,item.getName());
            st.setDouble(2,item.getPrice());
            st.setString(3,item.getPricePerWeight());
            st.setInt(4,item.isOnSale() ? 1 : 0);
            st.setDouble(5,item.getOnSalePrice());
            st.setInt(6,item.getCalories());
            st.setInt(7,item.getFat());
            st.setInt(8,item.getSaturatedFat());
            st.setInt(9,item.getTransFat());
            st.setInt(10,item.getCholesterol());
            st.setInt(11,item.getSodium());
            st.setInt(12,item.getCarbohydrates());
            st.setInt(13,item.getFiber());
            st.setInt(14,item.getSugar());
            st.setInt(15,item.getProtein());
            st.setInt(16,item.getPotassium());
            st.setString(17,item.getPerAmount());
            st.setInt(18,item.getAisle());
            st.setString(19,item.getAisleDescription());
            st.setString(20,item.getDepartment());

            st.executeUpdate();

            return item;
        }
        catch(final SQLException e){
            throw new ItemPersistenceException(e);
        }
    }

    @Override
    public GroceryItem updateItem(GroceryItem item) {
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("UPDATE items SET price = ?, pricePerWeight = ?, onSale = ?, onSalePrice = ?, calories = ?, fat = ?, saturatedFat = ?, transFat = ?, cholesterol = ?, sodium = ?, carbohydrates = ?, fiber = ?, sugar = ?, protein = ?, potassium = ?, perAmount = ?, aisle = ?, aisleDescription = ?, department = ? WHERE name = ?");
            st.setDouble(1,item.getPrice());
            st.setString(2,item.getPricePerWeight());
            st.setInt(3,item.isOnSale() ? 1 : 0);
            st.setDouble(4,item.getOnSalePrice());
            st.setInt(5,item.getCalories());
            st.setInt(6,item.getFat());
            st.setInt(7,item.getSaturatedFat());
            st.setInt(8,item.getTransFat());
            st.setInt(9,item.getCholesterol());
            st.setInt(10,item.getSodium());
            st.setInt(11,item.getCarbohydrates());
            st.setInt(12,item.getFiber());
            st.setInt(13,item.getSugar());
            st.setInt(14,item.getProtein());
            st.setInt(15,item.getPotassium());
            st.setString(16,item.getPerAmount());
            st.setInt(17,item.getAisle());
            st.setString(18,item.getAisleDescription());
            st.setString(19,item.getDepartment());
            st.setString(20,item.getName());

            st.executeUpdate();

            return item;
        }
        catch(final SQLException e){
            throw new ItemPersistenceException(e);
        }
    }

    @Override
    public void deleteItem(GroceryItem item) {
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("DELETE FROM items WHERE name = ?");
            st.setString(1,item.getName());
            st.executeUpdate();
        }
        catch(final SQLException e){
            throw new ItemPersistenceException(e);
        }
    }
}
