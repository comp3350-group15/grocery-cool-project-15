package comp3350.grocerystoreassistant.application;

import comp3350.grocerystoreassistant.location.locatorFacade.StoreLocator;
import comp3350.grocerystoreassistant.location.locatorImplementation.GooglePlacesServices;
import comp3350.grocerystoreassistant.location.locatorInterface.StoreLocatorService;
import comp3350.grocerystoreassistant.persistence.ItemPersistence;
import comp3350.grocerystoreassistant.persistence.RecipePersistence;
import comp3350.grocerystoreassistant.persistence.hsqldb.ItemPersistenceHSQLDB;
import comp3350.grocerystoreassistant.persistence.hsqldb.RecipePersistenceHSQLDB;

public class Services
{
    private static ItemPersistence itemPersistence = null;
    private static RecipePersistence recipePersistence = null;
    private static StoreLocator storeLocator = null;

    public static synchronized ItemPersistence getItemPersistence()
    {
        if(itemPersistence == null)
        {
            itemPersistence = new ItemPersistenceHSQLDB(Main.getDBPathName());
        }

        return itemPersistence;
    }

    public static synchronized RecipePersistence getRecipePersistence()
    {
        if(recipePersistence == null)
        {
            recipePersistence = new RecipePersistenceHSQLDB(Main.getDBPathName());
        }

        return recipePersistence;
    }

    public static synchronized StoreLocator getStoreLocator()
    {
        if(storeLocator == null)
        {
            // Change this if you want something other than google places.
            StoreLocatorService locatorService = new GooglePlacesServices();

            storeLocator = new StoreLocator(locatorService);
        }

        return storeLocator;
    }
}

