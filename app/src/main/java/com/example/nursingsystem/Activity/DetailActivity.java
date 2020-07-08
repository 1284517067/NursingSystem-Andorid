package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nursingsystem.Model.SickBed;
import com.example.nursingsystem.R;

public class DetailActivity extends AppCompatActivity {

    private Button back;
    private TextView name;
    private TextView age;
    private TextView sex;
    private TextView departmemnt;
    private TextView bed_num;
    private TextView inpatient;
    private Button advice;
    private Button advice_record;
    private Button cost;
    private Button sign;
    private Button access;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        bindView();
        SickBed sickBed = new SickBed();
        sickBed = (SickBed) getIntent().getSerializableExtra("sickbed");
        int _inpatient = sickBed.getInpatient();
        String _name = sickBed.getName();
        name.setText("姓名："+sickBed.getName());
        age.setText("年龄："+sickBed.getAge() + "");
        sex.setText("性别："+sickBed.getSex());
        departmemnt.setText("科室："+sickBed.getDepartment());
        bed_num.setText("床号："+sickBed.getBed_num() + "");
        inpatient.setText("住院号："+sickBed.getInpatient() + "");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        advice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,Check_AdviceActivity.class);
                intent.putExtra("inpatient",_inpatient);
                startActivity(intent);
            }
        });
        advice_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,Execute_AdviceActivity.class);
                intent.putExtra("inpatient",_inpatient);
                intent.putExtra("type","record");
                startActivity(intent);
            }
        });
        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,Collect_SignsActivity.class);
                intent.putExtra("inpatient", _inpatient);
                startActivity(intent);
            }
        });
        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,AccessActivity.class);
                intent.putExtra("inpatient",_inpatient);
                intent.putExtra("name",_name);
                startActivity(intent);
            }
        });
    }

    public void bindView(){
        back = (Button)findViewById(R.id.detail_back);
        name = (TextView)findViewById(R.id.detail_name);
        age = (TextView)findViewById(R.id.detail_age);
        sex = (TextView)findViewById(R.id.detail_sex);
        departmemnt = (TextView)findViewById(R.id.detail_department);
        bed_num = (TextView)findViewById(R.id.detail_bednum);
        inpatient = (TextView)findViewById(R.id.detail_inpatient);
        advice = (Button)findViewById(R.id.detail_advice);
        advice_record = (Button)findViewById(R.id.detail_advice_record);
        cost = (Button)findViewById(R.id.detail_cost);
        sign = (Button)findViewById(R.id.detail_sign);
        access = (Button)findViewById(R.id.detail_access);
    }
}
