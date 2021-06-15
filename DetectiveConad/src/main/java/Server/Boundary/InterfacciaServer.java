/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Boundary;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

/**
 *
 * @author Vito
 */
public class InterfacciaServer extends javax.swing.JFrame {

    public InterfacciaServer() {
        inizializzaInterfaccia();
        initComponents();
    }
    
    public void inizializzaInterfaccia(){
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        AreaTesto = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Detective Conad Server");
        setIconImage((new ImageIcon("./risorse/immagini/icone/icona_server.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AreaTesto.setBackground(new java.awt.Color(0, 0, 0));
        AreaTesto.setColumns(20);
        AreaTesto.setForeground(new java.awt.Color(255, 255, 255));
        AreaTesto.setRows(5);
        jScrollPane1.setViewportView(AreaTesto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 290));

        jButton1.setText("Chiudi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaTesto;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public JTextArea getAreaTesto() {
        return AreaTesto;
    }

    

}
