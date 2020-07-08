package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
import com.example.nursingsystem.Model.Care_Form;
import com.example.nursingsystem.Model.Nurse;
import com.example.nursingsystem.Model.Nursing_Sheet;
import com.example.nursingsystem.Presenter.JumpTextWatcher;
import com.example.nursingsystem.Presenter.Nursing_SheetPresenter;
import com.example.nursingsystem.Presenter.Singleton;
import com.example.nursingsystem.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Detail_Care_FormActivity extends AppCompatActivity {

    private ToolbarFragment toolbarFragment;
    private NavbarFlagment navbarFlagment;
    private TextView dcf_id;
    private TextView dcf_name;
    private EditText dcf_oxygen;
    private EditText dcf_input;
    private EditText dcf_output;
    private EditText dcf_skin;
    private EditText dcf_tube_care;
    private EditText dcf_observation;
    private Button dcf_submit;
    private Context context;
    private Nursing_SheetPresenter nursing_sheetPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__care__form);
        bindView();
        toolbarFragment.setTitle("护理详情");
        context = Detail_Care_FormActivity.this;
        final Care_Form care_form = (Care_Form)getIntent().getSerializableExtra("care_form");
        nursing_sheetPresenter = new Nursing_SheetPresenter();
        dcf_id.setText("护理单号："+care_form.getCare_list());
        dcf_name.setText("姓名："+care_form.getName());
        dcf_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (createNursingSheet(care_form)){
                    Toast.makeText(context,"提交成功",Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(context,"提交失败，请重试",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void bindView(){
        toolbarFragment = (ToolbarFragment) getSupportFragmentManager().findFragmentById(R.id.dcf_toolbar);
        navbarFlagment = (NavbarFlagment) getSupportFragmentManager().findFragmentById(R.id.dcf_navbar);
        dcf_id = (TextView)findViewById(R.id.dcf_id);
        dcf_name = (TextView)findViewById(R.id.dcf_name);
        dcf_oxygen = (EditText)findViewById(R.id.dcf_oxygen);
        dcf_input = (EditText)findViewById(R.id.dcf_intput);
        dcf_output = (EditText)findViewById(R.id.dcf_output);
        dcf_skin = (EditText)findViewById(R.id.dcf_skin);
        dcf_tube_care = (EditText)findViewById(R.id.dcf_tube_care);
        dcf_observation = (EditText)findViewById(R.id.dcf_observation);
        dcf_submit = (Button)findViewById(R.id.dcf_submit);
        dcf_oxygen.addTextChangedListener(new JumpTextWatcher(dcf_oxygen,dcf_output));
        dcf_output.addTextChangedListener(new JumpTextWatcher(dcf_output,dcf_input));
        dcf_input.addTextChangedListener(new JumpTextWatcher(dcf_input,dcf_skin));
        dcf_skin.addTextChangedListener(new JumpTextWatcher(dcf_skin,dcf_tube_care));
        dcf_tube_care.addTextChangedListener(new JumpTextWatcher(dcf_tube_care,dcf_observation));
        dcf_observation.addTextChangedListener(new JumpTextWatcher(dcf_observation,null));
    }

    private boolean createNursingSheet(Care_Form care_form){
        boolean flag = false;
        try {
            if(TextUtils.isEmpty(dcf_oxygen.getText())){
                Log.d("createNS", "oxygen is empty");
                Toast.makeText(context,"请输入吸氧量",Toast.LENGTH_SHORT).show();
            } else {
                if (TextUtils.isEmpty(dcf_input.getText())){
                    Log.d("createNS", "input is empty");
                    Toast.makeText(context,"请输入入量",Toast.LENGTH_SHORT).show();
                } else {
                    if (TextUtils.isEmpty(dcf_output.getText())){
                        Log.d("createNS", "output is empty");
                        Toast.makeText(context,"请输入出量",Toast.LENGTH_SHORT).show();
                    } else {
                        if (TextUtils.isEmpty(dcf_skin.getText())){
                            Log.d("createNS", "skin is empty");
                            Toast.makeText(context,"请输入皮肤情况",Toast.LENGTH_SHORT).show();
                        } else {
                            if (TextUtils.isEmpty(dcf_tube_care.getText())){
                                Log.d("createNS", "tube care is empty");
                                Toast.makeText(context,"请输入管路护理",Toast.LENGTH_SHORT).show();
                            } else {
                                if (TextUtils.isEmpty(dcf_observation.getText())){
                                    Log.d("createNS", "observation is empty");
                                    Toast.makeText(context,"请输入病情观察及措施",Toast.LENGTH_SHORT).show();
                                }else {
                                    Nurse nurse = (Nurse)Singleton.getInstance().get("nurse");
                                    Nursing_Sheet nursing_sheet = new Nursing_Sheet();
                                    nursing_sheet.setId(care_form.getCare_list());
                                    nursing_sheet.setInpatient(care_form.getInpatient());
                                    nursing_sheet.setDate(new Date());
                                    nursing_sheet.setOxygen(Double.parseDouble(dcf_oxygen.getText().toString()));
                                    nursing_sheet.setInput(Double.parseDouble(dcf_input.getText().toString()));
                                    nursing_sheet.setOutput(Double.parseDouble(dcf_output.getText().toString()));
                                    nursing_sheet.setSkin(dcf_skin.getText().toString());
                                    nursing_sheet.setTube_care(dcf_tube_care.getText().toString());
                                    nursing_sheet.setObservation(dcf_observation.getText().toString());
                                    nursing_sheet.setJob_num(nurse.getJob_num());
                                    flag = nursing_sheetPresenter.send(nursing_sheet);
                                }
                            }
                        }
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
