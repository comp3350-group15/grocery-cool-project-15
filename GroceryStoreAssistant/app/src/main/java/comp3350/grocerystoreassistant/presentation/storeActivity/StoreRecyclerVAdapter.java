package comp3350.grocerystoreassistant.presentation.storeActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.location.locatorImplementation.GooglePlacesUtilities;
import comp3350.grocerystoreassistant.objects.groceryStore.Store;
import de.hdodenhof.circleimageview.CircleImageView;

public class StoreRecyclerVAdapter extends RecyclerView.Adapter<StoreRecyclerVAdapter.ViewHolder> {
    private static final String TAG = "StoreRecyclerVAdapter";
    private ArrayList<Store> mStoreArrayList = new ArrayList<>();
    private Context mContext;

    public StoreRecyclerVAdapter(Context context, ArrayList<Store> mStoresList) {
        mContext = context;
        mStoreArrayList = mStoresList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_store_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        final Store store = mStoreArrayList.get(position);

        int imgAddrs = store.getImageAddress();
        final String storeName = store.getName();
        String address = store.getStoreAddress();
        String rating = Double.toString(store.getRating());

        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_WEEK);
        String time = store.getHours(Store.days[day]);
        String hours = Store.days[day] + ": " + time;
//        Log.i(TAG, "onBindViewHolder: " + hours);

        holder.image.setImageResource(imgAddrs);
        holder.imageName.setText(storeName);
        holder.storeAddress.setText(address);
        holder.storeHours.setText(hours);
        holder.storeRating.setText(rating);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, StorePageActivity.class);
                Bundle data = new Bundle();
                data.putParcelable("store", store);

                intent.putExtra("bundle", data);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStoreArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView imageName;
        TextView storeAddress;
        TextView storeHours;
        TextView storeRating;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            imageName = itemView.findViewById(R.id.layout_store_name);
            storeAddress = itemView.findViewById(R.id.layout_store_address);
            storeHours = itemView.findViewById(R.id.layout_store_hours);
            storeRating = itemView.findViewById(R.id.layout_store_rating);

            parentLayout = itemView.findViewById(R.id.parent_store_layout);
        }
    }
}
