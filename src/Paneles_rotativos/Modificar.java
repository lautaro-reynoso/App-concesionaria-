/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles_rotativos;


import clases.Auto;
import clases.Camioneta;
import clases.Vehiculo;
import interfaces.Principal;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/**
 *
 * @author Lauti
 */
public final class Modificar extends javax.swing.JPanel {

    public int tipo;
    public Modificar() {
        
        initComponents();
        setear();
        
    }
    public void setear(){
        n_chasis1.setText(null);
        n_motor1.setText(null);
  
        
      
        anio1.setText(null);
    
    
        cabina1.setText(null);
    }
public void MostrarPanel(JPanel p) {
     
       /* p.setLocation(0, 0);
        jPanel1.removeAll();
        jPanel1.add(p);
        jPanel1.revalidate();
        jPanel1.repaint();
*/
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        info = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        n_motor1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        n_chasis1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        anio1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cabina1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        confirmar = new javax.swing.JLabel();
        marca1 = new javax.swing.JComboBox<>();
        traccion1 = new javax.swing.JComboBox<>();
        puertas1 = new javax.swing.JComboBox<>();
        color1 = new javax.swing.JComboBox<>();
        modelo = new javax.swing.JComboBox<>();
        Buscador = new javax.swing.JTextField();
        B_buscar = new javax.swing.JLabel();

        jLabel10.setText("Año");

        n_motor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_motor1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Color");

        n_chasis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_chasis1ActionPerformed(evt);
            }
        });
        n_chasis1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                n_chasis1KeyPressed(evt);
            }
        });

        jLabel12.setText("cantida de puertas");

        jLabel13.setText("Cabina");

        anio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                anio1KeyPressed(evt);
            }
        });

        jLabel14.setText("Traccion");

        jLabel15.setText("Nº Motor");

        jLabel16.setText("Nº chasis");

        jLabel17.setText("Marca");

        jLabel18.setText("Modelo");

        confirmar.setText("Confirmar");
        confirmar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        confirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                confirmarMousePressed(evt);
            }
        });

        marca1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ford", "Volskwagen", "Fiat", "Peugeot" }));
        marca1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                marca1ItemStateChanged(evt);
            }
        });
        marca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marca1ActionPerformed(evt);
            }
        });

        traccion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "delantera", "trasera", "4x4" }));

        puertas1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5" }));

        color1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "azul", "blanco", "verde", "negro" }));

        modelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Focus", "Mondeo", "Fiesta", "Mustantg" }));
        modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoLayout = new javax.swing.GroupLayout(info);
        info.setLayout(infoLayout);
        infoLayout.setHorizontalGroup(
            infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoLayout.createSequentialGroup()
                .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoLayout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(n_chasis1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(infoLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(anio1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
                            .addGroup(infoLayout.createSequentialGroup()
                                .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(infoLayout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(modelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(infoLayout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(marca1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cabina1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(traccion1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(puertas1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(color1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(confirmar)
                .addGap(57, 57, 57))
            .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(infoLayout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(n_motor1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(279, Short.MAX_VALUE)))
        );
        infoLayout.setVerticalGroup(
            infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(n_chasis1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(color1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(anio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cabina1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(marca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(infoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(puertas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel14)
                    .addComponent(traccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(infoLayout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15)
                        .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(n_motor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addContainerGap(204, Short.MAX_VALUE)))
        );

        Buscador.setText("Ingrese el numero del chasis");
        Buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscadorActionPerformed(evt);
            }
        });
        Buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BuscadorKeyPressed(evt);
            }
        });

        B_buscar.setText("Buscar");
        B_buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                B_buscarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(B_buscar)
                    .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(350, 350, 350))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void BuscarChasis(){
       
        cabina1.setEnabled(true);
        puertas1.setEnabled(true);
        int cont =0;
        try{
        for (int i = 0 ; i < Vehiculo.vehiculo.size(); i++){
            if (Vehiculo.vehiculo.get(i).getNro_chasis() == Integer.parseInt(Buscador.getText()) ){
                
                if (Vehiculo.vehiculo.get(i) instanceof Auto) {
                tipo=1;
                Auto cc = (Auto) Vehiculo.vehiculo.get(i);

                String cant_puertas = Integer.toString(cc.getCant_puertas());
                String numero_chasis = Integer.toString(cc.getNro_chasis());
                String numero_motor = Integer.toString(cc.getNro_motor());
                
                
                n_chasis1.setText(numero_chasis);
                n_motor1.setText(numero_motor);
                marca1.setSelectedItem(cc.getMarca());
                modelo.setSelectedItem(cc.getModelo());
                
                anio1.setText(cc.getAnio());
                
                
  
                cabina1.setText("nulo");
                cabina1.setEnabled(false);
                traccion1.setEnabled(false);
                
                
                
                
                

            } else {
                tipo=2;
                Camioneta cb = (Camioneta) Vehiculo.vehiculo.get(i);

                String numero_chasis = Integer.toString(cb.getNro_chasis());
                String numero_motor = Integer.toString(cb.getNro_motor());
                
                n_chasis1.setText(numero_chasis);
                n_motor1.setText(numero_motor);
                marca1.setSelectedItem(cb.getMarca());
                modelo.setSelectedItem(cb.getModelo());
                
         
                anio1.setText(cb.getAnio());
  
                puertas1.setEnabled(false);
                traccion1.setEnabled(true);
        
                cabina1.setText(cb.getTpo_cabina());
               

            }
            }

        }
        
              
        }catch(Exception e ){    
                javax.swing.JOptionPane.showMessageDialog(this, "Error, No se encontro el vehiculo.", "ERROR", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        }
    
    
    private void B_buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_buscarMousePressed
        if (Buscador.getText()!= null){
            if(Vehiculo.vehiculo.size()!=0){
                BuscarChasis();
            }
            else{
                Component jFrame = null;
                JOptionPane.showMessageDialog(jFrame,"Error, no hay ningun vehiculo cargado");
            }
                
        }
    }//GEN-LAST:event_B_buscarMousePressed

    private void BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscadorActionPerformed

    private void confirmarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarMousePressed
         if(Integer.parseInt(anio1.getText())<2000||Integer.parseInt(anio1.getText())>2022){
            Component jFrame = null;
                JOptionPane.showMessageDialog(jFrame,""
                        + "Error, solo se vende autos desde 2000 hasta 2022");
        }
         else{
        try {
            if (cabina1.getText().equals("nulo")){
                Modificar(n_chasis1.getText(),n_motor1.getText(),anio1.getText(), marca1.getSelectedItem().toString(), (String) modelo.getSelectedItem(),color1.getSelectedItem().toString(),cabina1.getText(),puertas1.getSelectedItem().toString(),"nulo", 1 );
            }
            else{
                Modificar(n_chasis1.getText(),n_motor1.getText(),anio1.getText(), marca1.getSelectedItem().toString(), (String) modelo.getSelectedItem(),color1.getSelectedItem().toString(),cabina1.getText(),puertas1.getSelectedItem().toString(),traccion1.getSelectedItem().toString(), 2 );
            }

        }

        catch (IOException ex) {
            Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    }//GEN-LAST:event_confirmarMousePressed
    
    private void n_chasis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_chasis1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_chasis1ActionPerformed

    private void n_motor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_motor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_motor1ActionPerformed

    private void BuscadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscadorKeyPressed
         char validador = evt.getKeyChar();
        
        if(Character.isLetter(validador)){
            getToolkit().beep();
            evt.consume();
           Component rootPane = null;
        
           JOptionPane.showMessageDialog(rootPane, "Ingrese solo números!  ");
            
        }
    }//GEN-LAST:event_BuscadorKeyPressed

    private void anio1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anio1KeyPressed
         char validador = evt.getKeyChar();
        
        if(Character.isLetter(validador)){
            getToolkit().beep();
            evt.consume();
           Component rootPane = null;
        
           JOptionPane.showMessageDialog(rootPane, "Ingrese solo números!  ");
            
        }
    }//GEN-LAST:event_anio1KeyPressed

    private void n_chasis1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_n_chasis1KeyPressed
         char validador = evt.getKeyChar();
        
        if(Character.isLetter(validador)){
            getToolkit().beep();
            evt.consume();
           Component rootPane = null;
        
           JOptionPane.showMessageDialog(rootPane, "Ingrese solo números!  ");
            
        }
    }//GEN-LAST:event_n_chasis1KeyPressed
    public String[] getmodelos(String marca){
        String[] modelos = new String[4];
        if(marca.equalsIgnoreCase("Ford"))
        {
           modelos[0] = "Focus";
           modelos[1] = "Fiesta";
           modelos[2] = "Mondeo";
           modelos[3] = "Mustang"; 
        }
        if(marca.equalsIgnoreCase("Volskwagen"))
        {
           modelos[0] = "Golf";
           modelos[1] = "Polo";
           modelos[2] = "Vento";
           modelos[3] = "Gol"; 
        }
        
        if(marca.equalsIgnoreCase("Fiat"))
        {
           modelos[0] = "600";
           modelos[1] = "Argo";
           modelos[2] = "Cronnos";
           modelos[3] = "Uno";    
        }
        if(marca.equalsIgnoreCase("Peugeot"))
        {
           modelos[0] = "208";
           modelos[1] = "306";
           modelos[2] = "RCZ";
           modelos[3] = "408";    
        }
        return modelos;
    }
    private void modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloActionPerformed
       
    }//GEN-LAST:event_modeloActionPerformed

    private void marca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marca1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marca1ActionPerformed

      public String[] getmodelos_c(String marca){
        String[] modelos = new String[4];
        if(marca.equalsIgnoreCase("Ford"))
        {
           modelos[0] = "Ranger";
           modelos[1] = "Raptor";
           modelos[2] = "F-150";
           modelos[3] = "Maverick"; 
        }
        if(marca.equalsIgnoreCase("Volskwagen"))
        {
           modelos[0] = "Amarok";
           modelos[1] = "Tarok";
           modelos[2] = "Saveiro";
           modelos[3] = "Taos";
        }
        
        if(marca.equalsIgnoreCase("Fiat"))
        {
           modelos[0] = "Strada";
           modelos[1] = "Fullback";
           modelos[2] = "Toro";
           modelos[3] = "Pulse";
        }
        if(marca.equalsIgnoreCase("Peugeot"))
        {
           modelos[0] = "2008";
           modelos[1] = "3008";
           modelos[2] = "patner";
           modelos[3] = "5008";
        }
        return modelos;
    }
    private void marca1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_marca1ItemStateChanged
         if(evt.getStateChange() == ItemEvent.SELECTED){
             if( tipo == 1){
                 this.modelo.setModel(new DefaultComboBoxModel(this.getmodelos(this.marca1.getSelectedItem().toString())));
             }
             else{
            this.modelo.setModel(new DefaultComboBoxModel(this.getmodelos_c(this.marca1.getSelectedItem().toString()))); 
            }
         
        }
        
         
    }//GEN-LAST:event_marca1ItemStateChanged
    public void Modificar (String n_chasis, String n_motor, String anio, String marca, String modelo,
                            String color, String cabina, String puertas, String traccion, int tipo) throws FileNotFoundException, IOException{
       
        
         if(tipo ==1){
           
            int n = Integer.parseInt(n_chasis);
            
            for(int i = 0; i < Vehiculo.vehiculo.size(); i++){
                
                if(Vehiculo.vehiculo.get(i).getNro_chasis() == Integer.parseInt(Buscador.getText())){
                   
                    Vehiculo.vehiculo.remove(Vehiculo.vehiculo.get(i));
                    
                    Auto auto = new Auto (Integer.parseInt(n_chasis),Integer.parseInt(n_motor),marca,color,modelo,anio,Integer.parseInt(puertas));
                   
                    Vehiculo.vehiculo.add(auto);
                    
                    /*for (int j = 0 ; j < Vehiculo.vehiculo.size(); j++){
                        System.out.println(Vehiculo.vehiculo.get(j));
                    } 
                    */
                }
            }
            
            
            
            
            File file = new File("autos.txt");
                    if(file.exists()){
                          PrintWriter autoosr = new PrintWriter(file);
                          autoosr.close();
                    }
                    
                   
            FileWriter autsr = new FileWriter(file, true);
            BufferedWriter autsb = new BufferedWriter(autsr);

            autsb.write("nro_chasis nro_motor marca color modelo anio cant_puertas");
            
                    for(int j = 0;j< Vehiculo.vehiculo.size();j++){
                        
                            if(Vehiculo.vehiculo.get(j) instanceof Auto) {
                                
                                Auto cc = (Auto) Vehiculo.vehiculo.get(j);
                                    autsb.write("\n");
                                    autsb.write(Vehiculo.vehiculo.get(j).getNro_chasis() + " " + Vehiculo.vehiculo.get(j).getNro_motor() + " " + Vehiculo.vehiculo.get(j).getMarca() + " " + Vehiculo.vehiculo.get(j).getColor() + " " + Vehiculo.vehiculo.get(j).getModelo() + " " + Vehiculo.vehiculo.get(j).getAnio() + " " + cc.getCant_puertas());
                                    
                            }
                    }
                    autsb.close();
                    autsr.close();
                   
            
                    n_chasis1.setText(null);
                    n_motor1.setText(null);
               
                   
      
                    anio1.setText(null);

                    cabina1.setText(null);
                    cabina1.setEnabled(true);
                    traccion1.setEnabled(true);
             
            }else{
             int n = Integer.parseInt(n_chasis);
            
            for(int i = 0; i < Vehiculo.vehiculo.size(); i++){
                
                if(Vehiculo.vehiculo.get(i).getNro_chasis() == Integer.parseInt(Buscador.getText())){
                   
                    Vehiculo.vehiculo.remove(Vehiculo.vehiculo.get(i));
                    
                    Camioneta camioneta = new Camioneta (Integer.parseInt(n_chasis),Integer.parseInt(n_motor),color,marca,modelo,anio,traccion,cabina);
                   
                    Vehiculo.vehiculo.add(camioneta);
                    
                    /*for (int j = 0 ; j < Vehiculo.vehiculo.size(); j++){
                        System.out.println(Vehiculo.vehiculo.get(j));
                    } 
                    */
                }
            }
            File file = new File("camionetas.txt");
                    if(file.exists()){
                          PrintWriter autoosr = new PrintWriter(file);
                          autoosr.close();
                    }
                    
                   
            FileWriter autsr = new FileWriter(file, true);
            BufferedWriter autsb = new BufferedWriter(autsr);

            autsb.write("nro_chasis nro_motor color marca modelo anio traccion tpo_cabina");
            
                    for(int j = 0;j< Vehiculo.vehiculo.size();j++){
                        
                            if(Vehiculo.vehiculo.get(j) instanceof Camioneta) {
                                
                                Camioneta cc = (Camioneta) Vehiculo.vehiculo.get(j);
                                    autsb.write("\n");
                                    autsb.write(Vehiculo.vehiculo.get(j).getNro_chasis() + " " + Vehiculo.vehiculo.get(j).getNro_motor() + " " + Vehiculo.vehiculo.get(j).getColor()+ " " + Vehiculo.vehiculo.get(j).getMarca() + " " + Vehiculo.vehiculo.get(j).getModelo() + " " + Vehiculo.vehiculo.get(j).getAnio() + " " + cc.getTraccion() + " " + cc.getTpo_cabina());
                                    
                            }
                    }
                    autsb.close();
                    autsr.close();
                    
                    n_chasis1.setText(null);
                    n_motor1.setText(null);
                 
                    
       
                    anio1.setText(null);
           
                    cabina1.setText(null);
                    puertas1.setEnabled(true);
            
            
             
         }
         
            
        
        
        }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel B_buscar;
    private javax.swing.JTextField Buscador;
    private javax.swing.JTextField anio1;
    private javax.swing.JTextField cabina1;
    private javax.swing.JComboBox<String> color1;
    private javax.swing.JLabel confirmar;
    private javax.swing.JPanel info;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JComboBox<String> marca1;
    private javax.swing.JComboBox<String> modelo;
    private javax.swing.JTextField n_chasis1;
    private javax.swing.JTextField n_motor1;
    private javax.swing.JComboBox<String> puertas1;
    private javax.swing.JComboBox<String> traccion1;
    // End of variables declaration//GEN-END:variables
}
