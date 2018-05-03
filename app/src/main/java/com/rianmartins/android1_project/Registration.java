package com.rianmartins.android1_project;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Registration extends FragmentActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getActionBar().setIcon(R.mipmap.gas_tank);
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        TextView data_nascimento_field = findViewById(R.id.data_nascimento_field);

        data_nascimento_field.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEvent.ACTION_UP == event.getAction()) {
                    DialogFragment newFragment = new DatePickerFragment();
                    newFragment.show(getFragmentManager(),"Date Picker");
                }

                return true; // return is important...
            }
        });
    }

    public void register(View v){
        finish();
    }
}
