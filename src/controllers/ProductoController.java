package controllers;

import java.util.*;
import models.Producto;

public class ProductoController {

    public Set<Producto> ordenarProducto(List<Producto> lista) {
    return new TreeSet<>(lista); 
}

    public Map<String, List<Producto>> clasificarPorUnicidad(Set<Producto> productos) {
        LinkedHashMap<String, List<Producto>> mapa = new LinkedHashMap();

        mapa.put("A", new LinkedList());
        mapa.put("B", new LinkedList());
        mapa.put("C", new LinkedList());
        mapa.put("D", new LinkedList());
        mapa.put("E", new LinkedList());

        for (Producto p : productos) {
            double porcentaje = p.getPorcentajeCaracteresUnicos();

            if (porcentaje >= 90) {
                mapa.get("A").add(p);
            } else if (porcentaje >= 70) {
                mapa.get("B").add(p);
            } else if (porcentaje >= 50) {
                mapa.get("C").add(p);
            } else if (porcentaje >= 30) {
                mapa.get("D").add(p);
            } else {
                mapa.get("E").add(p);
            }
        }

        return mapa;
    }

    public List<Producto> obtenerDestacados(List<Producto> productos) {
        List<Producto> destacados = new ArrayList();

        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            if (p.getCatidadPreciosRepetidos() > 1) {
                destacados.add(p);
            }
        }

        for (int i = 0; i < destacados.size() - 1; i++) {
            for (int j = i + 1; j < destacados.size(); j++) {
                if (destacados.get(i).getNombre().compareTo(destacados.get(j).getNombre()) > 0) {
                    Producto temp = destacados.get(i);
                    destacados.set(i, destacados.get(j));
                    destacados.set(j, temp);
                }
            }
        }

        return destacados;
    }

    public Producto buscarPorNombre(List<Producto> lista, String nombre) {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).getNombre().compareTo(lista.get(j).getNombre()) > 0) {
                    Producto temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                }
            }
        }

        int izquierda = 0;
        int derecha = lista.size() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            Producto p = lista.get(medio);
            int resultado = p.getNombre().compareTo(nombre);

            if (resultado == 0) {
                return p;
            } else if (resultado < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return null;
    }
}
