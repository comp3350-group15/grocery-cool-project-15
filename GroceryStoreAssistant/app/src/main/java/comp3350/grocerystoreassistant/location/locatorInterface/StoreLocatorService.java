package comp3350.grocerystoreassistant.location.locatorInterface;

import android.app.Activity;

import org.json.JSONObject;

import java.util.ArrayList;

import comp3350.grocerystoreassistant.objects.groceryStore.Store;

public interface StoreLocatorService {
    
    public void requestNearbyStore(LocatorCallback callback);

    public ArrayList<Store> getNearbyStoreStub();

    public ArrayList<Store> getNearbyFetchedStore();

    public void setUserLocation(double[] userLocation);

    public void setActivity(Activity activity);
}
