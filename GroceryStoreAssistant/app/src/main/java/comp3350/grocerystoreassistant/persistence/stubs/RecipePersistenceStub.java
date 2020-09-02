package comp3350.grocerystoreassistant.persistence.stubs;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.objects.RecipeItem;
import comp3350.grocerystoreassistant.persistence.RecipePersistence;
import comp3350.grocerystoreassistant.persistence.stubs.ItemPersistenceStub;

public class RecipePersistenceStub implements RecipePersistence {
    private List<RecipeItem> recipes;

    public RecipePersistenceStub(){
        recipes = new ArrayList();
        loadRecipes();
    }


    public List getAllRecipes(){
        return recipes;
    }

    public RecipeItem insertRecipe(RecipeItem newRecipe){
        recipes.add(newRecipe);
        return newRecipe;
    }

    public RecipeItem updateRecipe(RecipeItem item){
        int index = recipes.indexOf(item);

        if(index >= 0){
            recipes.set(index, item);
        }
        return item;
    }

    public void deleteRecipe(RecipeItem item){
        int index = recipes.indexOf(item);

        if(index >= 0){
            recipes.remove(index);
        }
    }

    public void loadRecipes(){
        ItemPersistenceStub itemPersistenceStub = new ItemPersistenceStub();

        /* Create all the recipes
           recipeXName => name of the recipe
           recipeXGroceryItems => Physical grocery items in the store that this recipe uses - useful for
           when for example adding ingredients from a recipe to a grocery list
           recipeXIngredients => a nicer way to display the ingredients to the user
           recipeXQuantities => quantity of each ingredient needed for the recipe
           recipeXDirections => Cooking directions - how to make the recipe
           recipeXServings => (approximately) how many servings does this recipe yield
           recipeXCategory => category of the recipe i.e. dinner recipe etc
         */
        String recipe1Name = "Grilled Ham and Cheese Sandwich";
        List<GroceryItem> recipe1GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Whole Wheat Bread"),
                itemPersistenceStub.searchByName("Cooked Ham"), itemPersistenceStub.searchByName("Cheddar Cheese, 450g"),
                itemPersistenceStub.searchByName("Butter, 1lb"));
        List<String> recipe1Ingredients = Arrays.asList("Whole Wheat Bread", "Ham", "Cheddar Cheese", "Butter");
        List<String> recipe1Quantities = Arrays.asList("6 slices", "3 slices", "3 slices", "3 Tbsp");
        List<String> recipe1Directions = Arrays.asList("1. Place 1 slice of ham and 1 piece of cheese on 3 slices of bread. Top with" +
                " the remaining slices. Spread each side with butter.", "2. Heat pan over a medium heat and toast sandwiches for 2 minutes" +
                        "per side until golden brown and cheese has melted.");
        String recipe1Servings = "3";
        String recipe1Category = "Lunch";

