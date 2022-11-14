package clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mateo
 */
public class Camioneta extends Vehiculo {

    String traccion, tpo_cabina;


    public Camioneta(int nro_chasis, int nro_motor, String color, String marca, String modelo, String anio, String traccion, String tpo_cabina) {
        super(nro_chasis, nro_motor, color, marca, modelo, anio);
        this.traccion = traccion;
        this.tpo_cabina = tpo_cabina;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public String getTpo_cabina() {
        return tpo_cabina;
    }

    public void setTpo_cabina(String tpo_cabina) {
        this.tpo_cabina = tpo_cabina;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Camioneta{");
        sb.append("traccion='").append(traccion).append('\'');
        sb.append(", tpo_cabina='").append(tpo_cabina).append('\'');
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
