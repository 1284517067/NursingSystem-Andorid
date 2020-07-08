package com.example.nursingsystem.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nursingsystem.Model.Take_Medicine_Form;
import com.example.nursingsystem.R;
import com.example.nursingsystem.Service.Adapter.TakeMedicineAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TakeMedicineFragment extends Fragment {

    private List<Take_Medicine_Form> list;

    public TakeMedicineFragment(List<Take_Medicine_Form> list1){
        this.list = list1;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_takemedicine,container,false);
        /*list = initTakeMedicineForm();
        String type = getActivity().getIntent().getStringExtra("listtype");
        if(type != null){
            if(type.equals("all"))
            {
                list = initTakeMedicineForm();
            }else {
                int inpatient = Integer.parseInt(type);
                list = searchOfInpatient(inpatient);
            }
        }*/
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.fg_takemdeicine);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        TakeMedicineAdapter adapter = new TakeMedicineAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);
        return view;
    }


}
