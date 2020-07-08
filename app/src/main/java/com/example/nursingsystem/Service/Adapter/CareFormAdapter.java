package com.example.nursingsystem.Service.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nursingsystem.Activity.Detail_Care_FormActivity;
import com.example.nursingsystem.Model.Care_Form;
import com.example.nursingsystem.R;

import java.util.List;

public class CareFormAdapter extends RecyclerView.Adapter<CareFormAdapter.ViewHolder> {
    private List<Care_Form> list;
    private Context context;

    public CareFormAdapter (List<Care_Form> list1,Context context1){
        this.list = list1;
        this.context = context1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_care_form,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.form_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int poaition = holder.getAdapterPosition();
                Care_Form care_form = list.get(poaition);
                /**
                 * 跳转到详细页面
                 */
                Intent intent = new Intent(context, Detail_Care_FormActivity.class);
                intent.putExtra("care_form",care_form);
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Care_Form care_form = list.get(position);
        holder.name.setText(care_form.getName());
        holder.content.setText(care_form.getContent());
        holder.caretype.setText(care_form.getCaretype());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View form_view;
        TextView name;
        TextView content;
        TextView caretype;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            form_view = itemView;
            name = (TextView)itemView.findViewById(R.id.care_form_name);
            caretype = (TextView)itemView.findViewById(R.id.care_form_level);
            content = (TextView)itemView.findViewById(R.id.care_form_content);
        }
    }
}
