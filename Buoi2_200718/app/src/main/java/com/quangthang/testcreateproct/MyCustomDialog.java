package com.quangthang.testcreateproct;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class MyCustomDialog extends Dialog {

    Context context;
    ImageView imgOK, imgCancel;
    public MyCustomDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        linkViews();
        setCanceledOnTouchOutside(false);
        addEvent();
    }


    private void linkViews() {
        imgOK = findViewById(R.id.imgOK);
        imgCancel = findViewById(R.id.imgCancel);
    }

    private void addEvent() {
        imgOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.finish();
            }
        });
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
