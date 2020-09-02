package comp3350.grocerystoreassistant.location;
import android.app.Activity;
import android.content.Context;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import comp3350.grocerystoreassistant.location.locatorImplementation.GooglePlacesServices;
import comp3350.grocerystoreassistant.location.locatorInterface.StoreLocatorService;
import comp3350.grocerystoreassistant.presentation.HomeActivity;

public class GooglePlacesServicesTest {

    private StoreLocatorService mStoreLocatorService;
    private HomeActivity mHomeActivity;
    private double[] location = {49.8096, -97.1327};


    @Before
    public void setUp() {

        System.out.println("**Starting Store Utils Test**");

        mHomeActivity = new HomeActivity();
        mStoreLocatorService = new GooglePlacesServices();

        mStoreLocatorService.setActivity(mHomeActivity);
        mStoreLocatorService.setUserLocation(location);
    }

    @Test
    public void testPlacesURL() {
        String URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                "location="+location[0]+"," +location[1]+
                "&rankby=distance" +
                "&keyword=grocery" +
                "&key=AIzaSyC3A3tZgeZgaZgNaIPXPeiwo5ASIVyc9wc";

        assertEquals(URL, ((GooglePlacesServices) mStoreLocatorService).placeURL(location[0],location[1]));
    }

    @Test
    public void testPlacesDetailURL() {
        String URL = "https://maps.googleapis.com/maps/api/place/details/json?place_id=" + "ID" +
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

        assertEquals(URL, ((GooglePlacesServices) mStoreLocatorService).placeDetailURL("ID"));
    }

    @Test
    public void testFetch() {
        assertEquals(0, mStoreLocatorService.getNearbyFetchedStore().size());
    }

    @Test
    public void testRequest() {
        mStoreLocatorService.requestNearbyStore(null);
    }

    @After
    public void tearDown() {
        System.out.println("**Finished Store Utils Test**");
    }
}
