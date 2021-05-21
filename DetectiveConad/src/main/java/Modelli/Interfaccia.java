package Modelli;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import Modelli.Eseguibile.GestoreAzioni;
import java.awt.Color;

public class Interfaccia extends javax.swing.JFrame {

    private final ImageIcon menu, selettorePartita;
    private boolean creazioneNuovaPartita = false;
    Clip audio;

    public Interfaccia(GestoreAzioni g) {
        initComponents();
        inizializzaFinestra();
        menu = new ImageIcon("./risorse/immagini/menu/menu.png");
        selettorePartita = new ImageIcon("./risorse/immagini/menu/salvataggi.png");

        disattivaInterfacciaMenu();
        disattivaInterfacciaUtente();

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

        NuovaPartita1.addActionListener(g);
        NuovaPartita1.setActionCommand("CREA_PARTITA");

        ApriEditor.addActionListener(g);
        ApriEditor.setActionCommand("APRI_EDITOR");

        ApriTelefono.addActionListener(g);
        ApriTelefono.setActionCommand("APRI_TELEFONO");
        
        PulsanteSalta.addActionListener(g);
        PulsanteSalta.setActionCommand("SALTA_VIDEO");

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PulsanteEsci = new javax.swing.JButton();
        PulsanteCrediti = new javax.swing.JButton();
        PulsanteIndaga = new javax.swing.JButton();
        SalvataggiEsci = new javax.swing.JButton();
        CreaSalvataggioEsci = new javax.swing.JButton();
        IniziaPartita = new javax.swing.JButton();
        NomePartita = new javax.swing.JTextField();
        ErroreMaxCaratteri = new javax.swing.JLabel();
        ErroreNoCaratteri = new javax.swing.JLabel();
        CreaSalvataggioLabel = new javax.swing.JLabel();
        NuovaPartita1 = new javax.swing.JButton();
        NuovaPartita2 = new javax.swing.JButton();
        NuovaPartita3 = new javax.swing.JButton();
        NuovaPartita4 = new javax.swing.JButton();
        ScriviTesto = new javax.swing.JTextField();
        CasellaTesto = new javax.swing.JScrollPane();
        ScritturaTesto = new javax.swing.JTextArea();
        GraficaEditor = new javax.swing.JLabel();
        GraficaCellulare = new javax.swing.JLabel();
        ApriEditor = new javax.swing.JButton();
        ApriTelefono = new javax.swing.JButton();
        PulsanteSalta = new javax.swing.JButton();
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
        jPanel1.add(PulsanteEsci, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 230, 50));

