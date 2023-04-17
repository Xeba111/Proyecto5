package com.example.proyecto4_v1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ThirdActivity extends AppCompatActivity {
    private EditText campoTipo;

    private Spinner optionSpinner;
    private GastosSingleton mainSingleton = GastosSingleton.useSingleton();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        optionSpinner = (Spinner) findViewById(R.id.spinnerTipos);

        ArrayAdapter<String> optionAdapter = new ArrayAdapter<String>(ThirdActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.options));
        optionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        optionSpinner.setAdapter(optionAdapter);
    }
    public void regresarMainActivity(View view){
        Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void agregarTipo(View view) {

    }

    public void editarTipo(View view) {

    }
}