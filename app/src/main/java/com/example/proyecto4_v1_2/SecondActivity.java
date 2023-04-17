package com.example.proyecto4_v1_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import org.jetbrains.annotations.NonNls;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView rv1;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    private GastosSingleton mainSingleton = GastosSingleton.useSingleton();

    private GastosAdapter gastosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());

        gastosAdapter = new GastosAdapter();

        rv1 = (RecyclerView) findViewById(R.id.recyclerGastos);
        rv1.setAdapter(gastosAdapter);

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

    private class GastosAdapter extends RecyclerView.Adapter<GastosAdapter.GastosAdapterHolder>
    {
        @NonNull
        @Override
        public GastosAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            return new GastosAdapterHolder(getLayoutInflater().inflate(R.layout))
        }
    }

    public void resetRecycler(View view) {
    }

    public void filtrarRecycler(View view) {
    }
}