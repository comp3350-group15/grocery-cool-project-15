package comp3350.grocerystoreassistant.presentation.departmentActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import java.util.ArrayList;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.presentation.HomeActivity;
import comp3350.grocerystoreassistant.presentation.SearchActivity;
import comp3350.grocerystoreassistant.presentation.listActivity.GroceryListActivity;

public class DepartmentActivity extends AppCompatActivity {
    private ArrayList<String> mDepartments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        //initialize department list (this search page will show the list of departments before
        //doing any kind of searching!
        initDepartmentList();
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

    private void initDepartmentList(){
        mDepartments = new ArrayList<String>();
        for(int i = 0; i < getResources().getStringArray(R.array.department).length; i++){
            mDepartments.add(getResources().getStringArray(R.array.department)[i]);
        }

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.department_list_recycler_view);
        DepartmentRecyclerVAdapter adapter = new DepartmentRecyclerVAdapter(this, mDepartments );

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
