package clases;

import interfaces.*;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mateo
 */
public abstract class Vehiculo {
    
    public static ArrayList<Vehiculo> vehiculo = new ArrayList<Vehiculo>();

    int nro_chasis;
    int nro_motor;
    String color, marca, modelo, anio;


    public Vehiculo(int nro_chasis, int nro_motor, String color, String marca, String modelo, String anio) {
        this.nro_chasis = nro_chasis;
        this.nro_motor = nro_motor;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }
    

     
     
    public int getNro_chasis() {
        return nro_chasis;
    }

    public void setNro_chasis(int nro_chasis) {
        this.nro_chasis = nro_chasis;
    }

    public int getNro_motor() {
        return nro_motor;
    }

    public void setNro_motor(int nro_motor) {
        this.nro_motor = nro_motor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
    
    
    

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Vehiculo{");
        sb.append("nro_chasis=").append(nro_chasis);
        sb.append(", nro_motor=").append(nro_motor);
        sb.append(", color='").append(color).append('\'');
        sb.append(", marca='").append(marca).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append(", anio='").append(anio).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
