package Modelli;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import Modelli.Eseguibile.GestoreAzioni;

public class Interfaccia extends javax.swing.JFrame {

    private ImageIcon[] caricamento;
    private ImageIcon menu;
    private boolean creazioneNuovaPartita = false;
    
    public Interfaccia(GestoreAzioni g) {
        initComponents();
        inizializzaFinestra();
        caricamento = new ImageIcon[4];
        menu = new ImageIcon("./risorse/immagini/menu/menu.png");
        
        jButton2.addActionListener(g);
        jButton2.setActionCommand("ESCI");
        
        jButton3.addActionListener(g);
        jButton3.setActionCommand("NUOVA_PARTITA");
        
        jButton1.addActionListener(g);
        jButton1.setActionCommand("INIZIA_PARTITA");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage((new ImageIcon("./risorse/immagini/icona/icona.png")).getImage());
        setName("Detective Conad"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setToolTipText("");
        jLabel2.setEnabled(false);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 160, -1));

        jTextField1.setToolTipText("");
        jTextField1.setBorder(null);
        jTextField1.setEnabled(false);
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 150, -1));

        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setEnabled(false);
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 330, 180));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setEnabled(false);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 150, 40));

        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setEnabled(false);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    
    public void inizializzaFinestra() {
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void caricaImmaginiCaricamento() {
        for (int i = 0; i <= 3; i++) {
            caricamento[i] = new ImageIcon("./risorse/immagini/caricamento/caricamento" + i + ".png");
        }
    }

    public void riproduciAudio(String nome) {
        File fileAudio = new File("./risorse/audio/" + nome + ".wav");
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

    public void chiediNomePartita(){
        jButton1.setOpaque(true);
        jButton1.setContentAreaFilled(true);
        jButton1.setBorderPainted(true);
        jButton1.setEnabled(true);
        jButton1.setText("INIZIA PARTITA");
        jTextField1.setOpaque(true);
        jTextField1.setEnabled(true);
        jTextField1.setToolTipText("Inserisci nome partita");
        jLabel2.setEnabled(true);
        jLabel2.setText("Dai un nome alla tua partita");
    }
    
    public void disabilitaChiediNomePartita(){
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.setEnabled(false);
        jButton1.setText("");
        jTextField1.setOpaque(false);
        jTextField1.setEnabled(false);
        jTextField1.setToolTipText("");
        jLabel2.setEnabled(false);
        jLabel2.setText("");
    }
    
    public String getNomePartita(){
        return jTextField1.getText();
    }
    
    public void creaNuovaPartita(){
        creazioneNuovaPartita = true;
    }
    
    public boolean controllaStato(){
        do{
            if(creazioneNuovaPartita == false){
                System.out.print("");
            }
            if(creazioneNuovaPartita == true){
                creazioneNuovaPartita = false;
                return true;
            }
        }while(creazioneNuovaPartita == false);
        return true;
    }
    
    public void riproduciIntro() {
        disattivaPulsanti();
        ImageIcon[] intro = new ImageIcon[100];
        this.jLabel1.setIcon(caricamento[0]);
        String prefisso = "";
        for (int i = 0; i <= 99; i++) {
            if (i == 30) {
                jLabel1.setIcon(caricamento[1]);
            }
            if (i == 60) {
                jLabel1.setIcon(caricamento[2]);
            }
            if (i == 90) {
                jLabel1.setIcon(caricamento[3]);
            }
            if (i < 10) {
                prefisso = "000";
            }
            if (i < 100) {
                prefisso = "00";
            }
            intro[i] = new ImageIcon("./risorse/immagini/intro/image" + prefisso + i + ".jpg");
        }
        riproduciAudio("intro");
        for (int i = 0; i <= 99; i++) {
            jLabel1.setIcon(intro[i]);
            try {
                TimeUnit.MILLISECONDS.sleep(39);
            } catch (InterruptedException ex) {
                Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void riproduciIntroduzione() {
        disattivaPulsanti();
        ImageIcon[] introduzione = new ImageIcon[925];
        jLabel1.setIcon(caricamento[0]);
        String prefisso = "";
        for (int i = 0; i <= 924; i++) {
            if (i == 300) {
                jLabel1.setIcon(caricamento[1]);
            } else if (i == 600) {
                jLabel1.setIcon(caricamento[2]);
            } else if (i == 900) {
                jLabel1.setIcon(caricamento[3]);
            }
            if (i < 10) {
                prefisso = "000";
            } else if (i < 100) {
                prefisso = "00";
            } else if (i < 1000) {
                prefisso = "0";
            }
            introduzione[i] = new ImageIcon("./risorse/immagini/iniziogioco/image" + prefisso + i + ".jpg");
        }
        riproduciAudio("introduzione");
        for (int i = 0; i <= 924; i++) {
            jLabel1.setIcon(introduzione[i]);
            try {
                TimeUnit.MILLISECONDS.sleep(39);
            } catch (InterruptedException ex) {
                Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void attivaPulsanti(){
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
    }
    public void disattivaPulsanti(){
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jButton2.setEnabled(false);
        jButton2.setText("");
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setBorderPainted(false);
        jButton3.setEnabled(false);
        jButton3.setText("");
        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setBorderPainted(false);
        jButton4.setEnabled(false);
        jButton4.setText("");
    }
    
    public void inizializzaMenu() {
        attivaPulsanti();
        jLabel1.setIcon(menu);
    }

}
