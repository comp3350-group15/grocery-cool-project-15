package comp3350.grocerystoreassistant.business.itemList;

/** GroceryList
 * A class for a user's grocery list.
 * Use this class if you want to make a list that is for user's grocery list
 */
public class GroceryList extends ItemList {

    private static int nextID = 0;

    private String name; // the name of the grocery list (maybe, the user want to name it (?) )
    private int id; // ID of the grocery list, useful if we want to implement past grocery list.

    public GroceryList() {
        super();
        id = nextID;
        nextID++;

        name = "";
    }

    public GroceryList(String name) {
        super();
        id = nextID;
        nextID++;

        this.name = name;
    }

    public void setListName(String name) {
        this.name = name;
    }

    public String getListName() {
        return this.name;
    }

    public int getID() {
        return this.id;
    }
}
