package com.example.nursingsystem.Service.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nursingsystem.Activity.Detail_Transfusion_FormActivity;
import com.example.nursingsystem.Model.Tranfusion_Form;
import com.example.nursingsystem.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class TransfusionAdapter extends RecyclerView.Adapter<TransfusionAdapter.Viewholder> {
    private List<Tranfusion_Form> tranfusion_formList;
    private Context context;

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_take_medicine,parent,false);
        final Viewholder holder = new Viewholder(view);
        holder.formView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Tranfusion_Form tranfusion_form = tranfusion_formList.get(position);
                Intent intent = new Intent(context, Detail_Transfusion_FormActivity.class);
                intent.putExtra("transfusion_form",tranfusion_form);
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Tranfusion_Form form = tranfusion_formList.get(position);
        holder.name.setText(form.getName());
        holder.bednum.setText(form.getBed_num() + "床");
        holder.drug.setText(form.getDrug_name());
        holder.status.setText(form.getState());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(form.getTime());
        holder.time.setText(date);
    }

    @Override
    public int getItemCount() {
        return tranfusion_formList.size();
    }

    static class Viewholder extends RecyclerView.ViewHolder{
        View formView;
        TextView name;
        TextView bednum;
        TextView drug;
        TextView time;
        TextView status;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            formView = itemView;
            name = (TextView)itemView.findViewById(R.id.tm_name);
            bednum = (TextView)itemView.findViewById(R.id.tm_bed);
            drug = (TextView)itemView.findViewById(R.id.tm_medicine);
            time = (TextView)itemView.findViewById(R.id.tm_time);
            status = (TextView)itemView.findViewById(R.id.tm_status);
        }
    }
    public TransfusionAdapter(Context mcontext,List<Tranfusion_Form> mlist){
        this.tranfusion_formList = mlist;
        this.context = mcontext;
    }

}
