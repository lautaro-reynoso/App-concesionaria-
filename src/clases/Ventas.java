package clases;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mateo
 */
public class Ventas {

    public static ArrayList<Ventas> ventas = new ArrayList<Ventas>();
    //  public static ArrayList<Vehiculo> vehiculo = new ArrayList<Vehiculo>();

    int nro_contrato;
    float monto;

    String fecha,
            tpo_moneda, marca_v, nro_chasis; //descuento segun tpo moneda.

    // Vehiculo vehiculo;
    Comprador cliente;

    public Ventas(int nro_contrato, float monto, String fecha, String tpo_moneda, String marca_v, String nro_chasis, Comprador cliente) {
        this.nro_contrato = nro_contrato;
        this.monto = monto;
        this.fecha = fecha;
        this.tpo_moneda = tpo_moneda;
        this.marca_v = marca_v;
        this.nro_chasis = nro_chasis;
        this.cliente = cliente;
    }

    public int getNro_contrato() {
        return nro_contrato;
    }

    public String getMarca() {
        return marca_v;
    }
    
    public String getNrochasis() {
        return nro_chasis;
    }
    
    public void setNro_contrato(int nro_contrato) {
        this.nro_contrato = nro_contrato;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTpo_moneda() {
        return tpo_moneda;
    }

    public void setTpo_moneda(String tpo_moneda) {
        this.tpo_moneda = tpo_moneda;
    }

    public Comprador getCliente() {
        return cliente;
    }

    public void setCliente(Comprador cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ventas{");
        sb.append("nro_contrato=").append(nro_contrato);
        sb.append(", monto=").append(monto);
        sb.append(", fecha='").append(fecha).append('\'');
        sb.append(", tpo_moneda='").append(tpo_moneda).append('\'');
        sb.append(", cliente=").append(cliente);
        sb.append('}');
        return sb.toString();
    }
}
