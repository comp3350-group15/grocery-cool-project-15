package comp3350.grocerystoreassistant.location.locatorInterface;

import java.util.ArrayList;

import comp3350.grocerystoreassistant.objects.groceryStore.Store;

public interface LocatorCallback {
    public void onResponse(ArrayList<Store> stores);
}
