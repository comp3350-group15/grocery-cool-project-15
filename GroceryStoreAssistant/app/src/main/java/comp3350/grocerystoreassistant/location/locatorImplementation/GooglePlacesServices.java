/**
 * Places API http request
 */
package comp3350.grocerystoreassistant.location.locatorImplementation;

import android.app.Activity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import comp3350.grocerystoreassistant.location.locatorInterface.LocatorCallback;
import comp3350.grocerystoreassistant.location.locatorInterface.StoreLocatorService;
import comp3350.grocerystoreassistant.objects.groceryStore.Store;

public class GooglePlacesServices implements StoreLocatorService {

    // Change this if you want more result
    private final int MAX_RESULT = 10;
    private final String TAG = ".HomeActivity";

    private Activity mActivity;
    private double mLatitude;
    private double mLongitude;

    private int maxResponseCount;
    private int response;

    private ArrayList<Store> mStores;

    public GooglePlacesServices() {
        mActivity = null;

        mLatitude = -1;
        mLongitude = -1;

        maxResponseCount = MAX_RESULT;
        response = 0;
        mStores = new ArrayList<>();
    }

    public String placeURL(double latitude, double longitude) {
        String URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                "location="+latitude+"," +longitude+
                "&rankby=distance" +
                "&keyword=grocery" +
                "&key=AIzaSyC3A3tZgeZgaZgNaIPXPeiwo5ASIVyc9wc";

        return URL;
    }

    /**
     * Tweak this if you want different fields for the store that you get
     * @param placeID
     * @return
     */
    public String placeDetailURL(String placeID) {
        String s = "https://maps.googleapis.com/maps/api/place/details/json?place_id=" + placeID +
                "&fields=" +
                "name," +
                "formatted_address," +
                "website," +
                "vicinity," +
                "formatted_phone_number," +
                "url," +
                "rating," +
                "geometry," +
                "opening_hours" +
                "&key=AIzaSyC3A3tZgeZgaZgNaIPXPeiwo5ASIVyc9wc";

        return s;
    }

    /**
     * @purpose api call to get nearby grocery store
     * @param url
     * @param callback handle the response
     */
    public void requestPlacesData(String url, final LocatorCallback callback) {

    // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(mActivity);

    // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject callResponse = new JSONObject(response);
                            JSONArray results = callResponse.getJSONArray("results");
                            if(MAX_RESULT > results.length()) {
                                maxResponseCount = results.length();
                            }

                            String id;

                            for (int i = 0; i < maxResponseCount; i++) {
                                JSONObject curr = results.getJSONObject(i);
                                id = curr.getString("place_id");
                                String url = placeDetailURL(id);
                                requestPlacesDetailData(url, callback);
                            }

                        } catch (Exception err) {
                            Log.d("Error", err.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

    // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    /**
     * @purpose api call for detailed information of a store
     * @param url
     * @param callback function to handle the response
     */
    private void requestPlacesDetailData(String url, final LocatorCallback callback) {
    // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(mActivity);

    // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            GooglePlacesUtilities utils = new GooglePlacesUtilities();
                            JSONObject callResponse = new JSONObject(response);
                            mStores.add(utils.jsonToStore(callResponse));
                            GooglePlacesServices.this.response++;

                            if(GooglePlacesServices.this.response == maxResponseCount) {
                                Log.i(TAG, "They are equal!");
                                callback.onResponse(mStores);
                            }

                        } catch (Exception err) {
                            Log.d("Error", err.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

    // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    @Override
    public void requestNearbyStore(LocatorCallback callback) {
        maxResponseCount = MAX_RESULT;
        response = 0;
        mStores = new ArrayList<>();

        String url = this.placeURL(this.mLatitude, this.mLongitude);

        if(callback != null) {
            this.requestPlacesData(url, callback);
        }
    }

    @Override
    public ArrayList<Store> getNearbyStoreStub() {
        GooglePlacesUtilities utils = new GooglePlacesUtilities();
        String file = "res/raw/store_details.json";
        InputStream in = getClass().getClassLoader().getResourceAsStream(file);
        Scanner scanner = new Scanner(in).useDelimiter("\\A");
        String result = scanner.hasNext() ? scanner.next() : "";

        ArrayList<Store> stores = utils.getStubStoreData(result);
        mLatitude = 49.8096;
        mLongitude = -97.1327;

        return stores;
    }

    @Override
    public void setUserLocation(double[] userLocation) {
        this.mLatitude = userLocation[0];
        this.mLongitude = userLocation[1];
    }

    @Override
    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public ArrayList<Store> getNearbyFetchedStore() {
        return this.mStores;
    }
}
