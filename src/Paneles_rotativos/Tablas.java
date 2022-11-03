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

    //public static int filas_autos = 0, filas_camionetas = 0, filas_ventas = 0;
    // Principal principal = new Principal();
    //   ArrayList<Vehiculo> vehiculo = new ArrayList<Vehiculo>();
    /**
     * Creates new form Cargar
     */
    public Tablas() {

        initComponents();
        MuestraTabla();
        colormasvendido();
        Ventas.ventas.clear();
        CargadeVentas();
        MuestraTabla();

    }

    public void MuestraTabla() {

        Tabla();

        jLabel2.setText("Total de autos: " + tab_a.getRowCount());
        jLabel1.setText("Total de camionetas: " + tab_c.getRowCount());
        jLabel3.setText("Total de ventas: " + jTable3.getRowCount());

    }

    public static void colormasvendido() {
        Colores array[] = new Colores[4];

        if (Vehiculo.vehiculo.size() != 0) {

            ArrayList<String> ar = new ArrayList();

            for (int i = 0; i < Vehiculo.vehiculo.size(); i++) {

                ar.add(Vehiculo.vehiculo.get(i).getColor());
            }
            int verde = Collections.frequency(ar, "verde");
            int azul = Collections.frequency(ar, "azul");
            int blanco = Collections.frequency(ar, "blanco");
            int negro = Collections.frequency(ar, "negro");

            array[0] = new Colores("verde", verde);
            array[1] = new Colores("azul", azul);
            array[2] = new Colores("blanco", blanco);
            array[3] = new Colores("negro", negro);
            for (int i = 0; i < 4; i++) {
                System.out.println(array[i]);
            }
            System.out.println("\n");

            Arrays.sort(array);

            top1.setText("1 " + array[3].getNombre());
            if (array[2].getValor() != 0) {
                top2.setText("2 " + array[2].getNombre());
                if (array[1].getValor() != 0) {
                    top3.setText("3 " + array[1].getNombre());
                } else {
                    top3.setText("3 ");
                }
            } else {
                top2.setText("2 ");
                top3.setText("3 ");
            }
        } else {
            top1.setText("1 ");
            top2.setText("2 ");
            top3.setText("3 ");
        }

    }

    public void CargadeVentas() {

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

                //     filas_ventas = f;
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

                //     filas_autos = f;
            }

            autosb.close();
            autosr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void Tabla() {

        DefaultTableModel modelo2 = new DefaultTableModel();

        ArrayList<Object> nombrecolumna = new ArrayList<Object>();
        nombrecolumna.add("Vehiculo");
        nombrecolumna.add("DNI");
        nombrecolumna.add("Telefono");
        nombrecolumna.add("CUIL");
        nombrecolumna.add("Nombre");
        nombrecolumna.add("Apellido");
        nombrecolumna.add("Correo electronico");
        nombrecolumna.add("Numero de chasis");
        nombrecolumna.add("Monto");
        nombrecolumna.add("Fecha");
        nombrecolumna.add("Tipo de moneda");
        nombrecolumna.add("Marca");
        nombrecolumna.add("Numero de chasis");
        for (Object columna : nombrecolumna) {
            modelo2.addColumn(columna);
        }

        this.tab_a.setModel(modelo2);

        for (int k = 0; k < Ventas.ventas.size(); k++) {
            Ventas vv = Ventas.ventas.get(k);

            String dni = Long.toString(vv.getCliente().getDni());
            String telefono = Long.toString(vv.getCliente().getTelefono());
            String cuil = Long.toString(vv.getCliente().getCuil());
            String nro_contrato = Integer.toString(vv.getNro_contrato());
            String monto = Float.toString(vv.getMonto());

            String tab1[] = {dni, telefono, cuil, vv.getCliente().getNombre(),
                vv.getCliente().getApellido(), vv.getCliente().getCorreo_e(),
                nro_contrato, monto, vv.getFecha(), vv.getTpo_moneda(),
                vv.getMarca(), vv.getNrochasis()};
            modelo2.addRow(tab1);

        }

        DefaultTableModel modelo = new DefaultTableModel();

        ArrayList<Object> nombrecolumn = new ArrayList<>();

        nombrecolumn.add(
                "Nro Chasis");
        nombrecolumn.add(
                "Nro Motor");
        nombrecolumn.add(
                "Color");
        nombrecolumn.add(
                "Marca");
        nombrecolumn.add(
                "Modelo");
        nombrecolumn.add(
                "Anio");
        nombrecolumn.add(
                "Traccion");
        nombrecolumn.add(
                "Tipo de cabina");
        for (Object columna : nombrecolumn) {
            modelo.addColumn(columna);
        }

        this.tab_c.setModel(modelo);

        DefaultTableModel modelo1 = new DefaultTableModel();

        ArrayList<Object> nombrecolum = new ArrayList<Object>();

        nombrecolum.add(
                "Nro Chasis");
        nombrecolum.add(
                "Nro Motor");
        nombrecolum.add(
                "Color");
        nombrecolum.add(
                "Marca");
        nombrecolum.add(
                "Modelo");
        nombrecolum.add(
                "Anio");
        nombrecolum.add(
                "Cant puertas");
        for (Object columna : nombrecolum) {
            modelo1.addColumn(columna);
        }

        this.tab_a.setModel(modelo1);

        for (int k = 0;
                k < Vehiculo.vehiculo.size();
                k++) {

            if (Vehiculo.vehiculo.get(k) instanceof Camioneta) {

                Camioneta cb = (Camioneta) Vehiculo.vehiculo.get(k);
                String numero_chasis = Integer.toString(cb.getNro_chasis());
                String numero_motor = Integer.toString(cb.getNro_motor());

                String tab3[] = {numero_chasis, numero_motor, cb.getColor(), cb.getMarca(), cb.getModelo(), cb.getAnio(), cb.getTraccion(), cb.getTpo_cabina()};

                modelo.addRow(tab3);
            } else {

                Auto cc = (Auto) Vehiculo.vehiculo.get(k);

                String cant_puertas = Integer.toString(cc.getCant_puertas());
                String numero_chasis = Integer.toString(cc.getNro_chasis());
                String numero_motor = Integer.toString(cc.getNro_motor());

                String tab4[] = {numero_chasis, numero_motor, cc.getColor(), cc.getMarca(), cc.getModelo(), cc.getAnio(), cant_puertas};

                modelo1.addRow(tab4);
            }

        }

        tab_c.setModel(modelo);

        tab_a.setModel(modelo1);

        jTable3.setModel(modelo2);
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

                //       filas_camionetas = f;
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        año = new javax.swing.JTextField();
        buscar = new javax.swing.JLabel();
        marca = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedPane1MousePressed(evt);
            }
        });

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

        jLabel5.setText("CAMIONETAS");

        jLabel6.setText("AUTOS");

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
                                .addGap(321, 321, 321)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addGap(327, 327, 327)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(top2)
                        .addGap(12, 12, 12)
                        .addComponent(top3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("VEHICULOS", jPanel1);

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

        año.setText("Ingrese el año");

        buscar.setText("Buscar");
        buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buscarMousePressed(evt);
            }
        });

        marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ford", "volskwagen", "fiat", "peugeot" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(marca, 0, 343, Short.MAX_VALUE)
                    .addComponent(año))
                .addGap(56, 56, 56))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehiculo", "Modelo", "Marca", "Color", "Nro de chasis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(271, 271, 271))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("BUSCAR", jPanel3);

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
    public void buscarchasismarca(){
        DefaultTableModel modelo = new DefaultTableModel();

        ArrayList<Object> nombrecolumna = new ArrayList<Object>();
        nombrecolumna.add("Vehiculo");
        nombrecolumna.add("Modelo");
        nombrecolumna.add("Marca");
        nombrecolumna.add("Color");
        nombrecolumna.add("Nro de chasis");
        for (Object columna : nombrecolumna) {
            modelo.addColumn(columna);
        }

        this.jTable1.setModel(modelo);
        
        for (int i = 0 ; i < Vehiculo.vehiculo.size(); i++){
            if (Vehiculo.vehiculo.get(i).getAnio().equals(año.getText()) && Vehiculo.vehiculo.get(i).getMarca().equals(marca.getSelectedItem())){
                if (Vehiculo.vehiculo.get(i) instanceof Auto) {
                Auto cc = (Auto) Vehiculo.vehiculo.get(i);

                String numero_chasis = Integer.toString(cc.getNro_chasis());

                String tab[] = {"Auto", cc.getModelo(), cc.getMarca(), cc.getColor(), numero_chasis};

                modelo.addRow(tab);
            } else {
                Camioneta cc = (Camioneta) Vehiculo.vehiculo.get(i);
                String numero_chasis = Integer.toString(cc.getNro_chasis());

                String tab2[] = {"Camioneta", cc.getModelo(), cc.getMarca(), cc.getColor(), numero_chasis};
                modelo.addRow(tab2);
            }
                
            }
         }
        jTable1.setModel(modelo);
       
         
    }
    private void buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMousePressed
        buscarchasismarca();
    }//GEN-LAST:event_buscarMousePressed

    private void jTabbedPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MousePressed
     
    }//GEN-LAST:event_jTabbedPane1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField año;
    private javax.swing.JLabel buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JComboBox<String> marca;
    private javax.swing.JTable tab_a;
    private javax.swing.JTable tab_c;
    public static javax.swing.JLabel top1;
    private static javax.swing.JLabel top2;
    private static javax.swing.JLabel top3;
    // End of variables declaration//GEN-END:variables
}
