package com.example.nursingsystem.Service.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nursingsystem.Activity.Detail_Check_AdviceActivity;
import com.example.nursingsystem.Model.Doctor_Advice;
import com.example.nursingsystem.R;

import java.util.List;

public class Doctor_AdviceAdapter extends RecyclerView.Adapter<Doctor_AdviceAdapter.ViewHolder> {
    private List<Doctor_Advice> list;
    private Context context;

    public Doctor_AdviceAdapter(List<Doctor_Advice>list1,Context context1){
        this.context = context1;
        this.list = list1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor_advice,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.advice_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Doctor_Advice doctor_advice = list.get(position);
                Intent intent = new Intent(context, Detail_Check_AdviceActivity.class);
                intent.putExtra("doctor_advice",doctor_advice);
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Doctor_Advice doctor_advice = list.get(position);
        holder.name.setText(doctor_advice.getName());
        holder.type.setText(doctor_advice.getOrder_type());
        holder.content.setText(doctor_advice.getDoc_order_content());
        holder.time.setText(doctor_advice.getEntry_time()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View advice_view;
        TextView name;
        TextView content;
        TextView time;
        TextView type;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            advice_view = itemView;
            name = (TextView)itemView.findViewById(R.id.check_advice_list_name);
            content = (TextView)itemView.findViewById(R.id.check_advice_list_content);
            time = (TextView)itemView.findViewById(R.id.check_advice_list_time);
            type = (TextView)itemView.findViewById(R.id.check_advice_list_type);
        }
    }
}
