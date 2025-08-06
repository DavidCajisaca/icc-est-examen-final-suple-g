package controller;

import java.util.List;

import model.Producto;

public class ProductoController {
private void quicksort(List<Producto>lista,int low,int high){
  int pi = quicksorte(lista, low, high);
  quicksort(lista, low, pi+1);
  quicksort(lista, pi-1, high);
}
private void quicksorte(List<Producto>lista,int low,int high){
  
}
}
