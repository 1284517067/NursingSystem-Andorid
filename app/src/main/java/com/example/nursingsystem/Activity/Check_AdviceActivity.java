package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.nursingsystem.Fragment.NavbarFlagment;
import com.example.nursingsystem.Fragment.ToolbarFragment;
import com.example.nursingsystem.Model.Doctor_Advice;
import com.example.nursingsystem.Presenter.Doctor_AdvicePresenter;
import com.example.nursingsystem.R;
import com.example.nursingsystem.Service.Adapter.Doctor_AdviceAdapter;

import java.util.List;

public class Check_AdviceActivity extends AppCompatActivity {

    private ToolbarFragment toolbarFragment;
    private NavbarFlagment navbarFlagment;
    private RecyclerView advice_view;
    private List<Doctor_Advice> list;
    private Context context;
    private Doctor_AdvicePresenter doctor_advicePresenter = new Doctor_AdvicePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check__advice);
        context = Check_AdviceActivity.this;
        bindView();
        toolbarFragment.setTitle("医嘱列表");
        long inpatient = getIntent().getLongExtra("inpatient",0);
        String type = getIntent().getStringExtra("type");
        if (type == null||type == ""){
            list = doctor_advicePresenter.initDoctorAdvice(inpatient);
        }else{
            list = doctor_advicePresenter.initDoctorAdviceRecord(inpatient);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        advice_view.setLayoutManager(linearLayoutManager);
        Doctor_AdviceAdapter adviceAdapter = new Doctor_AdviceAdapter(list,context);
        advice_view.setAdapter(adviceAdapter);
    }

    private void bindView(){
        toolbarFragment = (ToolbarFragment)getSupportFragmentManager().findFragmentById(R.id.check_advice_toolbar);
        navbarFlagment = (NavbarFlagment)getSupportFragmentManager().findFragmentById(R.id.check_advice_navbar);
        advice_view = (RecyclerView)findViewById(R.id.check_advice_list);
    }
}
