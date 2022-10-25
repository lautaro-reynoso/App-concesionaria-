package Paneles_rotativos;

import com.formdev.flatlaf.*;
import clases.*;
import interfaces.Principal;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class Tablas extends javax.swing.JPanel {

    public static int filas_autos = 0, filas_camionetas = 0, filas_ventas = 0;

    // Principal principal = new Principal();
    //   ArrayList<Vehiculo> vehiculo = new ArrayList<Vehiculo>();
    /**
     * Creates new form Cargar
     */
    public Tablas() {

        initComponents();
        MuestraTabla();
        colormasvendido();

        
        

    }

    public void MuestraTabla() {

        Tabla();

        jLabel2.setText("Total de autos: " + tab_a.getRowCount());
        jLabel1.setText("Total de camionetas: " + tab_c.getRowCount());
        jLabel3.setText("Total de ventas: " + Ventas.ventas.size());

    }

    public static void   colormasvendido() {
       Colores array[] = new Colores[4];
        
        if (Vehiculo.vehiculo.size()!=0){
            
            
            ArrayList <String> ar = new ArrayList();
            
            for (int i = 0; i < Vehiculo.vehiculo.size(); i++) {
                
                ar.add(Vehiculo.vehiculo.get(i).getColor());
            }
            int verde = Collections.frequency(ar, "verde");
            int azul = Collections.frequency(ar, "azul");
            int blanco = Collections.frequency(ar, "blanco");
            int negro = Collections.frequency(ar, "negro");
            
            array[0] = new Colores("verde",verde);
            array[1] = new Colores("azul",azul);
            array[2] = new Colores("blanco",blanco);
            array[3] = new Colores("negro",negro);
             for (int i = 0; i < 4; i++) {
              System.out.println(array[i]);   
            }
             System.out.println("\n");
            
            Arrays.sort(array);
            
            top1.setText("1 "+array[3].getNombre());
            if(array[2].getValor()!=0){
                 top2.setText("2 "+array[2].getNombre());
                    if(array[1].getValor()!=0)
                         top3.setText("3 "+array[1].getNombre());
                    else
                        top3.setText("3 ");
            }else {
                top2.setText("2 ");
                top3.setText("3 ");
            }
        }
        else{
            top1.setText("1 ");
            top2.setText("2 ");
            top3.setText("3 ");
        }
            
        
    }

    public static void CargadeVentas() {

        try {
            File ventas = new File("ventas.txt");
            FileReader ventasr = new FileReader(ventas);
            BufferedReader ventasb = new BufferedReader(ventasr);
            List<String> lista_de_archivo = new ArrayList<String>();

            LecturaArchivo(ventas, ventasb, lista_de_archivo);

            String[] arr = lista_de_archivo.toArray(new String[0]);
            int f = 0;
            System.out.println(arr[19]);
            for (int posicion = 0; posicion < (arr.length) - 12; posicion += 12) {

                Comprador comprador = new Comprador(Long.parseLong(arr[posicion + 12]), Long.parseLong(arr[posicion + 13]), Long.parseLong(arr[posicion + 14]), arr[posicion + 15], arr[posicion + 16],
                        arr[posicion + 17]);

                Ventas venta = new Ventas(Integer.parseInt(arr[posicion + 18]), Float.parseFloat(arr[posicion + 19]), arr[posicion + 20], arr[posicion + 21], arr[posicion + 22], arr[posicion + 23], comprador);

                Ventas.ventas.add(venta);

                f++;

                filas_ventas = f;
            }

            ventasb.close();
            ventasr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void CargadeAutosArchivo() {

        try {
            File autos = new File("autos.txt");
            FileReader autosr = new FileReader(autos);
            BufferedReader autosb = new BufferedReader(autosr);
            List<String> lista_de_archivo = new ArrayList<String>();

            LecturaArchivo(autos, autosb, lista_de_archivo);

            String[] arr = lista_de_archivo.toArray(new String[0]);
            int f = 0;
            for (int posicion = 0; posicion < (arr.length) - 7; posicion += 7) {

                String k = arr[posicion + 13].replaceAll("\\s", "");

                Vehiculo auto = new Auto(Integer.parseInt(arr[posicion + 7]), Integer.parseInt(arr[posicion + 8]), arr[posicion + 9], arr[posicion + 10], arr[posicion + 11],
                        arr[posicion + 12], Integer.parseInt(k));

                Vehiculo.vehiculo.add(auto);

                f++;

                filas_autos = f;
            }

            autosb.close();
            autosr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void Tabla() {

        for (int i = 0; i < Ventas.ventas.size(); i++) {

            Ventas vv = Ventas.ventas.get(i);

            String dni = Long.toString(vv.getCliente().getDni());
            String telefono = Long.toString(vv.getCliente().getTelefono());
            String cuil = Long.toString(vv.getCliente().getCuil());
            String nro_contrato = Integer.toString(vv.getNro_contrato());
            String monto = Float.toString(vv.getMonto());

            String tab[] = {dni, telefono, cuil, vv.getCliente().getNombre(),
                vv.getCliente().getApellido(), vv.getCliente().getCorreo_e(),
                nro_contrato, monto, vv.getFecha(), vv.getTpo_moneda(),
                vv.getMarca(), vv.getNrochasis()};

            DefaultTableModel tablamodelo = (DefaultTableModel) jTable3.getModel();

            // cont++;
            int rows = tablamodelo.getRowCount();

            for (int j = rows - filas_ventas; j >= 0; j--) {
                tablamodelo.removeRow(j);

            }

            tablamodelo.addRow(tab);

        }

        DefaultTableModel modelo = new DefaultTableModel();

        ArrayList<Object> nombrecolumna = new ArrayList<>();

        nombrecolumna.add("Nro Chasis");
        nombrecolumna.add("Nro Motor");
        nombrecolumna.add("Color");
        nombrecolumna.add("Marca");
        nombrecolumna.add("Modelo");
        nombrecolumna.add("Anio");
        nombrecolumna.add("Traccion");
        nombrecolumna.add("Tipo de cabina");
        for (Object columna : nombrecolumna) {
            modelo.addColumn(columna);
        }

        this.tab_c.setModel(modelo);

        DefaultTableModel modelo1 = new DefaultTableModel();

        ArrayList<Object> nombrecolum = new ArrayList<Object>();
        nombrecolum.add("Nro Chasis");
        nombrecolum.add("Nro Motor");
        nombrecolum.add("Color");
        nombrecolum.add("Marca");
        nombrecolum.add("Modelo");
        nombrecolum.add("Anio");
        nombrecolum.add("Cant puertas");
        for (Object columna : nombrecolum) {
            modelo1.addColumn(columna);
        }

        this.tab_a.setModel(modelo1);

        for (int k = 0; k < Vehiculo.vehiculo.size(); k++) {

            if (Vehiculo.vehiculo.get(k) instanceof Camioneta) {

                Camioneta cb = (Camioneta) Vehiculo.vehiculo.get(k);
                String numero_chasis = Integer.toString(cb.getNro_chasis());
                String numero_motor = Integer.toString(cb.getNro_motor());

                String tab[] = {numero_chasis, numero_motor, cb.getColor(), cb.getMarca(), cb.getModelo(), cb.getAnio(), cb.getTraccion(), cb.getTpo_cabina()};

                modelo.addRow(tab);
            } else {

                Auto cc = (Auto) Vehiculo.vehiculo.get(k);

                String cant_puertas = Integer.toString(cc.getCant_puertas());
                String numero_chasis = Integer.toString(cc.getNro_chasis());
                String numero_motor = Integer.toString(cc.getNro_motor());

                String tab[] = {numero_chasis, numero_motor, cc.getColor(), cc.getMarca(), cc.getModelo(), cc.getAnio(), cant_puertas};

                modelo1.addRow(tab);
            }

        }

        tab_c.setModel(modelo);
        tab_a.setModel(modelo1);

    }

    /*
     */
    public static void LecturaArchivo(File archivo, BufferedReader archivob, List<String> lista_de_archivo) throws IOException {

        String s = new String();
        char ch;
        int cont = (int) archivo.length() - 1;
        while (cont >= 0) {
            ch = (char) archivob.read();
            if (ch == '\n' || ch == ' ' || ch == ',') {
                lista_de_archivo.add(s);
                s = new String();
            } else {
                s += ch;
            }
            cont--;
        }
        if (s.length() > 0) {
            lista_de_archivo.add(s);
        }
    }

    public static void CargadeCamionetasArchivo() {

        try {
            File camionetas = new File("camionetas.txt");
            FileReader camionetasr = new FileReader(camionetas);
            BufferedReader camionetasb = new BufferedReader(camionetasr);
            List<String> lista_de_archivo = new ArrayList<String>();

            LecturaArchivo(camionetas, camionetasb, lista_de_archivo);

            String[] arr = lista_de_archivo.toArray(new String[0]);
            int f = 0;
            for (int posicion = 0; posicion < (arr.length) - 8; posicion += 8) {
                String k = arr[posicion + 15].replaceAll("\\s", "");
                Vehiculo camioneta = new Camioneta(Integer.parseInt(arr[posicion + 8]), Integer.parseInt(arr[posicion + 9]), arr[posicion + 10], arr[posicion + 11], arr[posicion + 12], arr[posicion + 13], arr[posicion + 14], k);
                Vehiculo.vehiculo.add(camioneta);

                f++;

                filas_camionetas = f;
            }
            camionetasb.close();
            camionetasr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_c = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_a = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        top1 = new javax.swing.JLabel();
        top2 = new javax.swing.JLabel();
        top3 = new javax.swing.JLabel();

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Telefono", "CUIL", "Nombre", "Apellido", "Correo electronico", "Numero de contrato", "Monto", "Fecha", "Tipo de moneda", "Marca", "Numero de chasis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jButton2.setText("Consultar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jLabel3.setText("Total de ventas: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("VENTAS", jPanel2);

        tab_c.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Traccion", "Nro de chasis", "Nro de motor", "Color", "Marca", "Modelo", "Anio", "Tipo de cabina"
            }
        ));
        jScrollPane2.setViewportView(tab_c);

        jLabel1.setText("Total de camionetas: "+tab_c.getRowCount());

        tab_a.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de chasis", "Numero de motor", "Marca", "Color", "Modelo", "Año", "Cantidad de puertas"
            }
        ));
        jScrollPane1.setViewportView(tab_a);

        jLabel2.setText("Total de autos: "+ tab_a.getRowCount());

        jButton1.setText("Consultar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Top 3 colores:");

        top1.setText("jLabel5");

        top2.setText("jLabel6");

        top3.setText("jLabel7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(top3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(top1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                .addComponent(top2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(60, 60, 60))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(top1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel4))
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(top2)
                        .addGap(12, 12, 12)
                        .addComponent(top3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("VEHICULOS", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed

    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        Ventas.ventas.clear();
        CargadeVentas();
        MuestraTabla();
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        Vehiculo.vehiculo.clear();
        CargadeCamionetasArchivo();
        CargadeAutosArchivo();
        MuestraTabla();
        colormasvendido();


    }//GEN-LAST:event_jButton1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable tab_a;
    private javax.swing.JTable tab_c;
    public static javax.swing.JLabel top1;
    private static javax.swing.JLabel top2;
    private static javax.swing.JLabel top3;
    // End of variables declaration//GEN-END:variables
}
