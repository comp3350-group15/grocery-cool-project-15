package comp3350.grocerystoreassistant.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.content.Intent;


import java.util.ArrayList;
import java.util.List;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.business.AccessItems;
import comp3350.grocerystoreassistant.presentation.listActivity.GroceryListActivity;
import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.persistence.stubs.ItemPersistenceStub;
import comp3350.grocerystoreassistant.presentation.listActivity.ItemRecyclerVAdapter;


public class SearchActivity extends AppCompatActivity {

    private SearchView mySearchView;
    private ListView myListView;

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    private List<GroceryItem> list;
    private AccessItems accessItems;
    private ArrayList<String> mDepartments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //initialize department list (this search page will show the list of departments before
        //doing any kind of searching!
        // initDepartmentList();

        mySearchView = (SearchView) findViewById(R.id.SearchView);
        myListView = (ListView) findViewById(R.id.myList);

        accessItems = new AccessItems(new ItemPersistenceStub());
        list = accessItems.getAllItems();

        items = new ArrayList<String>();

        for (int itemToAdd = 0; itemToAdd < list.size(); itemToAdd++) {
            items.add(list.get(itemToAdd).getName());
        }


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        myListView.setAdapter(adapter);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            int j;
            Context c;

            @Override
            public boolean onQueryTextSubmit(String query) {

                for (int i = 0; i < list.size(); i++) {
                    j = i;
                    if (query.equalsIgnoreCase(list.get(i).getName())) {
                        displayOptionButton(i);
                    }
                }

                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });


        myListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> li, View v, int i, long l) {

                for (int itemSearch = 0; itemSearch < items.size(); itemSearch++) {
                    if (myListView.getAdapter().getItem(i).equals(list.get(itemSearch).getName())) {
                        displayOptionButton(itemSearch);
                    }
                }
            }
        });
    }

    private void displayOptionButton(int i) {
        Context context = SearchActivity.this;
        final int j = i;

        AlertDialog.Builder alert = new AlertDialog.Builder(context);

        alert.setTitle("Add to List?");

        alert.setMessage("Would you like to add item: " + list.get(i).getName() + " to your " +
                "list, or view more information about it?");
        alert.setCancelable(true);
        alert.setPositiveButton("ADD TO LIST", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent newAddToListIntent = new Intent(getApplicationContext(), GroceryListActivity.class);
                Bundle extras = new Bundle(2);
                extras.putString("add", "addToList");
                extras.putString("item", list.get(j).getName());
                newAddToListIntent.putExtras(extras);
                newAddToListIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newAddToListIntent);
            }
        });

        alert.setNegativeButton("VIEW MORE INFORMATION", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Context c = SearchActivity.this;
                ItemRecyclerVAdapter adapter = new ItemRecyclerVAdapter();
                adapter.viewMoreInformation(list.get(j).getName(), c);
            }
        });

        alert.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alert.create();
        alertDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
}
