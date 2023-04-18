package com.example.proyecto4_v1_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NonNls;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView rv1;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    private TextView tv1;

    private GastosSingleton mainSingleton = GastosSingleton.useSingleton();

    private GastosAdapter gastosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());

        LinearLayoutManager l = new LinearLayoutManager(this);

        gastosAdapter = new GastosAdapter();

        tv1 = (TextView) findViewById(R.id.textGetPosition);
        rv1 = (RecyclerView) findViewById(R.id.recyclerGastos);
        rv1.setAdapter(gastosAdapter);
        rv1.setLayoutManager(l);

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

    public void mostrar(int pos)
    {
        tv1.setText(mainSingleton.getListaGastos().get(pos).getValor().toString());
    }

    public void eliminar(View view)
    {
        int pos = -1;
        for(int i = 0; i < mainSingleton.getListaGastos().size(); i++)
        {
            String valorString = tv1.getText().toString();
            double valor = Double.parseDouble(valorString);

            if(mainSingleton.getListaGastos().get(i).getValor() == valor) {
                pos = i;
            }
        }
        if(pos != -1)
        {
            mainSingleton.getListaGastos().remove(pos);
            gastosAdapter.notifyDataSetChanged();
            tv1.setText("");
            Toast.makeText(SecondActivity.this, "SE ELIMINÓ LA PERSONA", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(SecondActivity.this, "NO EXISTE LA PERSONA", Toast.LENGTH_SHORT).show();
        }
    }

    private class GastosAdapter extends RecyclerView.Adapter<GastosAdapter.GastosAdapterHolder>
    {
        @NonNull
        @Override
        public GastosAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            return new GastosAdapterHolder(getLayoutInflater().inflate(R.layout.itemsgastos, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull GastosAdapterHolder holder, int position)
        {
            holder.imprimir(position);

        }

        @Override
        public int getItemCount() {
            return mainSingleton.getListaGastos().size();
        }

        class GastosAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {
            TextView tv1, tv2, tv3;

            public GastosAdapterHolder(@NonNull View itemView)
            {
                super(itemView);
                tv1 = itemView.findViewById(R.id.tvFecha);
                tv2 = itemView.findViewById(R.id.tvValor);
                tv3 = itemView.findViewById(R.id.tvTipo);

                itemView.setOnClickListener(this);
            }

            public void imprimir(int position)
            {
                tv1.setText(mainSingleton.getListaGastos().get(position).getFecha());
                tv2.setText(mainSingleton.getListaGastos().get(position).getValor().toString());
                tv3.setText(mainSingleton.getListaGastos().get(position).getTipo());
            }

            @Override
            public void onClick(View v)
            {
                mostrar(getLayoutPosition());
            }

        }
    }

    public void resetRecycler(View view) {
    }

    public void filtrarRecycler(View view) {
    }
}