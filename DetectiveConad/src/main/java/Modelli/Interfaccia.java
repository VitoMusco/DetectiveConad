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
    Clip audio;
    
    public Interfaccia(GestoreAzioni g) {
        initComponents();
        inizializzaFinestra();
        caricamento = new ImageIcon[4];
        menu = new ImageIcon("./risorse/immagini/menu/menu.png");
        selettorePartita = new ImageIcon("./risorse/immagini/menu/salvataggi.png");
        
        inizializzaInterfaccia();
        
        PulsanteEsci.addActionListener(g);
        PulsanteEsci.setActionCommand("ESCI");
        
        PulsanteIndaga.addActionListener(g);
        PulsanteIndaga.setActionCommand("NUOVA_PARTITA");
        
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
        PulsanteEsci = new javax.swing.JButton();
        PulsanteCrediti = new javax.swing.JButton();
        PulsanteIndaga = new javax.swing.JButton();
        SalvataggiEsci = new javax.swing.JButton();
        NuovaPartita = new javax.swing.JButton();
        CreaSalvataggioEsci = new javax.swing.JButton();
        IniziaPartita = new javax.swing.JButton();
        NomePartita = new javax.swing.JTextField();
        ErroreMaxCaratteri = new javax.swing.JLabel();
        CreaSalvataggioLabel = new javax.swing.JLabel();
        MediaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage((new ImageIcon("./risorse/immagini/icona/icona.png")).getImage());
        setName("Detective Conad"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PulsanteEsci.setIcon(new ImageIcon("./risorse/immagini/menu/esci.png"));
        PulsanteEsci.setBorder(null);
        PulsanteEsci.setBorderPainted(false);
        PulsanteEsci.setContentAreaFilled(false);
        PulsanteEsci.setEnabled(false);
        PulsanteEsci.setMargin(null);
        PulsanteEsci.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/esci_highlighted.png"));
        jPanel1.add(PulsanteEsci, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 230, 50));

        PulsanteCrediti.setIcon(new ImageIcon("./risorse/immagini/menu/crediti.png"));
        PulsanteCrediti.setBorder(null);
        PulsanteCrediti.setBorderPainted(false);
        PulsanteCrediti.setContentAreaFilled(false);
        PulsanteCrediti.setEnabled(false);
        PulsanteCrediti.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/crediti_highlighted.png"));
        jPanel1.add(PulsanteCrediti, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 230, 50));

        PulsanteIndaga.setIcon(new ImageIcon("./risorse/immagini/menu/indaga.png"));
        PulsanteIndaga.setBorder(null);
        PulsanteIndaga.setBorderPainted(false);
        PulsanteIndaga.setContentAreaFilled(false);
        PulsanteIndaga.setEnabled(false);
        PulsanteIndaga.setMargin(null);
        PulsanteIndaga.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/indaga_highlighted.png"));
        jPanel1.add(PulsanteIndaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 230, 50));

        SalvataggiEsci.setIcon(new ImageIcon("./risorse/immagini/menu/pulsante_uscita.png"));
        SalvataggiEsci.setBorder(null);
        SalvataggiEsci.setBorderPainted(false);
        SalvataggiEsci.setContentAreaFilled(false);
        SalvataggiEsci.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SalvataggiEsci.setEnabled(false);
        SalvataggiEsci.setMargin(null);
        SalvataggiEsci.setMinimumSize(new java.awt.Dimension(44, 44));
        SalvataggiEsci.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/pulsante_uscita_highlighted.png"));
        jPanel1.add(SalvataggiEsci, new org.netbeans.lib.awtextra.AbsoluteConstraints(1175, 40, 44, 44));

        NuovaPartita.setIcon(new ImageIcon("./risorse/immagini/menu/nuova_partita.png"));
        NuovaPartita.setBorder(null);
        NuovaPartita.setBorderPainted(false);
        NuovaPartita.setContentAreaFilled(false);
        NuovaPartita.setEnabled(false);
        NuovaPartita.setMargin(null);
        NuovaPartita.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/nuova_partita_highlighted.png"));
        jPanel1.add(NuovaPartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 367, 81));

        CreaSalvataggioEsci.setIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio_uscita.png"));
        CreaSalvataggioEsci.setToolTipText("");
        CreaSalvataggioEsci.setBorder(null);
        CreaSalvataggioEsci.setBorderPainted(false);
        CreaSalvataggioEsci.setContentAreaFilled(false);
        CreaSalvataggioEsci.setEnabled(false);
        CreaSalvataggioEsci.setMargin(null);
        CreaSalvataggioEsci.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio_uscita_highlighted.png"));
        jPanel1.add(CreaSalvataggioEsci, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 150, 44, 44));

        IniziaPartita.setIcon(new ImageIcon("./risorse/immagini/menu/inizia_partita.png"));
        IniziaPartita.setBorder(null);
        IniziaPartita.setBorderPainted(false);
        IniziaPartita.setContentAreaFilled(false);
        IniziaPartita.setEnabled(false);
        IniziaPartita.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/inizia_partita_highlighted.png"));
        jPanel1.add(IniziaPartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 367, 81));

        NomePartita.setBackground(new java.awt.Color(255, 251, 250));
        NomePartita.setColumns(16);
        NomePartita.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        NomePartita.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        NomePartita.setToolTipText("");
        NomePartita.setAutoscrolls(false);
        NomePartita.setBorder(null);
        NomePartita.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        NomePartita.setEnabled(false);
        NomePartita.setMargin(null);
        NomePartita.setName(""); // NOI18N
        jPanel1.add(NomePartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 210, 35));

        ErroreMaxCaratteri.setIcon(new ImageIcon("./risorse/immagini/menu/errore_max_caratteri.png"));
        ErroreMaxCaratteri.setEnabled(false);
        jPanel1.add(ErroreMaxCaratteri, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 270, 50));

        CreaSalvataggioLabel.setIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio.png"));
        CreaSalvataggioLabel.setDisabledIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio_disabilitato.png"));
        CreaSalvataggioLabel.setEnabled(false);
        jPanel1.add(CreaSalvataggioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        MediaLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vito\\DetectiveConad\\DetectiveConad\\risorse\\immagini\\menu\\menu.png")); // NOI18N
        jPanel1.add(MediaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreaSalvataggioEsci;
    private javax.swing.JLabel CreaSalvataggioLabel;
    private javax.swing.JLabel ErroreMaxCaratteri;
    private javax.swing.JButton IniziaPartita;
    private javax.swing.JLabel MediaLabel;
    private javax.swing.JTextField NomePartita;
    private javax.swing.JButton NuovaPartita;
    private javax.swing.JButton PulsanteCrediti;
    private javax.swing.JButton PulsanteEsci;
    private javax.swing.JButton PulsanteIndaga;
    private javax.swing.JButton SalvataggiEsci;
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
            audio = AudioSystem.getClip();
            audio.open(audioStream);
            audio.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stoppaAudio(){
        audio.stop();
    }
    
    public void creaNuovaPartita(){
        chiudiSelettorePartita();
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
        disattivaPulsantiMenu();
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
        disattivaPulsantiMenu();
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
        stoppaAudio();
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

    public void attivaPulsantiMenu(){
        PulsanteIndaga.setEnabled(true);
        PulsanteCrediti.setEnabled(true);
        PulsanteEsci.setEnabled(true);
        PulsanteIndaga.setVisible(true);
        PulsanteCrediti.setVisible(true);
        PulsanteEsci.setVisible(true);
    }
    public void disattivaPulsantiMenu(){
        PulsanteIndaga.setEnabled(false);
        PulsanteCrediti.setEnabled(false);
        PulsanteEsci.setEnabled(false);
        PulsanteIndaga.setVisible(false);
        PulsanteCrediti.setVisible(false);
        PulsanteEsci.setVisible(false);
    }
    
    public void inizializzaMenu() {
        attivaPulsantiMenu();
        MediaLabel.setIcon(menu);
    }

    public void inizializzaSelettorePartita(){
        disattivaPulsantiMenu();
        SalvataggiEsci.setEnabled(true);
        NuovaPartita.setEnabled(true);
        SalvataggiEsci.setVisible(true);
        NuovaPartita.setVisible(true);
        MediaLabel.setIcon(selettorePartita);
    }
    
    public void esciDaSelettorePartita(){
        SalvataggiEsci.setEnabled(false);
        NuovaPartita.setEnabled(false);
        SalvataggiEsci.setVisible(false);
        NuovaPartita.setVisible(false);
        esciDaCreatorePartita();
        inizializzaMenu();
    }
    
    public void chiudiSelettorePartita(){
        SalvataggiEsci.setEnabled(false);
        NuovaPartita.setEnabled(false);
        SalvataggiEsci.setVisible(false);
        NuovaPartita.setVisible(false);
        esciDaCreatorePartita();
    }
    
    public void inizializzaCreatorePartita(){
        CreaSalvataggioLabel.setEnabled(true);
        CreaSalvataggioEsci.setEnabled(true);
        IniziaPartita.setEnabled(true);
        NomePartita.setEnabled(true);
        CreaSalvataggioLabel.setVisible(true);
        CreaSalvataggioEsci.setVisible(true);
        IniziaPartita.setVisible(true);
        NomePartita.setVisible(true);
    }
    
    public void esciDaCreatorePartita(){
        CreaSalvataggioLabel.setEnabled(false);
        CreaSalvataggioEsci.setEnabled(false);
        IniziaPartita.setEnabled(false);
        NomePartita.setEnabled(false);
        ErroreMaxCaratteri.setEnabled(false);
        CreaSalvataggioLabel.setVisible(false);
        CreaSalvataggioEsci.setVisible(false);
        IniziaPartita.setVisible(false);
        NomePartita.setVisible(false);
        NomePartita.setText(null);
        ErroreMaxCaratteri.setVisible(false);
    }
    
    public void inizializzaInterfaccia(){
        PulsanteIndaga.setEnabled(false);
        PulsanteCrediti.setEnabled(false);
        PulsanteEsci.setEnabled(false);
        SalvataggiEsci.setEnabled(false);
        NuovaPartita.setEnabled(false);
        SalvataggiEsci.setVisible(false);
        NuovaPartita.setVisible(false);
        CreaSalvataggioLabel.setEnabled(false);
        CreaSalvataggioEsci.setEnabled(false);
        IniziaPartita.setEnabled(false);
        NomePartita.setEnabled(false);
        PulsanteIndaga.setVisible(false);
        PulsanteCrediti.setVisible(false);
        PulsanteEsci.setVisible(false);
        CreaSalvataggioLabel.setVisible(false);
        CreaSalvataggioEsci.setVisible(false);
        IniziaPartita.setVisible(false);
        NomePartita.setVisible(false);
        ErroreMaxCaratteri.setEnabled(false);
        ErroreMaxCaratteri.setVisible(false);
    }
    
    public boolean controllaNomePartita(){
        if(NomePartita.getText().length() > 16){
            ErroreMaxCaratteri.setEnabled(true);
            ErroreMaxCaratteri.setVisible(true);
            return false;
        }
        else{
            return true;
        }
    }
}
