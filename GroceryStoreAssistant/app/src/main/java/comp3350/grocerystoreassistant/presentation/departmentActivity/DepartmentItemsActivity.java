package comp3350.grocerystoreassistant.presentation.departmentActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.business.AccessItems;
import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.persistence.stubs.ItemPersistenceStub;
import comp3350.grocerystoreassistant.presentation.HomeActivity;
import comp3350.grocerystoreassistant.presentation.SearchActivity;
import comp3350.grocerystoreassistant.presentation.listActivity.GroceryListActivity;
import comp3350.grocerystoreassistant.presentation.listActivity.ItemRecyclerVAdapter;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DepartmentItemsActivity extends AppCompatActivity {
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageAddrs = new ArrayList<>();
    private ArrayList<String> itemAisle = new ArrayList<>();
    private ArrayList<String> itemPrice = new ArrayList<>();
    private ArrayList<String> itemOnSale = new ArrayList<>();
    private AccessItems accessItems = new AccessItems(new ItemPersistenceStub());;
    private ArrayList<String> mDepartments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_items);
        getItemsForDepartment();
        initRecyclerView();
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

    private void initRecyclerView() {
            RecyclerView recyclerView = findViewById(R.id.department_items_list_recycler_view);
            ItemRecyclerVAdapter adapter = new ItemRecyclerVAdapter(this, mNames, mImageAddrs, itemAisle, itemPrice, itemOnSale);

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

    private void getItemsForDepartment(){
        String departmentName;
        int[] stubImgAsset = {R.drawable.food_1, R.drawable.food_2, R.drawable.food_3, R.drawable.food_4, R.drawable.food_5};
        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            departmentName = bundle.getString("DepartmentName");
            for(GroceryItem gi: accessItems.getAllItems()){
                if(gi != null && gi.getDepartment() != null) {
                    if(gi.getDepartment().equalsIgnoreCase(departmentName)) {
                        mNames.add(gi.getName());

                        int rnd = new Random().nextInt(stubImgAsset.length);
                        mImageAddrs.add(stubImgAsset[rnd]);

                        itemAisle.add("Aisle: " + gi.getAisle());

                        itemPrice.add("$" + gi.getPrice());

                        itemOnSale.add("On sale: " + gi.isOnSale());
                    }
                }
            }
        }
    }
}
