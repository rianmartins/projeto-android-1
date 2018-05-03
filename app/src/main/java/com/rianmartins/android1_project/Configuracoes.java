package com.rianmartins.android1_project;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class Configuracoes extends Activity {

    String[] items;
    String[] itemsCombustiveis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        Spinner dropdown = findViewById(R.id.spinnerMaxDist);
        Spinner dropdownComb = findViewById(R.id.spinnerCombustivelPref);
        //create a list of items for the spinner.
        items = new String[]{"10km", "20km", "30km", "50km", "100km", "150km"};
        itemsCombustiveis = new String[]{"Gasolina", "Gasolina Adtv", "Álcool", "Diesel", "Diesel S10"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        ArrayAdapter<String> adapterCombustivel = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsCombustiveis);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdownComb.setAdapter(adapterCombustivel);

        Spinner maxDistSpinner = findViewById(R.id.spinnerMaxDist);
        Spinner combustivelPrefSpinner = findViewById(R.id.spinnerCombustivelPref);

        maxDistSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String maxDistanceValue = items[i];

                SharedPreferences sharedPref = getSharedPreferences("settings", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("MAX_DISTANCE", maxDistanceValue);
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                SharedPreferences sharedPref = getSharedPreferences("settings", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("MAX_DISTANCE", "10km");
                editor.commit();
            }
        });

        combustivelPrefSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String combustivelPrefValue = itemsCombustiveis[i];

                SharedPreferences sharedPref = getSharedPreferences("settings", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("COMBUSTIVEL_PREF", combustivelPrefValue);
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                SharedPreferences sharedPref = getSharedPreferences("settings", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("COMBUSTIVEL_PREF", "Gasolina");
                editor.commit();
            }
        });
    }

    public void onToggleNotificacoes(View v){
        boolean on = ((ToggleButton) v).isChecked();

        SharedPreferences sharedPref = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("NOTIFICATION", on);
        editor.commit();
    }
}
