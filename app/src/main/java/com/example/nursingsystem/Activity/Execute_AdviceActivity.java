package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.nursingsystem.Fragment.TakeMedicineFragment;
import com.example.nursingsystem.Fragment.TransfusionFragment;
import com.example.nursingsystem.Model.Doctor_Advice;
import com.example.nursingsystem.Model.Take_Medicine_Form;
import com.example.nursingsystem.Model.Tranfusion_Form;
import com.example.nursingsystem.Presenter.TakeMedicinePresenter;
import com.example.nursingsystem.Presenter.TransfusionPresenter;
import com.example.nursingsystem.R;

import java.util.ArrayList;
import java.util.List;

public class Execute_AdviceActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private Button back;
    private RadioButton tm;
    private RadioButton ifu;
    private FrameLayout dm_list;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioGroup tab_bar;
    private TakeMedicineFragment tmf;
    private TransfusionFragment tf;
    private TextView title;
    private TransfusionPresenter transfusionPresenter = new TransfusionPresenter();
    private TakeMedicinePresenter takeMedicinePresenter = new TakeMedicinePresenter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispense__medicines);
        bindView();
        fragmentManager = getSupportFragmentManager();
        title.setText("医嘱列表");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tab_bar.setOnCheckedChangeListener(this);
        tm.setChecked(true);

    }

    private void bindView(){
        back = (Button) findViewById(R.id.dm_back);
        tm = (RadioButton)findViewById(R.id.dm_tm);
        ifu = (RadioButton)findViewById(R.id.dm_if);
        dm_list = (FrameLayout)findViewById(R.id.dm_list);
        tab_bar = (RadioGroup)findViewById(R.id.dm_tab_bar);
        title = (TextView)findViewById(R.id.dm_title);
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if(tf != null){
            fragmentTransaction.hide(tf);
        }
        if (tmf != null){
            fragmentTransaction.hide(tmf);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        long inpatient = getIntent().getLongExtra("inpatient",0);
        switch (checkedId){
            case R.id.dm_tm:
                if(tmf == null){
                    List<Take_Medicine_Form> list = new ArrayList<>();
                    list = takeMedicinePresenter.searchOfInpatient(inpatient);
                    tmf = new TakeMedicineFragment(list);
                    fragmentTransaction.add(R.id.dm_list,tmf);
                }else {
                    fragmentTransaction.show(tmf);
                }
                break;
            case R.id.dm_if:
                if (tf == null){
                    List<Tranfusion_Form>list = new ArrayList<>();
                    list = transfusionPresenter.searchOfInpatient(inpatient);
                    tf = new TransfusionFragment(list);
                    fragmentTransaction.add(R.id.dm_list,tf);
                }else {
                    fragmentTransaction.show(tf);
                }
                break;
            default:
                return;
        }
        fragmentTransaction.commit();
    }
}