        PulsanteCrediti.setIcon(new ImageIcon("./risorse/immagini/menu/crediti.png"));
        PulsanteCrediti.setBorder(null);
        PulsanteCrediti.setBorderPainted(false);
        PulsanteCrediti.setContentAreaFilled(false);
        PulsanteCrediti.setEnabled(false);
        PulsanteCrediti.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/crediti_highlighted.png"));
        jPanel1.add(PulsanteCrediti, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 230, 50));

        PulsanteIndaga.setIcon(new ImageIcon("./risorse/immagini/menu/indaga.png"));
        PulsanteIndaga.setBorder(null);
        PulsanteIndaga.setBorderPainted(false);
        PulsanteIndaga.setContentAreaFilled(false);
        PulsanteIndaga.setEnabled(false);
        PulsanteIndaga.setMargin(null);
        PulsanteIndaga.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/indaga_highlighted.png"));
        jPanel1.add(PulsanteIndaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 230, 50));

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
        NomePartita.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NomePartita.setEnabled(false);
        NomePartita.setMargin(null);
        NomePartita.setName(""); // NOI18N
        jPanel1.add(NomePartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 210, 35));

        ErroreMaxCaratteri.setIcon(new ImageIcon("./risorse/immagini/menu/errore_max_caratteri.png"));
        ErroreMaxCaratteri.setEnabled(false);
        jPanel1.add(ErroreMaxCaratteri, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 270, 50));

        ErroreNoCaratteri.setIcon(new ImageIcon("./risorse/immagini/menu/errore_no_caratteri.png"));
        ErroreNoCaratteri.setEnabled(false);
        jPanel1.add(ErroreNoCaratteri, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 270, 50));

        CreaSalvataggioLabel.setIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio.png"));
        CreaSalvataggioLabel.setDisabledIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio_disabilitato.png"));
        CreaSalvataggioLabel.setEnabled(false);
        jPanel1.add(CreaSalvataggioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        NuovaPartita1.setIcon(new ImageIcon("./risorse/immagini/menu/nuova_partita.png"));
        NuovaPartita1.setBorder(null);
        NuovaPartita1.setBorderPainted(false);
        NuovaPartita1.setContentAreaFilled(false);
        NuovaPartita1.setEnabled(false);
        NuovaPartita1.setMargin(null);
        NuovaPartita1.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/nuova_partita_highlighted.png"));
        jPanel1.add(NuovaPartita1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 367, 81));

        NuovaPartita2.setIcon(new ImageIcon("./risorse/immagini/menu/nuova_partita.png"));
        NuovaPartita2.setBorder(null);
        NuovaPartita2.setBorderPainted(false);
        NuovaPartita2.setContentAreaFilled(false);
        NuovaPartita2.setEnabled(false);
        NuovaPartita2.setMargin(null);
        NuovaPartita2.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/nuova_partita_highlighted.png"));
        jPanel1.add(NuovaPartita2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 367, 81));

        NuovaPartita3.setIcon(new ImageIcon("./risorse/immagini/menu/nuova_partita.png"));
        NuovaPartita3.setBorder(null);
        NuovaPartita3.setBorderPainted(false);
        NuovaPartita3.setContentAreaFilled(false);
        NuovaPartita3.setEnabled(false);
        NuovaPartita3.setMargin(null);
        NuovaPartita3.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/nuova_partita_highlighted.png"));
        jPanel1.add(NuovaPartita3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 367, 81));

        NuovaPartita4.setIcon(new ImageIcon("./risorse/immagini/menu/nuova_partita.png"));
        NuovaPartita4.setBorder(null);
        NuovaPartita4.setBorderPainted(false);
        NuovaPartita4.setContentAreaFilled(false);
        NuovaPartita4.setEnabled(false);
        NuovaPartita4.setMargin(null);
        NuovaPartita4.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/nuova_partita_highlighted.png"));
        jPanel1.add(NuovaPartita4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 367, 81));

        ScriviTesto.setBackground(new java.awt.Color(0, 0, 0));
        ScriviTesto.setBorder(null);
        ScriviTesto.setMargin(null);
        jPanel1.add(ScriviTesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 820, 30));

        CasellaTesto.setBackground(new java.awt.Color(0, 0, 0));
        CasellaTesto.setBorder(null);
        CasellaTesto.setForeground(new java.awt.Color(255, 255, 255));
        CasellaTesto.setAutoscrolls(true);

        ScritturaTesto.setEditable(false);
        ScritturaTesto.setBackground(new java.awt.Color(0, 0, 0));
        ScritturaTesto.setColumns(20);
        ScritturaTesto.setForeground(new java.awt.Color(255, 255, 255));
        ScritturaTesto.setLineWrap(true);
        ScritturaTesto.setRows(5);
        ScritturaTesto.setBorder(null);
        ScritturaTesto.setMargin(null);
        ScritturaTesto.setOpaque(false);
        CasellaTesto.setViewportView(ScritturaTesto);

        jPanel1.add(CasellaTesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 920, 540));

        GraficaEditor.setIcon(new ImageIcon("./risorse/immagini/interfaccia/testo.png"));
        jPanel1.add(GraficaEditor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 960, 670));

        GraficaCellulare.setIcon(new ImageIcon("./risorse/immagini/interfaccia/telefono.png"));
        jPanel1.add(GraficaCellulare, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 270, 670));

        ApriEditor.setIcon(new ImageIcon("./risorse/immagini/interfaccia/pulsante_testo.png"));
        ApriEditor.setBorder(null);
        ApriEditor.setBorderPainted(false);
        ApriEditor.setContentAreaFilled(false);
        ApriEditor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ApriEditor.setMargin(null);
        jPanel1.add(ApriEditor, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 120, 144));

        ApriTelefono.setIcon(new ImageIcon("./risorse/immagini/interfaccia/pulsante_telefono.png"));
        ApriTelefono.setBorder(null);
        ApriTelefono.setBorderPainted(false);
        ApriTelefono.setContentAreaFilled(false);
        ApriTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ApriTelefono.setMargin(null);
        jPanel1.add(ApriTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 40, 120, 144));

        PulsanteSalta.setIcon(new ImageIcon("./risorse/immagini/menu/salta_filmato.png"));
        PulsanteSalta.setBorder(null);
        PulsanteSalta.setBorderPainted(false);
        PulsanteSalta.setContentAreaFilled(false);
        PulsanteSalta.setEnabled(false);
        PulsanteSalta.setMargin(null);
        PulsanteSalta.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/salta_filmato_highlighted.png"));
        jPanel1.add(PulsanteSalta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 610, 190, 90));
        jPanel1.add(MediaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApriEditor;
    private javax.swing.JButton ApriTelefono;
    private javax.swing.JScrollPane CasellaTesto;
    private javax.swing.JButton CreaSalvataggioEsci;
    private javax.swing.JLabel CreaSalvataggioLabel;
    private javax.swing.JLabel ErroreMaxCaratteri;
    private javax.swing.JLabel ErroreNoCaratteri;
    private javax.swing.JLabel GraficaCellulare;
    private javax.swing.JLabel GraficaEditor;
    private javax.swing.JButton IniziaPartita;
    private javax.swing.JLabel MediaLabel;
    private javax.swing.JTextField NomePartita;
    private javax.swing.JButton NuovaPartita1;
    private javax.swing.JButton NuovaPartita2;
    private javax.swing.JButton NuovaPartita3;
    private javax.swing.JButton NuovaPartita4;
    private javax.swing.JButton PulsanteCrediti;
    private javax.swing.JButton PulsanteEsci;
    private javax.swing.JButton PulsanteIndaga;
    private javax.swing.JButton PulsanteSalta;
    private javax.swing.JButton SalvataggiEsci;
    private javax.swing.JTextArea ScritturaTesto;
    private javax.swing.JTextField ScriviTesto;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void inizializzaFinestra() {
        setLocationRelativeTo(null);
        setVisible(true);
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

    public void stoppaAudio() {
        audio.close();
        audio.stop();
    }

    public void creaNuovaPartita() {
        chiudiSelettorePartita();
        creazioneNuovaPartita = true;
    }

    public boolean controllaStato() {
        do {
            if (creazioneNuovaPartita == false) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (creazioneNuovaPartita == true) {
                creazioneNuovaPartita = false;
                return true;
            }
        } while (creazioneNuovaPartita == false);
        return true;
    }

    public void riproduciIntro() {
        disattivaPulsantiMenu();
        MediaLabel.setIcon(new ImageIcon("./risorse/gif/intro.gif"));
        riproduciAudio("intro");
        try {
            TimeUnit.MILLISECONDS.sleep(4300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void riproduciIntroduzione() {
        stoppaAudio();
        disattivaPulsantiMenu();
        mostraPulsanteSalta();
        MediaLabel.setIcon(new ImageIcon("./risorse/gif/videointroduzione.gif"));
        riproduciAudio("videointroduzione");
        try {
            TimeUnit.SECONDS.sleep(38);
        } catch (InterruptedException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        }
        disattivaPulsanteSalta();
    }

    public void attivaPulsantiMenu() {
        PulsanteIndaga.setEnabled(true);
        PulsanteCrediti.setEnabled(true);
        PulsanteEsci.setEnabled(true);
        PulsanteIndaga.setVisible(true);
        PulsanteCrediti.setVisible(true);
        PulsanteEsci.setVisible(true);
    }

    public void disattivaPulsantiMenu() {
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

    public void inizializzaSelettorePartita() {
        disattivaPulsantiMenu();
        SalvataggiEsci.setEnabled(true);
        NuovaPartita1.setEnabled(true);
        NuovaPartita2.setEnabled(true);
        NuovaPartita3.setEnabled(true);
        NuovaPartita4.setEnabled(true);
        SalvataggiEsci.setVisible(true);
        NuovaPartita1.setVisible(true);
        NuovaPartita2.setVisible(true);
        NuovaPartita3.setVisible(true);
        NuovaPartita4.setVisible(true);
        MediaLabel.setIcon(selettorePartita);
    }

    public void esciDaSelettorePartita() {
        chiudiSelettorePartita();
        inizializzaMenu();
    }

    public void chiudiSelettorePartita() {
        SalvataggiEsci.setEnabled(false);
        NuovaPartita1.setEnabled(false);
        NuovaPartita2.setEnabled(false);
        NuovaPartita3.setEnabled(false);
        NuovaPartita4.setEnabled(false);
        SalvataggiEsci.setVisible(false);
        NuovaPartita1.setVisible(false);
        NuovaPartita2.setVisible(false);
        NuovaPartita3.setVisible(false);
        NuovaPartita4.setVisible(false);
        esciDaCreatorePartita();
    }

    public void inizializzaCreatorePartita() {
        CreaSalvataggioLabel.setEnabled(true);
        CreaSalvataggioEsci.setEnabled(true);
        IniziaPartita.setEnabled(true);
        NomePartita.setEnabled(true);
        CreaSalvataggioLabel.setVisible(true);
        CreaSalvataggioEsci.setVisible(true);
        IniziaPartita.setVisible(true);
        NomePartita.setVisible(true);
    }

    public void esciDaCreatorePartita() {
        CreaSalvataggioLabel.setEnabled(false);
        CreaSalvataggioEsci.setEnabled(false);
        IniziaPartita.setEnabled(false);
        NomePartita.setEnabled(false);
        ErroreMaxCaratteri.setEnabled(false);
        ErroreNoCaratteri.setEnabled(false);
        CreaSalvataggioLabel.setVisible(false);
        CreaSalvataggioEsci.setVisible(false);
        IniziaPartita.setVisible(false);
        NomePartita.setVisible(false);
        NomePartita.setText(null);
        ErroreMaxCaratteri.setVisible(false);
        ErroreNoCaratteri.setVisible(false);
    }

    //disattiva l'interfaccia del menu
    public void disattivaInterfacciaMenu() {
        PulsanteIndaga.setEnabled(false);
        PulsanteCrediti.setEnabled(false);
        PulsanteEsci.setEnabled(false);
        SalvataggiEsci.setEnabled(false);
        NuovaPartita1.setEnabled(false);
        NuovaPartita2.setEnabled(false);
        NuovaPartita3.setEnabled(false);
        NuovaPartita4.setEnabled(false);
        ErroreMaxCaratteri.setEnabled(false);
        ErroreNoCaratteri.setEnabled(false);
        PulsanteSalta.setEnabled(false);
        SalvataggiEsci.setVisible(false);
        NuovaPartita1.setVisible(false);
        NuovaPartita2.setVisible(false);
        NuovaPartita3.setVisible(false);
        NuovaPartita4.setVisible(false);
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
        ErroreMaxCaratteri.setVisible(false);
        ErroreNoCaratteri.setVisible(false);
        PulsanteSalta.setVisible(false);
    }

    //Inizializza l'interfaccia grafica sul quale si gioca
    public void inizializzaInterfacciaUtente() {
        ApriEditor.setVisible(true);
        ApriTelefono.setVisible(true);

        ApriEditor.setEnabled(true);
        ApriTelefono.setEnabled(true);

        MediaLabel.setIcon(new ImageIcon("./risorse/immagini/interfaccia/sfondo.png"));
    }

    //Disattiva l'interfaccia utente
    public void disattivaInterfacciaUtente() {
        ScriviTesto.setVisible(false);
        CasellaTesto.setVisible(false);
        ScritturaTesto.setVisible(false);
        GraficaCellulare.setVisible(false);
        GraficaEditor.setVisible(false);
        ApriEditor.setVisible(false);
        ApriTelefono.setVisible(false);
    
        ScriviTesto.setEnabled(false);
        CasellaTesto.setEnabled(false);
        ScritturaTesto.setEnabled(false);
        GraficaCellulare.setEnabled(false);
        GraficaEditor.setEnabled(false);
        ApriEditor.setEnabled(false);
        ApriTelefono.setEnabled(false);
    }

    //Mostra l'interfaccia del cellulare
    public void mostraCellulare() {
        GraficaCellulare.setEnabled(true);
        GraficaCellulare.setVisible(true);

        ApriTelefono.setEnabled(false);
        ApriTelefono.setVisible(false);
    }

    public void disattivaCellulare() {
        GraficaCellulare.setEnabled(false);
        GraficaCellulare.setVisible(false);

        ApriTelefono.setEnabled(true);
        ApriTelefono.setVisible(true);
    }

    //Mostra l'interfaccia dell'editor di testo
    public void mostraEditorTesto() {
        GraficaEditor.setVisible(true);
        ScriviTesto.setVisible(true);
        CasellaTesto.setVisible(true);
        ScritturaTesto.setVisible(true);

        GraficaEditor.setEnabled(true);
        ScriviTesto.setEnabled(true);
        CasellaTesto.setEnabled(true);
        ScritturaTesto.setEnabled(true);

        CasellaTesto.setOpaque(true);
        ScritturaTesto.setOpaque(true);
        CasellaTesto.setBackground(Color.black);
        ScritturaTesto.setBackground(Color.black);

        ScritturaTesto.setForeground(Color.white);
        ScriviTesto.setForeground(Color.white);

        ApriEditor.setVisible(false);
        ApriEditor.setEnabled(false);
    }

    public void disattivaEditorTesto() {
        GraficaEditor.setVisible(false);
        ScriviTesto.setVisible(false);
        CasellaTesto.setVisible(false);
        ScritturaTesto.setVisible(false);

        GraficaEditor.setEnabled(false);
        ScriviTesto.setEnabled(false);
        CasellaTesto.setEnabled(false);
        ScritturaTesto.setEnabled(false);

        ApriEditor.setVisible(true);
        ApriEditor.setEnabled(true);
    }

    public void disattivaPulsanteSalta(){
        PulsanteSalta.setEnabled(false);
        PulsanteSalta.setVisible(false);
    }
    
    public void mostraPulsanteSalta(){
        PulsanteSalta.setEnabled(true);
        PulsanteSalta.setVisible(true);
    }
    public void saltaIntroduzione(){
        disattivaPulsanteSalta();
        stoppaAudio();
    }

    
    public boolean controllaNomePartita() {
        if (NomePartita.getText().length() > 16) {
            ErroreNoCaratteri.setEnabled(false);
            ErroreNoCaratteri.setVisible(false);
            ErroreMaxCaratteri.setEnabled(true);
            ErroreMaxCaratteri.setVisible(true);
            return false;
        } else if (NomePartita.getText().length() == 0) {
            ErroreMaxCaratteri.setEnabled(false);
            ErroreMaxCaratteri.setVisible(false);
            ErroreNoCaratteri.setEnabled(true);
            ErroreNoCaratteri.setVisible(true);
            return false;
        } else {
            return true;
        }
    }
    
    public String getNomePartita(){
        return NomePartita.getText();
    }
    
    public void mostraTesto(String messaggio){
        ScritturaTesto.setText(messaggio);
    }
}
