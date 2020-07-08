package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nursingsystem.Fragment.ToolbarFragment;
import com.example.nursingsystem.Model.Take_Medicine_Form;
import com.example.nursingsystem.Model.Tranfusion_Form;
import com.example.nursingsystem.R;

public class Detail_Take_MedicineActivity extends AppCompatActivity {

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
        Take_Medicine_Form take_medicine_form = (Take_Medicine_Form)getIntent().getSerializableExtra("take_medicine_form");
        id.setText("服药单号：" + take_medicine_form.getId());
        time.setText("服药时间：" + take_medicine_form.getTime());
        status.setText("服药单状态：" + take_medicine_form.getState());
        elixir.setText("药剂名称：" + take_medicine_form.getElixir());
        bed.setText("床号：" + take_medicine_form.getBed_num());
        name.setText("姓名：" + take_medicine_form.getName());
        switch (take_medicine_form.getState()){
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
                switch (take_medicine_form.getState()){
                    case "待收取":
                        take_medicine_form.setState("已收取");
                        break;
                    case "已收取":
                        take_medicine_form.setState("已执行");
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
