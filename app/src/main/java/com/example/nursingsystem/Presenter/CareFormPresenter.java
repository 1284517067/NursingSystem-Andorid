package com.example.nursingsystem.Presenter;

import com.example.nursingsystem.Model.Care_Form;

import java.util.ArrayList;
import java.util.List;

public class CareFormPresenter {
    public List<Care_Form> initCareForm(long inpatient){
        List<Care_Form> list = new ArrayList<>();
        /**
         * 数据库查询获取数据
         */

        /**
         * 测试用假数据
         */
        Care_Form care_form = new Care_Form();
        care_form.setName("阿似乎");
        care_form.setCare_list(1321315);
        care_form.setCaretype("基础护理");
        care_form.setContent("清创");
        care_form.setInpatient(11122);
        for (int i = 0 ; i < 20 ; i++) {
            list.add(care_form);
        }
        return list;
    }
}
