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
            contador.put(precio, contador.getOrDefault(precio, 0) + 1);
        }
        int repetidos = 0;
        for (int count : contador.values()) {
            if (count > 1) {
                repetidos += count - 1; 
            }
        }
        return repetidos;
    }

    public int getPorcentajeCaracteresUnicos() {
    String nombreSinEspacios = nombre.replaceAll(" ", "").toLowerCase();
    HashMap<Character, Integer> contador = new HashMap<>();

    for (int i = 0; i < nombreSinEspacios.length(); i++) {
        char c = nombreSinEspacios.charAt(i);
        contador.put(c, contador.getOrDefault(c, 0) + 1);
    }

    int totalCaracteres = nombreSinEspacios.length();
    int totalUnicos = contador.size();

    if (totalCaracteres == 0) return 0;

    return (int) ((double) totalUnicos / totalCaracteres * 100);
}

    @Override
    public int compareTo(Producto otro) {
        int comparacionNombre = this.nombre.compareTo(otro.nombre);
        if (comparacionNombre != 0) {
            return comparacionNombre;
        }
        return this.codigo.compareTo(otro.codigo);
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ")";
    }
}
