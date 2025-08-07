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
    for (int count : contador.values()) {
        if (count > 1) {
            repetidos += count - 1; 
        }
    }
    return repetidos;
}


  public int getPorcentajeCaracteresUnicos() {
    String nombreSinEspacios = nombre.replace(" ", "").toLowerCase();
    int totalCaracteres = nombreSinEspacios.length();

    if (totalCaracteres == 0) {
        return 0;
    }
    String caracteresUnicos = "";

    for (int i = 0; i < totalCaracteres; i++) {
        char c = nombreSinEspacios.charAt(i);
        boolean existe = false;
        for (int j = 0; j < caracteresUnicos.length(); j++) {
            if (caracteresUnicos.charAt(j) == c) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            caracteresUnicos += c; 
        }
    }

    int totalUnicos = caracteresUnicos.length();

    int porcentaje = (totalUnicos * 100) / totalCaracteres;

    return porcentaje;
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
