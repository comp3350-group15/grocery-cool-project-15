package comp3350.grocerystoreassistant.presentation.storeActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Random;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.objects.groceryStore.Store;
import comp3350.grocerystoreassistant.presentation.listActivity.GroceryListActivity;
import comp3350.grocerystoreassistant.presentation.HomeActivity;
import comp3350.grocerystoreassistant.presentation.SearchActivity;

public class StoreListActivity extends AppCompatActivity {

    private static final String TAG = "StoreListActivity";
    private ArrayList<Store> mStores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);
        Log.d(TAG, "onCreate: started");
        initImageBitmaps();
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

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        int[] stubImgAsset = {R.drawable.store_1, R.drawable.store_2, R.drawable.store_3, R.drawable.store_4, R.drawable.store_5};

        Bundle data = getIntent().getBundleExtra("bundle");
        mStores = data.getParcelableArrayList("stores");

        for(int i = 0; i < mStores.size(); i++) {
            int rnd = new Random().nextInt(stubImgAsset.length);
            mStores.get(i).setImageAddress(stubImgAsset[rnd]);
        }

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerView.");

        RecyclerView recyclerView = findViewById(R.id.store_list_recycler_view);
        StoreRecyclerVAdapter adapter = new StoreRecyclerVAdapter(this, mStores);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
