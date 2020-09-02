package comp3350.grocerystoreassistant.location.locatorImplementation;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import comp3350.grocerystoreassistant.objects.groceryStore.LocationCoordinate;
import comp3350.grocerystoreassistant.objects.groceryStore.OpeningHours;
import comp3350.grocerystoreassistant.objects.groceryStore.Store;

public class GooglePlacesUtilities {

    private static final String TAG = "StoreUtils";

    /**
     * Use this for parsing API response this will call the function below it
     *
     * @param jsonObject
     * @return
     */
    public Store jsonToStore(JSONObject jsonObject) {
        return jsonToStore(jsonObject, false);
    }

    private Store jsonToStore(JSONObject jsonObject, boolean stub) {
        Store s = null;

        if (jsonObject == null) {
            return null;
        }

        try {
            if (!stub) {
                jsonObject = jsonObject.getJSONObject("result");
            }

            JSONObject dummy;

            // get the name, address, phone, url, and rating
            String name = jsonObject.getString("name");

            String address = "Not Available";
            if (jsonObject.has("vicinity")) {
                address = jsonObject.getString("vicinity");
            }

            String phone = "Not available";
            if (jsonObject.has("formatted_phone_number")) {
                phone = jsonObject.getString("formatted_phone_number");
            }

            String url = "https://www.google.com/";
            if (jsonObject.has("website")) {
                url = jsonObject.getString("website"); // website link
            } else {
                url = jsonObject.getString("url"); // just get the google maps link
            }

            double rating = -1;
            if (jsonObject.has("rating")) {
                rating = jsonObject.getDouble("rating");
            }

            // get the opening hours
            ArrayList<String> hourString = new ArrayList<>();
            if (jsonObject.has("opening_hours")) {
                dummy = jsonObject.getJSONObject("opening_hours");
                JSONArray dummyArray = dummy.getJSONArray("weekday_text");

                for (int i = 0; i < dummyArray.length(); i++) {
                    hourString.add(dummyArray.get(i).toString());
                }
            }
            OpeningHours hours = new OpeningHours(hourString);

            // Get the store coordinate
            dummy = jsonObject.getJSONObject("geometry");
            dummy = dummy.getJSONObject("location");
            double latitude = dummy.getDouble("lat");
            double longitude = dummy.getDouble("lng");
            LocationCoordinate latLng = new LocationCoordinate(latitude, longitude);

            s = new Store(name, phone, url, rating, address, hours, latLng);
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println(jsonObject);
        }

        return s;
    }

    /**
     * use this for parsing the stub database (JSON)
     *
     * @return
     */
    public ArrayList<Store> getStubStoreData(String input) {
        ArrayList<Store> stores = null;

        stores = parsePlaceAPIJSON(input, true);

        return stores;
    }

    private ArrayList<Store> parsePlaceAPIJSON(String response, boolean stub) {
        ArrayList<Store> stores = new ArrayList<>();

        try {
            JSONObject callResponse = new JSONObject(response);
            JSONArray results = callResponse.getJSONArray("result");
            JSONObject currJSONStore = null;
            Store store = null;
            int count = results.length();

            for (int i = 0; i < count; i++) {
                currJSONStore = results.getJSONObject(i);
                store = jsonToStore(currJSONStore, true);
                stores.add(store);
            }
        } catch (Exception err) {
            err.printStackTrace();
        }

        return stores;
    }
}
