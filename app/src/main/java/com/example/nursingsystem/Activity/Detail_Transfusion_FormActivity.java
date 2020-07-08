package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nursingsystem.Fragment.ToolbarFragment;
import com.example.nursingsystem.Model.Tranfusion_Form;
import com.example.nursingsystem.R;

public class Detail_Transfusion_FormActivity extends AppCompatActivity {

    private ToolbarFragment toolbarFragment;
    private TextView id;
    private TextView time;
    private TextView status;
    private TextView elixir;
    private TextView bed;
    private TextView name;
    private Button confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__take__medicine);
        bindView();
        Tranfusion_Form tranfusion_form = (Tranfusion_Form) getIntent().getSerializableExtra("transfusion_form");
        id.setText("输液单号：" + tranfusion_form.getId());
        time.setText("输液时间：" + tranfusion_form.getTime());
        status.setText("输液单状态：" + tranfusion_form.getState());
        elixir.setText("药剂名称：" + tranfusion_form.getDrug_name());
        bed.setText("床号：" + tranfusion_form.getBed_num());
        name.setText("姓名：" + tranfusion_form.getName());
        switch (tranfusion_form.getState()){
            case "待收取":
                confirm.setText("确认收取");
                confirm.setEnabled(true);
                break;
            case "已收取":
                confirm.setText("确认执行");
                confirm.setEnabled(true);
                confirm.setBackgroundColor(0xFF9B71E1);
                break;
            default:
                confirm.setEnabled(false);
                confirm.setText("不可收取");
                confirm.setBackgroundColor(0xFF666A6A);
                break;
        }
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (tranfusion_form.getState()){
                    case "待收取":
                        tranfusion_form.setState("已收取");
                        break;
                    case "已收取":
                        tranfusion_form.setState("已执行");
                        break;
                }
                /**
                 * http连接服务端进行数据库操作
                 */

                finish();

            }
        });
        toolbarFragment = (ToolbarFragment)getSupportFragmentManager().findFragmentById(R.id.dtm_toolbar);
        toolbarFragment.setTitle("详细信息");

    }

    private void bindView(){
        id = (TextView)findViewById(R.id.dtm_id);
        time = (TextView)findViewById(R.id.dtm_time);
        status = (TextView)findViewById(R.id.dtm_status);
        elixir = (TextView)findViewById(R.id.dtm_elixir);
        bed = (TextView)findViewById(R.id.dtm_bed);
        name = (TextView)findViewById(R.id.dtm_name);
        confirm = (Button)findViewById(R.id.dtm_confirm);
    }
}
