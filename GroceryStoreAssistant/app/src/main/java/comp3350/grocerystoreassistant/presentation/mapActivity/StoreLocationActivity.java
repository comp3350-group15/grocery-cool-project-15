package comp3350.grocerystoreassistant.presentation.mapActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.objects.groceryStore.Store;
import comp3350.grocerystoreassistant.presentation.listActivity.GroceryListActivity;
import comp3350.grocerystoreassistant.presentation.HomeActivity;
import comp3350.grocerystoreassistant.presentation.SearchActivity;

public class StoreLocationActivity extends AppCompatActivity implements OnMapReadyCallback {

    private final String TAG = ".StoreLocation";
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
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

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        double lat = getIntent().getDoubleExtra("latitude", -1);
        double lng = getIntent().getDoubleExtra("longitude", -1);
        // Add a marker in Sydney and move the camera
        LatLng um = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(um).title("Marker in University of Manitoba"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(um));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(um, 13));

        Bundle data = getIntent().getBundleExtra("bundle");
        ArrayList<Store> stores = data.getParcelableArrayList("stores");

        for (int i = 0; i < stores.size(); i++) {

            double sLat = stores.get(i).getLatidue();
            double sLng = stores.get(i).getLongitude();

            LatLng sLatLng = new LatLng(sLat, sLng);

            mMap.addMarker(new MarkerOptions()
                    .position(sLatLng)
                    .title(stores.get(i).getName()))
                    .setIcon(BitmapDescriptorFactory
                            .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        }
    }
}
