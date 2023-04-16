package com.example.proyecto4_v1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatePicker();
        dateButton =  findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());

        Spinner optionSpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> optionAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.options));
        optionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        optionSpinner.setAdapter(optionAdapter);
    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        month = month+1;

        return makeDateString(day, month, year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
                mes = mes +1;
                String date = makeDateString(dia, mes, anio);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    private String makeDateString(int dia, int mes, int anio) {
        return dia + " " + getMonthFormat(mes) + " " + anio;
    }

    private String getMonthFormat(int mes) {
        if(mes == 1){return  "ENE";}
        if(mes == 2){return  "FEB";}
        if(mes == 3){return  "MAR";}
        if(mes == 4){return  "ABR";}
        if(mes == 5){return  "MAY";}
        if(mes == 6){return  "JUN";}
        if(mes == 7){return  "JUL";}
        if(mes == 8){return  "AGO";}
        if(mes == 9){return  "SEP";}
        if(mes == 10){return  "OCT";}
        if(mes == 11){return  "NOV";}
        if(mes == 12){return  "DIC";}

        return "ENE";
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

    public void launchSegundaPantalla(View view) {

    }

    public void startSecondActivity(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    public void startThirdActivity(View view){
        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
        startActivity(intent);
    }
}