package comp3350.grocerystoreassistant.presentation;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.card.MaterialCardView;

import org.json.JSONObject;

import java.util.ArrayList;


import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.application.Services;
import comp3350.grocerystoreassistant.location.locatorFacade.StoreLocator;
import comp3350.grocerystoreassistant.location.locatorImplementation.GooglePlacesServices;
import comp3350.grocerystoreassistant.location.locatorInterface.LocatorCallback;
import comp3350.grocerystoreassistant.location.locatorInterface.StoreLocatorService;

import comp3350.grocerystoreassistant.objects.groceryStore.Store;
import comp3350.grocerystoreassistant.presentation.departmentActivity.DepartmentActivity;
import comp3350.grocerystoreassistant.presentation.listActivity.GroceryListActivity;
import comp3350.grocerystoreassistant.presentation.storeActivity.StoreListActivity;
import comp3350.grocerystoreassistant.presentation.mapActivity.StoreLocationActivity;
import comp3350.grocerystoreassistant.location.PermissionsPackage;
import comp3350.grocerystoreassistant.location.UserLocation;
import comp3350.grocerystoreassistant.presentation.suggestedRecipeActivity.SuggestedRecipeActivity;

public class HomeActivity extends AppCompatActivity {

    /**
     * set DEBUG_MODE to false if you want to use the Places API
     * You can try a couple of time using the API but please don't make a tons of call
     * my free credit for Google Cloud will run out quickly lol ;)
     * <p>
     * set to false if you want to test the Places API or if you need some other data for the store.
     * --devin
     */
    private final boolean DEBUG_MODE = true;

    private final String TAG = ".HomeActivity";
    private MaterialCardView mapsCardView;
    private MaterialCardView findStoreView;
    private MaterialCardView departmentView;
    private MaterialCardView suggestedRecipesView;

    private StoreLocator mStoreLocator;


    private Double mDefaultLatitude = 49.8096;
    private Double mDefaultLongitude = -97.1327;
    private Double mLatitude;
    private Double mLongitude;

    private ArrayList<Store> currentStores;

    private boolean permissionGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mStoreLocator = Services.getStoreLocator();

        if (mStoreLocator.isStoreFetched()) {
            double[] userLocation = mStoreLocator.getUserLocation();
            // get the last information of fetched locations
            mLongitude = userLocation[0];
            mLatitude = userLocation[1];
            currentStores = mStoreLocator.getFetchedNearbyStore();
        } else {
            double[] userLocation = {mDefaultLatitude, mDefaultLongitude};
            mStoreLocator.setup(this, userLocation);
        }


        // Bind Button UI
        // Find Store Button
        mapsCardView = (MaterialCardView) this.findViewById(R.id.card_view_home);
        mapsCardView.setOnClickListener(googleMapCallback);

        findStoreView = (MaterialCardView) this.findViewById(R.id.card_view_findstore);
        findStoreView.setOnClickListener(nearbyStoreCallback);

        departmentView = (MaterialCardView) this.findViewById(R.id.card_view_department);
        departmentView.setOnClickListener(storeDepartmentCallback);

