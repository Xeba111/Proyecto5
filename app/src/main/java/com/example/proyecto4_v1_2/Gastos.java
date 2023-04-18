package com.example.proyecto4_v1_2;

public class Gastos
{
    String fecha ;
    double valor = 0.0;
    String tipo;
    int limite;


    public Gastos(String fecha,double valor, String tipo){
        this.fecha= fecha;
        this.tipo = tipo;
        this.valor = valor;
    }
    public Gastos(String tipo, int limite){
        this.tipo = tipo;
        this.limite = limite;
    }

    public String getFecha()
    {
        return fecha;
    }

    public Double getValor ()
    {
        return valor;
    }

    public String getTipo(){
        return tipo;
    }


}