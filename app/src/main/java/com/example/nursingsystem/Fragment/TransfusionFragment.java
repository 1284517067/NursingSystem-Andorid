package com.example.nursingsystem.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nursingsystem.Model.Tranfusion_Form;
import com.example.nursingsystem.R;
import com.example.nursingsystem.Service.Adapter.TransfusionAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransfusionFragment extends Fragment {

    private List<Tranfusion_Form> list;

    public TransfusionFragment (List<Tranfusion_Form> tranfusion_formList){
        this.list = tranfusion_formList;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_transfusion,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fg_transfusion);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        /*list = initTransfusion();
        String type = getActivity().getIntent().getStringExtra("listtype");
        if(type != null) {
            if(type.equals("all"))
            {
                list = initTransfusion();
            }else {
                int inpatient = Integer.parseInt(type);
                list = searchOfInpatient(inpatient);
            }
        }*/
        TransfusionAdapter adapter = new TransfusionAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);
        return view;
    }


}