        suggestedRecipesView = (MaterialCardView) this.findViewById(R.id.suggested_recipes_view);
        suggestedRecipesView.setOnClickListener(suggestedRecipeCallback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                Intent newHomeIntent = new Intent(this, HomeActivity.class);
                newHomeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newHomeIntent);
                return true;
            case R.id.navigation_search:
                Intent newSearchIntent = new Intent(this, SearchActivity.class);
                newSearchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newSearchIntent);
                return true;
            case R.id.navigation_list:
                Intent newListIntent = new Intent(this, GroceryListActivity.class);
                newListIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newListIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // =======================================================================================
    // ======================= Permissions, API, and HTTP Request methods =======================
    // =======================================================================================
    public void packIntentBundle(Intent intent) {
        Bundle data = new Bundle();
        data.putParcelableArrayList("stores", currentStores);
        intent.putExtra("bundle", data);
        if(DEBUG_MODE)
        {
            mLatitude = mDefaultLatitude;
            mLongitude = mDefaultLongitude;
        }
        intent.putExtra("latitude", mLatitude);
        intent.putExtra("longitude", mLongitude);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public interface HomeActivityCallback {
        void run();
    }

    // ================================= NEARBY STORE METHODS =================================
    View.OnClickListener nearbyStoreCallback = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            requestUserLocation(startStoreList);
        }
    };

    public void requestNearbyStore() {
        // callback function
        LocatorCallback callback = new LocatorCallback() {
            @Override
            public void onResponse(ArrayList<Store> stores) {
                currentStores = stores;
                Log.i(TAG, "onResponse: " + currentStores.toString());
                Intent intent = new Intent(getApplicationContext(), StoreListActivity.class);
                packIntentBundle(intent);
                startActivity(intent);
                currentStores = stores;
            }
        };

        mStoreLocator.locateNearbyStore(callback);
    }

    HomeActivityCallback startStoreList = new HomeActivityCallback() {
        @Override
        public void run() {
            if (DEBUG_MODE) {
                HomeActivity.this.currentStores = mStoreLocator.getNearbyStoreStub();
                Intent intent = new Intent(getApplicationContext(), StoreListActivity.class);
                packIntentBundle(intent);
                startActivity(intent);
            } else {
                requestNearbyStore();
            }
        }
    };

    // ================================= Google Maps METHODS =================================

    /**
     * @purpose Callback function for showing nearby stores and user location in
     */
    View.OnClickListener googleMapCallback = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            requestUserLocation(startGoogleMaps);
        }
    };

    // entry point for http request
    public void requestPlacesAPI() {
        // callback function
        LocatorCallback callback = new LocatorCallback() {
            @Override
            public void onResponse(ArrayList<Store> stores) {
                currentStores = stores;
                Log.i(TAG, "onResponse: " + currentStores.toString());
                Intent intent = new Intent(getApplicationContext(), StoreLocationActivity.class);
                packIntentBundle(intent);
                startActivity(intent);
                currentStores = stores;
            }
        };

        mStoreLocator.locateNearbyStore(callback);
    }

    HomeActivityCallback startGoogleMaps = new HomeActivityCallback() {
        @Override
        public void run() {
            if (DEBUG_MODE) {
                HomeActivity.this.currentStores = mStoreLocator.getNearbyStoreStub();
                Intent intent = new Intent(getApplicationContext(), StoreLocationActivity.class);
                packIntentBundle(intent);
                startActivity(intent);
            } else {
                requestPlacesAPI();
            }
        }
    };

    // ================================= Store Department METHODS =================================

    View.OnClickListener storeDepartmentCallback = new View.OnClickListener() {
        @Override

        public void onClick(View view) {
            Intent newDepartmentIntent = new Intent(getApplicationContext(), DepartmentActivity.class);
            newDepartmentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newDepartmentIntent);

        }
    };

    // ================================= Suggested Recipe METHODS =================================

    View.OnClickListener suggestedRecipeCallback = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent newSuggestedRecipesIntent = new Intent(getApplicationContext(), SuggestedRecipeActivity.class);
            newSuggestedRecipesIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newSuggestedRecipesIntent);
        }
    };

    // ================================= Location Related METHODS =================================

    /** NOTE:
     * Although this looks like methods from a logic layer, but the location method require
     * some part of it to be executed in the activity that requested it.
     * Especially, the requesting permission.
     */

    private void requestUserLocation(final HomeActivityCallback callback) {
        mLatitude = mDefaultLatitude;
        mLongitude = mDefaultLongitude;

        PermissionsPackage permission = new PermissionsPackage();

        if (permission.checkLocationPermissions(HomeActivity.this)) {
            if (permission.isLocationEnabled(HomeActivity.this)) {
                HomeActivity.this.getLocation(callback);
            } else {
                HomeActivity.this.turnOnLocationPrompt();
            }
        } else {
            requestPermissions(PermissionsPackage.LOCATION_REQUEST_CODE);
        }
    }

    // get user location
    // refactor separate the inside function
    private void getLocation(final HomeActivityCallback callback) {
        UserLocation.LocationResult locationResult = new UserLocation.LocationResult() {
            @Override
            public void gotLocation(Location location) {
                //Got the location!
                mLatitude = location.getLatitude();
                mLongitude = location.getLongitude();

                double[] result = {mLatitude, mLongitude};
                HomeActivity.this.mStoreLocator.setUserLocation(result);

                permissionGranted = true;
                callback.run();
            }
        };

        UserLocation userLocation = new UserLocation();
        userLocation.locateUser(getApplicationContext(), locationResult);
    }

    private void turnOnLocationPrompt() {
        Toast.makeText(getApplicationContext(), "Turn on location", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    public void requestPermissions(int requestCode) {
        if (requestCode == PermissionsPackage.LOCATION_REQUEST_CODE) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                    PermissionsPackage.LOCATION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PermissionsPackage.LOCATION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "Location allowed!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