        String recipe2Name = "Chicken Stir-Fry";
        List<GroceryItem> recipe2GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Cooking Oil, 3L"),
                itemPersistenceStub.searchByName("Garlic"), itemPersistenceStub.searchByName("Boneless, Skinless, Chicken " +
                                "Breast"), itemPersistenceStub.searchByName("Broccoli"), itemPersistenceStub.searchByName("Mushrooms, 227 g tray"),
                itemPersistenceStub.searchByName("Carrots, Bulk"), itemPersistenceStub.searchByName("Green Beans"),
                itemPersistenceStub.searchByName("Teriyaki Sauce"));
        List<String> recipe2Ingredients = Arrays.asList("Oil", "Garlic", "Boneless, Skinless, Chicken Breasts", "Broccoli", "Mushrooms",
                "Carrots", "Green Beans", "Teriyaki Sauce");
        List<String> recipe2Quantities = Arrays.asList("2 tbsp", "2 cloves", "2 lbs", "1 head", "12", "3", "1/4 lb", "2-3 tbsp");
        List<String> recipe2Directions = Arrays.asList("1. Chop all vegetables. Heat 1 tablespoon oil in a sautée pan over medium heat. Add garlic and stir." +
                " Place the chicken in the pan and brown 4 minutes on each side. Remove from pan, slice into strips, set aside.",
                "2. Heat remaining tablespoon of oil in a pan over high heat. Add the vegetables and teriyaki sauce. Stir-fry quickly" +
                        " until vegetables begin to soften. Add the chicken strips, combine well, and continue to cook for 2 to 3 minutes." +
                        " Serve immediately.");
        String recipe2Servings = "4";
        String recipe2Category = "Dinner";

        String recipe3Name = "Fettuccine Alfredo";
        List<GroceryItem> recipe3GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Fettuccine Noodles"),
                itemPersistenceStub.searchByName("Butter, 1lb"), itemPersistenceStub.searchByName("Heavy Cream"),
                itemPersistenceStub.searchByName("Grated Parmesan Cheese"));
        List<String> recipe3Ingredients = Arrays.asList("Fettuccine", "Butter", "Heavy Cream", "Parmesan Cheese");
        List<String> recipe3Directions = Arrays.asList("1. Cook the fettuccine according to package directions. In a saucepan or skillet" +
                " over low heat, warm the butter and cream. Season with salt and pepper. Place half of the parmesan into a large " +
                "serving bowl. Pour the warm butter/cream mixture over the top. Drain the pasta and immediately pour it into the " +
                "bowl. Toss a couple of times, and then sprinkle in the other half of the Parmesan. Toss to combine, thinning with pasta" +
                " water if necessary. Serve immediately.");
        List<String> recipe3Quantities = Arrays.asList("1 lb", "4 oz", "1 cup", "2 cups");
        String recipe3Servings = "6";
        String recipe3Category = "Dinner";

        String recipe4Name = "Eggs Benedict";
        List<GroceryItem> recipe4GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Eggs, Dozen"),
                itemPersistenceStub.searchByName("Lemons"), itemPersistenceStub.searchByName("Butter, 1lb"),
                itemPersistenceStub.searchByName("English Muffins, 6 Pack"), itemPersistenceStub.searchByName("Bacon"),
                itemPersistenceStub.searchByName("Bell Peppers"), itemPersistenceStub.searchByName("Spices, assorted"));
        List<String> recipe4Ingredients = Arrays.asList("Egg Yolks, room temperature", "Fresh Lemon Juice", "Butter", "Eggs", "English" +
                " Muffins, split and toasted", "Bacon", "Small Red Pepper, finely diced", "Small Yellow Pepper, finely diced", "Chives, finely" +
                " chopped");
        List<String> recipe4Quantities = Arrays.asList("3", "1 tbsp", "8 oz", "8", "4", "8 slices", "1/2", "1/2", "2");
        List<String> recipe4Directions = Arrays.asList("1. For the hollandaise sauce: Fill a medium saucepan (or the bottom half" +
                " of a double boiler) with 2 inches of water and bring to a simmer. In a medium bowl that fits snugly into the " +
                "saucepan without touching the bottom (or the top half of a double boiler), whisk together the egg yolks, lemon" +
                " juice, and 1 tablespoon water.", "2. Set the bowl over the simmering water and cook over very low heat, whisking " +
                "constantly, until the egg yolk mixture is very pale and thick, about 3 minutes. If it begins to heat to quickly and get" +
                " lumpy, remove the bowl from the saucepan and whisk before setting it back over the simmering water. When ready," +
                " you should be able to see the bottom of the bowl with every whisk stroke. Continue whisking while adding the butter the" +
                " a little at a time. When all of the butter has been incorporated, and salt and pepper to taste. Remove" +
                " the bowl from the saucepan and set it into a warm bowl of hot water to keep the sauce warm; stir occasionally while " +
                "poaching the eggs.", "3. For the poached eggs: Fill an egg poaching pan with 1 inch of water. Cover and bring to a simmer" +
                        " over medium heat. Lightly grease the poaching cups with butter. Crack the eggs into the cups and set the cups into " +
                        "the poaching pan. Reduce the heat to medium-low, cover, and cook to your desired doneness.", "4. To serve: " +
                        "Set two toasted muffin halves on each plate. Top each with bacon and a poached egg. Garnish with red and yellow" +
                        " peppers and chives. Serve immediately");
        String recipe4Servings = "4";
        String recipe4Category = "Breakfast";

        String recipe5Name = "Triple Chocolate Brownies";
        List<GroceryItem> recipe5GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Butter, 1lb"), itemPersistenceStub.searchByName(
                "White Sugar, 2kg bag"), itemPersistenceStub.searchByName("Vanilla"), itemPersistenceStub.searchByName(
                        "Eggs, Dozen"), itemPersistenceStub.searchByName("Cocoa"), itemPersistenceStub.searchByName("Flour, 5 kg bag"),
                itemPersistenceStub.searchByName("Baking Powder"), itemPersistenceStub.searchByName("Salt"),
                itemPersistenceStub.searchByName("Chocolate Chips, 300g bag"), itemPersistenceStub.searchByName("Honey"),
                itemPersistenceStub.searchByName("Milk, White, 2%, 1L Jug"));
        List<String> recipe5Ingredients = Arrays.asList("Butter", "Sugar", "Vanilla", "Eggs", "Cocoa", "Flour", "Baking Powder", "Salt",
                "Chocolate Chips", "Honey", "Milk");
        List<String> recipe5Quantities = Arrays.asList("1 cup, plus 6 tbsp", "2 cups", "3 tsp", "4", "3/4 cup, plus 6 tbsp", "1 cup", "1/2" +
                "tsp", "1/4 tsp", "1 cup", "2 tbsp", "2 tbsp");
        List<String> recipe5Directions = Arrays.asList("1. Heat oven to 350F. Grease 13x9x2 inch baking pan or two 8 or 9 inch square pans.",
                "2. Place 1 cup butter in large microwave safe bowl. Microwave at medium for 2-2.5 minutes, or until melted. Stir in sugar" +
                        " and 2 tsp vanilla. Add remaining dry ingredients, and beat well. Pour batter into pans.", "3. Bake 30 to 35 minutes" +
                        " for 13 x 9 x 2 inch pan (20 to 22 minutes for 8 or 9 inch pans), or until brownies begin to pull away from sides of " +
                        "pan. Cool completely in pan on wire rack. Prepare and frost with frosting. Garnish frosted brownies with chocolate " +
                        "chips. ", "4. For the frosting: beat 6 tbsp butter, 6 tbsp cocoa, 2 tbsp honey, 1 tsp vanilla in medium" +
                        " bowl until blended. Add 2 cups sugar and 2 to 4 tbsp of milk, beat to spread consistency.");
        String recipe5Servings = "About 24 brownies";
        String recipe5Category = "Dessert";

        String recipe6Name = "Scones";
        List<GroceryItem> recipe6GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Flour, 5 kg bag"),
                itemPersistenceStub.searchByName("White Sugar, 2kg bag"), itemPersistenceStub.searchByName("Baking Soda"),
                itemPersistenceStub.searchByName("Baking Powder"), itemPersistenceStub.searchByName("Margarine 907g"),
                itemPersistenceStub.searchByName("Milk, White, 2%, 1L Jug"));
        List<String> recipe6Ingredients = Arrays.asList("Flour", "Sugar", "Baking Soda", "Baking Powder", "Margarine", "Milk");
        List<String> recipe6Quantities = Arrays.asList("4 cups", "3/4 cup", "1 tsp", "4 tsp", "6 tbsp", "1 cup");
        List<String> recipe6Directions = Arrays.asList("1. Mix dry ingredients.", "2. Cut in margarine.", "3. Add milk and mix until well" +
                " combined, kneading with hands if necessary. ", "4. Use cookie cutter to cut and place on baking pan.", "In a 350F oven, " +
                "cook for about 10 to 15 minutes.");
        String recipe6Servings = "12 - 15 scones";
        String recipe6Category = "Dessert";

        String recipe7Name = "Chocolate Chip Cookies";
        List<GroceryItem> recipe7GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Butter, 1lb"),
                itemPersistenceStub.searchByName("Brown Sugar, 2kg bag"), itemPersistenceStub.searchByName("Eggs, Dozen"),
                itemPersistenceStub.searchByName("Vanilla"), itemPersistenceStub.searchByName("Flour, 5 kg bag"),
                itemPersistenceStub.searchByName("Corn Starch, 500g"), itemPersistenceStub.searchByName("Salt"),
                itemPersistenceStub.searchByName("Baking Soda"), itemPersistenceStub.searchByName("Chocolate Chips, 300g bag"));
        List<String> recipe7Ingredients = Arrays.asList("Butter, softened", "Brown sugar, packed", "Eggs", "Vanilla", "Flour", "Cornstarch",
                "Salt", "Baking Soda", "Chocolate Chips");
        List<String> recipe7Quantities = Arrays.asList("1 cup", "1 1/2 cups", "2", "1 tsp", "2 cups", "1/4 cup", "3/4 tsp", "1 tsp", "2 cups");
        List<String> recipe7Directions = Arrays.asList("1. Cream butter and sugar together. Beat in eggs one at a time. Add vanilla.",
                "2. Stir flour, cornstarch, salt, and baking soda together and add. Stir in chocolate chips. Drop by greased spoonfuls onto" +
                        " greased baking sheet. Bake in 350 oven for 10 to 15 minutes.");
        String recipe7Servings = "Approx 30 cookies";
        String recipe7Category = "Dessert";

        String recipe8Name = "Banana Bread";
        List<GroceryItem> recipe8GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Butter, 1lb"),
                itemPersistenceStub.searchByName("White Sugar, 2kg bag"), itemPersistenceStub.searchByName("Bananas"),
                itemPersistenceStub.searchByName("Eggs, Dozen"), itemPersistenceStub.searchByName("Flour, 5 kg bag"),
                itemPersistenceStub.searchByName("Baking Soda"), itemPersistenceStub.searchByName("Salt"),
                itemPersistenceStub.searchByName("Chocolate Chips, 300g bag"), itemPersistenceStub.searchByName("Baking Powder"));
        List<String> recipe8Ingredients = Arrays.asList("Butter", "Sugar", "Bananas", "Eggs", "Flour", "Baking Soda", "Salt", "Chocolate" +
                " Chips", "Baking Powder");
        List<String> recipe8Quantities = Arrays.asList("1/2 cup", "1 cup", "4", "2", "1.75 cups", "1 tsp", "1/2 tsp", "3/4 cup",
                "1/2 tsp");
        List<String> recipe8Directions = Arrays.asList("1. Cream butter and sugar. Beat in eggs one at a time. Beat until smooth. " +
                "Add bananas and blend.", "2. In separate bowl, stir flour, baking powder, baking soda. Add to banana mixture only " +
                "to moisten. Add chips.", "3. Transfer to greased loaf pan. Bake at 350F for 1 hour.", "4. Let stand for 10 minutes, then " +
                        "remove and put on rack to cool.");
        String recipe8Servings = "1 loaf";
        String recipe8Category = "Dessert";

        String recipe9Name = "Blue Cheese Caesar Salad";
        List<GroceryItem> recipe9GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Lettuce"),
                itemPersistenceStub.searchByName("Croutons, 142g"), itemPersistenceStub.searchByName("Eggs, Dozen"),
                itemPersistenceStub.searchByName("Blue Cheese, Wedge"), itemPersistenceStub.searchByName("" +
                        "Salad Dressing, assorted kinds, 475 mL"));
        List<String> recipe9Ingredients = Arrays.asList("Lettuce, torn", "Croutons", "Hard boiled eggs", "Blue Cheese, crumbled",
        "Caesar Salad Dressing");
        List<String> recipe9Quantities = Arrays.asList("1 head", "1 cup", "2", "1/2 cup", "1/2 cup");
        List<String> recipe9Directions = Arrays.asList("1. Boil the eggs so they are hard boiled.", "2. Toss lettuce, croutons, " +
                "egg, and cheese together in large bowl.", "3. Just before serving, pour dressing over salad. Toss well");
        String recipe9Servings = "12 cups";
        String recipe9Category = "Salad";

        String recipe10Name = "Make Ahead Salad";
        List<GroceryItem> recipe10GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Lettuce"),
                itemPersistenceStub.searchByName("Red Onions"), itemPersistenceStub.searchByName("Cauliflower"),
                itemPersistenceStub.searchByName("Bacon"), itemPersistenceStub.searchByName("Bell Peppers"),
                itemPersistenceStub.searchByName("Mayonnaise"), itemPersistenceStub.searchByName("Grated Parmesan Cheese"));
        List<String> recipe10Ingredients = Arrays.asList("Lettuce, shredded", "Red Onion, sliced thinly", "Cauliflower, chopped", "Bacon, fried" +
                        " crisp and crumbled", "Green Pepper, chopped", "Mayonnaise", "Parmesan Cheese");
        List<String> recipe10Quantities = Arrays.asList("1 head", "1", "1 head", "8 strips", "1", "1 cup", "1/2 cup");
        List<String> recipe10Directions = Arrays.asList("1. In a large salad bowl, layer all ingredients.", "2. Refrigerate. Toss when" +
                "ready to use.");
        String recipe10Servings = "4-5";
        String recipe10Category = "Salad";

        String recipe11Name = "Breakfast Sandwich";
        List<GroceryItem> recipe11GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("English Muffins, 6 Pack"),
                itemPersistenceStub.searchByName("Eggs, Dozen"), itemPersistenceStub.searchByName("Bacon"),
                itemPersistenceStub.searchByName("Swiss Cheese"));
        List<String> recipe11Ingredients = Arrays.asList("English muffin", "Eggs", "Bacon", "Swiss Cheese");
        List<String> recipe11Quantities = Arrays.asList("1", "1", "1 slice", "1 slice");
        List<String> recipe11Directions = Arrays.asList("1. Heat muffin halves, cut side down, in hot frying pan until toasted. Transfer" +
                " to plate.", "2. Break egg into lightly greased frying pan. Break yolk with fork. Let eggs spread out into thin layer. " +
                "Sprinkle with seasoning, if desired. Cook on medium-high for 1-2 minutes until egg white and surface of yolk is " +
                "beginning to firm.", "3. Fry bacon in same frying pan beside egg until lightly browned. Turn egg over. Cook for " +
                "1 minute.", "4. Layer cheese, egg, and bacon on bottom half of muffin. Top with top half of muffin");
        String recipe11Servings = "1";
        String recipe11Category = "Breakfast";

        String recipe12Name = "Baked French Toast";
        List<GroceryItem> recipe12GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Eggs, Dozen"),
                itemPersistenceStub.searchByName("Yogurt, Tub"), itemPersistenceStub.searchByName("White Sugar, 2kg bag"),
                itemPersistenceStub.searchByName("Vanilla"), itemPersistenceStub.searchByName("Salt"),
                itemPersistenceStub.searchByName("Spices, assorted"), itemPersistenceStub.searchByName("White Bread"));
        List<String> recipe12Ingredients = Arrays.asList("Eggs", "Vanilla Yogurt", "Sugar", "Vanilla", "Salt", "Cinnamon", "Bread");
        List<String> recipe12Quantities = Arrays.asList("5", "1/2 cup", "3 tbsp", "1 tsp", "1/2 tsp", "1/4 tsp", "8 slices");
        List<String> recipe12Directions = Arrays.asList("1. Beat eggs, yogurt, sugar, vanilla, salt, and cinnamon in medium bowl until" +
                "smooth.", "2. Dip bread slices into egg mixture until soaked. Place on well greased baking sheet. Pour any remaining " +
                "egg mixture over bread slices. Let stand for 5 minutes to allow egg mixture to soak into bread slices. Bake in " +
                "350 oven for 10 minutes per side until set and edges are golden.", "3. Sprinkle with icing sugar, if desired, and serve");
        String recipe12Servings = "4";
        String recipe12Category = "Breakfast";

        String recipe13Name = "Omelette";
        List<GroceryItem> recipe13GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Eggs, Dozen"),
                itemPersistenceStub.searchByName("Cooking Oil, 3L"), itemPersistenceStub.searchByName("White Onions"),
                itemPersistenceStub.searchByName("Mushrooms, 227 g tray"), itemPersistenceStub.searchByName("Cooked Ham"));
        List<String> recipe13Ingredients = Arrays.asList("Eggs", "Water", "Salt", "Pepper", "Oil", "Onion", "Mushrooms", "Ham, chopped");
        List<String> recipe13Directions = Arrays.asList("1. Beat eggs, water, salt, and pepper in medium bowl until smooth.", "2. " +
                "Heat cooking oil in frying pan on medium high. Add onion and mushrooms. Sauté for 8 to 10 minutes until onion" +
                " is soft and golden.", "3. Add ham. Heat and stir for about 2 minutes until ham is hot and slightly golden. Reduce" +
                " heat to medium. Add egg mixture. Heat and cook for about 4 minutes until eggs are cooked but not dry.");
        List<String> recipe13Quantities = Arrays.asList("8", "2 tbsp", "1/2 tsp", "1/4 tsp", "1 tbsp", "1 cup", "2 cups", "1 cup");
        String recipe13Servings = "4 cups";
        String recipe13Category = "Breakfast";

        String recipe14Name = "Monte Cristo";
        List<GroceryItem> recipe14GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Butter, 1lb"),
                itemPersistenceStub.searchByName("White Bread"), itemPersistenceStub.searchByName("Mozzarella Cheese"),
                itemPersistenceStub.searchByName("Cooked Ham"), itemPersistenceStub.searchByName("White Chicken Breast"),
                itemPersistenceStub.searchByName("Eggs, Dozen"));
        List<String> recipe14Ingredients = Arrays.asList("Butter, softened", "White Bread", "Mozzarella cheese", "Cooked Ham Slices",
                "Cooked Chicken Slices", "Eggs", "Water");
        List<String> recipe14Quantities = Arrays.asList("4 tbsp", "4 slices", "4 slices", "2 slices", "4 slices", "1", "2 tbsp");
        List<String> recipe14Directions = Arrays.asList("1. Divide and spread 2 tbsp of margarine on 2 sides of first amount" +
                " of bread slices.", "2. Layer 2 slices of cheese, ham, chicken, and remaining 2 slices of cheese over margarine in that order",
                "3. Divide and spread 2 tbsp of margarine over remaining 2 slices of bread. Place on top of cheese, buttered side down.",
                "4. Beat egg and water together in shallow dish using fork. Carefully dip sandwiches into egg mixture to coat both sides." +
                        " Place in non-stick frying pan. Cover. Heat on medium low for about 3 minutes per side until" +
                        " cheese is melted and sandwich is golden.");
        String recipe14Servings = "2 sandwiches";
        String recipe14Category = "Lunch";

        String recipe15Name = "Baby Pizzas";
        List<GroceryItem> recipe15GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("English Muffins, 6 Pack"),
                itemPersistenceStub.searchByName("Tomato Sauce, 680 mL can"), itemPersistenceStub.searchByName("Bacon"),
                itemPersistenceStub.searchByName("Mushrooms, 227 g tray"), itemPersistenceStub.searchByName("" +
                        "Mozzarella Cheese"));
        List<String> recipe15Ingredients = Arrays.asList("English muffins, split", "Pizza sauce", "Bacon, cooked crisp and crumbled",
                "Chopped Mushrooms", "Mozzarella Cheese, grated");
        List<String> recipe15Quantities = Arrays.asList("2", "1/4 cup", "3 slices", "1/2 cup", "1/2 cup");
        List<String> recipe15Directions = Arrays.asList("Arrange bun halves on ungreased baking sheet. Divide and spread pizza sauce on " +
                "each bun half. Scatter bacon over pizza sauce. Sprinkle mushrooms and cheese over bacon. Broil 4 inches from heat" +
                " for about 2 minutes until hot and cheese is melted.");
        String recipe15Servings = "2";
        String recipe15Category = "Lunch";

        String recipe16Name = "Potato Soup";
        List<GroceryItem> recipe16GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Potatoes"),
                itemPersistenceStub.searchByName("White Onions"), itemPersistenceStub.searchByName("Celery"),
                itemPersistenceStub.searchByName("Margarine 907g"), itemPersistenceStub.searchByName("Flour, 5 kg bag"),
                itemPersistenceStub.searchByName("Spices, assorted"), itemPersistenceStub.searchByName("Milk, White, 2%, 2L Jug"),
                itemPersistenceStub.searchByName("Cheddar Cheese, 450g"));
        List<String> recipe16Ingredients = Arrays.asList("Potatoes, peeled and cut", "Onion, chopped", "Leaves of celery, finely chopped",
                "Margarine","Flour", "Parsley", "Salt", "Pepper", "Milk", "Cheddar Cheese, grated", "Chives (to garnish)");
        List<String> recipe16Quantities = Arrays.asList("5", "1 cup", "2 tsp", "1 tbsp", "1 tbsp", "2-3 tsp", "2 tsp", "1/4 tsp", "3 cups",
                "1/2 cup", "Garnish");
        List<String> recipe16Directions = Arrays.asList("1. Put potato, onion, and celery leaves into medium saucepan. Add enough water" +
                " just to cover potato. Cover. Bring to a boil on medium. Reduce heat. Simmer for about 15 minutes until vegetables are" +
                " tender. Do not drain. Cool slightly. Transfer, in batches, to blender. Process until puréed. Set aside", "2. Melt" +
                " margarine in large saucepan on medium-low. Mix in flour, parsley, salt, and pepper until smooth. Add milk. Heat and " +
                "stir for about 10 minutes until boiling and slightly thickened. Add potato mixture.", "3. Sprinkle cheese and" +
                        "chives over individual servings.");
        String recipe16Servings = "8 cups";
        String recipe16Category = "Dinner";

        String recipe17Name = "Beef Parmesan";
        List<GroceryItem> recipe17GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Eggs, Dozen"),
                itemPersistenceStub.searchByName("Croutons, 142g"), itemPersistenceStub.searchByName("Grated Parmesan Cheese"),
                itemPersistenceStub.searchByName("Sirloin Steak"),  itemPersistenceStub.searchByName("Cooking Oil, 3L"),
                itemPersistenceStub.searchByName("Tomato Sauce, 680 mL can"),  itemPersistenceStub.searchByName("Mozzarella Cheese"));
        List<String> recipe17Ingredients = Arrays.asList("Egg", "Water", "Croutons", "Parmesan Cheese", "Tenderized Steaks", "Oil",
                "Pizza Sauce", "Mozzarella cheese, grated", "Pepper");
        List<String> recipe17Quantities = Arrays.asList("1", "2 tbsp", "2/3 cup", "1/4 + 1/3 cup", "4", "1 tbsp", "7.5 oz", "225 g", "Sprinkle");
        List<String> recipe17Directions = Arrays.asList("1. Beat egg and water together in small bowl using fork.", "2. Process croutons" +
                " in blender until fine crumbs form.", "3. Combine crumbs with 1/4 cup of parmesan cheese in shallow dish.",
                "4. Dip each steak into egg mixture. Press in crumb mixture to coat completely. Cook in cooking oil in frying pan on medium" +
                        " high for about 5 minutes per side until browned.", "5. Spread half of pizza sauce in 9x13 baking dish large" +
                        " enough to hold steaks in single layer. Arrange steaks on pizza sauce. Spoon remaining pizza sauce over top",
                "6. Sprinkle remaining parmesan cheese over sauce. Lay mozzarella on each steak. Bake, uncovered at 350F for about" +
                        " 30 minutes until heated through and cheese is melted. Sprinkle pepper over individual servings once cooked.");
        String recipe17Servings = "4";
        String recipe17Category = "Dinner";

        String recipe18Name = "Oven-Baked Chicken";
        List<GroceryItem> recipe18GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Flour, 5 kg bag"),
                itemPersistenceStub.searchByName("Spices, assorted"), itemPersistenceStub.searchByName("Chicken Drumsticks, " +
                        "6 pack"));
        List<String> recipe18Ingredients = Arrays.asList("Flour", "Paprika", "Seasoning salt", "Salt", "Pepper", "Chicken drumsticks");
        List<String> recipe18Quantities = Arrays.asList("1/3 cup", "1 tsp", "3/4 tsp", "3/4 tsp", "1/4 tsp", "12");
        List<String> recipe18Directions = Arrays.asList("1. Combine flour, paprika, seasoning salt, salt, and pepper in large" +
                " resealable freezer bag.", "2. Dampen chicken with water. Add a few pieces to bag. Seal bag. Shake until chicken " +
                "is well coated. Arrange chicken in single layer on grease baking sheet. Repeat with remaining chicken and spice" +
                " mixture. Bake at 425F for 30 minutes. Turn chicken. Bake for about 15 minutes until juices run clear.");
        String recipe18Servings = "4";
        String recipe18Category = "Dinner";

        String recipe19Name = "Salmon Cakes";
        List<GroceryItem> recipe19GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Eggs, Dozen"),
                    itemPersistenceStub.searchByName("Canned Tuna and Canned Salmon"),
                itemPersistenceStub.searchByName("Potatoes"), itemPersistenceStub.searchByName("Green Onions"),
                itemPersistenceStub.searchByName("Spices, assorted"), itemPersistenceStub.searchByName("Butter, 1lb"));
        List<String> recipe19Ingredients = Arrays.asList("Egg", "Salmon, flaked", "Potato, mashed", "Green onion, chopped", "Dill",
                "Onion salt", "Pepper", "Butter");
        List<String> recipe19Quantities = Arrays.asList("1", "1 cup", "1 cup", "2 tsp", "1/2 tsp", "1/4 tsp", "1/8 tsp", "2 tbsp");
        List<String> recipe19Directions = Arrays.asList("1. Beat egg in small bowl using fork. Add next 6 ingredients. Mix well. Shape " +
                "into 4 patties.", "2. Melt butter in frying pan on medium. Add patties. Brown for 4 to 5 minutes per side, until golden.");
        String recipe19Servings = "4";
        String recipe19Category = "Dinner";

        String recipe20Name = "Ham and Veggie Frittata";
        List<GroceryItem> recipe20GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("White Onions"),
                itemPersistenceStub.searchByName("Potatoes"), itemPersistenceStub.searchByName("Bell Peppers"),
                itemPersistenceStub.searchByName("Mushrooms, 227 g tray"), itemPersistenceStub.searchByName("Cooking Oil, 3L"),
                itemPersistenceStub.searchByName("Cooked Ham"), itemPersistenceStub.searchByName("Eggs, Dozen"),
                itemPersistenceStub.searchByName("Tomatoes"));
        List<String> recipe20Ingredients = Arrays.asList("Onion, chopped", "Potato, chopped", "Green pepper, chopped", "Mushrooms, chopped",
                "Salt", "Pepper", "Oil", "Diced ham", "Eggs, fork-beaten", "Tomato, chopped");
        List<String> recipe20Quantities = Arrays.asList("1/2 cup", "1/2 cup", "1/2 cup", "1/2 cup", "1/2 tsp", "1/8 tsp", "1/2 tbsp", "1/2 cup",
                "6", "1/2 cup");
        List<String> recipe20Directions = Arrays.asList("1. Sautée first 6 ingredients in cooking oil in large frying pan on medium" +
                " for about 5 minutes until onion and green pepper are soft. Reduce heat to medium low.", "2. Add ham. Heat and stir" +
                " for one minute.", "3. Pour eggs over ham mixture. Cover. Cook for about 10 minutes, without stirring, until eggs are " +
                "set. Loosen sides with spatula. Slide onto serving dish. Sprinkle tomato on top.");
        String recipe20Servings = "6 wedges";
        String recipe20Category = "Lunch";

        String recipe21Name = "Tuna Salad";
        List<GroceryItem> recipe21GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Mayonnaise"),
                itemPersistenceStub.searchByName("Yogurt, Tub"), itemPersistenceStub.searchByName("Lemons"),
                itemPersistenceStub.searchByName("Canned Tuna and Canned Salmon"), itemPersistenceStub.searchByName("" +
                        "Red Onions"));
        List<String> recipe21Ingredients = Arrays.asList("Mayonnaise", "Plain Yogurt", "Juice of lemon", "Tuna", "Red onion, chopped",
                "Salt", "Pepper");
        List<String> recipe21Quantities = Arrays.asList("2 tbsp", "2 tbsp", "1/2 lemon", "2 cans", "1/4", "Pinch", "Pinch");
        List<String> recipe21Directions = Arrays.asList("1. In a large bowl, whisk together mayo, yogurt, lemon juice.", "2. Drain" +
                " tuna then add to mayonnaise mixture. Add red onion and season with salt and pepper.", "3. Serve on lettuce or bread," +
                " if desired");
        String recipe21Servings = "4";
        String recipe21Category = "Lunch";

        String recipe22Name = "Bacon Lettuce Tomato (BLT) Sandwich";
        List<GroceryItem> recipe22GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Bacon"),
                itemPersistenceStub.searchByName("Lettuce"), itemPersistenceStub.searchByName("Tomatoes"),
                itemPersistenceStub.searchByName("Whole Wheat Bread"), itemPersistenceStub.searchByName("Mayonnaise"));
        List<String> recipe22Ingredients = Arrays.asList("Bacon", "Lettuce", "Tomato", "Bread", "Mayonnaise");
        List<String> recipe22Quantities = Arrays.asList("4 slices", "2 leaves","2 slices", "2 slices", "1 tbsp");
        List<String> recipe22Directions = Arrays.asList("1. Cook the bacon in a skillet or pan over medium-high heat until" +
                " evenly browned, about 10 minutes, depending on your preferred crispness. Drain the bacon slices on a paper towel " +
                "lined plate.", "2. Arrange the cooked bacon, lettuce, and tomato slices on one slice of bread. Spread one side of " +
                "remaining bread slice with the mayonnaise. Bring two pieces together to make a sandwich");
        String recipe22Servings = "1";
        String recipe22Category = "Lunch";

        String recipe23Name = "Strawberry Banana Breakfast Smoothie";
        List<GroceryItem> recipe23GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Strawberries, 1lb box"),
                itemPersistenceStub.searchByName("Bananas"), itemPersistenceStub.searchByName("Milk, White, 2%, 1L Jug"));
        List<String> recipe23Ingredients = Arrays.asList("Strawberries", "Bananas", "Milk", "Ice");
        List<String> recipe23Quantities = Arrays.asList("2 cups", "1", "1 cup", "1 cup");
        List<String> recipe23Directions = Arrays.asList("1. Add all ingredients to blender. Pulse until combined.", "2. If smoothie is too" +
                " thick, add more milk. If it is too thin, add more fruit and/or ice.");
        String recipe23Servings = "1";
        String recipe23Category = "Breakfast";

        String recipe24Name = "Egg-in-a-Hole";
        List<GroceryItem> recipe24GroceryItems = Arrays.asList(itemPersistenceStub.searchByName("Whole Wheat Bread"),
                itemPersistenceStub.searchByName("Butter, 1lb"), itemPersistenceStub.searchByName("Eggs, Dozen"));
        List<String> recipe24Ingredients = Arrays.asList("Bread", "Butter", "Egg", "Salt", "Pepper");
        List<String> recipe24Directions = Arrays.asList("1. With cookie cutter or rim of a glass, press a hole in the center of the bread.",
                "2. Heat a skillet over medium-low heat and melt in the butter. When the butter is all spread out, place the slice" +
                        " of bread in the skillet and crack the egg straight into the center of the hole.", "3. Cook until the egg sets a bit" +
                        " on the bottom, 30 to 45 seconds. Sprinkle the egg with salt and pepper. After about a minute, flip it over" +
                        " with a spatula and add salt and pepper to the other side.", "4. Move the toast around in the skillet, soaking " +
                        "up the butter. Let it cook until the yolk feels soft.");
        List<String> recipe24Quantities = Arrays.asList("1 slice", "1 tablespoon", "1", "Pinch", "Pinch");
        String recipe24Servings = "1";
        String recipe24Category = "Breakfast";

        // add all the recipes to a list of recipes
        recipes.add(new RecipeItem(recipe1Name, recipe1GroceryItems, recipe1Ingredients, recipe1Quantities, recipe1Directions,
                recipe1Servings, recipe1Category));
        recipes.add(new RecipeItem(recipe2Name, recipe2GroceryItems, recipe2Ingredients, recipe2Quantities, recipe2Directions,
                recipe2Servings, recipe2Category));
        recipes.add(new RecipeItem(recipe3Name, recipe3GroceryItems, recipe3Ingredients, recipe3Quantities, recipe3Directions,
                recipe3Servings, recipe3Category));
        recipes.add(new RecipeItem(recipe4Name, recipe4GroceryItems, recipe4Ingredients, recipe4Quantities, recipe4Directions,
                recipe4Servings, recipe4Category));
        recipes.add(new RecipeItem(recipe5Name, recipe5GroceryItems, recipe5Ingredients, recipe5Quantities, recipe5Directions,
                recipe5Servings, recipe5Category));
        recipes.add(new RecipeItem(recipe6Name, recipe6GroceryItems, recipe6Ingredients, recipe6Quantities, recipe6Directions,
                recipe6Servings, recipe6Category));
        recipes.add(new RecipeItem(recipe7Name, recipe7GroceryItems, recipe7Ingredients, recipe7Quantities, recipe7Directions,
                recipe7Servings, recipe7Category));
        recipes.add(new RecipeItem(recipe8Name, recipe8GroceryItems, recipe8Ingredients, recipe8Quantities, recipe8Directions,
                recipe8Servings, recipe8Category));
        recipes.add(new RecipeItem(recipe9Name, recipe9GroceryItems, recipe9Ingredients, recipe9Quantities, recipe9Directions,
                recipe9Servings, recipe9Category));
        recipes.add(new RecipeItem(recipe10Name, recipe10GroceryItems, recipe10Ingredients, recipe10Quantities, recipe10Directions,
                recipe10Servings, recipe10Category));
        recipes.add(new RecipeItem(recipe11Name, recipe11GroceryItems, recipe11Ingredients, recipe11Quantities, recipe11Directions,
                recipe11Servings, recipe11Category));
        recipes.add(new RecipeItem(recipe12Name, recipe12GroceryItems, recipe12Ingredients, recipe12Quantities, recipe12Directions,
                recipe12Servings, recipe12Category));
        recipes.add(new RecipeItem(recipe13Name, recipe13GroceryItems, recipe13Ingredients, recipe13Quantities, recipe13Directions,
                recipe13Servings, recipe13Category));
        recipes.add(new RecipeItem(recipe14Name, recipe14GroceryItems, recipe14Ingredients, recipe14Quantities, recipe14Directions,
                recipe14Servings, recipe14Category));
        recipes.add(new RecipeItem(recipe15Name, recipe15GroceryItems, recipe15Ingredients, recipe15Quantities, recipe15Directions,
                recipe15Servings, recipe15Category));
        recipes.add(new RecipeItem(recipe16Name, recipe16GroceryItems, recipe16Ingredients, recipe16Quantities, recipe16Directions,
                recipe16Servings, recipe16Category));
        recipes.add(new RecipeItem(recipe17Name, recipe17GroceryItems, recipe17Ingredients, recipe17Quantities, recipe17Directions,
                recipe17Servings, recipe17Category));
        recipes.add(new RecipeItem(recipe18Name, recipe18GroceryItems, recipe18Ingredients, recipe18Quantities, recipe18Directions,
                recipe18Servings, recipe18Category));
        recipes.add(new RecipeItem(recipe19Name, recipe19GroceryItems, recipe19Ingredients, recipe19Quantities, recipe19Directions,
                recipe19Servings, recipe19Category));
        recipes.add(new RecipeItem(recipe20Name, recipe20GroceryItems, recipe20Ingredients, recipe20Quantities, recipe20Directions,
                recipe20Servings, recipe20Category));
        recipes.add(new RecipeItem(recipe21Name, recipe21GroceryItems, recipe21Ingredients, recipe21Quantities, recipe21Directions,
                recipe21Servings, recipe21Category));
        recipes.add(new RecipeItem(recipe22Name, recipe22GroceryItems, recipe22Ingredients, recipe22Quantities, recipe22Directions,
                recipe22Servings, recipe22Category));
        recipes.add(new RecipeItem(recipe23Name, recipe23GroceryItems, recipe23Ingredients, recipe23Quantities, recipe23Directions,
                recipe23Servings, recipe23Category));
        recipes.add(new RecipeItem(recipe24Name, recipe24GroceryItems, recipe24Ingredients, recipe24Quantities, recipe24Directions,
                recipe24Servings, recipe24Category));
    }
}
