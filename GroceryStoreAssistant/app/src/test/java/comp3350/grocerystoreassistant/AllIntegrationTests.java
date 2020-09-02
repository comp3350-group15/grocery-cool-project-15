package comp3350.grocerystoreassistant;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.grocerystoreassistant.business.AccessItemsIT;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessItemsIT.class
})

public class AllIntegrationTests {
}
