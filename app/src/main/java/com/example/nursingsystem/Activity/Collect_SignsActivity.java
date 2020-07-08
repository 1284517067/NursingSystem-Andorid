package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nursingsystem.Model.Nurse;
import com.example.nursingsystem.Model.Patient;
import com.example.nursingsystem.Model.Vital_Sign_Record_Sheet;
import com.example.nursingsystem.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Collect_SignsActivity extends AppCompatActivity {

    private Button back;
    private Button post;
    private EditText temperature;
    private EditText pluse;
    private EditText blood_pressure;
    private EditText blood_sugar;
    private EditText height;
    private EditText weight;
    private EditText breathe;
    private EditText blood_oxygen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect__signs);
        bindView();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        String datetime = simpleDateFormat.format(date);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nurse nurse = new Nurse();
                nurse = (Nurse)getIntent().getSerializableExtra("nurse");
                Patient patient = new Patient();
                patient = (Patient)getIntent().getSerializableExtra("patient");
                String temp = temperature.getText().toString();
                String plu = pluse.getText().toString();
                String bp = blood_pressure.getText().toString();
                String bs = blood_sugar.getText().toString();
                String h = height.getText().toString();
                String w = weight.getText().toString();
                String b = breathe.getText().toString();
                String b_o = blood_oxygen.getText().toString();
                int b_ = Integer.parseInt(b);
                int b_p = Integer.parseInt(bp);
                double b_s = Double.parseDouble(bs);
                Vital_Sign_Record_Sheet vital_sign_record_sheet = new Vital_Sign_Record_Sheet();
                vital_sign_record_sheet.setBlood_pressure(b_p);
                vital_sign_record_sheet.setBlood_sugar(b_s);
                vital_sign_record_sheet.setBreathe(b_);
                vital_sign_record_sheet.setHeight(Double.parseDouble(h));
                vital_sign_record_sheet.setWeight(Double.parseDouble(w));
                vital_sign_record_sheet.setInpartient(patient.getInpatient());
                vital_sign_record_sheet.setJob_num(nurse.getJob_num());
                vital_sign_record_sheet.setTemperature(Double.parseDouble(temp));
                vital_sign_record_sheet.setPluse(Double.parseDouble(plu));
                vital_sign_record_sheet.setDatetime(datetime);
                vital_sign_record_sheet.setBlood_oxygen(Double.parseDouble(b_o));
                /**
                 * 调用http连接服务端进行数据库操作
                 */
            }
        });
    }

    public void bindView(){
        back = (Button)findViewById(R.id.cs_back);
        post = (Button)findViewById(R.id.sign_post);
        temperature = (EditText)findViewById(R.id.temperature);
        pluse = (EditText)findViewById(R.id.pluse);
        blood_pressure = (EditText)findViewById(R.id.blood_pressure);
        blood_sugar = (EditText)findViewById(R.id.blood_sugar);
        height = (EditText)findViewById(R.id.height);
        weight = (EditText)findViewById(R.id.weight);
        breathe = (EditText)findViewById(R.id.breathe);
        blood_oxygen = (EditText)findViewById(R.id.blood_oxygen);
    }
}
