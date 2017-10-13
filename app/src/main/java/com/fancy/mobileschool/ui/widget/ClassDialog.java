package com.fancy.mobileschool.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fancy.mobileschool.R;

/**
 * Created by Jackie on 2017/10/12.
 *
 */

public class ClassDialog extends Dialog {

    private Context context;

    private String message;


    public ClassDialog(Context context, String message){
        super(context);
        this.context = context;
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View classDetail = LayoutInflater.from(context).inflate(R.layout.class_detail, null);
        setContentView(classDetail);
        TextView tv = (TextView) classDetail.findViewById(R.id.class_detail_dialog);
        tv.setText(message);
    }
}
