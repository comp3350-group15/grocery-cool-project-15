package comp3350.grocerystoreassistant.presentation.storeActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.location.locatorImplementation.GooglePlacesUtilities;
import comp3350.grocerystoreassistant.objects.groceryStore.Store;

public class StorePageActivity extends AppCompatActivity {
    private static final String TAG = "StorePageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_page);
        Log.i(TAG, "onCreate: " + "I'm here");
        initStorePage();
    }

    private void initStorePage() {
        ImageView storeImage = findViewById(R.id.layout_store_page_photo);
        TextView storeNameText = findViewById(R.id.layout_store_page_name);
        TextView storeAddressText = findViewById(R.id.layout_store_page_address_text);
        TextView storeWebText = findViewById(R.id.layout_store_page_website_text);
        TextView storePhoneText = findViewById(R.id.layout_store_page_phone_text);
        TextView storeHoursText = findViewById(R.id.layout_store_page_hours_text);
        TextView storeRatingText = findViewById(R.id.layout_store_page_rating_text);

        Bundle data = getIntent().getBundleExtra("bundle");
        Store store = data.getParcelable("store");

        storeNameText.setText(store.getName());
        storeAddressText.setText(store.getStoreAddress());
        storePhoneText.setText(store.getPhoneNumber());
        storeImage.setImageResource(store.getImageAddress());

        String rateStr = "Rating: " + store.getRating() + " / " + 5.0;
        storeRatingText.setText(rateStr);

        String str_links = "<a href=\""+store.getUrl()+"\">Go to Website</a>\n";
        Log.i(TAG, "initStorePage: " + str_links);

        storeWebText.setText( Html.fromHtml( str_links ) );
        storeWebText.setMovementMethod(LinkMovementMethod.getInstance());

        String openingHours = "";

        for(int i = 1; i < 8; i++) {
            String day = Store.days[i];
            openingHours += day + ": " + store.getHours(day);
            if(i != 7) {
                openingHours += "\n";
            }
        }

        storeHoursText.setText(openingHours);

    }
}

