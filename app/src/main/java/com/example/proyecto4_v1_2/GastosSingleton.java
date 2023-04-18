package com.example.proyecto4_v1_2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GastosSingleton {
    private static GastosSingleton instanceGastosSingleton = new GastosSingleton();

    private ArrayList<Gastos> listaGastos;

    private Map<String, Double> mapaLimites;

    public static GastosSingleton useSingleton() {
        return instanceGastosSingleton;
    }

    private GastosSingleton() {
        listaGastos = new ArrayList<>();
        mapaLimites = new LinkedHashMap<>();
        mapaLimites.put("Vivienda", 99999999.9);
        mapaLimites.put("Alimentacion", 99999999.9);
        mapaLimites.put("Salud", 99999999.9);
        mapaLimites.put("Educacion", 99999999.9);
        mapaLimites.put("Ropa", 99999999.9);

    }

    public List<Gastos> getListaGastos() {
        return listaGastos;
    }

    public double getLimite(String tipo) {

        return mapaLimites.get(tipo);

    }

    public void addGasto(String date, double value, String type) {
        Gastos gasto = new Gastos(date, value, type);

        listaGastos.add(gasto);
    }

    public void deleteGasto(int pos)
    {
        listaGastos.remove(pos);
    }

    public void setLimite(String tipo, double limite)
    {
        mapaLimites.put(tipo, limite);
        System.out.println(mapaLimites);
    }


}
