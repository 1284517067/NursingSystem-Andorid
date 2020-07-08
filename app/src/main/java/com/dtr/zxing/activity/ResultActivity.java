package com.dtr.zxing.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.dtr.zxing.decode.DecodeThread;
import com.example.nursingsystem.Activity.Care_ListActivity;
import com.example.nursingsystem.Activity.Check_AdviceActivity;
import com.example.nursingsystem.Activity.Examine_AdviceActivity;
import com.example.nursingsystem.Activity.Execute_AdviceActivity;
import com.example.nursingsystem.Activity.MainActivity;
import com.example.nursingsystem.Activity.TourActivity;
import com.example.nursingsystem.Fragment.NavbarFlagment;
import com.example.nursingsystem.Model.Patient;
import com.example.nursingsystem.R;

public class ResultActivity extends AppCompatActivity {

	private Button back;
	private TextView name;
	private TextView sex;
	private TextView age;
	private TextView department;
	private TextView bed_num;
	private Button examine;
	private Button check;
	private Button tour;
	private Button care;
	private FrameLayout navbar;
	private long inpatient;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		bindView();
		Bundle extras = getIntent().getExtras();
		Patient patient = new Patient();
		if (null != extras) {
			String result = extras.getString("result");
			Log.d("Scan", "result = " + result);
			/**
			 * 数据库获取病人信息
			 */
			inpatient = Long.parseLong(result);
			patient.setAddress("阿斯U盾哦窘迫就");
			patient.setAdmission_date("2020-1-31 12:00:00");
			patient.setAge(15);
			patient.setBed_num(2033);
			patient.setDepartment("呼吸科");
			patient.setHometown("uishdaoooo");
			patient.setId("6846463531321321");
			patient.setInpatient(2545555);
			patient.setName("四UK");
			patient.setNation("汉");
			patient.setSex("男");
			patient.setStatus("晕厥");
		}
		name.setText("姓名："+ patient.getName());
		sex.setText("性别："+ patient.getSex());
		age.setText("年龄："+ patient.getAge());
		department.setText("科室："+ patient.getDepartment());
		bed_num.setText("床号："+ patient.getBed_num());
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ResultActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		examine.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ResultActivity.this, Execute_AdviceActivity.class);
				/**
				 * 传递病人信息
				 */
				intent.putExtra("inpatient",inpatient);
				startActivity(intent);
			}
		});
		check.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ResultActivity.this, Check_AdviceActivity.class);
				/**
				 * 传递病人信息
				 */
				intent.putExtra("inpatient",inpatient);
				startActivity(intent);
			}
		});
		care.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ResultActivity.this, Care_ListActivity.class);
				intent.putExtra("inpatient",inpatient);
				startActivity(intent);
			}
		});

		tour.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ResultActivity.this, TourActivity.class);
				intent.putExtra("inpatient",inpatient);
				startActivity(intent);
			}
		});
	}

	/**
	 * 绑定控件
	 */
	private void bindView()
	{
		back = (Button)findViewById(R.id.result_back);
		name = (TextView)findViewById(R.id.patient_message_name);
		sex = (TextView)findViewById(R.id.patient_message_sex);
		age = (TextView)findViewById(R.id.patient_message_age);
		department = (TextView)findViewById(R.id.patient_message_department);
		bed_num = (TextView)findViewById(R.id.patient_message_bed_num);
		examine = (Button) findViewById(R.id.patient_message_examine);
		check = (Button)findViewById(R.id.patient_message_check);
		care = (Button)findViewById(R.id.m_care);
		tour = (Button)findViewById(R.id.m_tour);
	}

}
