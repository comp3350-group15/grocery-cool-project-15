package comp3350.grocerystoreassistant.objects;

/**Class GroceryItem - to store information about items that are in the store. This includes name, price, whether
// or not it is on sale, nutritional info, and location info. */
public class GroceryItem {
	private String name; // the name is unique, so we use the name as the identifier
	private double price;
	private String pricePerWeight;
	private boolean onSale;
	private double onSalePrice;
	private int calories;
	private int fat;
	private int saturatedFat;
	private int transFat;
	private int cholesterol;
	private int sodium;
	private int carbohydrates;
	private int fiber;
	private int sugar;
	private int protein;
	private int potassium;
	private String perAmount;
	private int aisle;
	private String aisleDescription;
	private String department;

	public GroceryItem(String name, double price, String pricePerWeight, boolean onSale, double onSalePrice, int calories, int fat,
					   int saturatedFat, int transFat, int cholesterol, int sodium, int carbohydrates, int fiber, int sugar,
					   int protein, int potassium, String perAmount, int aisle, String aisleDescription, String department) {
		this.name = name;
		this.price = price;
		this.pricePerWeight = pricePerWeight;
		this.onSale = onSale;
		this.onSalePrice = onSalePrice;
		this.calories = calories;
		this.fat = fat;
		this.saturatedFat = saturatedFat;
		this.transFat = transFat;
		this.cholesterol = cholesterol;
		this.sodium = sodium;
		this.carbohydrates = carbohydrates;
		this.fiber = fiber;
		this.sugar = sugar;
		this.protein = protein;
		this.potassium = potassium;
		this.perAmount = perAmount;
		this.aisle = aisle;
		this.aisleDescription = aisleDescription;
		this.department = department;
	}

	@Override
	public boolean equals(Object itemObject) {
		if(!(itemObject instanceof GroceryItem)) {
			return false;
		}

		GroceryItem otherItem = (GroceryItem) itemObject;
		// the name is unique
		return cmpStr(this.name, otherItem.name);
	}

	private boolean cmpInt(int a, int b) {
		return a == b;
	}

	private boolean cmpStr(String a, String b) {
		return a.compareTo(b) == 0;
	}

	private boolean cmpDouble(Double a, Double b) {
		return Math.abs(a- b) <= 1.e-10;
	}

	private boolean cmpBool(boolean a, boolean b) {
		return a == b;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getPricePerWeight() {
		return pricePerWeight;
	}

	public boolean isOnSale() {
		return onSale;
	}

	public double getOnSalePrice() {
		return onSalePrice;
	}

	public int getCalories() {
		return calories;
	}

	public int getFat() {
		return fat;
	}

	public int getSaturatedFat() {
		return saturatedFat;
	}

	public int getTransFat() { return transFat; }

	public int getCholesterol() {
		return cholesterol;
	}

	public int getSodium() {
		return sodium;
	}

	public int getCarbohydrates() {
		return carbohydrates;
	}

	public int getFiber() {
		return fiber;
	}

	public int getSugar() { return sugar; }

	public int getProtein() {
		return protein;
	}

	public int getPotassium() {
		return potassium;
	}

	public String getPerAmount() {
		return perAmount;
	}

	public int getAisle() {
		return aisle;
	}

	public String getAisleDescription() {
		return aisleDescription;
	}

	public String getDepartment(){ return department; }
}