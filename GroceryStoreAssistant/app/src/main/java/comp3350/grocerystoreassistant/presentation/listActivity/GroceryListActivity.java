package comp3350.grocerystoreassistant.presentation.listActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.business.AccessItems;
import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.business.itemList.ItemListUtils;
import comp3350.grocerystoreassistant.persistence.stubs.ItemPersistenceStub;
import comp3350.grocerystoreassistant.presentation.HomeActivity;
import comp3350.grocerystoreassistant.presentation.SearchActivity;


public class GroceryListActivity extends AppCompatActivity {

    private static ArrayList<String> mNames = new ArrayList<>();
    private static ArrayList<Integer> mImageAddrs = new ArrayList<>();
    private static ArrayList<String> itemAisle = new ArrayList<>();
    private static ArrayList<String> itemPrice = new ArrayList<>();
    private static ArrayList<String> itemOnSale = new ArrayList<>();
    private static ArrayList<Date> datesAdded = new ArrayList<>();
    private AccessItems accessItems = new AccessItems(new ItemPersistenceStub());
    private Spinner filterDropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);
        initRecyclerView();
        filterDropdown = findViewById(R.id.filter_items_drop_down_list);
        final String[] filterOptions = new String[]{"Sort List By...", "Time Added (oldest to newest)(default)" ,
                 "Alphabetical", "Price"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                filterOptions);
        filterDropdown.setAdapter(adapter);


        if((String.valueOf(getIntent().getStringExtra("add")).equals("addToList"))) {
            List items = accessItems.getAllItems();
            for(int itemNum = 0; itemNum < items.size(); itemNum++) {
                GroceryItem groceryItem = (GroceryItem)items.get(itemNum);
                for(int i = 0; i < getIntent().getExtras().keySet().size()-1; i++){
                    String key = "item"+i;
                    if(groceryItem.getName().equals(getIntent().getStringExtra(key)) || groceryItem.getName().equals(getIntent().getStringExtra("item"))) {
                        addToList(groceryItem);
                    }
                }
            }
        }

        filterDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                List list = ItemListUtils.sort(mNames, filterOptions[position], datesAdded);
                mNames.clear();
                itemPrice.clear();
                itemAisle.clear();
                itemOnSale.clear();
                for(int addItem = 0; addItem < list.size(); addItem++) {
                    GroceryItem item = (GroceryItem) list.get(addItem);
                    mNames.add(item.getName());
                    itemAisle.add("Aisle: " + item.getAisle());
                    itemPrice.add("Price: " + item.getPrice());
                    itemOnSale.add("On sale: " + item.isOnSale());
                }


                initRecyclerView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.navigation_home:
                Intent newHomeIntent = new Intent(this, HomeActivity.class);
                newHomeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newHomeIntent);
                return true;
            case R.id.navigation_search:
                Intent newSearchIntent = new Intent(this, SearchActivity.class);
                newSearchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newSearchIntent);
                return true;
            case R.id.navigation_list:
                Intent newListIntent = new Intent(this, GroceryListActivity.class);
                newListIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newListIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void addToList(GroceryItem item){
        int[] stubImgAsset = {R.drawable.food_1, R.drawable.food_2, R.drawable.food_3, R.drawable.food_4, R.drawable.food_5};
        mNames.add(item.getName());
        int rnd = new Random().nextInt(stubImgAsset.length);
        mImageAddrs.add(stubImgAsset[rnd]);
        itemAisle.add("Aisle: " + item.getAisle());
        itemPrice.add("$" + item.getPrice());
        itemOnSale.add("On sale: " + item.isOnSale());
        datesAdded.add(new Date());
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.item_list_recycler_view);
        ItemRecyclerVAdapter adapter = new ItemRecyclerVAdapter(this, mNames, mImageAddrs, itemAisle, itemPrice, itemOnSale);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

