package com.example.proyecto4_v1_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    ArrayList<Gastos> gastos;
    RecyclerView rv1;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        gastos =new ArrayList<Gastos>();
       // rv1 = findViewById(R.id.)
        gastos.add(new Gastos("23 ENE 2023", 345,"Alimentacion"));
        gastos.add(new Gastos("15 FEB 2023", 25,"Ropa"));
        gastos.add(new Gastos("18 ENE 2023", 10,"Vivienda"));
        gastos.add(new Gastos("26 MAR 2023", 150,"Educación"));
        gastos.add(new Gastos("09 ABR 2023", 90,"Vivienda"));
        gastos.add(new Gastos("10 ENE 2023", 56,"Alimentación"));
        gastos.add(new Gastos("12 FEB 2023", 89,"Vivienda"));
        gastos.add(new Gastos("24 MAR 2023", 546,"Ropa"));
        gastos.add(new Gastos("17 FEB 2023", 367,"Salud"));
        gastos.add(new Gastos("10 ABR 2023", 123,"Alimentación"));
        gastos.add(new Gastos("15 FEB 2023", 55,"Salud"));
        gastos.add(new Gastos("16 MAR 2023", 13,"Vivienda"));
        gastos.add(new Gastos("19 ABR 2023", 68,"Educación"));
        gastos.add(new Gastos("12 ABR 2023", 907,"Vivienda"));
        gastos.add(new Gastos("27 MAR 2023", 1356,"Educación"));
        gastos.add(new Gastos("29 ENE 2023", 25,"Alimentación"));
        gastos.add(new Gastos("30 FEB 2023", 15,"Vivienda"));
        gastos.add(new Gastos("23 ENE 2023", 76,"Ropa"));
        gastos.add(new Gastos("15 FEB 2023", 845,"Educación"));

        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());

        Spinner optionSpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> optionAdapter = new ArrayAdapter<String>(this,
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

    public void regresarMainActivity(View view){
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
    }


}