package com.example.nursingsystem.Service.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nursingsystem.Activity.Detail_Take_MedicineActivity;
import com.example.nursingsystem.Model.Take_Medicine_Form;
import com.example.nursingsystem.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class TakeMedicineAdapter extends RecyclerView.Adapter<TakeMedicineAdapter.ViewHolder> {

    private List<Take_Medicine_Form> formList;
    private Context context;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View formView;
        TextView name;
        TextView bed_num;
        TextView medicine;
        TextView time;
        TextView status;

        public ViewHolder(View view){
            super(view);
            formView = view;
            name = (TextView)view.findViewById(R.id.tm_name);
            bed_num = (TextView)view.findViewById(R.id.tm_bed);
            medicine = (TextView)view.findViewById(R.id.tm_medicine);
            time = (TextView)view.findViewById(R.id.tm_time);
            status = (TextView)view.findViewById(R.id.tm_status);
        }
    }

    public TakeMedicineAdapter(Context mcontext,List<Take_Medicine_Form> list){
        this.formList = list;
        this.context = mcontext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_take_medicine,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.formView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Take_Medicine_Form form = formList.get(position);
                Intent intent = new Intent(context, Detail_Take_MedicineActivity.class);
                intent.putExtra("take_medicine_form",form);
                context.startActivity(intent);
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Take_Medicine_Form form = formList.get(position);
            holder.name.setText(form.getName());
            holder.bed_num.setText(form.getBed_num() +"床");
            holder.medicine.setText(form.getElixir());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = simpleDateFormat.format(form.getTime());
            holder.time.setText(date);
            holder.status.setText(form.getState());

    }

    @Override
    public int getItemCount() {
        return formList.size();
    }
}
