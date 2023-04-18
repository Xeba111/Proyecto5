package com.example.proyecto4_v1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    private EditText campoTipo;
    private EditText campolimite;
    private EditText campoVivienda;
    private EditText campoAlimentacion;
    private EditText campoSalud;
    private EditText campoEducacion;
    private EditText campoRopa;

    private TextView vivienda;
    private TextView alimentacion;
    private TextView salud;
    private TextView educacion;
    private TextView ropa;


    private Spinner optionSpinner;
    private GastosSingleton mainSingleton = GastosSingleton.useSingleton();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        campoTipo=findViewById(R.id.etp);
        campolimite=findViewById(R.id.etlimite);
        campoVivienda = findViewById(R.id.etvivienda);
        campoAlimentacion = findViewById(R.id.etalimentacion);
        campoSalud = findViewById(R.id.etsalud);
        campoEducacion = findViewById(R.id.eteducacion);
        campoRopa = findViewById(R.id.etropa);
        vivienda = findViewById(R.id.tvvivienda);
        alimentacion= findViewById(R.id.tvalimentacion);
        salud = findViewById(R.id.tvsalud);
        educacion = findViewById(R.id.tveducacion);
        ropa = findViewById(R.id.tvropa);


    }
    public void regresarMainActivity(View view){
        Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void agregarTipo(View view) {
        String tipo = campoTipo.getText().toString();
        String stringlimite = campolimite.getText().toString();
        double limite = Double.parseDouble(stringlimite);
       mainSingleton.setLimite(tipo,limite);

    }

    public void editarLimites(View view) {
    String stringvivienda = vivienda.getText().toString();
    String stringalimentacion = alimentacion.getText().toString();
    String stringsalud =salud.getText().toString();
    String stringeducacion = educacion.getText().toString();
    String stringropa = ropa.getText().toString();

    String stringlimviv = campoVivienda.getText().toString();
    String stringlimali = campoAlimentacion.getText().toString();
    String stringlimsal = campoSalud.getText().toString();
    String stringlimedu = campoEducacion.getText().toString();
    String stringlimrop = campoRopa.getText().toString();

    double limviv = Double.parseDouble(stringlimviv);
    double limali = Double.parseDouble(stringlimali);
    double limsal = Double.parseDouble(stringlimsal) ;
    double limedu = Double.parseDouble(stringlimedu);
    double limrop = Double.parseDouble(stringlimrop);
        if(stringlimviv.isEmpty()){
            Toast.makeText(this,"Campo Vivienda vacio",Toast.LENGTH_LONG).show();
        } else {
            if(stringlimali.isEmpty()){
                Toast.makeText(this,"Campo Alimentacion vacio",Toast.LENGTH_LONG).show();
            } else {
                if(stringlimsal.isEmpty()){
                    Toast.makeText(this,"Campo Salud vacio",Toast.LENGTH_LONG).show();
                } else{
                    if(stringlimedu.isEmpty()){
                        Toast.makeText(this,"Campo Eduacion vacio",Toast.LENGTH_LONG).show();
                    } else {

                        if(stringlimrop.isEmpty()){
                            Toast.makeText(this,"Campo Ropa vacio",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        }
    mainSingleton.setLimite(stringvivienda,limviv);
    mainSingleton.setLimite(stringalimentacion,limali);
    mainSingleton.setLimite(stringsalud,limsal);
    mainSingleton.setLimite(stringeducacion,limedu);
    mainSingleton.setLimite(stringropa,limrop);


    }

}