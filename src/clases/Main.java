/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Paneles_rotativos.Tablas;
import com.formdev.flatlaf.FlatLightLaf;
import interfaces.Principal;

/**
 *
 * @author Lauti
 */

public class Main {

    
    public static void main(String args[]) {
        

        Vehiculo.vehiculo.clear();

        Tablas.CargadeAutosArchivo();
        Tablas.CargadeCamionetasArchivo();
        
        FlatLightLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

}
