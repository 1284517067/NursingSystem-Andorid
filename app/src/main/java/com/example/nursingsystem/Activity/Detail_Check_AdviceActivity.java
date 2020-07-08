package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nursingsystem.Fragment.NavbarFlagment;
import com.example.nursingsystem.Fragment.ToolbarFragment;
import com.example.nursingsystem.Model.Doctor_Advice;
import com.example.nursingsystem.Presenter.Doctor_AdvicePresenter;
import com.example.nursingsystem.R;

import java.text.SimpleDateFormat;

public class Detail_Check_AdviceActivity extends AppCompatActivity {

    private ToolbarFragment toolbarFragment;
    private NavbarFlagment navbarFlagment;
    private TextView name;
    private TextView content;
    private TextView inpatient;
    private TextView time;
    private TextView type;
    private Button confirm;
    private Context context;
    private Doctor_AdvicePresenter presenter = new Doctor_AdvicePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__check__advice);
        context = Detail_Check_AdviceActivity.this;
        bindView();
        toolbarFragment.setTitle("医嘱核查");
        Doctor_Advice advice = (Doctor_Advice) getIntent().getSerializableExtra("doctor_advice");
        name.setText("姓名："+advice.getName());
        content.setText("医嘱内容："+advice.getDoc_order_content());
        inpatient.setText("住院号："+advice.getInpatient());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(advice.getEntry_time());
        time.setText("立嘱时间："+date);
        type.setText("医嘱类型："+advice.getOrder_type());
        if (advice.getStatus().equals("已核查")){
            confirm.setEnabled(false);
            confirm.setText("已核查");
            confirm.setBackgroundColor(0xFF666A6A);
        }
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advice.setStatus("已核查");
                Toast.makeText(context,"操作成功",Toast.LENGTH_SHORT).show();
                presenter.sendAdvice(advice);
                finish();
            }
        });
    }

    private void bindView(){
        toolbarFragment = (ToolbarFragment)getSupportFragmentManager().findFragmentById(R.id.dca_toolbar);
        navbarFlagment = (NavbarFlagment)getSupportFragmentManager().findFragmentById(R.id.dca_navbar);
        name = (TextView)findViewById(R.id.dca_name);
        confirm = (Button)findViewById(R.id.dca_confirm);
        content = (TextView)findViewById(R.id.dca_content);
        inpatient = (TextView)findViewById(R.id.dca_inpatient);
        time = (TextView)findViewById(R.id.dca_time);
        type = (TextView)findViewById(R.id.dca_type);
    }
}
