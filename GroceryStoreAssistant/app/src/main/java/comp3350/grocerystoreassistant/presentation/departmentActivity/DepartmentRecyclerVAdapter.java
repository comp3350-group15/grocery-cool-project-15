package comp3350.grocerystoreassistant.presentation.departmentActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import comp3350.grocerystoreassistant.R;

public class DepartmentRecyclerVAdapter extends RecyclerView.Adapter<DepartmentRecyclerVAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<String> mDepartments;
    public DepartmentRecyclerVAdapter(Context mContext, ArrayList<String> mDepartments) {

        this.mContext = mContext;
        this.mDepartments = mDepartments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_departments_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentRecyclerVAdapter.ViewHolder holder, final int position) {
        holder.deptName.setText(mDepartments.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(mContext, mDepartments.get(position), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(mContext, DepartmentItemsActivity.class);

                intent.putExtra("DepartmentName", mDepartments.get(position));
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDepartments.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView deptName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            deptName= itemView.findViewById(R.id.layout_department_name);

            parentLayout = itemView.findViewById(R.id.parent_departments_list_layout);
        }
    }


}

