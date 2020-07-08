package com.example.nursingsystem.Service.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nursingsystem.Activity.Access_RecordActivity;
import com.example.nursingsystem.Model.Access_Form;
import com.example.nursingsystem.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class Access_RecordAdapter extends RecyclerView.Adapter<Access_RecordAdapter.ViewHolder> {
    private List<Access_Form> list;
    private Context context;

    public Access_RecordAdapter (List<Access_Form> list1,Context context1){
        this.list = list1;
        this.context = context1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_access_record,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Access_Form access_form = list.get(position);
        holder.name.setText(access_form.getName());
        holder.inpatient.setText(access_form.getInpatient()+"");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        holder.out.setText(format.format(access_form.getOut()));
        holder.back.setText(format.format(access_form.getBack()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View recordView;
        TextView name;
        TextView reason;
        TextView inpatient;
        TextView back;
        TextView out;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recordView = itemView;
            name = (TextView)itemView.findViewById(R.id.ar_name);
            reason = (TextView)itemView.findViewById(R.id.ar_reason);
            inpatient = (TextView)itemView.findViewById(R.id.ar_inpatient);
            back = (TextView)itemView.findViewById(R.id.ar_back);
            out = (TextView)itemView.findViewById(R.id.ar_out);
        }
    }
}
