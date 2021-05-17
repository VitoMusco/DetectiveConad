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
    private ImageIcon menu,selettorePartita;
    private boolean creazioneNuovaPartita = false;
    
    public Interfaccia(GestoreAzioni g) {
        initComponents();
        inizializzaFinestra();
        caricamento = new ImageIcon[4];
        menu = new ImageIcon("./risorse/immagini/menu/menu.png");
        selettorePartita = new ImageIcon("./risorse/immagini/menu/salvataggi.png");
        
        jButton2.addActionListener(g);
        jButton2.setActionCommand("ESCI");
        
        jButton3.addActionListener(g);
        jButton3.setActionCommand("NUOVA_PARTITA");
        
        IniziaPartita.addActionListener(g);
        IniziaPartita.setActionCommand("INIZIA_PARTITA");
        
        SalvataggiEsci.addActionListener(g);
        SalvataggiEsci.setActionCommand("MENU_INIZIALE");
        
        CreaSalvataggioEsci.addActionListener(g);
        CreaSalvataggioEsci.setActionCommand("CREA_SALVATAGGIO_ESCI");
        
        NuovaPartita.addActionListener(g);
        NuovaPartita.setActionCommand("CREA_PARTITA");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        SalvataggiEsci = new javax.swing.JButton();
        NuovaPartita = new javax.swing.JButton();
        CreaSalvataggioEsci = new javax.swing.JButton();
        IniziaPartita = new javax.swing.JButton();
        CreaSalvataggioLabel = new javax.swing.JLabel();
        MediaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage((new ImageIcon("./risorse/immagini/icona/icona.png")).getImage());
        setName("Detective Conad"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setEnabled(false);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 150, 40));

        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setEnabled(false);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 150, 40));

        SalvataggiEsci.setIcon(new ImageIcon("./risorse/immagini/menu/pulsante_uscita.png"));
        SalvataggiEsci.setBorder(null);
        SalvataggiEsci.setBorderPainted(false);
        SalvataggiEsci.setContentAreaFilled(false);
        SalvataggiEsci.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SalvataggiEsci.setDisabledIcon(new ImageIcon("./risorse/immagini/menu/pulsante_piccolo_disabilitato.png"));
        SalvataggiEsci.setEnabled(false);
        SalvataggiEsci.setMargin(null);
        SalvataggiEsci.setMinimumSize(new java.awt.Dimension(44, 44));
        SalvataggiEsci.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/pulsante_uscita_highlited.png"));
        jPanel1.add(SalvataggiEsci, new org.netbeans.lib.awtextra.AbsoluteConstraints(1175, 40, 44, 44));

        NuovaPartita.setIcon(new ImageIcon("./risorse/immagini/menu/nuova_partita.png"));
        NuovaPartita.setBorder(null);
        NuovaPartita.setBorderPainted(false);
        NuovaPartita.setContentAreaFilled(false);
        NuovaPartita.setDisabledIcon(new ImageIcon("./risorse/immagini/menu/pulsante_medio_disabilitato.png"));
        NuovaPartita.setEnabled(false);
        NuovaPartita.setMargin(null);
        NuovaPartita.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/nuova_partita_highlited.png"));
        jPanel1.add(NuovaPartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 367, 81));

        CreaSalvataggioEsci.setIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio_uscita.png"));
        CreaSalvataggioEsci.setToolTipText("");
        CreaSalvataggioEsci.setBorder(null);
        CreaSalvataggioEsci.setBorderPainted(false);
        CreaSalvataggioEsci.setContentAreaFilled(false);
        CreaSalvataggioEsci.setDisabledIcon(new ImageIcon("./risorse/immagini/menu/pulsante_piccolo_disabilitato.png"));
        CreaSalvataggioEsci.setEnabled(false);
        CreaSalvataggioEsci.setMargin(null);
        CreaSalvataggioEsci.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio_uscita_highlited.png"));
        jPanel1.add(CreaSalvataggioEsci, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 150, 44, 44));

        IniziaPartita.setIcon(new ImageIcon("./risorse/immagini/menu/inizia_partita.png"));
        IniziaPartita.setBorder(null);
        IniziaPartita.setBorderPainted(false);
        IniziaPartita.setContentAreaFilled(false);
        IniziaPartita.setDisabledIcon(new ImageIcon("./risorse/immagini/menu/pulsante_medio_disabilitato.png"));
        IniziaPartita.setEnabled(false);
        IniziaPartita.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/inizia_partita_highlited.png"));
        jPanel1.add(IniziaPartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 367, 81));

        CreaSalvataggioLabel.setIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio.png"));
        CreaSalvataggioLabel.setDisabledIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio_disabilitato.png"));
        CreaSalvataggioLabel.setEnabled(false);
        jPanel1.add(CreaSalvataggioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
        jPanel1.add(MediaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreaSalvataggioEsci;
    private javax.swing.JLabel CreaSalvataggioLabel;
    private javax.swing.JButton IniziaPartita;
    private javax.swing.JLabel MediaLabel;
    private javax.swing.JButton NuovaPartita;
    private javax.swing.JButton SalvataggiEsci;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
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
        this.MediaLabel.setIcon(caricamento[0]);
        String prefisso = "";
        for (int i = 0; i <= 99; i++) {
            if (i == 30) {
                MediaLabel.setIcon(caricamento[1]);
            }
            if (i == 60) {
                MediaLabel.setIcon(caricamento[2]);
            }
            if (i == 90) {
                MediaLabel.setIcon(caricamento[3]);
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
            MediaLabel.setIcon(intro[i]);
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
        MediaLabel.setIcon(caricamento[0]);
        String prefisso = "";
        for (int i = 0; i <= 924; i++) {
            if (i == 300) {
                MediaLabel.setIcon(caricamento[1]);
            } else if (i == 600) {
                MediaLabel.setIcon(caricamento[2]);
            } else if (i == 900) {
                MediaLabel.setIcon(caricamento[3]);
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
            MediaLabel.setIcon(introduzione[i]);
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
    }
    
    public void inizializzaMenu() {
        attivaPulsanti();
        MediaLabel.setIcon(menu);
    }

    public void inizializzaSelettorePartita(){
        disattivaPulsanti();
        SalvataggiEsci.setEnabled(true);
        NuovaPartita.setEnabled(true);
        MediaLabel.setIcon(selettorePartita);
    }
    
    public void esciDaSelettorePartita(){
        SalvataggiEsci.setEnabled(false);
        NuovaPartita.setEnabled(false);
        esciDaCreatorePartita();
        inizializzaMenu();
    }
    
    public void inizializzaCreatorePartita(){
        CreaSalvataggioLabel.setEnabled(true);
        CreaSalvataggioEsci.setEnabled(true);
        IniziaPartita.setEnabled(true);
    }
    
    public void esciDaCreatorePartita(){
        CreaSalvataggioLabel.setEnabled(false);
        CreaSalvataggioEsci.setEnabled(false);
        IniziaPartita.setEnabled(false);
    }
    
}
