package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nursingsystem.Fragment.ToolbarFragment;
import com.example.nursingsystem.Model.Nurse;
import com.example.nursingsystem.Model.Tour_Record;
import com.example.nursingsystem.Presenter.Singleton;
import com.example.nursingsystem.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TourActivity extends AppCompatActivity {

    private TextView inpatient;
    private EditText inspection_situation;
    private ToolbarFragment toolbarFragment;
    private Button submit;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        bindView();
        toolbarFragment.setTitle("巡视情况");
        context = TourActivity.this;
        long _inpatient = getIntent().getLongExtra("inpatient",0);
        Nurse nurse = new Nurse();
        nurse = (Nurse) Singleton.getInstance().get("nurse");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前时间
        Date date = new Date();
        String datetime = simpleDateFormat.format(date);
        inpatient.setText("住院号" + _inpatient);
        String i_s = inspection_situation.getText().toString();
        Tour_Record tour_record = new Tour_Record();
        tour_record.setInpatient(_inpatient);
        tour_record.setInspection_situation(i_s);
        tour_record.setJob_num(nurse.getJob_num());
        tour_record.setTime(datetime);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 提交巡床记录并返回
                 */
                Toast.makeText(context,"操作成功",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void bindView(){
        inpatient = (TextView)findViewById(R.id.tour_inpatient);
        inspection_situation = (EditText)findViewById(R.id.tour_inspection_situation);
        submit = (Button)findViewById(R.id.tour_submit);
        toolbarFragment = (ToolbarFragment)getSupportFragmentManager().findFragmentById(R.id.tour_toolbar);
    }
}
