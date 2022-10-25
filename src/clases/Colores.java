/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author lauti
 */
public class Colores implements Comparable<Colores>{
    
    private String nombre;
    private int valor;

    public Colores(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Colores{" + "nombre=" + nombre + ", valor=" + valor + '}';
    }

    @Override
    public int compareTo(Colores o) {
       if (this.valor != o.getValor()) {
            return this.valor - o.getValor();
        }
        return this.nombre.compareTo(o.getNombre());
    }
    
    }
    
    
    

