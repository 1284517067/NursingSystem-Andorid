package com.example.nursingsystem.Presenter;

import com.example.nursingsystem.Model.Nursing_Sheet;

import java.util.Date;

public class Nursing_SheetPresenter {
    public Nursing_Sheet getNuringSheet(long id){
        Nursing_Sheet nursing_sheet = new Nursing_Sheet();
        /**
         * 网络连接服务端
         */

        /**
         * 假数据
         */
        nursing_sheet.setId(13355);
        nursing_sheet.setDate(new Date());
        nursing_sheet.setInpatient(13554452);
        return nursing_sheet;
    }

    public boolean send(Nursing_Sheet nursing_sheet){
        boolean flag;
        /**
         * 网络连接服务端
         */
        flag = true;

        return flag;
    }
}
