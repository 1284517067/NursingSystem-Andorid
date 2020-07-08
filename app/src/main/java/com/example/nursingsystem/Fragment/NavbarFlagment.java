package com.example.nursingsystem.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;

import com.example.nursingsystem.Activity.Collect_SignsActivity;
import com.example.nursingsystem.Activity.Doctor_Advice_listActivity;
import com.example.nursingsystem.Activity.MainActivity;
import com.example.nursingsystem.Activity.Sick_Bed_ListActivity;
import com.example.nursingsystem.R;

public class NavbarFlagment extends Fragment implements View.OnClickListener {

    private RadioButton doctor_advice_btn;
    private RadioButton blood_samping_btn;
    private RadioButton tour_btn;
    private RadioButton information_btn;
    private Context context;

    public NavbarFlagment(){

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.navbar,container,false);
        //UI 控件
        doctor_advice_btn = (RadioButton) view.findViewById(R.id.doctor_advice_btn);
        blood_samping_btn = (RadioButton) view.findViewById(R.id.blood_samping_btn);
        tour_btn = (RadioButton) view.findViewById(R.id.tour_btn);
        information_btn = (RadioButton) view.findViewById(R.id.information_btn);
        //约束事件
        doctor_advice_btn.setOnClickListener(this);
        blood_samping_btn.setOnClickListener(this);
        tour_btn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.doctor_advice_btn:
                intent = new Intent(context, Doctor_Advice_listActivity.class);
                startActivity(intent);
                break;
            case R.id.blood_samping_btn:
            case R.id.tour_btn:
                intent = new Intent(context, Sick_Bed_ListActivity.class);
                startActivity(intent);
                break;
            case R.id.information_btn:
                break;
            default:
                return;
        }
    }
}
