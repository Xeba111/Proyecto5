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

        addGasto("23 ENE 2023", 345, "Alimentacion");
        addGasto("15 FEB 2023", 25, "Ropa");
        addGasto("18 ENE 2023", 10, "Vivienda");
        addGasto("26 MAR 2023", 150, "EducaciON");
        addGasto("09 ABR 2023", 90, "Vivienda");
        addGasto("10 ENE 2023", 56, "Alimentacion");
        addGasto("12 FEB 2023", 89, "Vivienda");
        addGasto("24 MAR 2023", 546, "Ropa");
        addGasto("17 FEB 2023", 367, "Salud");
        addGasto("10 ABR 2023", 123, "Alimentacion");
        addGasto("15 FEB 2023", 55, "Salud");
        addGasto("16 MAR 2023", 13, "Vivienda");
        addGasto("19 ABR 2023", 68, "Educacion");
        addGasto("12 ABR 2023", 907, "Vivienda");
        addGasto("27 MAR 2023", 1356, "Educacion");
        addGasto("23 ENE 2023", 76, "Ropa");
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
    }
}
