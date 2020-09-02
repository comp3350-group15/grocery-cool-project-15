# Architecture
The architecture for this project will follow a 3-tier model (**_UI_, _Logic_, _Data_**). This model will be broken down into the following packages: `application`, `domain objects`, `presentation`, `business` and `persistence`.
## Domain Objects
The main objects used in our domain are `GroceryItem`, `RecipeItem` and `Store`. `GroceryItem` represents a single grocery item with its attributes like nutriton facts and location within the store. `RecipeItem` represents a single recipe with its ingredients and serving directions. `Store` represents a single grocery store along with further details such as `LocationCoordinates` and `OpeningHours` which store additional data used. `Store` data is non persisting and only locally stored due to it depending on geographic location.
## Presentation
The presentation layer has 6 main activities: `MainActivity` / `HomeActivity`, `StoreActivity`, `SearchActivity`, `GroceryListActivity`, `SuggestedRecipeActivity` and `DepartmentActivity`. The `MainActivity` provides the entry point for the application which will switch to the `HomeActivity` as default. The `HomeActivity` will provide an overview of the app to allow for quick actions such as browsing the store by switching to `DepartmentActivity` and selecting a store from a map which the `StoreActivity` will provide or by choosing from a list of nearby stores. It also has some helper classes `StoreListActivity`, `StorePageActivity` and `StoreLocationActivity`. The `SearchActivity` is where the user will look for items within a store to be able to perform certain actions such as adding the item to their grocery list, etc. That along with `DepartmentActivity`, which will categorize items into departments and allow for search in those categories. The `SuggestedRecipeActivity` is where the user can browse recipes and when one is selected `SuggestedRecipeListActivity` will show the user more info and allow them to add all the ingredients to their list. The `GroceryListActivity` is where the user will be able to view all the items they have added and view them as a scrollable list, with options to view additional information on the item.
## Business 
The business layer has 6 classes: `GroceryList` and `StoreItemList` which are subclasses of `ItemList`, and `SearchItems`, `AccessRecipes` and `AccessItems`. The list logic is used to to retrieve the data from `AccessItems` and send it to the UI layer so it can display it. They also handle our data specific list operations such as `contains` and `sort` so the data can be filtered. The `SearchItems` class will implement the search functionality by retrieving items based on some input which could be a name or any search input from the user. The `AccessItems` and `AccessRecipes` classes will retrieve the data from the data peristence layer.
## Persistence
The database used for the persistence layer is HSQLDB. The `ItemPersistenceHSQLDB` and `RecipePersistenceHSQLDB` are used to perform the database operations such as `getAll`,`insert` and `delete`. There is also a stub database containing hardcoded values for each of our domain objects which are found in `ItemPersistenceStub` and `RecipePersistenceStub`. The `ItemPersistence` and `RecipePersistence` classes provide the same interface to the stub data as it does to the database.
                      Presentation              +                        Business Logic                           +                Persistence
                                                |                                                                 |
                +----------------------+        |                                                                 |
                |                      |        |                                                                 |
                |      MainActivity    |        |                                                                 |
                |                      |        |                                                                 |
                +----------------------+        |                                                                 |
                                                |                                                                 |
                +----------------------+        |                                                                 |
                |                      |        |                                                                 |                                    +----------------------+
                |     HomeActivity     |        |                                                                 |                                    >                      |
                |                      |        |     +----------------------+       +----------------------+     |                                  +/|ItemPersistenceHSQLDB |
                +----------------------+        |   +->                      |       |                      |     |                                +/  |                      |
                                               +--+/  |     SearchItems      <------->     AccessItems      <+    |                              +/    +----------------------+
                +----------------------+  +--+/ |     |                      |       |                      | \+--+    +-----------------------+/
                |                      <+/      |     +----------------------+       +----------------------+     \+-+ |                      /
                |    SearchActivity    |        |                                                                 +   \>   ItemPersistence    +
                |                      <-+\     +                                                                 | +->+                      |\
                +----------------------+   +---+\                                                               +-+/   +----------------------+ ++\    +----------------------+
                                                +----+\                                                     +-+/  |                                ++\ |                      |
                +----------------------+        |      +---+\                                          +--+/      |                                   +> ItemPersistenceStub  |
                |                      |        |            +---+\  +----------------------+      +-+/           |                                    |                      |
                | GroceryListActivity  <---------------+\          +->                      |  +-+/               |                                    +----------------------+
                |                      |        |        +---------------->  ItemList       <+/                   |
                +----------------------+        |                 +-->                      |                     |
                                                |         +-----+/   +----------------------+                     |
                +----------------------+        |  +----+/                                                        |
                |                      |   +-----+/                                                               |
                | Department Activity  <-+/     |                                                                 |
                |                      |        |                                                                 |
                +----------------------+        |                                                                 |
                                                |                                                                 |                                     +----------------------+
                                                |                                                                 |                                     >                      |
                                                |                                                                 |                                   +/|RecipePersistenceHSQLDB
            +------------------------------+    |                    +----------------------+                     |                                 +/  |                      |
            |                              |    |                    |                      |                     |                               +/    +----------------------+
            | SuggestedRecipeListActivity  +------------------------->     AccessRecipe     +-------------+       |     +-----------------------+/
            |                              |    |                    |                      |             |       |     |                      /
            +------------------------------+    |                    +----------------------+             +------------->   RecipePersistence  +
                                                |                                                                 |     |                      |\
                                                |                                                                 |     +----------------------+ ++\    +----------------------+
                                                |                                                                 |                                 ++\ |                      |
                                                |                                                                 |                                    +> RecipePersistenceStub|
                +----------------------+        |                                                                 |                                     |                      |
                |                      |        |                                                                 |                                     +----------------------+
                |StoreLocationActivity <-+\     |                                                                 |
                |                      |   +-----+\                                                               |
                +----------------------+        |  +----+\                                                        |
                                                |         +-----+\   +----------------------+                     |
                +----------------------+        |                 +-->                      |                     |
                |                      |        |      +------------->     StoreLocator     |                     |
                |  StorePageActivity   <-------------+/            +->                      |                     |
                |                      |        |             +--+/  +----------------+-----+                     |
                +----------------------+        |        +--+/                        |                           |
                                                |   +--+/                             |                           |
                +----------------------+       +--+/                                  |                           |
                |                      |  +--+/ |                                     |                           |
                |  StoreListActivity   <+/      |                                     |                           |
                |                      |        |                                     |                           |
                +----------------------+        |                                     |                           |
                                                +                                     |                           +
                                                                                      |
                                                                                      |
                                                                                      |
                                                                                      |
                                                                                      |
                                                                                      |
