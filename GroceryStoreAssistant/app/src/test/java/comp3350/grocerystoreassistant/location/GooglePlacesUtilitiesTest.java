package comp3350.grocerystoreassistant.location;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import comp3350.grocerystoreassistant.location.locatorImplementation.GooglePlacesUtilities;
import comp3350.grocerystoreassistant.objects.groceryStore.Store;
import comp3350.grocerystoreassistant.resources.TestStoreString;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class GooglePlacesUtilitiesTest {

    private String jsonStoreStr = "";

    private GooglePlacesUtilities util;

    @Before
    public void setUp() {
        System.out.println("**Starting Store Utils Test**");
        util = new GooglePlacesUtilities();
    }

    @Test
    public void testStubStoreData() {
        ArrayList<Store> testStubStores = util.getStubStoreData(TestStoreString.jsonStoreStubStr);
        assertNotNull(testStubStores);
    }

    @Test
    public void testJsonToStore() {
        try {
            JSONObject json = new JSONObject(TestStoreString.jsonStore);
            Store store = util.jsonToStore(json);
            assertNotNull(store);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJsonToStoreFailNull() {
        try {
            JSONObject json = null;
            Store store = util.jsonToStore(json);
            assertNull(store);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        System.out.println("**Finished Store Utils Test**");
    }
}
