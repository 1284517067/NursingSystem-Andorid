package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.nursingsystem.Fragment.NavbarFlagment;
import com.example.nursingsystem.Fragment.ToolbarFragment;
import com.example.nursingsystem.Model.Doctor_Advice;
import com.example.nursingsystem.Presenter.Doctor_AdvicePresenter;
import com.example.nursingsystem.R;
import com.example.nursingsystem.Service.Adapter.Doctor_AdviceAdapter;

import java.util.List;

public class Doctor_Advice_listActivity extends AppCompatActivity {

    private ToolbarFragment toolbarFragment;
    private NavbarFlagment navbarFlagment;
    private RecyclerView recyclerView;
    private List<Doctor_Advice>list;
    private Context context;
    private Doctor_AdvicePresenter presenter = new Doctor_AdvicePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__advice_list);
        context = Doctor_Advice_listActivity.this;
        bindView();
        toolbarFragment.setTitle("医嘱列表");
        long inpatient = getIntent().getLongExtra("inpatient",0);
        list = presenter.initAllDoctorAdvice();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        Doctor_AdviceAdapter adapter = new Doctor_AdviceAdapter(list,context);
        recyclerView.setAdapter(adapter);
    }

    private void bindView(){
        toolbarFragment = (ToolbarFragment)getSupportFragmentManager().findFragmentById(R.id.dc_toolbar);
        navbarFlagment = (NavbarFlagment)getSupportFragmentManager().findFragmentById(R.id.dc_navbar);
        recyclerView = (RecyclerView)findViewById(R.id.dc_list);
    }
}
