package com.example.nursingsystem.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.nursingsystem.R;

public class ToolbarFragment extends Fragment {

    private Button back;
    private Context context;
    private TextView title;

    public ToolbarFragment(){

    }

    public void onAttach(Context context){
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fg_toolbar,container,false);
        back = (Button) view.findViewById(R.id.toolbar_back);
        title = (TextView) view.findViewById(R.id.toolbar_title);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return view;
    }

    public void setTitle(String title1) {
        title.setText(title1);

    }
}
