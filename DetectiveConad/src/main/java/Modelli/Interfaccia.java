package Modelli;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Interfaccia extends javax.swing.JFrame {

    public Interfaccia() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Detective Conad"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 150, 40));

        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setEnabled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 150, 40));

        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setEnabled(false);
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 150, 40));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        Mappa mappa = new Mappa();
        Interfaccia interfaccia = new Interfaccia();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                interfaccia.setLocationRelativeTo(null);
                interfaccia.setVisible(true);
            }
        });
        interfaccia.riproduciAudioIntro();
        interfaccia.riproduciIntro();
        interfaccia.riproduciAudioIntroduzione();
        interfaccia.riproduciIntroduzione();
        interfaccia.riproduciAudioMenu();
        interfaccia.impostaMenuIniziale();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void riproduciAudioIntro() {
        File fileAudio = new File("./risorse/audio/intro.wav");
        AudioInputStream audioStream;
        try {
            audioStream = AudioSystem.getAudioInputStream(fileAudio);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void riproduciIntro() {
        String prefisso = "";
        for (int i = 0; i <= 99; i++) {
            if (i < 10) {
                prefisso = "000";
            } else if (i < 100) {
                prefisso = "00";
            }
            jLabel1.setIcon(new ImageIcon("./risorse/immagini/intro/image" + prefisso + i + ".jpg"));
            try {
                TimeUnit.MILLISECONDS.sleep(29);
            } catch (InterruptedException ex) {
                Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void riproduciAudioMenu(){
        File fileAudio = new File("./risorse/audio/menu.wav");
        AudioInputStream audioStream;
        try {
            audioStream = AudioSystem.getAudioInputStream(fileAudio);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void impostaMenuIniziale() {
        jButton2.setOpaque(true);
        jButton2.setContentAreaFilled(true);
        jButton2.setBorderPainted(true);
        jButton2.setEnabled(true);
        jButton2.setText("ESCI");
        jButton3.setOpaque(true);
        jButton3.setContentAreaFilled(true);
        jButton3.setBorderPainted(true);
        jButton3.setEnabled(true);
        jButton3.setText("NUOVA PARTITA");
        jButton4.setOpaque(true);
        jButton4.setContentAreaFilled(true);
        jButton4.setBorderPainted(true);
        jButton4.setEnabled(true);
        jButton4.setText("CARICA PARTITA");
        jLabel1.setIcon(new ImageIcon("./risorse/immagini/menu/menu.png"));
    }
    
    public void riproduciAudioIntroduzione(){
        File fileAudio = new File("./risorse/audio/introduzione.wav");
        AudioInputStream audioStream;
        try {
            audioStream = AudioSystem.getAudioInputStream(fileAudio);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void riproduciIntroduzione(){
        String prefisso = "";
        for (int i = 0; i <= 924; i++) {
            if (i < 10) {
                prefisso = "000";
            } else if (i < 100) {
                prefisso = "00";
            } else if (i < 1000) {
                prefisso = "0";
            }
            jLabel1.setIcon(new ImageIcon("./risorse/immagini/iniziogioco/image" + prefisso + i + ".jpg"));
            try {
                TimeUnit.MILLISECONDS.sleep(29);
            } catch (InterruptedException ex) {
                Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
