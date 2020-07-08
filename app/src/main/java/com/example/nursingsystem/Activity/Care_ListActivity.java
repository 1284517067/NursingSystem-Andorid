package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.nursingsystem.Fragment.NavbarFlagment;
import com.example.nursingsystem.Fragment.ToolbarFragment;
import com.example.nursingsystem.Model.Care_Form;
import com.example.nursingsystem.Presenter.CareFormPresenter;
import com.example.nursingsystem.R;
import com.example.nursingsystem.Service.Adapter.CareFormAdapter;

import java.util.List;


public class Care_ListActivity extends AppCompatActivity {

    private ToolbarFragment toolbarFragment;
    private NavbarFlagment navbarFlagment;
    private RecyclerView care_List_View;
    private List<Care_Form> list;
    private Context context;
    private CareFormPresenter careFormPresenter = new CareFormPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care__list);
        context = Care_ListActivity.this;
        bindView();
        toolbarFragment.setTitle("护理任务列表");
        long inpatient = getIntent().getLongExtra("inpatient",0);
        Log.d("care", "inpatient = "+inpatient);
        list = careFormPresenter.initCareForm(inpatient);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        care_List_View.setLayoutManager(linearLayoutManager);
        CareFormAdapter adapter = new CareFormAdapter(list,context);
        care_List_View.setAdapter(adapter);
    }

    private void bindView(){
        toolbarFragment = (ToolbarFragment)getSupportFragmentManager().findFragmentById(R.id.care_list_toolbar);
        care_List_View = (RecyclerView)findViewById(R.id.care_form_list);
        navbarFlagment = (NavbarFlagment)getSupportFragmentManager().findFragmentById(R.id.care_from_list_navbar);
    }
}
