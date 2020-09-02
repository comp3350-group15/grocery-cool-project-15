package comp3350.grocerystoreassistant.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.persistence.ItemPersistence;

public class ItemPersistenceStub implements ItemPersistence {
    private List<GroceryItem> items;

    public ItemPersistenceStub() {
        items = new ArrayList<>();
        loadStore();
    }

    @Override
    public List<GroceryItem> getAllItems(){
        return items;
    }

    @Override
    public GroceryItem insertItem(GroceryItem item){
        items.add(item);
        return item;
    }

    @Override
    public GroceryItem updateItem(GroceryItem item){
        int index = items.indexOf(item);

        if(index >= 0){
            items.set(index, item);
        }
        return item;
    }

    @Override
    public void deleteItem(GroceryItem item){
        int index = items.indexOf(item);

        if(index >= 0){
            items.remove(index);
        }
    }

    public GroceryItem searchByName(String itemName) {
        GroceryItem returnItem = null;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(itemName)) {
                returnItem = items.get(i);
            }
        }

        return returnItem;
    }

    public void loadStore() {
        String aisle0Description = "By Cashiers";
        String aisle1Description = "Leftmost Aisle";
        String aisle2Description = "Between Aisle 1 and Frozen Aisle";
        String aisle3Description = "Frozen Aisle";
        String aisle4Description = "Next to Frozen Aisle";
        String aisle5Description = "Between Aisles 4 and 6";
        String aisle6Description = "Right End of Store, next to Bakery Service Counter";
        String aisle7Description = "Rightmost Aisle, Bakery Service Counter located here";
        String aisle8Description = "Back of Store; Meat and Dairy";
        String aisle9Description = "Right Corner of Store, by Bakery/Aisle 6 & 7; Deli Service Counter and "
                + "products";

        items.add(new GroceryItem("Apples", 1.99, "per lb", false, 1.99, 80, 0, 0, 0, 0, 0, 22, 5,
                16, 0, 170, "1 medium apple", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Navel Oranges", 1.99, "per lb", false, 1.99, 70, 0, 0, 0, 0, 0, 18,
                3, 12, 1, 0, "1 medium orange", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Red Seedless Grapes", 0.65, "per 100g", true, 0.85, 34, 0, 0, 0, 0,
                1, 9, 0, 8, 0, 0, "10 grapes (49 grams)", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Green Seedless Grapes", 0.65, "per 100g", true, 0.85, 34, 0, 0, 0, 0,
                1, 9, 0, 8, 0, 0, "10 grapes (49 grams)", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Bananas", 0.77, "per lb", false, 0.77, 105, 0, 0, 0, 0, 2, 27, 3, 14,
                1, 358, "1 banana", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Pineapple", 3.89, "", false, 3.89, 82, 0, 0, 0, 0, 2, 22, 2, 16, 1,
                0, "165 g", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Cantalopue", 3.47, "", false, 3.47, 60, 0, 0, 0, 0, 28, 16, 2, 14, 1,
                400, "177 g", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Kiwi", 0.99, "", false, 0.99, 108, 1, 0, 0, 0, 5, 26, 5, 16, 2, 0,
                "1 kiwi", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Garlic", 0.68, "", false, 0.68, 90, 1, 0, 0, 0, 190, 18, 3, 0, 3, 0,
                "1/4 cup", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Honeydew Melon", 4.77, "", true, 4.97, 48, 0, 0, 0, 0, 24, 12, 1, 11,
                1, 306, "134 g", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Strawberries, 1lb box", 3.99, "", false, 3.99, 46, 0, 0, 0, 0, 1,
                11, 3, 7, 1, 0, "1 cup", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Blueberries, 1lb box", 3.99, "", false, 3.99, 80, 0, 0, 0, 0, 0, 19,
                6, 10, 0, 95, "1 cup", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Raspberries, 1lb box", 4.29, "", false, 4.29, 50, 0, 0, 0, 0, 0, 17,
                8, 9, 1, 0, "1 cup", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Blackberries, 1lb box", 4.29, "", false, 4.29, 60, 1, 0, 0, 0, 0, 13,
                7, 7, 2, 230, "1 cup", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Baby Carrots, 2lb Bag", 4.97, "", false, 4.97, 30, 0, 0, 0, 0, 60, 7,
                2, 4, 1, 0, "8 baby carrots", 2, aisle2Description, "Produce"));
        items.add(new GroceryItem("Carrots, Bulk", 4.69, "per kg", false, 4.69, 52, 0, 0, 0, 0, 88, 12,
                4, 6, 1, 0, "1 cup, chopped", 2, aisle2Description, "Produce"));
        items.add(new GroceryItem("Bell Peppers", 3.99, "per lb", false, 3.99, 37, 0, 0, 0, 0, 5, 7, 2,
                5, 1, 0, "119 g", 2, aisle2Description, "Produce"));
        items.add(new GroceryItem("Mushrooms, 227 g tray", 1.97, "", false, 1.97, 25, 0, 0, 0, 0, 4, 3,
                1, 2, 3, 280, "100 g", 1, aisle2Description, "Produce"));
        items.add(new GroceryItem("Celery", 2.98, "", false, 2.98, 20, 0, 0, 0, 0, 100, 5, 2, 1, 1, 0,
                "2 medium stalks", 1, aisle2Description, "Produce"));
        items.add(new GroceryItem("Cucumber", 1.49, "", false, 1.49, 8, 0, 0, 0, 0, 1, 2, 1, 1, 0, 76,
                "1/2 cup cucumber slices", 1, aisle2Description, "Produce"));
        items.add(new GroceryItem("Broccoli", 0.59, "per 100g", false, 0.59, 31, 0 ,0 ,0, 0, 30, 6, 2,
                2, 3, 0, "1 cup chopped", 2, aisle2Description, "Produce"));
        items.add(new GroceryItem("Cauliflower", 0.59, "per 100g", false, 0.59, 13, 0, 0, 0, 0, 16, 3,
                1, 1, 1, 160, "1/2 cup", 2, aisle2Description, "Produce"));
        items.add(new GroceryItem("Tomatoes", 0.49, "per 100g", false, 0.49, 22, 0, 0, 0, 0, 6, 5, 2, 3,
                1, 0, "1 medium tomato", 2, aisle2Description, "Produce"));
        items.add(new GroceryItem("Potatoes", 0.49, "per 100g", false, 0.49, 110, 0, 0, 0, 0, 0, 26, 2,
                1, 3, 620, "1 potato", 2, aisle2Description, "Produce"));
        items.add(new GroceryItem("Lemons", 0.69, "", false, 0.69, 29, 0, 0, 0, 0, 2, 9, 3, 3, 1,
                138, "100 g", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Lettuce", 2.59, "", true, 2.99, 14, 0, 0, 0, 0, 10, 3, 1, 2, 1, 141,
                "100 g", 2, aisle2Description, "Produce"));
        items.add(new GroceryItem("Red Onions", 0.42, "per 100g", false, 0.42, 40, 0, 0, 0, 0, 4, 9, 2,
                4, 1, 146, "100 g", 2, aisle2Description, "Produce"));
        items.add(new GroceryItem("White Onions", 0.42, "per 100g", false, 0.42, 60, 0, 0, 0, 0, 5, 16,
                3, 0, 1, 0, "1 medium raw onion", 2, aisle2Description, "Produce"));
        items.add(new GroceryItem("Whole Wheat Bread", 3.19, "", false, 3.19, 160, 2, 1, 0, 0, 250, 30,
                3, 2, 7, 250, "2 slices", 6, aisle6Description, "Bakery"));
        items.add(new GroceryItem("White Bread", 2.99, "", false, 2.99, 160, 2, 1, 0, 0, 250, 31, 1, 3,
                5, 250, "2 slices", 6, aisle6Description, "Bakery"));
        items.add(new GroceryItem("Rye Bread", 2.79, "", false, 2.79, 140, 1, 0, 0, 0, 240, 28, 2, 1, 5,
                166, "2 slices", 6, aisle6Description, "Bakery"));
        items.add(new GroceryItem("Bagels, pack of 6, assorted flavours", 2.99, "", false, 2.99, 290, 5,
                1, 0, 10, 330, 54, 7, 4, 7, 165, "1 bagel", 6, aisle6Description, "Bakery"));
        items.add(new GroceryItem("Doughnuts", 0.99, "", false, 0.89, 289, 16, 4, 0, 22, 387, 33, 1, 18,
                5, 67, "1 doughnut", 6, aisle6Description, "Bakery"));
        items.add(new GroceryItem("Fresh Cookies", 0.99, "", false, 0.99, 190, 10, 6, 0, 25, 190, 24, 1,
                16, 2, 0, "1 cookie", 6, aisle6Description, "Bakery"));
        items.add(new GroceryItem("Garlic Toast", 2.29, "", false, 2.29, 170, 8, 0, 0, 0, 280, 22, 0,
                1, 4, 54, "57 g", 6, aisle6Description, "Bakery"));
        items.add(new GroceryItem("Cinnamon Bun", 2.49, "", true, 2.79, 260, 6, 2, 0, 0, 220, 48,
                2, 16, 4, 63, "1 cinnamon bun", 6, aisle6Description, "Bakery"));
        items.add(new GroceryItem("Danish Pastry", 2.49, "", false, 2.49, 190, 10, 5, 0, 0, 290, 20, 1,
                3, 3, 0, "50 g", 6, aisle6Description, "Bakery"));
        items.add(new GroceryItem("Bakery Cake", 17.99, "", false, 17.99, 330, 16, 4, 0, 25, 210, 43,
                0, 36, 2, 0, "1 slice", 7, aisle7Description, "Bakery"));
        items.add(new GroceryItem("Bakery Cheesecake", 19.99, "", false, 19.99, 360, 19, 11, 0, 45, 260,
                43, 1, 31, 6, 0, "1 slice", 7, aisle7Description, "Bakery"));
        items.add(new GroceryItem("Cupcakes", 12.99, "per dozen", false, 12.99, 250, 15, 5, 0, 25, 170,
                28, 1, 20, 2, 0, "1 cupcake", 7, aisle7Description, "Bakery"));
        items.add(new GroceryItem("Dinner Rolls", 0.39, "", false, 0.39, 120, 2, 0, 0, 0, 220, 22, 1, 0,
                3, 35, "1 roll", 6, aisle6Description, "Bakery"));
        items.add(new GroceryItem("Tortilla Wraps, 10 pack", 2.97, "", true, 3.19, 100, 3, 1, 0, 0, 190,
                16, 1, 1, 2, 75, "1 tortilla", 6, aisle6Description, "Bakery"));
        items.add(new GroceryItem("Muffins", 12.99, "per dozen", false, 12.99, 460, 24, 5, 0, 95, 470,
                57, 1, 31, 6, 0, "1 muffin", 7, aisle7Description, "Bakery"));
        items.add(new GroceryItem("Milk, White, 1%, 1L Jug", 1.19, "", false, 1.19,110, 2, 1, 0, 5, 140, 12,
                0, 11, 9, 400, "250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, White, Skim (0%), 1L Jug", 1.19, "",false, 1.19, 90, 0, 0, 0, 0,
                140, 12, 0, 11, 9, 410, "250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, White, 2%, 1L Jug", 1.19, "",false, 1.19, 130, 5, 3, 0, 15, 140, 12,
                0, 11, 9, 400, "250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, White, 3%, 1L Jug", 1.19, "",false, 1.19, 160, 8, 6, 0, 20, 135, 12,
                0, 11, 9, 400, "250 mL serving" , 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, White, Skim (0%), 2L Jug", 2.38, "",false, 2.38, 90, 0, 0, 0, 0,
                140, 12, 0, 11, 9, 410, "250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, White, 1%, 2L Jug", 2.38, "",false, 2.38, 110, 2, 1, 0, 5, 140, 12,
                0, 11, 9, 400, "250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, White, 2%, 2L Jug", 2.38, "",false, 2.38, 130, 5, 3, 0, 15, 140, 12,
                0, 11, 9, 400, "250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, White, 3%, 2L Jug", 2.38, "",false, 2.38, 160, 8, 6, 0, 20, 135, 12,
                0, 11, 9, 400, "250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, White, Skim (0%), 4L Jug", 4.76, "",false, 4.76, 90, 0, 0, 0, 0,
                140, 12, 0, 11, 9, 410, "per 250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, White, 1%, 4L Jug", 4.76, "",false, 4.76, 110, 2, 1, 0, 5, 140, 1,
                0, 11, 9, 400, "250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, White, 2%, 4L Jug", 4.76, "",false, 4.76, 130, 5, 3, 0, 15, 140, 12,
                0, 11, 9, 400, "250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, White, 3%, 4L Jug", 4.76, "",false, 4.76, 160, 8, 6, 0, 20, 135, 12,
                0, 11, 9, 400, "250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, Chocolate, 1L Jug", 1.29, "",false, 1.29, 150, 2, 1, 0, 10, 160,
                24, 1, 24, 8, 450, "250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, Chocolate, 2L Jug", 2.48, "",false, 2.48, 150, 2, 1, 0, 10, 160, 24,
                1, 24, 8, 450, "250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Milk, Chocolate, 4L Jug", 4.86, "",false, 4.86, 150, 2, 1, 0, 10, 160, 24,
                1, 24, 8, 450, "250 mL serving", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Yogurt, Tub", 2.99,"", false, 2.99, 130, 2, 1, 0, 5, 80, 26, 0, 22, 5,
                240, "3/4 cup", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Yogurt, Cups, pack of 4", 2.49, "",false, 2.49, 140, 3, 2, 0, 15, 160, 16,
                0, 16, 8, 400, "cup", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Sour Cream", 2.67, "",false, 2.67, 60, 5, 3, 0, 20, 15, 1, 0, 1, 1, 0,
                "2 tablespoons", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Buttermilk, 1L", 2.49, "",false, 2.49, 130, 4, 2, 0, 20, 300, 15, 0, 14,
                10, 0, "250 mL", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Soy Milk Beverage 1L", 1.89, "",false, 1.89, 100, 4, 0, 0, 0, 110, 8, 2,
                5, 7, 330, "250 mL", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Eggs, Dozen", 2.69, "",false, 2.69, 70, 5, 1, 0, 195, 65, 1, 0, 0, 6,
                126, "1 egg", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Butter, 1lb", 3.99, "",true, 4.49, 70, 8, 5, 0, 25, 70, 0, 0, 0, 0, 0,
                "2 teaspoons", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Margarine 907g", 4.48, "",true, 4.98, 70, 8, 1, 0, 0, 70, 0, 0, 0, 0,
                0, "2 teaspoons", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Cottage Cheese, 500g", 2.99, "",false, 2.99, 90, 0, 0, 0, 5, 370, 6,
                0, 6, 15, 104, "1/2 cup", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Coffee Cream, 1L", 2.29, "",false, 2.29, 50, 5, 4, 0, 15, 10, 0, 0, 0,
                3, 0, "60 mL", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Cheddar Cheese, 450g", 1.19, "per 100 g", false, 1.19, 120, 10, 6, 0,
                25, 240, 0, 0, 0, 7, 30, "30 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Mozzarella Cheese", 1.19, "per 100 g", false, 1.19, 80, 6, 3, 0, 20,
                50, 1, 0, 0, 5, 25, "30 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Swiss Cheese", 1.39, "per 100 g", false, 1.39, 70, 5, 3, 0, 15, 80, 0,
                0, 0, 5, 5, "20 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Potato Salad", 0.99, "per 100 g", false, 0.99, 260, 19, 3, 0, 15, 460,
                19, 2, 4, 3, 370, "1/2 cup", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Chicken Salad", 1.49, "per 100 g", false, 1.49, 210, 14, 2, 0, 50, 230,
                4, 0, 2, 17, 400, "1/2 cup", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Coleslaw", 1.29, "per 100 g", false, 1.29, 152, 10, 2, 0, 4, 203, 15,
                2, 12, 1, 129, "100 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Spring Rolls, 6 pack, served hot or cold", 1.49, "", false, 1.49, 85,
                4, 1, 0, 0, 249, 2, 1, 0, 9, 226, "spring roll", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Potato Wedges, Hot", 0.89, "per 100 g", false, 0.89, 120, 4, 0, 0, 0,
                340, 20, 2, 0, 2, 320, "approx. 8 wedges", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Chicken Legs, Hot", 2.49, "", false, 2.49, 156, 5, 1, 0, 118, 124, 0,
                0, 0, 24, 309, "leg", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Chicken Strips, Hot", 1.99, "per 100 g", false, 1.99, 210, 10, 3, 0,
                40, 520, 13, 1, 0, 14, 0, "2 strips", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Onion Rings, Hot", 1.99, "per 100 g", false, 1.99, 230, 10, 1, 0, 0,
                350, 31, 3, 4, 3, 95, "approx. 7 rings", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Fried Chicken Drumsticks, Hot", 1.69, "", false, 1.69, 210, 12, 2, 0,
                56, 322, 3, 0, 1, 2, 40, "1 drumstick", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Chicken Wings, Hot", 2.19, "per 100 g", false, 2.19, 190, 12, 2, 0, 50,
                690, 6, 0, 3, 13, 0, "approx 3 wings", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Buffalo Flings, Hot", 2.29, "per 100 g", false, 2.29, 200, 7, 1, 0, 30,
                720, 22, 1, 0, 12, 0, "3 flings", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Whole Rotisserie Chicken, Hot", 9.99, "", false, 9.99, 160, 8, 3, 0,
                35, 440, 0, 0, 0, 22, 241, "85 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Maple Ham, Hot", 8.99, "", false, 8.99, 140, 4, 2, 0, 70, 640, 11, 0,
                9, 18, 0, "100 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Honey Ham", 1.99, "per 100 g", true, 2.49, 50, 1, 0, 0, 25, 590, 2, 0,
                2, 9, 550, "60 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Black Forest Ham", 1.99, "per 100 g", true, 2.49, 100, 3, 1, 0, 45,
                870, 1, 0, 1, 17, 550, "100 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Cooked Ham", 1.49, "per 100 g", false, 1.49, 45, 2, 1, 0, 20, 380, 1,
                0, 0, 8, 200, "50 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Corned Beef", 3.19, "per 100 g", false, 3.19, 70, 3, 1, 0, 25, 460,
                2, 0, 0, 10, 110, "55 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Roast Beef (Deli)", 3.19, "per 100 g", false, 3.19, 70, 3, 1, 0, 25,
                470, 1, 0, 0, 10, 110, "55 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Montreal Smoked Meat", 3.19, "per 100 g", false, 3.19, 70, 3, 1, 0,
                25, 460, 2, 0, 0, 10, 110, "55 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Pastrami", 3.19, "per 100 g", false, 3.19, 70, 3, 1, 1, 25, 460,
                2, 0, 0, 10, 110, "55 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Salami, Regular", 1.99, "per 100 g", false, 1.99, 110, 8, 2, 0, 40,
                390, 2, 1, 0, 8, 0, "55 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Deli Pepperoni", 1.99, "per 100 g", true, 2.19, 170, 14, 5, 0, 30,
                490, 4, 0, 0, 7, 0, "55 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Bologna", 1.49, "per 100 g", false, 1.49, 140, 11, 4, 0, 45, 470,
                3, 0, 0, 6, 0, "55 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Mock Chicken", 2.29, "per 100 g", false, 2.29, 140, 11, 4, 0, 30,
                470, 4, 0, 1, 7, 0, "55 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("White Chicken Breast", 2.49, "per 100 g", true, 2.69, 50, 0, 0, 0,
                15, 360, 0, 0, 0, 10, 180, "55 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Oven Roast Chicken Breast", 2.99, "per 100 g", false, 2.99, 60, 0, 0,
                0, 20, 280, 2, 0, 0, 11, 360, "55 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Cajun Chicken Breast", 2.89, "per 100 g", false, 2.89, 50, 0, 0, 0,
                20, 390, 2, 0, 1, 9, 120, "50 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("White Turkey Breast", 2.99, "per 100 g", false, 2.99, 50, 0, 0,
                0, 10, 410, 3, 1, 1, 9, 0, "55 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Oven Roast Turkey Breast", 3.69, "per 100 g", false, 3.69, 60, 0,
                0, 0, 30, 470, 1, 0, 0, 13, 260, "55 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Sundried Tomato Turkey Breast", 3.69, "per 100 g", false, 3.69, 50,
                0, 0, 0, 20, 310, 2, 0, 0, 11, 0, "55 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Salami, Specialty", 3.99, "per 100 g", false, 3.99, 130, 10, 4, 0, 30,
                460, 1, 0, 0, 8, 0, "33 g", 9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Boneless, Skinless, Chicken Breast", 3.99, "per lb", false, 3.99, 110,
                1, 0, 0, 55, 370, 0, 0, 0, 23, 256, "112 g", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Bone in Chicken Breast", 4.49, "per lb", false, 4.49, 374, 7, 2, 0,
                192, 168, 7, 0, 0, 22, 0, "226 g", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Pork Chops", 4.99, "per lb", false, 4.99, 505, 31, 10, 0, 170, 162,
                0, 0, 0, 52, 690, "1 chop", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Roast Beef", 5.99, "per lb", false, 5.99, 170, 6, 1, 0, 86, 57, 0,
                0, 0, 29, 377, "100 g", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Salmon", 3.99, "per 100 g", false, 3.99, 120, 13, 3, 0, 55, 59, 0, 0,
                0, 20, 363, "100 g", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Shrimp", 3.19, "per 100 g", false, 3.19, 85, 1, 0, 0, 161, 119, 0, 0,
                0, 20, 264, "100 g", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Steel Head Trout", 3.49, "per 100 g", false, 3.49, 141, 6, 1, 0,
                59, 51, 0, 0, 0, 20, 377, "100 g",8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Pickerel", 4.29, "per 100 g", false, 4.29, 91, 2, 0, 0, 34, 0, 0, 0,
                0, 18, 0, "100 g", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Ground Beef", 1.19, "per 100 g", false, 1.19, 308, 20, 7, 1, 101,
                103, 0, 0, 0, 31, 431, "113 g", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Cooking Oil, 3L", 6.79, "",false, 6.79, 40, 4, 1, 0, 0, 0, 0,
                0, 0, 0, 0, "1 teaspoon", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Hot Dog Buns, 12 pack", 2.49, "", false, 2.49, 130, 2, 0, 0, 0, 220,
                24, 1, 3, 4, 35, "1 bun", 6, aisle6Description, "Bakery"));
        items.add(new GroceryItem("Hamburger Buns, 12 pack", 2.49, "", false, 2.49, 140, 2, 0, 0, 0,
                240, 26, 1, 3, 4, 40, "1 bun", 8, aisle8Description, "Bakery"));
        items.add(new GroceryItem("Hamburger Patties, 4 pack", 6.29, "", false, 6.29, 300, 21, 10, 1, 95,
                115, 0, 0, 0, 29, 250, "1 six-ounce patty", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Sirloin Steak", 7.49, "per lb", true, 7.99, 342, 22, 8, 0, 128, 88,
                0, 0, 0, 35, 535, "1 six-ounce steak", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("T-Bone Steak", 9.99, "per lb", false, 9.99, 365, 24, 10, 2, 105, 88,
                0, 0, 0, 35, 418, "1 six-ounce steak", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Strip Steak", 10.49, "per lb", false, 10.49, 360, 18, 6, 0, 120,
                2000, 0, 0, 0, 46, 400, "1 six-ounce steak", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Ribs", 6.99, "per lb", false, 6.99, 300, 24, 10, 0, 71, 54, 0, 0, 0,
                19, 259, "3 ounces", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Sausages", 4.97, "per lb", false, 4.97, 260, 21, 8, 0, 60, 570, 3,
                0, 2, 14, 200, "1 sausage", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Ground Pork", 4.69, "per lb", true, 4.99, 185, 6, 2, 0, 85, 88, 1,
                0, 0, 32, 415, "100 g", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Bacon", 6.79, "per lb", false, 6.79, 79, 7, 2, 0, 13, 202, 0, 0,
                0, 3, 79, "1 slice", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Meatballs", 2.29, "per 100 g", false, 2.29, 197, 9, 1, 0, 0, 550, 8,
                5, 1, 21, 180, "100 g", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Wieners, 24 pack", 4.99, "", false, 4.99, 151, 13, 4, 0, 40, 566,
                2, 0, 0, 5, 567, "1 wiener", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Pepperoni 500g Piece", 6.99, "", false, 6.99, 110, 8, 2, 0, 35, 400,
                3, 0, 0, 8, 0, "50 g", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Cream Cheese, 250g", 3.97, "", false, 3.97, 49, 5, 3, 0, 16, 47, 1, 0,
                1, 1, 20, "1 tablespoon", 8, aisle8Description, "Dairy"));
        items.add(new GroceryItem("Perogies, 24 pack", 8.49, "", false, 8.49, 170, 2, 1, 0, 5, 510, 32,
                1, 1, 6, 0, "3 perogies", 9, aisle9Description, "Frozen"));
        items.add(new GroceryItem("Ice Cream, 1.5 L tub, assorted flavours", 4.49, "",false, 4.49, 140, 7,
                5, 0, 50, 16, 0, 0, 13, 2, 0, "1/2 cup", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("Frozen Lemonade", 1.19, "",false, 1.19, 110, 0, 0, 0, 0, 0, 27, 0, 24,
                1, 450, "60 mL", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("Frozen Orange Juice", 1.19, "",false, 1.19, 110, 0, 0, 0, 0, 0, 27, 0,
                24, 1, 450, "60 mL", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("12\" Take and Bake Pizza", 7.99, "", false, 7.99, 250, 10, 5, 0, 18,
                639, 36, 3, 4, 12, 184, "1 slice", 9, aisle9Description, "Frozen"));
        items.add(new GroceryItem("16\" Take and Bake Pizza", 10.99, "", false, 10.99, 250, 10, 5, 0, 18,
                639, 36, 3, 4, 12, 184, "1 slice", 9, aisle9Description, "Frozen"));
        items.add(new GroceryItem("Frozen Pizza", 5.79, "",false, 5.79, 230, 8, 4, 0, 20, 610, 27, 2, 2,
                11, 100, "1 slice", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("French Fries, 1kg bag", 1.99, "",false, 1.99, 140, 5, 1, 0, 0, 240,
                22, 1, 0, 2, 320, "3 ounces", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("Frozen Battered Fish, 700g box", 5.99, "",false, 5.99, 160, 6, 3, 0,
                40, 350, 20, 7, 2, 12, 0, "2 fillets", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("Ice Cream Bars, 12 pack", 3.99,"", false, 3.99, 177, 3, 1, 0, 2,
                125, 36, 3, 19, 3, 0, "1 bar", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("Frozen Vegetables, 500g", 2.99, "",false, 2.99, 60, 0, 0, 0, 0, 271,
                13, 4, 3, 3, 169, "1 cup", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("Lasagna, 2kg", 12.99, "", false, 12.99, 344, 13, 6, 0, 43, 951,
                39, 4, 8, 19, 499, "255 g piece", 9, aisle9Description, "Frozen"));
        items.add(new GroceryItem("Frozen Waffles, 16 pack", 4.99, "",false, 4.99, 180, 5, 2, 0, 5,
                350, 30, 1, 4, 4, 50, "2 waffles", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("Ravioli", 4.99, "",false, 4.99, 111, 3, 1, 0, 11, 280, 17, 1, 4, 5,
                233, "100 g", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("Tortellini", 4.99, "",false, 4.99, 230, 5, 3, 0, 30, 230, 32, 2, 0,
                10, 34, "1 cup", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("Guacamole, 454g tub", 7.99, "", false, 7.99, 45, 4, 1, 0, 0, 127,
                3, 1, 0, 1, 3, "2 tablespoons", 9, aisle9Description, "Produce"));
        items.add(new GroceryItem("Tzatziki Sauce, 227g tub", 3.99, "", false, 3.99, 50, 4, 2, 0, 10,
                110, 3, 1, 1, 2, 0, "2 tablespoons", 9, aisle9Description, "Produce"));
        items.add(new GroceryItem("Chicken Pot Pie", 4.99, "", false, 4.99, 599, 35, 13, 0, 51, 1229,
                57, 3, 7, 15, 317, "1 pie", 9, aisle9Description, "Produce"));
        items.add(new GroceryItem("Beef Pot Pie", 4.99, "", false, 4.99, 589, 30, 11, 0, 56, 978, 59, 2,
                0, 19, 308, "1 pie", 9, aisle9Description, "Produce"));
        items.add(new GroceryItem("Frozen Fruit, 500g", 2.99, "",false, 2.99, 84, 0, 0, 0, 0, 2, 21, 3,
                16, 1, 300, "1 cup", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("Pizza Pops, 4 pack", 1.87, "",true, 2.37, 260, 12, 2, 0, 5, 580, 34, 3,
                6, 7, 0, "1 pizza pop", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("Frozen Chicken Strips, 1lb box", 6.99, "",false, 6.99, 210, 10, 3, 0,
                40, 520, 13, 1, 0, 14, 0, "2 strips", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("Chicken Drumsticks, 6 pack", 6.99, "", false, 6.99, 159, 9, 3, 0, 92,
                104, 0, 0, 0, 18, 223, "drumstick", 8, aisle8Description,"Meat"));
        items.add(new GroceryItem("Chicken Legs, 4 pack", 8.99, "", false, 8.99, 156, 5, 1, 0, 118, 124,
                0, 0, 0, 24, 309, "leg", 8, aisle8Description, "Meat"));
        items.add(new GroceryItem("Pie Crust", 1.79, "",false, 1.79, 82, 5, 1, 0, 0, 104, 7, 0, 1, 1,
                18, "1/8 crust", 3, aisle3Description, "Frozen"));
        items.add(new GroceryItem("Sandwiches, assorted kinds", 4.99, "", false, 4.99, 200, 2, 0, 0, 0,
                295, 28, 2, 3, 6, 103, "1 sandwich", 9, aisle9Description, "Produce"));
        items.add(new GroceryItem("Potato Chips, Family Size Bag, assorted kinds", 3.19,  "", false,
                3.19, 160, 10, 2, 0, 0, 220, 15, 1, 1, 2, 320, "about 17 chips", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Potato Chips, 42.5 gram bag, assorted kinds", 1.00, "",false,
                1.00, 240, 16, 2, 0, 0, 250, 23, 2, 1, 3, 520, "1 bag", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Canned Fruit, assorted kinds", 1.49, "",false, 1.49, 70, 0, 0,
                0, 0, 10, 17, 1, 6, 4, 200, "113 g", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Canned Vegetables, assorted kinds", 1.49, "",false, 1.49, 80, 0,
                0, 0, 0, 243, 15, 4, 4, 4, 474, "1 cup", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Cereal, assorted kinds, 450g box", 3.99, "",false, 3.99, 379, 7,
                1, 0, 0, 6, 68, 10, 1, 13, 362, "100 g", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Granola Bars, 5 pack, assorted kinds", 1.97, "",false, 1.97, 99,
                4, 0, 0, 0, 61, 14, 1, 6, 2, 70, "bar", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Applesauce, pack of 6 cups", 1.97, "",false, 1.97, 60, 0, 0, 0,
                0, 5, 16, 1, 14, 0, 70, "cup", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Pudding, assorted flavours, pack of 2 cups", 1.47, "",false,
                1.47, 100, 3, 0, 0, 0, 115, 17, 1, 12, 0, 0, "cup", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Flour, 5 kg bag", 6.29, "",false, 6.29, 455, 1, 0, 0, 0, 3, 95,
                3, 0, 12, 134, "1 cup", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("White Sugar, 2kg bag", 2.97, "",false, 2.97, 15, 0, 0, 0, 0, 0,
                4, 0, 4, 0, 0, "1 teaspoon", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Brown Sugar, 2kg bag", 2.97, "",false, 2.97, 15, 0, 0, 0, 0, 0,
                4, 0, 4, 0, 0, "1 teaspoon", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Chocolate Chips, 300g bag", 3.57, "",false, 3.57, 80, 5, 3, 0,
                5, 15, 9, 0, 8, 1, 0, "1 tablespoon", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Baking Chocolate, 225g", 4.87, "",false, 4.87, 145, 15, 9, 0, 0,
                7, 9, 4, 1, 4, 240, "1 square", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Tomato Sauce, 680 mL can", 1.17, "",false, 1.17, 80, 0, 0, 0,
                0, 1640, 16, 4, 8, 2, 640, "1 cup", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Tomato Paste, 680 mL can", 1.17, "",false, 1.17, 30, 0, 0, 0, 0,
                20, 7, 2, 4, 1, 0, "2 tablespoons", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Soy Sauce, 591 mL", 7.97,"", false, 7.97, 53, 1, 0, 0, 0, 5493,
                5, 1, 0, 8, 435, "100 g", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Salad Dressing, assorted kinds, 475 mL", 1.47, "",true, 1.87,
                120, 12, 1, 0, 10, 230, 2, 0, 1, 1, 34, "2 tablespoons", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Peanut Butter, 1kg", 4.77, "",false, 4.77, 188, 16, 3, 0, 0,
                5, 6, 2, 3, 8, 207, "2 tablespoons", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Popcorn", 3.97, "",false, 3.97, 120, 1, 0, 0, 0, 2, 21, 4, 0,
                3, 0, "1 ounce", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Tortilla Chips, 480g", 2.27, "",false, 2.27, 74, 2, 1, 0, 1,
                137, 12, 1, 0, 1, 43, "10 chips", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Taco Shells, 18 shells", 3.77, "",false, 3.77, 150, 7, 3, 0, 0,
                135, 19, 1, 0, 2, 0, "3 shells", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Soft Drinks, 1L Bottle, assorted kinds", 1.29, "",false, 1.29,
                140, 0, 0, 0, 0, 45, 39, 0, 39, 0, 0, "355 mL", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Soft Drinks, 2L Bottle, assorted kinds", 1.99, "",false, 1.99,
                140, 0, 0, 0, 0, 45, 39, 0, 39, 0, 0, "355 mL", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Soft Drinks, 591 mL Bottle, assorted kinds", 0.99, "",false,
                0.99, 230, 0, 0, 0, 0, 80, 60, 0, 59, 0, 0, "bottle", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Soft Drinks, 12 pack cans, assorted kinds", 4.97, "",false,
                4.97, 140, 0, 0, 0, 0, 45, 39, 0, 39, 0, 0, "1 can", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Soft Drinks, 24 pack cans, assorted kinds", 8.99, "",false,
                8.99, 140, 0, 0, 0, 0, 45, 39, 0, 39, 0, 0, "1 can", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Soft Drinks, 355 mL can, assorted kinds", 0.79, "",false, 0.79,
                140, 0, 0, 0, 0, 45, 39, 0, 39, 0, 0, "1 can", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Water, 500 mL bottle", 0.59, "",false, 0.59, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, "bottle", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Water, 12 pack bottles", 2.29, "",false, 2.99, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, "500 mL bottle", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Water, 24 pack bottles", 3.99, "",false, 3.99, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, "500 mL bottle", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Chocolate Bars, King Size (73 g), assorted kinds", 1.59,"",
                false, 1.59, 406, 23, 0, 0, 4, 4, 44, 5, 35, 4, 366, "bar", 0, aisle0Description, "Other"));
        items.add(new GroceryItem("Chocolate Bars, 40 g bar, assorted kinds", 1.00, "",false, 1.00,
                222, 13, 0, 0, 2, 2, 24, 3, 19, 2, 200, "bar", 0, aisle0Description, "Other"));
        items.add(new GroceryItem("Tassimo or Keurig Tabs, Coffee, Tea or Hot Chocolate, assorted"
                + "varieties, 14 tabs/pack", 7.99, "",false, 7.99, 60, 5, 3, 0, 15, 105, 3, 0, 3, 0, 0,
                "beverage", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Iced Tea Mix, 1kg", 4.77, "",true, 4.97, 36, 0, 0, 0, 0, 21,
                9, 0, 9, 0, 19, "100 g iced tea", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Chocolate Sauce, 700mL", 3.27, "",false, 3.27, 100, 1, 0, 0,
                0, 0, 4, 1, 19, 1, 0, "2 tablespoons", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Caramel Sauce, 700mL", 3.27, "",false, 3.27, 100, 1, 0, 0,
                0, 0, 4, 1, 19, 1, 0, "2 tablespoons", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Fruit Juices, 1L, assorted kinds", 1.29, "",false, 1.29, 120, 0,
                0, 0, 0, 20, 30, 0, 30, 0, 20, "250 mL", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Oreo, Fudgeeo, and Dad's Brand Cookies, 303 g box", 2.97,"",
                false, 2.97, 160, 7, 2, 0, 0, 190, 25, 1, 14, 2, 0, "3 cookies", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Crackers, assorted varieties, 200g", 2.47, "",false, 2.47, 81,
                4, 0, 0, 0, 119, 10, 0, 1, 1, 17, "5 crackers", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Corn Starch, 500g", 1.97,"", false, 1.97, 381, 0, 0, 0, 0, 9,
                91, 1, 0, 0, 3, "100 g", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Kraft Dinner", 1.00, "",true, 1.29, 160, 2, 0, 0, 5, 250, 31,
                1, 5, 6, 0, "1/4 box", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Salt", 0.97, "",false, 0.97, 0, 0, 0, 0, 0, 2326, 0, 0, 0,
                0, 1, "1 teaspoon", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Baking Soda" ,1.47, "",false, 1.47, 0, 0, 0, 0, 0, 1259, 0, 0, 0,
                0, 0, "1 teaspoon", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Baking Powder", 1.47,"", false, 1.47, 2, 0, 0, 0, 0, 488, 1, 0,
                0, 0, 1, "1 teaspoon", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Shortening, 1 lb box", 2.87, "",false, 2.87, 113, 13, 12, 0, 0, 0,
                0, 0, 0, 0, 0, "1 tablespoon", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Mayonnaise", 4.99, "",false, 4.99, 94, 10, 1, 0, 6, 87, 0, 0,
                0, 0, 3, "1 tablespoon", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Ketchup", 3.97, "",false, 3.97, 112, 0, 0, 0, 0, 907, 26, 0, 22,
                1, 315, "100 g", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Mustard", 3.97, "",false, 3.97, 66, 4, 0, 0, 0, 1135, 5, 3, 1,
                4, 138, "100 g", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Relish", 3.97,"", false, 3.97, 130, 1, 0, 0, 0, 811, 35, 1, 29,
                0, 25, "100 g", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Grated Parmesan Cheese", 4.99, "",false, 4.99, 60, 4, 2, 0, 15,
                210, 1, 0, 0, 6, 10, "2 tablespoons", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Spaghetti", 1.27, "",false, 1.27, 371, 1, 0, 0, 0, 6, 75, 3,
                3, 13, 223, "100 g", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Canned Pasta", 1.49, "",false, 1.49, 150, 3, 0, 0, 0, 620, 26,
                2, 8, 6, 0, "3/4 cup", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Lasagna Noodles", 1.99, "",false, 1.99, 210, 1, 0, 0, 0, 0,
                41, 39, 2, 2, 105, "56 g", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Macaroni", 1.67,"", false, 1.67, 212, 1, 0, 0, 0, 3, 43, 1,
                1, 7, 127, "57 g", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Penne Pasta", 1.67,"", false, 1.67, 290, 11, 3, 0, 20, 880,
                45, 3, 13, 11, 75, "1 cup", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Vermicelli", 2.29, "",false, 2.29, 231, 0, 0, 0, 0, 2, 57, 2, 12,
                0, 2, "1/2 cup", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Croutons, 142g", 1.97, "",false, 1.97, 122, 2, 0, 0, 0, 209, 22,
                2, 0,  4, 37, "1 cup", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Vanilla", 7.99,"", false, 7.99, 38, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1,
                "1 tablespoon", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Cooking Spray", 3.97,"", false, 3.97, 2, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, "1 spray, approx 1/3 second", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Honey", 4.99, "",false, 4.99, 60, 0, 0, 0, 0, 0, 17, 0, 16, 0,
                0, "1 tablespoon", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Jams, assorted flavours", 3.29, "",false, 3.29, 278, 0, 0,
                0, 0, 32, 69, 1, 49, 0, 77, "100 g", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Salsa", 3.27, "",false, 3.27, 36, 0, 0, 0, 0, 430, 7, 1, 0, 1,
                270, "100 g", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Raisins, 750g", 5.97,"", false, 5.97, 299, 1, 0, 0, 0, 11, 79,
                4, 59, 3, 749, "100 g", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Canned Soup, assorted varieties", 1.27, "",false, 1.27, 110, 2,
                0, 0, 0, 750, 22, 2, 16, 3, 0, "250 mL prepared", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Canned Tuna and Canned Salmon", 1.00, "",false, 1.00, 60, 0,
                0, 0, 0, 150, 0, 0, 0, 13, 125, "1/2 can, drained", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Syrup, 750 mL", 2.77,"", false, 2.77, 180, 0, 0, 0, 0, 5,
                44, 0, 29, 0, 0, "3 tablespoons", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Chocolate Powder/Nesquik, 540g", 4.79, "",false, 4.79, 170,
                1, 0, 0, 0, 25, 12, 1, 1, 1, 0, "1 cup, prepared", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Coffee, 925 g tin, assorted brands", 7.78, "",false, 7.78, 5, 0,
                0, 0, 0, 10, 1, 0, 0, 0, 0, "1 tin", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Tea, box of 48 bags, assorted kinds", 7.78, "",false, 7.78, 1,
                0, 0, 0, 0, 4, 0, 0, 0, 0, 0, "1 cup tea", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("Coffee Filters", 3.29,"", false, 3.29, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, "N/A", 4, aisle4Description, "Other"));
        items.add(new GroceryItem("200 mL Juice Boxes, 12 pack, assorted kinds", 2.97, "",false,
                2.97, 100, 0, 0, 0, 0, 15, 23, 0, 20, 1, 370, "1 box", 5, aisle5Description, "Other"));
        items.add(new GroceryItem("Green Beans", 1.00, "100 g", false, 1.00, 31, 0, 0, 0,
                0, 6, 7, 3, 0, 2, 209, "100 g", 1, aisle1Description, "Produce"));
        items.add(new GroceryItem("Teriyaki Sauce", 4.17, "", false, 4.17, 89, 0, 0, 0,
                0 , 3833, 16, 0, 14, 6, 225, "100 g", 4, aisle4Description,
                "Other"));
        items.add(new GroceryItem("Fettuccine Noodles", 6.00, "", true, 5.50, 99, 3, 0,
                0, 14, 166, 14, 2, 1, 6, 168, "100g", 4,
                aisle4Description, "Other"));
        items.add(new GroceryItem("Heavy Cream", 5.55, "", false, 5.55, 196, 19,12,
                0, 66, 40, 4, 0, 3, 122, 40, "250g", 8, aisle8Description,
                "Dairy"));
        items.add(new GroceryItem("English Muffins, 6 Pack", 2.75, "", false, 2.75, 134, 1, 0,
                0, 0, 264, 26, 1, 0, 4, 74, "per 1 muffin", 7,
                aisle7Description, "Bakery"));
        items.add(new GroceryItem("Spices, assorted", 0.99, "", false, 0.99, 10, 0, 0,
                0, 0, 1, 2, 0, 0, 0, 15, "1 tsp", 4,
                aisle4Description, "Other"));
        items.add(new GroceryItem("Cocoa", 4.00, "", false, 4.00, 12, 1, 0, 0,
                0, 1, 3, 1, 0, 1, 82, "1 tbsp", 4, aisle4Description,
                "Other"));
        items.add(new GroceryItem("Blue Cheese, Wedge", 4.99, "", false, 4.99, 353, 29,
                19, 0, 75, 1395, 2, 0, 0, 21, 256, "per 100 g",
                9, aisle9Description, "Deli"));
        items.add(new GroceryItem("Green Onions", 0.42, "per 100g", false, 0.42, 60, 0, 0, 0, 0, 5, 16,
                3, 0, 1, 0, "1 onion", 2, aisle2Description, "Produce"));




    }
}