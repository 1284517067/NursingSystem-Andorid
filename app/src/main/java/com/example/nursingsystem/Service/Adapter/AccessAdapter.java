package com.example.nursingsystem.Service.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nursingsystem.Activity.Detail_AccessActivity;
import com.example.nursingsystem.Model.Access_Form;
import com.example.nursingsystem.Presenter.AccessPresenter;
import com.example.nursingsystem.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class AccessAdapter extends RecyclerView.Adapter<AccessAdapter.ViewHolder>{
    private List<Access_Form> list;
    private Context context;
    private AccessPresenter presenter;
    public AccessAdapter(List<Access_Form> list1,Context context1){
        this.context = context1;
        this.list = list1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_access_form,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Access_Form access_form = list.get(position);
                access_form.setStatus("已确认回室");
                presenter = new AccessPresenter();
                if (presenter.updateAccessForm(access_form)){
                    holder.accessView.setVisibility(View.INVISIBLE);
                    Toast.makeText(context,"操作成功",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context,"操作失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
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
        View accessView;
        TextView name;
        TextView inpatient;
        TextView back;
        TextView out;
        TextView reason;
        Button confirm;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            accessView = itemView;
            name = (TextView)itemView.findViewById(R.id.da_name);
            inpatient = (TextView)itemView.findViewById(R.id.da_inpatient);
            reason = (TextView)itemView.findViewById(R.id.da_reason);
            back = (TextView)itemView.findViewById(R.id.da_back);
            out = (TextView)itemView.findViewById(R.id.da_out);
            confirm = (Button)itemView.findViewById(R.id.da_confirm);
        }
    }
}
