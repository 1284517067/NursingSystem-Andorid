package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.dtr.zxing.activity.CaptureActivity;
import com.example.nursingsystem.Model.Nurse;
import com.example.nursingsystem.Presenter.Singleton;
import com.example.nursingsystem.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String ACTION_DATE_CHANGED = Intent.ACTION_DATE_CHANGED;
    private TextView day;
    private TextView day_of_week;
    private TextView month_year;
    private ImageView set;
    private ImageView refresh;
    private TextView name;
    private TextView job_num;
    private RadioButton check_advice;
    private RadioButton examine_advice;
    private RadioButton care;
    private RadioButton dispense_medicines;
    private RadioButton tour;
    private RadioButton access;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        Nurse nurse = new Nurse();
        nurse = (Nurse) Singleton.getInstance().get("nurse");
        day.setText(Calendar.DAY_OF_MONTH+"");
        month_year.setText(Calendar.MONTH+"/"+Calendar.YEAR);
        name.setText("姓名："+nurse.getName());
        job_num.setText("工号："+nurse.getJob_num());
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResume();
            }
        });
        examine_advice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 跳转至扫码界面
                 */
                goScan();
            }
        });
        check_advice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 跳转至扫码界面
                 */
                goScan();
            }
        });
        dispense_medicines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Dispense_MedicinesActivity.class);
                startActivity(intent);
            }
        });
        tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goScan();
            }
        });
        care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goScan();
            }
        });
        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Access_LIstActivity.class);
                startActivity(intent);
            }
        });

    }

    /*protected void onResume(){
        super.onResume();
        onCreate(null);
    }*/

    private void goScan(){
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},1);
        } else {
            Intent intent = new Intent(MainActivity.this,CaptureActivity.class);
            startActivity(intent);
        }
    }


    private void toRefresh()
    {
        onCreate(null);
    }

    private void bindViews(){
        day = (TextView) findViewById(R.id.day);
        day_of_week = (TextView) findViewById(R.id.day_of_week);
        month_year = (TextView) findViewById(R.id.month_year);
        set = (ImageView) findViewById(R.id.set);
        refresh = (ImageView) findViewById(R.id.refresh);
        name = (TextView)findViewById(R.id.name);
        job_num = (TextView)findViewById(R.id.job_num);
        check_advice = (RadioButton)findViewById(R.id.check_advice);
        examine_advice = (RadioButton)findViewById(R.id.examine_advice);
        care = (RadioButton)findViewById(R.id.care);
        dispense_medicines = (RadioButton)findViewById(R.id.dispense_medicines);
        tour = (RadioButton)findViewById(R.id.tour);
        access = (RadioButton)findViewById(R.id.access);
    }

    class Date_Changed_Receiver extends BroadcastReceiver{
        public void onReceive(Context context, Intent intent) {
            int year;
            int month;
            int day;
            String day_of_week;
            if (intent.getAction().equals(Intent.ACTION_DATE_CHANGED))
            {
                year = Calendar.YEAR;
                month = Calendar.MONTH;
                day = Calendar.DAY_OF_MONTH;
                getDay_Of_Week();

            }
        }
    }
    public String getDay_Of_Week()
    {
        String day_of_week;
        switch (Calendar.DAY_OF_WEEK)
        {
            case 1:
                day_of_week = "星期日";
                break;
            case 2:
                day_of_week = "星期一";
                break;
            case 3:
                day_of_week = "星期二";
                break;
            case 4:
                day_of_week = "星期三";
                break;
            case 5:
                day_of_week = "星期四";
                break;
            case 6:
                day_of_week = "星期五";
                break;
            case 7:
                day_of_week = "星期六";
                break;
            default:
                return "";

        }
        return day_of_week;
    }
}
