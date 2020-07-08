package com.example.nursingsystem.Service.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nursingsystem.Activity.DetailActivity;
import com.example.nursingsystem.Model.SickBed;
import com.example.nursingsystem.R;

import java.util.List;

public class SickBedAdapter extends RecyclerView.Adapter<SickBedAdapter.ViewHolder> {
    private List<SickBed> list;
    private Context context;


    static class ViewHolder extends RecyclerView.ViewHolder{
        View sickbedView;
        CardView bedview;
        TextView name,inpatient,age,bed_num;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sickbedView = itemView;
            bedview = (CardView)itemView.findViewById(R.id.bed);
            name = (TextView)itemView.findViewById(R.id.sick_name);
            inpatient = (TextView)itemView.findViewById(R.id.sick_inpatient);
            age = (TextView)itemView.findViewById(R.id.sick_age);
            bed_num = (TextView)itemView.findViewById(R.id.sick_bednum);
        }
    }

    public SickBedAdapter(Context mcontext,List<SickBed> sickBedList){
        this.list = sickBedList;
        this.context = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bed,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.sickbedView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                SickBed sickBed = list.get(position);
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("sickbed",sickBed);
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SickBed sickBed = list.get(position);
        if(sickBed.getName() != null){
            holder.name.setText(sickBed.getName());
            holder.name.setTextColor(0xFFFFFFFF);
            holder.age.setText(sickBed.getAge()+"岁");
            holder.age.setTextColor(0xFFFFFFFF);
            holder.bed_num.setText(sickBed.getBed_num()+"床");
            holder.bed_num.setTextColor(0xFFFFFFFF);
            holder.inpatient.setText(""+sickBed.getInpatient());
            holder.inpatient.setTextColor(0xFFFFFFFF);
            switch (sickBed.getCarelevel()){
                case "基础护理":
                    holder.bedview.setBackgroundColor(0xFF43F91A);
                    break;
                case "一级护理":
                    holder.bedview.setBackgroundColor(0xFFDF3526);
                    break;
                case "二级护理":
                    holder.bedview.setBackgroundColor(0xFFF4D255);
                    break;
                case "三级护理":
                    holder.bedview.setBackgroundColor(0x00000000);
                    break;
                default:
                    break;
            }
        } else {
            holder.bedview.setBackgroundColor(0xFFBAB9B9);
            holder.name.setText("空");
            holder.bed_num.setText(sickBed.getBed_num() + "床");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
