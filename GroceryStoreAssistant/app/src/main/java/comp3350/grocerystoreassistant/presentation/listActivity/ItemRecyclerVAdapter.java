package comp3350.grocerystoreassistant.presentation.listActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import comp3350.grocerystoreassistant.R;
import comp3350.grocerystoreassistant.business.AccessItems;
import comp3350.grocerystoreassistant.objects.GroceryItem;
import comp3350.grocerystoreassistant.persistence.stubs.ItemPersistenceStub;
import comp3350.grocerystoreassistant.presentation.SearchActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class ItemRecyclerVAdapter extends RecyclerView.Adapter<ItemRecyclerVAdapter.ViewHolder> {

    private ArrayList<String> mNames;
    private ArrayList<Integer> mImagesAddr;
    private ArrayList<String> itemAisle;
    private ArrayList<String> itemPrice;
    private ArrayList<String> itemOnSale;

    private Context mContext;


    public ItemRecyclerVAdapter(){

    }

    public ItemRecyclerVAdapter(Context mContext, ArrayList<String> mNames, ArrayList<Integer> mImageAddrs, ArrayList<String> itemAisle, ArrayList<String> itemPrice, ArrayList<String> itemOnSale) {
        this.mNames = mNames;
        this.mImagesAddr = mImageAddrs;
        this.itemAisle = itemAisle;
        this.itemPrice = itemPrice;
        this.itemOnSale = itemOnSale;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_items_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImagesAddr.get(position))
                .into(holder.image);

        holder.imageName.setText(mNames.get(position));
        holder.aisle.setText(itemAisle.get(position));
        holder.price.setText(itemPrice.get(position));
        holder.onSale.setText(itemOnSale.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_LONG).show();
                
                Context context = mContext;
                AlertDialog.Builder alert;
                AlertDialog alertDialog;
                if(context instanceof GroceryListActivity) {
                    alert = new AlertDialog.Builder(context);
                    alert.setTitle("View information about item?");
                    alert.setMessage("Would you like to view more information about item " + mNames.get(position) +
                            "?");
                    alert.setCancelable(true);
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                                viewMoreInformation(mNames.get(position));
                        }
                    });

                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            dialog.dismiss();
                        }
                    });
                    alertDialog = alert.create();
                    alertDialog.show();
                } else {
                    alert = new AlertDialog.Builder(context);
                    alert.setTitle("View more information or add to list?");
                    alert.setMessage("Would you like to view more information about item " + mNames.get(position) +
                            " or add it to your list?");
                    alert.setCancelable(true);
                    alert.setPositiveButton("ADD TO LIST", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent newAddToListIntent = new Intent(mContext, GroceryListActivity.class);
                            Bundle extras = new Bundle(2);
                            extras.putString("add", "addToList");
                            extras.putString("item", mNames.get(position));
                            newAddToListIntent.putExtras(extras);
                            newAddToListIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            mContext.startActivity(newAddToListIntent);
                        }
                    });

                    alert.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            dialog.dismiss();
                        }
                    });

                    alert.setNegativeButton("VIEW MORE INFORMATION", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                                viewMoreInformation(mNames.get(position));
                        }
                    });
                    alertDialog = alert.create();
                    alertDialog.show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public void viewMoreInformation(String s) {

        
        AccessItems items = new AccessItems(new ItemPersistenceStub());
        List theItems = items.getAllItems();

        for (int i = 0; i < theItems.size(); i++) {
            GroceryItem newItem = (GroceryItem) theItems.get(i);
            if (newItem.getName().equals(s)) {

                AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                alert.setTitle("Information about item: " + s);
                alert.setMessage("Name: " + newItem.getName() + "\nPrice: " + newItem.getPrice() +
                      "\nPer: " + newItem.getPricePerWeight() + "\nOn Sale? " + newItem.isOnSale() +
                        "\nOn Sale Price: " + newItem.getOnSalePrice() + "\n\n----Nutritional Info----" +
                        "\nCalories: " + newItem.getCalories() + "\nFat: " + newItem.getFat() +
                        "\nSaturated Fat: " + newItem.getSaturatedFat() + "\nTrans Fat: " + newItem.getTransFat() +
                        "\nCholesterol: " + newItem.getCholesterol() + "\nSodium: " + newItem.getSodium() +
                        "\nFiber: " + newItem.getFiber() + "\nSugar: " + newItem.getSugar() + "\nProtein: " +
                         newItem.getProtein() + "\nPotassium: " + newItem.getPotassium() + "\nServing Size: " +
                         newItem.getPerAmount() + "\n\n----Location Info----" + "\nAisle: " + newItem.getAisle() +
                        "\nAisle Description: " + newItem.getAisleDescription() + "\nDepartment: " + newItem.getDepartment());

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alert.create();
                alertDialog.show();
            }
        }
    }

    public void viewMoreInformation(String s, Context c){
        mContext = c;
        viewMoreInformation(s);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView imageName;
        TextView aisle;
        TextView price;
        TextView onSale;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.grocery_list_item_image);
            imageName = itemView.findViewById(R.id.layout_grocery_item_name);
            aisle = itemView.findViewById(R.id.layout_grocery_item_aisle);
            price = itemView.findViewById(R.id.layout_grocery_item_price);
            onSale = itemView.findViewById(R.id.layout_grocery_item_sale);

            parentLayout = itemView.findViewById(R.id.parent_grocery_list_layout);
        }
    }
}
