package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nursingsystem.Fragment.NavbarFlagment;
import com.example.nursingsystem.Fragment.ToolbarFragment;
import com.example.nursingsystem.Model.Access_Form;
import com.example.nursingsystem.Model.Nurse;
import com.example.nursingsystem.Presenter.AccessPresenter;
import com.example.nursingsystem.Presenter.Singleton;
import com.example.nursingsystem.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccessActivity extends AppCompatActivity {

    private ToolbarFragment toolbarFragment;
    private NavbarFlagment navbarFlagment;
    private TextView inpatient;
    private TextView name;
    private EditText out;
    private EditText back;
    private EditText reason;
    private Button submit;
    private Context context;
    private AccessPresenter presenter = new AccessPresenter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);
        context = AccessActivity.this;
        bindView();
        toolbarFragment.setTitle("出入登记");
        int _inpatient = getIntent().getIntExtra("inpatient",0);
        String _name = getIntent().getStringExtra("name");
        name.setText("姓名："+_name);
        inpatient.setText("住院号："+_inpatient);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccessForm();
            }
        });
    }

    private void bindView(){
        toolbarFragment = (ToolbarFragment)getSupportFragmentManager().findFragmentById(R.id.access_toolbar);
        navbarFlagment = (NavbarFlagment)getSupportFragmentManager().findFragmentById(R.id.access_navbar);
        inpatient = (TextView)findViewById(R.id.access_inpatient);
        out = (EditText)findViewById(R.id.access_out);
        back = (EditText)findViewById(R.id.access_back);
        reason = (EditText)findViewById(R.id.access_reason);
        submit = (Button)findViewById(R.id.access_submit);
        name = (TextView)findViewById(R.id.access_name);
    }

    private void createAccessForm(){

        if (TextUtils.isEmpty(out.getText())){
            Log.d("access", "out is empty");
            Toast.makeText(context,"请输入外出时间",Toast.LENGTH_SHORT).show();
        }else{
            if (TextUtils.isEmpty(back.getText())){
                Log.d("access", "back is empty");
                Toast.makeText(context,"请输入回室时间",Toast.LENGTH_SHORT).show();
            }else {
                if (TextUtils.isEmpty(reason.getText())){
                    Log.d("access", "reason is empty");
                    Toast.makeText(context,"请输入外出原因",Toast.LENGTH_SHORT).show();
                }else {
                    Access_Form access_form = new Access_Form();
                    String out1 = out.getText().toString();
                    String back1 = back.getText().toString();
                    String reason1 = reason.getText().toString();
                    String _name = getIntent().getStringExtra("name");
                    int _inpatient = getIntent().getIntExtra("inpatient",0);
                    Nurse nurse = (Nurse)Singleton.getInstance().get("nurse");
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date date = format.parse(back1);
                        access_form.setName(_name);
                        access_form.setBack(date);
                        date = format.parse(out1);
                        access_form.setOut(date);
                        access_form.setReason(reason1);
                        access_form.setInpatient(_inpatient);
                        access_form.setJob_num(nurse.getJob_num());
                        access_form.setNurse_name(nurse.getName());
                        boolean flag = presenter.sendAccessForm(access_form);
                        if (flag){
                            Toast.makeText(context,"操作成功",Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(context,"操作失败",Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
