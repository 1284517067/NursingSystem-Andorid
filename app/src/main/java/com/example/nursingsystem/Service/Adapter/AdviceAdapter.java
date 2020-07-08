package com.example.nursingsystem.Service.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nursingsystem.Model.Doctor_Advice;

import java.util.List;

public class AdviceAdapter extends RecyclerView.Adapter {

    private List<Doctor_Advice> doctor_adviceList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View adviceView;
        TextView name;
        TextView bednum;
        TextView content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
