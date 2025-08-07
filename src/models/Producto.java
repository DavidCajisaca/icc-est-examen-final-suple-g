package models;

import java.util.HashMap;
import java.util.List;

public class Producto implements Comparable<Producto> {
    private String nombre;
    private String codigo;
    private List<Double> precios;

    public Producto(String nombre, String codigo, List<Double> precios) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precios = precios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Double> getPrecios() {
        return precios;
    }

    public int getCatidadPreciosRepetidos() {
        HashMap<Double, Integer> contador = new HashMap<>();
        for (Double precio : precios) {
            if (contador.containsKey(precio)) {
                contador.put(precio, contador.get(precio) + 1);
            } else {
                contador.put(precio, 1);
            }
        }
        int repetidos = 0;
        for (int cantidad : contador.values()) {
            if (cantidad > 1) {
                repetidos += cantidad - 1;
            }
        }
        return repetidos;
    }

    public int getPorcentajeCaracteresUnicos() {
        String sinEspacios = nombre.replace(" ", "").toLowerCase();
        int total = sinEspacios.length();

        if (total == 0) {
            return 0;
        }

        String unicos = "";
        for (int i = 0; i < total; i++) {
            char c = sinEspacios.charAt(i);
            if (unicos.indexOf(c) == -1) {
                unicos += c;
            }
        }

        int porcentaje = (unicos.length() * 100) / total;
        return porcentaje;
    }

    @Override
public int compareTo(Producto otro) {
    int compCodigo = this.codigo.compareTo(otro.codigo);
    if (compCodigo == 0) {
        return 0; // mismos códigos = duplicados
    }
    return this.nombre.compareTo(otro.nombre);
}


    @Override
    public String toString() {
        return nombre + " (" + codigo + ")";
    }
}