+-------------------------------------------------------------------------------+     |                          +-----------------------------------------------------------+
|                                Domain Objects                                 |     |                          |                            Location                       |
|                                                                               |     |                          |   +----------------------+                                |
| +----------------------+              +----------------------+                |     |                          |   |                      |                                |
| |                      |              |                      |                |     +------------------------------>  StoreLocatorService |                                |
| |     GroceryItem      |              |        Store         |                |                                |   |                      |                                |
| |                      |              |                      |                |                                |   +----------^-----------+                                |
| +----------------------+              +----+/+---------+\+---+                |                                |              |                  +----------------------+  |
|                                           /+             +\                   |                                |              |                  |                      |  |
|                                         /+                 +\                 |                                |              |                  |     UserLocation     |  |
|                                        /                     +\               |                                |              |                  |                      |  |
|                                      /+                        +\             |                                |   +----------v-----------+      +----------------------+  |
|                         +-----------<----------+     +----------->----------+ |                                |   |                      |                                |
|                         |                      |     |                      | |                                |   | GooglePlacesServices |                                |
|                         |  LocationCoordinate  |     |     OpeningHours     | |                                |   |                      |                                |
|                         |                      |     |                      | |                                |   +----------------------+                                |
|                         +----------------------+     +----------------------+ |                                |                                                           |
|                                                                               |                                +-----------------------------------------------------------+
+-------------------------------------------------------------------------------+
