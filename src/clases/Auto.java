package clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mateo
 */
public class Auto extends Vehiculo {

    int cant_puertas;

    public Auto(int nro_chasis, int nro_motor, String marca, String color, String modelo, String anio, int cant_puertas) {
        super(nro_chasis, nro_motor, color, marca, modelo, anio);
        this.cant_puertas = cant_puertas;
    }

    public int getCant_puertas() {
        return cant_puertas;
    }

    public void setCant_puertas(int cant_puertas) {
        this.cant_puertas = cant_puertas;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Auto{");
        sb.append("cant_puertas=").append(cant_puertas);
        sb.append(", nro_chasis=").append(nro_chasis);
        sb.append(", nro_motor=").append(nro_motor);
        sb.append(", color='").append(color).append('\'');
        sb.append(", marca='").append(marca).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append(", anio='").append(anio).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
