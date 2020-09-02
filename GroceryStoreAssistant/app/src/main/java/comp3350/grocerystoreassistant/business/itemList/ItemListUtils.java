package comp3350.grocerystoreassistant.business.itemList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import comp3350.grocerystoreassistant.business.AccessItems;
import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.persistence.stubs.ItemPersistenceStub;

public class ItemListUtils {

    // parameters - itemsInList -- a list of names of items that are in the user's grocery list
    // how -- how the list is to be sorted by
    public static List sort(List itemsInList, String how, List dates){
        AccessItems accessItems = new AccessItems(new ItemPersistenceStub());
        List<GroceryItem> list = accessItems.getAllItems();

        List<GroceryItem> returnList = new ArrayList<GroceryItem>(); // list that will store the current items
        // and sort them
        // take the list of names and make it into a list of grocery items
        for (int i = 0; i < itemsInList.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getName().equals(itemsInList.get(i).toString())) {
                    returnList.add(list.get(j));
                }
            }
        }
        if(how.equals("Alphabetical")) {
            if (returnList.size() > 0) {
                for (int swap = 0; swap < returnList.size() - 1; swap++) {
                    for (int where = 0; where < returnList.size() - swap - 1; where++) {
                        if (returnList.get(where).getName().compareTo(returnList.get(where + 1).getName()) > 0) {
                            GroceryItem temp = returnList.get(where);
                            Date tempDate = (Date)dates.get(where);
                            returnList.set(where, returnList.get(where + 1));
                            dates.set(where, dates.get(where+1));
                            returnList.set(where + 1, temp);
                            dates.set(where+1, tempDate);

                        }
                    }
                }
            }
        } else if(how.equals("Time Added (oldest to newest)(default)")) {
            if (returnList.size() > 0 && dates.size() > 0) {
                for (int start = 0; start < dates.size(); start++) {
                    for (int swap = 0; swap < dates.size() - start - 1; swap++)
                        if (dates.get(swap).toString().compareTo(dates.get(swap + 1).toString()) > 0) {
                            GroceryItem temp = returnList.get(swap);
                            Date tempDate = (Date)dates.get(swap);
                            returnList.set(swap, returnList.get(swap+1));
                            dates.set(swap, dates.get(swap+1));
                            returnList.set(swap+1, temp);
                            dates.set(swap+1, tempDate);
                        }
                }
            }
        } else if(how.equals("Price")) {
            if (returnList.size() > 0 && dates.size() > 0) {
                for (int i = 0; i < returnList.size(); i++) {
                    for (int j = 0; j < returnList.size() - i - 1; j++) {
                        if (returnList.get(j).getPrice() > returnList.get(j + 1).getPrice()) {
                            GroceryItem temp = returnList.get(j);
                            Date tempDate = (Date) dates.get(j);
                            returnList.set(j, returnList.get(j + 1));
                            dates.set(j, dates.get(j + 1));
                            returnList.set(j + 1, temp);
                            dates.set(j + 1, tempDate);
                        }
                    }
                }
            }
        }

        return returnList;
    }
}
