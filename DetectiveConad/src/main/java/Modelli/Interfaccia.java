package Modelli;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import Modelli.LogicaGioco.GestoreAzioni;
import java.awt.Color;

public class Interfaccia extends javax.swing.JFrame {

    private final ImageIcon menu, selettorePartita;
    private boolean creazioneNuovaPartita = false;
    Clip audio;

    public Interfaccia(GestoreAzioni g) {
        initComponents();
        inizializzaFinestra();
        
        MediaLabel.setName("Background");
        
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
        
        ApriMovimento.addActionListener(g);
        ApriMovimento.setActionCommand("APRI_MOVIMENTO");
        
        PulsanteSalta.addActionListener(g);
        PulsanteSalta.setActionCommand("SALTA_VIDEO");
        
        Su.addActionListener(g);
        Su.setActionCommand("VAI_SU");
        
        Giu.addActionListener(g);
        Giu.setActionCommand("VAI_GIU");
        
        Destra.addActionListener(g);
        Destra.setActionCommand("VAI_DESTRA");
        
        Sinistra.addActionListener(g);
        Sinistra.setActionCommand("VAI_SINISTRA");

        Osserva.addActionListener(g);
        Osserva.setActionCommand("OSSERVA");
        
        Fotocamera.addActionListener(g);
        Fotocamera.setActionCommand("SCATTA_FOTO");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Sinistra = new javax.swing.JButton();
        Destra = new javax.swing.JButton();
        Giu = new javax.swing.JButton();
        Su = new javax.swing.JButton();
        ApriMovimento = new javax.swing.JButton();
        GraficaMovimento = new javax.swing.JLabel();
        Osserva = new javax.swing.JButton();
        Inventario = new javax.swing.JButton();
        Flash = new javax.swing.JButton();
        Usa = new javax.swing.JButton();
        Fotocamera = new javax.swing.JButton();
        Incastra = new javax.swing.JButton();
        Salva = new javax.swing.JButton();
        Opzioni = new javax.swing.JButton();
        Menu = new javax.swing.JButton();
        Apri = new javax.swing.JButton();
        Esci = new javax.swing.JButton();
        Prendi = new javax.swing.JButton();
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

        Sinistra.setIcon(new ImageIcon("./risorse/immagini/interfaccia/sinistra.png"));
        Sinistra.setBorder(null);
        Sinistra.setContentAreaFilled(false);
        Sinistra.setMargin(null);
        Sinistra.setRolloverIcon(new ImageIcon("./risorse/immagini/interfaccia/sinistra_highlighted.png"));
        Sinistra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SinistraActionPerformed(evt);
            }
        });
        jPanel1.add(Sinistra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 610, 60, 60));

        Destra.setIcon(new ImageIcon("./risorse/immagini/interfaccia/destra.png"));
        Destra.setBorder(null);
        Destra.setContentAreaFilled(false);
        Destra.setMargin(null);
        Destra.setRolloverIcon(new ImageIcon("./risorse/immagini/interfaccia/destra_highlighted.png"));
        Destra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestraActionPerformed(evt);
            }
        });
        jPanel1.add(Destra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 610, 60, 60));

        Giu.setIcon(new ImageIcon("./risorse/immagini/interfaccia/giu.png"));
        Giu.setBorder(null);
        Giu.setContentAreaFilled(false);
        Giu.setMargin(null);
        Giu.setRolloverIcon(new ImageIcon("./risorse/immagini/interfaccia/giu_highlighted.png"));
        jPanel1.add(Giu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 610, 60, 60));

        Su.setIcon(new ImageIcon("./risorse/immagini/interfaccia/su.png"));
        Su.setBorder(null);
        Su.setContentAreaFilled(false);
        Su.setMargin(null);
        Su.setRolloverIcon(new ImageIcon("./risorse/immagini/interfaccia/su_highlighted.png"));
        Su.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuActionPerformed(evt);
            }
        });
        jPanel1.add(Su, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 540, 60, 60));

        ApriMovimento.setIcon(new ImageIcon("./risorse/immagini/interfaccia/pulsante_movimento.png"));
        ApriMovimento.setBorder(null);
        ApriMovimento.setBorderPainted(false);
        ApriMovimento.setContentAreaFilled(false);
        ApriMovimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ApriMovimento.setMargin(null);
        jPanel1.add(ApriMovimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 540, 120, 144));

        GraficaMovimento.setIcon(new ImageIcon("./risorse/immagini/interfaccia/contorno_movimento.png"));
        jPanel1.add(GraficaMovimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 520, 280, 175));

        Osserva.setIcon(new ImageIcon("./risorse/immagini/telefono/osserva.png"));
        Osserva.setBorder(null);
        Osserva.setContentAreaFilled(false);
        Osserva.setMargin(null);
        jPanel1.add(Osserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 210, 60, 60));

        Inventario.setIcon(new ImageIcon("./risorse/immagini/telefono/inventario.png"));
        Inventario.setBorder(null);
        Inventario.setContentAreaFilled(false);
        Inventario.setMargin(null);
        jPanel1.add(Inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 320, 60, 60));

        Flash.setIcon(new ImageIcon("./risorse/immagini/telefono/flash.png"));
        Flash.setBorder(null);
        Flash.setContentAreaFilled(false);
        Flash.setMargin(null);
        jPanel1.add(Flash, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 210, 60, 60));

        Usa.setIcon(new ImageIcon("./risorse/immagini/telefono/usa.png"));
        Usa.setBorder(null);
        Usa.setContentAreaFilled(false);
        Usa.setMargin(null);
        jPanel1.add(Usa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 320, 60, 60));

        Fotocamera.setIcon(new ImageIcon("./risorse/immagini/telefono/fotocamera.png"));
        Fotocamera.setBorder(null);
        Fotocamera.setContentAreaFilled(false);
        Fotocamera.setMargin(null);
        jPanel1.add(Fotocamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 100, 60, 60));

        Incastra.setIcon(new ImageIcon("./risorse/immagini/telefono/incastra.png"));
        Incastra.setBorder(null);
        Incastra.setContentAreaFilled(false);
        Incastra.setMargin(null);
        jPanel1.add(Incastra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 210, 60, 60));

        Salva.setIcon(new ImageIcon("./risorse/immagini/telefono/salva.png"));
        Salva.setBorder(null);
        Salva.setContentAreaFilled(false);
        Salva.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Salva.setMargin(null);
        jPanel1.add(Salva, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 320, 60, 60));

        Opzioni.setIcon(new ImageIcon("./risorse/immagini/telefono/opzioni.png"));
        Opzioni.setBorder(null);
        Opzioni.setContentAreaFilled(false);
        Opzioni.setMargin(null);
        jPanel1.add(Opzioni, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 100, 60, 60));

        Menu.setIcon(new ImageIcon("./risorse/immagini/telefono/menu.png"));
        Menu.setBorder(null);
        Menu.setContentAreaFilled(false);
        Menu.setMargin(null);
        jPanel1.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 430, 60, 60));

        Apri.setIcon(new ImageIcon("./risorse/immagini/telefono/apri.png"));
        Apri.setBorder(null);
        Apri.setContentAreaFilled(false);
        Apri.setMargin(null);
        jPanel1.add(Apri, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 430, 60, 60));

        Esci.setIcon(new ImageIcon("./risorse/immagini/telefono/esci.png"));
        Esci.setBorder(null);
        Esci.setContentAreaFilled(false);
        Esci.setMargin(null);
        jPanel1.add(Esci, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 430, 60, 60));

        Prendi.setIcon(new ImageIcon("./risorse/immagini/telefono/prendi.png"));
        Prendi.setBorder(null);
        Prendi.setContentAreaFilled(false);
        Prendi.setMargin(null);
        jPanel1.add(Prendi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 100, 60, 60));

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
        jPanel1.add(NomePartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 210, 35));

        ErroreMaxCaratteri.setIcon(new ImageIcon("./risorse/immagini/menu/errore_max_caratteri.png"));
        ErroreMaxCaratteri.setEnabled(false);
        jPanel1.add(ErroreMaxCaratteri, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 270, 50));

        ErroreNoCaratteri.setIcon(new ImageIcon("./risorse/immagini/menu/errore_no_caratteri.png"));
        ErroreNoCaratteri.setEnabled(false);
        jPanel1.add(ErroreNoCaratteri, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 270, 50));

        CreaSalvataggioLabel.setIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio.png"));
        CreaSalvataggioLabel.setDisabledIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio_disabilitato.png"));
        CreaSalvataggioLabel.setEnabled(false);
        jPanel1.add(CreaSalvataggioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1280, 720));

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
        jPanel1.add(GraficaCellulare, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 280, 500));

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

    private void SuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SuActionPerformed

    private void DestraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DestraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DestraActionPerformed

    private void SinistraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SinistraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SinistraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Apri;
    private javax.swing.JButton ApriEditor;
    private javax.swing.JButton ApriMovimento;
    private javax.swing.JButton ApriTelefono;
    private javax.swing.JScrollPane CasellaTesto;
    private javax.swing.JButton CreaSalvataggioEsci;
    private javax.swing.JLabel CreaSalvataggioLabel;
    private javax.swing.JButton Destra;
    private javax.swing.JLabel ErroreMaxCaratteri;
    private javax.swing.JLabel ErroreNoCaratteri;
    private javax.swing.JButton Esci;
    private javax.swing.JButton Flash;
    private javax.swing.JButton Fotocamera;
    private javax.swing.JButton Giu;
    private javax.swing.JLabel GraficaCellulare;
    private javax.swing.JLabel GraficaEditor;
    private javax.swing.JLabel GraficaMovimento;
    private javax.swing.JButton Incastra;
    private javax.swing.JButton IniziaPartita;
    private javax.swing.JButton Inventario;
    private javax.swing.JLabel MediaLabel;
    private javax.swing.JButton Menu;
    private javax.swing.JTextField NomePartita;
    private javax.swing.JButton NuovaPartita1;
    private javax.swing.JButton NuovaPartita2;
    private javax.swing.JButton NuovaPartita3;
    private javax.swing.JButton NuovaPartita4;
    private javax.swing.JButton Opzioni;
    private javax.swing.JButton Osserva;
    private javax.swing.JButton Prendi;
    private javax.swing.JButton PulsanteCrediti;
    private javax.swing.JButton PulsanteEsci;
    private javax.swing.JButton PulsanteIndaga;
    private javax.swing.JButton PulsanteSalta;
    private javax.swing.JButton Salva;
    private javax.swing.JButton SalvataggiEsci;
    private javax.swing.JTextArea ScritturaTesto;
    private javax.swing.JTextField ScriviTesto;
    private javax.swing.JButton Sinistra;
    private javax.swing.JButton Su;
    private javax.swing.JButton Usa;
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
        riproduciAudio("menu");
        inizializzaMenu();
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
        inizializzaInterfacciaUtente();
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
        if(!GraficaMovimento.isVisible()){
            ApriMovimento.setVisible(true);
            ApriMovimento.setEnabled(true);
        }
        if(!GraficaEditor.isVisible()){
            ApriEditor.setVisible(true);
            ApriEditor.setEnabled(true);
        }
        if(!GraficaCellulare.isVisible()){
            ApriTelefono.setVisible(true);
            ApriTelefono.setEnabled(true);
        }
        if(!MediaLabel.getName().equals("BackgroundInterfaccia")){
            MediaLabel.setIcon(new ImageIcon("./risorse/immagini/interfaccia/sfondo.png"));
        }
    }

    //Disattiva l'interfaccia utente
    public void disattivaInterfacciaUtente() {
        ScriviTesto.setVisible(false);
        CasellaTesto.setVisible(false);
        ScritturaTesto.setVisible(false);
        GraficaCellulare.setVisible(false);
        GraficaMovimento.setVisible(false);
        GraficaEditor.setVisible(false);
        ApriEditor.setVisible(false);
        ApriTelefono.setVisible(false);
        ApriMovimento.setVisible(false);
    
        ScriviTesto.setEnabled(false);
        CasellaTesto.setEnabled(false);
        ScritturaTesto.setEnabled(false);
        GraficaCellulare.setEnabled(false);
        GraficaMovimento.setEnabled(false);
        GraficaEditor.setEnabled(false);
        ApriEditor.setEnabled(false);
        ApriTelefono.setEnabled(false);
        ApriMovimento.setEnabled(false);
        
        Esci.setVisible(false);
        Esci.setEnabled(false);
        Flash.setVisible(false);
        Flash.setEnabled(false);
        Fotocamera.setVisible(false);
        Fotocamera.setEnabled(false);
        Incastra.setVisible(false);
        Incastra.setEnabled(false);
        Inventario.setVisible(false);
        Inventario.setEnabled(false);
        Menu.setVisible(false);
        Menu.setEnabled(false);
        Opzioni.setVisible(false);
        Opzioni.setEnabled(false);
        Osserva.setVisible(false);
        Osserva.setEnabled(false);
        Prendi.setVisible(false);
        Prendi.setEnabled(false);
        Salva.setVisible(false);
        Salva.setEnabled(false);
        Usa.setVisible(false);
        Usa.setEnabled(false);
        Apri.setEnabled(false);
        Apri.setVisible(false);
        Su.setVisible(false);
        Giu.setVisible(false);
        Destra.setVisible(false);
        Sinistra.setVisible(false);
        Su.setEnabled(false);
        Giu.setEnabled(false);
        Destra.setEnabled(false);
        Sinistra.setEnabled(false);
    }

    //Mostra l'interfaccia del cellulare
    public void mostraCellulare() {
        GraficaCellulare.setEnabled(true);
        GraficaCellulare.setVisible(true);

        ApriTelefono.setEnabled(false);
        ApriTelefono.setVisible(false);
        
        Esci.setVisible(true);
        Esci.setEnabled(true);
        Flash.setVisible(true);
        Flash.setEnabled(true);
        Fotocamera.setVisible(true);
        Fotocamera.setEnabled(true);
        Incastra.setVisible(true);
        Incastra.setEnabled(true);
        Inventario.setVisible(true);
        Apri.setVisible(true);
        Inventario.setEnabled(true);
        Menu.setVisible(true);
        Menu.setEnabled(true);
        Opzioni.setVisible(true);
        Opzioni.setEnabled(true);
        Osserva.setVisible(true);
        Osserva.setEnabled(true);
        Prendi.setVisible(true);
        Prendi.setEnabled(true);
        Salva.setVisible(true);
        Salva.setEnabled(true);
        Usa.setVisible(true);
        Usa.setEnabled(true);
        Apri.setEnabled(true);
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

    public void mostraInterfacciaMovimento(){
        GraficaMovimento.setEnabled(true);
        GraficaMovimento.setVisible(true);

        ApriMovimento.setEnabled(false);
        ApriMovimento.setVisible(false);
        
        Su.setVisible(true);
        Giu.setVisible(true);
        Destra.setVisible(true);
        Sinistra.setVisible(true);
        Su.setEnabled(true);
        Giu.setEnabled(true);
        Destra.setEnabled(true);
        Sinistra.setEnabled(true);
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
        inizializzaInterfacciaUtente();
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
        ScritturaTesto.setText(messaggio + "\n");
    }
    
     public void aggiungiTesto(String messaggio){
        ScritturaTesto.append(messaggio + "\n");
    }
}
