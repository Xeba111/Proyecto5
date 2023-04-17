package com.example.proyecto4_v1_2;

public class Gastos {
    String fecha ;
    int valor = 0;
    String tipo;


    public Gastos(String fecha,int valor, String tipo){
        this.fecha= fecha;
        this.tipo = tipo;
        this. valor = valor;
    }

    public String getFecha()
    {
        return fecha;
    }

    public Integer getValor ()
    {
        return valor;
    }

    public String getTipo(){
        return tipo;
    }

}
