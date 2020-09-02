package comp3350.grocerystoreassistant.location.locatorFacade;

import android.app.Activity;

import java.util.ArrayList;

import comp3350.grocerystoreassistant.location.ActivityLocationAdapter;
import comp3350.grocerystoreassistant.location.locatorInterface.LocatorCallback;
import comp3350.grocerystoreassistant.location.locatorInterface.StoreLocatorService;
import comp3350.grocerystoreassistant.objects.groceryStore.Store;

public class StoreLocator extends ActivityLocationAdapter {

    private StoreLocatorService mStoreLocator;
    private boolean storeFetched;
    private double[] userLocation;

    public StoreLocator() {
        super();
        mStoreLocator = null;
        userLocation = null;
        storeFetched = false;
    }

    public StoreLocator(StoreLocatorService storeLocator) {
        super();
        mStoreLocator = storeLocator;
        userLocation = null;
        storeFetched = false;
    }

    public void setup(Activity activity, double[] userLocation) {
        this.setActivity(activity);
        this.userLocation = userLocation;

        this.mStoreLocator.setActivity(this.getAppActivity());
        this.mStoreLocator.setUserLocation(this.userLocation);
    }

    public void locateNearbyStore(LocatorCallback callback) {
        mStoreLocator.requestNearbyStore(callback);
        storeFetched = true;
    }

    public ArrayList<Store> getNearbyStoreStub() {
        return this.mStoreLocator.getNearbyStoreStub();
    }

    public void setUserLocation(double[] userLocation) {
        this.userLocation = userLocation;
        this.mStoreLocator.setUserLocation(this.userLocation);
    }

    public double[] getUserLocation() {
        return this.userLocation;
    }

    public ArrayList<Store> getFetchedNearbyStore() {
        return this.mStoreLocator.getNearbyFetchedStore();
    }

    public boolean isStoreFetched() {
        return this.storeFetched;
    }
}
