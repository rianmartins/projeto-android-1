package com.rianmartins.android1_project;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setIcon(R.mipmap.gas_tank);
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        SharedPreferences settings = getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        String login = settings.getString("TOKEN", "");
        if(!login.equals("")){
            Intent loginIntent = new Intent(this, Home.class);
            startActivity(loginIntent);
        }
    }

    public void login(View v){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("TOKEN", "sapADAdsaDSADadasaDAS12D1D");
        editor.commit();

        Intent loginIntent = new Intent(this, Home.class);
        startActivity(loginIntent);
    }

    public void registration(View v){
        Intent registrationIntent = new Intent(this, Registration.class);
        startActivity(registrationIntent);
    }
}
