/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinica.Vista;



import Clinica.Modelo.daoBitacora;
import Clinica.Controlador.clsUsuarioConectado;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import Clinica.Controlador.clsBitacora;
import Clinica.Controlador.clsPerfil;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author visitante
 */
public class frmMantenimientoBitacora extends javax.swing.JInternalFrame {

    public void llenadoDeCombos() {

    }

 public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID ");
        modelo.addColumn("Fecha");
        modelo.addColumn("Accion");
         modelo.addColumn("Id Usuario");
          modelo.addColumn("Id Aplicacion");
           modelo.addColumn("IP");
            modelo.addColumn("Nombre PC");
        daoBitacora aplicacionDAO = new daoBitacora();
        List<clsBitacora> aplicaciones = aplicacionDAO.select();
        tablaAplicaciones.setModel(modelo);
        String[] dato = new String[7];
        for (int i = 0; i < aplicaciones.size(); i++) {
            dato[0] = Integer.toString(aplicaciones.get(i).getIdBitacora());
            dato[1] = aplicaciones.get(i).getFechaBitacora();
            dato[2] = aplicaciones.get(i). getAccionBitacora();
               dato[3] = Integer.toString(aplicaciones.get(i).getIdUsuario());
               dato[4] = Integer.toString(aplicaciones.get(i).getIdAplicacion());
               dato[5] = aplicaciones.get(i).getIpBitacora();
                dato[6] = aplicaciones.get(i).getNombrePcBitacora();
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void buscaraplicacion() {

    }
      public void buscarfechas() throws ParseException {
          String Primerafecha= txtNombre.getText();
          String Segundafecha= txtEstado.getText();
        
     DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID ");
        modelo.addColumn("Fecha");
        modelo.addColumn("Accion");
         modelo.addColumn("Id Usuario");
          modelo.addColumn("Id Aplicacion");
           modelo.addColumn("IP");
            modelo.addColumn("Nombre PC");
        clsBitacora bitacora = new clsBitacora();
        //VendedorDAO vendedorDAO = new VendedorDAO();
        List<clsBitacora> aplicaciones = bitacora.getListadoBitacora(Primerafecha, Segundafecha);
        tablaAplicaciones.setModel(modelo);
        String[] dato = new String[7];
        for (int i = 0; i < aplicaciones.size(); i++) {
            dato[0] = Integer.toString(aplicaciones.get(i).getIdBitacora());
            dato[1] = aplicaciones.get(i).getFechaBitacora();
            dato[2] = aplicaciones.get(i). getAccionBitacora();
               dato[3] = Integer.toString(aplicaciones.get(i).getIdUsuario());
               dato[4] = Integer.toString(aplicaciones.get(i).getIdAplicacion());
               dato[5] = aplicaciones.get(i).getIpBitacora();
                dato[6] = aplicaciones.get(i).getNombrePcBitacora();
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    
   
    }

    public frmMantenimientoBitacora() {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAplicaciones = new javax.swing.JTable();
        txtEstado = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        btnBuscar1 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Bitacora");
        setVisible(true);

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Bitacora");

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Primera Fecha");

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtNombre.setOpaque(false);

        tablaAplicaciones.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaAplicaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Aplicacion", "Nombre", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAplicaciones);

        txtEstado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtEstado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtEstado.setOpaque(false);

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Segunda Fecha");

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");

        btnBuscar1.setText("Reiniciar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label3)
                            .addComponent(label5))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(txtNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(294, 294, 294))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5)))
                            .addComponent(lb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar1)
                            .addComponent(btnBuscar))
                        .addGap(89, 89, 89))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
        llenadoDeTablas() ;
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            // TODO add your handling code here:
            buscarfechas();
        } catch (ParseException ex) {
            Logger.getLogger(frmMantenimientoBitacora.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaAplicaciones;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
