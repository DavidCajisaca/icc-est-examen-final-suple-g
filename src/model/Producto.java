package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Producto<E> {
  private String nombre;
  private String codigo;
  private List<Double> precios;
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  public List<Double> getPrecios() {
    return precios;
  }
  public void setPrecios(List<Double> precios) {
    this.precios = precios;
  }
  public Producto(String nombre, String codigo, List<Double> precios) {
    this.nombre = nombre;
    this.codigo = codigo;
    this.precios = precios;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
    result = prime * result + ((precios == null) ? 0 : precios.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Producto other = (Producto) obj;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    if (codigo == null) {
      if (other.codigo != null)
        return false;
    } else if (!codigo.equals(other.codigo))
      return false;
    if (precios == null) {
      if (other.precios != null)
        return false;
    } else if (!precios.equals(other.precios))
      return false;
    return true;
  }
  @Override
  public String toString() {
    return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", precios=" + precios + "]";
  }
 
  private void porcentajeCaracteresUnicos(List<Producto> lista,String nombre){
    Set<Producto> map = 
  }
  
}
