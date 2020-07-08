package com.example.nursingsystem.Service.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nursingsystem.Activity.Sick_Bed_ListActivity;
import com.example.nursingsystem.Interface_Index.OnRecyclerItemClkickListener;
import com.example.nursingsystem.R;

import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.ViewHolder> {
    @NonNull
    private List<String> departmentList;
    private Context context;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView department;
        View departmentView;

         public ViewHolder(@NonNull View itemView) {
            super(itemView);
            department = (TextView)itemView.findViewById(R.id.item_department);
            departmentView = itemView;
        }
    }

    public DepartmentAdapter(Context mcontext,List<String> mdepartmentList){
        this.departmentList = mdepartmentList;
        this.context = mcontext;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.department_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.departmentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                String department = departmentList.get(position);
                Intent intent = new Intent(context,Sick_Bed_ListActivity.class);
                intent.putExtra("setDepartment",department);
                context.startActivity(intent);
            }
        });
        return holder;
    }


    public void onBindViewHolder(ViewHolder holder, int position) {
        String department = departmentList.get(position);
        holder.department.setText(department);
    }

    @Override
    public int getItemCount() {
        return departmentList.size();
    }


}
