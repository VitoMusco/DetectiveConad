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
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Interfaccia extends javax.swing.JFrame {

    private final int MAX_PARTITE_SALVATE = 4;
    private final ImageIcon menu, selettorePartita;
    private boolean creazioneNuovaPartita = false;
    private boolean saltaFilmatoIntroduzione = false;
    private boolean riproduzioneFinaleCorretto = false;
    private boolean riproduzioneFinaleAlternativo = false;
    private boolean[] partiteSalvate = new boolean[4];
    private Clip audio;
    GestoreAzioni g;

    public Interfaccia(GestoreAzioni gestoreAzioni) {
        g = gestoreAzioni;
        initComponents();
        inizializzaFinestra();

        for (int i = 0; i < MAX_PARTITE_SALVATE; i++) {
            this.partiteSalvate[i] = false;
        }

        MediaLabel.setName("Background");

        menu = new ImageIcon("./risorse/immagini/menu/menu.png");
        selettorePartita = new ImageIcon("./risorse/immagini/menu/salvataggi.png");

        disattivaInterfacciaMenu();
        disattivaInterfacciaUtente();
        disattivaFinestraOpzioniSiNo();
        disattivaInterfacciaSalvataggio();
        disattivaInterfacciaGraficaAppCellulare();

        SceltaSi.addActionListener(g);
        SceltaNo.addActionListener(g);

        PulsanteAppDinamico1.addActionListener(g);
        PulsanteAppDinamico2.addActionListener(g);
        PulsanteAppDinamico3.addActionListener(g);
        PulsanteAppDinamico4.addActionListener(g);
        PulsanteAppDinamico5.addActionListener(g);
        PulsanteAppDinamico6.addActionListener(g);
        PulsanteAppDinamico7.addActionListener(g);
        PulsanteAppDinamico8.addActionListener(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MappaLabel = new javax.swing.JLabel();
        PulsanteAppDinamico1 = new javax.swing.JButton();
        PulsanteAppDinamico2 = new javax.swing.JButton();
        PulsanteAppDinamico3 = new javax.swing.JButton();
        PulsanteAppDinamico4 = new javax.swing.JButton();
        PulsanteAppDinamico5 = new javax.swing.JButton();
        PulsanteAppDinamico6 = new javax.swing.JButton();
        PulsanteAppDinamico7 = new javax.swing.JButton();
        PulsanteAppDinamico8 = new javax.swing.JButton();
        ChiudiGraficaAppCellulare = new javax.swing.JButton();
        GraficaAppCellulare = new javax.swing.JLabel();
        AnnullaSalvataggio = new javax.swing.JButton();
        SceltaSi = new javax.swing.JButton();
        SceltaNo = new javax.swing.JButton();
        SaltaFilmatoLabel = new javax.swing.JLabel();
        SalvaLabel = new javax.swing.JLabel();
        Sinistra = new javax.swing.JButton();
        Destra = new javax.swing.JButton();
        Giu = new javax.swing.JButton();
        Su = new javax.swing.JButton();
        ApriMovimento = new javax.swing.JButton();
        GraficaMovimento = new javax.swing.JLabel();
        Osserva = new javax.swing.JButton();
        Inventario = new javax.swing.JButton();
        Flash = new javax.swing.JButton();
        ChiudiCaso = new javax.swing.JButton();
        Fotocamera = new javax.swing.JButton();
        Incastra = new javax.swing.JButton();
        Salva = new javax.swing.JButton();
        Interroga = new javax.swing.JButton();
        SalvaEVaiAMenu = new javax.swing.JButton();
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
        ContinuaPartita1 = new javax.swing.JButton();
        ContinuaPartita2 = new javax.swing.JButton();
        ContinuaPartita3 = new javax.swing.JButton();
        ContinuaPartita4 = new javax.swing.JButton();
        ScriviTesto = new javax.swing.JTextField();
        CasellaTesto = new javax.swing.JScrollPane();
        ScritturaTesto = new javax.swing.JTextArea();
        GraficaEditor = new javax.swing.JLabel();
        GraficaCellulare = new javax.swing.JLabel();
        ApriEditor = new javax.swing.JButton();
        ApriTelefono = new javax.swing.JButton();
        MediaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage((new ImageIcon("./risorse/immagini/icona/icona.png")).getImage());
        setName("Detective Conad"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MappaLabel.setIcon(new ImageIcon("./risorse/immagini/telefono/mappa.png"));
        jPanel1.add(MappaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(995, 100, 250, 320));

        PulsanteAppDinamico1.setForeground(new java.awt.Color(255, 255, 255));
        PulsanteAppDinamico1.setBorder(null);
        PulsanteAppDinamico1.setContentAreaFilled(false);
        PulsanteAppDinamico1.setMargin(null);
        PulsanteAppDinamico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PulsanteAppDinamico1ActionPerformed(evt);
            }
        });
        jPanel1.add(PulsanteAppDinamico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, 250, 44));

        PulsanteAppDinamico2.setForeground(new java.awt.Color(255, 255, 255));
        PulsanteAppDinamico2.setBorder(null);
        PulsanteAppDinamico2.setContentAreaFilled(false);
        PulsanteAppDinamico2.setMargin(null);
        PulsanteAppDinamico2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PulsanteAppDinamico2ActionPerformed(evt);
            }
        });
        jPanel1.add(PulsanteAppDinamico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 150, 250, 44));

        PulsanteAppDinamico3.setForeground(new java.awt.Color(255, 255, 255));
        PulsanteAppDinamico3.setBorder(null);
        PulsanteAppDinamico3.setContentAreaFilled(false);
        PulsanteAppDinamico3.setMargin(null);
        PulsanteAppDinamico3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PulsanteAppDinamico3ActionPerformed(evt);
            }
        });
        jPanel1.add(PulsanteAppDinamico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 200, 250, 44));

        PulsanteAppDinamico4.setForeground(new java.awt.Color(255, 255, 255));
        PulsanteAppDinamico4.setBorder(null);
        PulsanteAppDinamico4.setContentAreaFilled(false);
        PulsanteAppDinamico4.setMargin(null);
        PulsanteAppDinamico4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PulsanteAppDinamico4ActionPerformed(evt);
            }
        });
        jPanel1.add(PulsanteAppDinamico4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 250, 250, 44));

        PulsanteAppDinamico5.setForeground(new java.awt.Color(255, 255, 255));
        PulsanteAppDinamico5.setBorder(null);
        PulsanteAppDinamico5.setContentAreaFilled(false);
        PulsanteAppDinamico5.setMargin(null);
        PulsanteAppDinamico5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PulsanteAppDinamico5ActionPerformed(evt);
            }
        });
        jPanel1.add(PulsanteAppDinamico5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 300, 250, 44));

        PulsanteAppDinamico6.setForeground(new java.awt.Color(255, 255, 255));
        PulsanteAppDinamico6.setBorder(null);
        PulsanteAppDinamico6.setContentAreaFilled(false);
        PulsanteAppDinamico6.setMargin(null);
        PulsanteAppDinamico6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PulsanteAppDinamico6ActionPerformed(evt);
            }
        });
        jPanel1.add(PulsanteAppDinamico6, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 350, 250, 44));

        PulsanteAppDinamico7.setForeground(new java.awt.Color(255, 255, 255));
        PulsanteAppDinamico7.setBorder(null);
        PulsanteAppDinamico7.setContentAreaFilled(false);
        PulsanteAppDinamico7.setMargin(null);
        PulsanteAppDinamico7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PulsanteAppDinamico7ActionPerformed(evt);
            }
        });
        jPanel1.add(PulsanteAppDinamico7, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 250, 44));

        PulsanteAppDinamico8.setForeground(new java.awt.Color(255, 255, 255));
        PulsanteAppDinamico8.setBorder(null);
        PulsanteAppDinamico8.setContentAreaFilled(false);
        PulsanteAppDinamico8.setMargin(null);
        PulsanteAppDinamico8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PulsanteAppDinamico8ActionPerformed(evt);
            }
        });
        jPanel1.add(PulsanteAppDinamico8, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 450, 250, 44));

        ChiudiGraficaAppCellulare.setIcon(new ImageIcon("./risorse/immagini/menu/annulla_salvataggio.png"));
        ChiudiGraficaAppCellulare.setBorder(null);
        ChiudiGraficaAppCellulare.setContentAreaFilled(false);
        ChiudiGraficaAppCellulare.setMargin(null);
        ChiudiGraficaAppCellulare.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/annulla_salvataggio_highlighted.png"));
        ChiudiGraficaAppCellulare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChiudiGraficaAppCellulareActionPerformed(evt);
            }
        });
        jPanel1.add(ChiudiGraficaAppCellulare, new org.netbeans.lib.awtextra.AbsoluteConstraints(1205, 38, 44, 44));

        GraficaAppCellulare.setIcon(new ImageIcon("./risorse/immagini/interfaccia/telefono.png"));
        jPanel1.add(GraficaAppCellulare, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 280, 500));

        AnnullaSalvataggio.setIcon(new ImageIcon("./risorse/immagini/menu/annulla_salvataggio.png"));
        AnnullaSalvataggio.setBorder(null);
        AnnullaSalvataggio.setContentAreaFilled(false);
        AnnullaSalvataggio.setMargin(null);
        AnnullaSalvataggio.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/annulla_salvataggio_highlighted.png"));
        AnnullaSalvataggio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnullaSalvataggioActionPerformed(evt);
            }
        });
        jPanel1.add(AnnullaSalvataggio, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 257, 44, 44));

        SceltaSi.setIcon(new ImageIcon("./risorse/immagini/menu/pulsante_salva_si.png"));
        SceltaSi.setBorder(null);
        SceltaSi.setContentAreaFilled(false);
        SceltaSi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SceltaSi.setMargin(null);
        SceltaSi.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/pulsante_salva_si_highlighted.png"));
        SceltaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SceltaSiActionPerformed(evt);
            }
        });
        jPanel1.add(SceltaSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 130, 70));

        SceltaNo.setIcon(new ImageIcon("./risorse/immagini/menu/pulsante_salva_no.png"));
        SceltaNo.setBorder(null);
        SceltaNo.setContentAreaFilled(false);
        SceltaNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SceltaNo.setMargin(null);
        SceltaNo.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/pulsante_salva_no_highlighted.png"));
        SceltaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SceltaNoActionPerformed(evt);
            }
        });
        jPanel1.add(SceltaNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 130, 70));

        SaltaFilmatoLabel.setDisabledIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio_disabilitato.png"));
        jPanel1.add(SaltaFilmatoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 360, 240));

        SalvaLabel.setIcon(new ImageIcon("./risorse/immagini/menu/salva.png"));
        SalvaLabel.setDisabledIcon(new ImageIcon("./risorse/immagini/menu/crea_salvataggio_disabilitato.png"));
        jPanel1.add(SalvaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 360, 240));

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

        ChiudiCaso.setIcon(new ImageIcon("./risorse/immagini/telefono/chiudi_caso.png"));
        ChiudiCaso.setBorder(null);
        ChiudiCaso.setContentAreaFilled(false);
        ChiudiCaso.setMargin(null);
        jPanel1.add(ChiudiCaso, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 320, 60, 60));

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

        Interroga.setIcon(new ImageIcon("./risorse/immagini/telefono/interroga.png"));
        Interroga.setBorder(null);
        Interroga.setContentAreaFilled(false);
        Interroga.setMargin(null);
        jPanel1.add(Interroga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 100, 60, 60));

        SalvaEVaiAMenu.setIcon(new ImageIcon("./risorse/immagini/telefono/menu.png"));
        SalvaEVaiAMenu.setBorder(null);
        SalvaEVaiAMenu.setContentAreaFilled(false);
        SalvaEVaiAMenu.setMargin(null);
        jPanel1.add(SalvaEVaiAMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 430, 60, 60));

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
        jPanel1.add(NomePartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 210, 35));

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

        ContinuaPartita1.setIcon(new ImageIcon("./risorse/immagini/menu/continua_partita.png"));
        ContinuaPartita1.setBorder(null);
        ContinuaPartita1.setBorderPainted(false);
        ContinuaPartita1.setContentAreaFilled(false);
        ContinuaPartita1.setEnabled(false);
        ContinuaPartita1.setMargin(null);
        ContinuaPartita1.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/continua_partita_highlighted.png"));
        ContinuaPartita1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuaPartita1ActionPerformed(evt);
            }
        });
        jPanel1.add(ContinuaPartita1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 367, 81));

        ContinuaPartita2.setIcon(new ImageIcon("./risorse/immagini/menu/continua_partita.png"));
        ContinuaPartita2.setBorder(null);
        ContinuaPartita2.setBorderPainted(false);
        ContinuaPartita2.setContentAreaFilled(false);
        ContinuaPartita2.setEnabled(false);
        ContinuaPartita2.setMargin(null);
        ContinuaPartita2.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/continua_partita_highlighted.png"));
        jPanel1.add(ContinuaPartita2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 367, 81));

        ContinuaPartita3.setIcon(new ImageIcon("./risorse/immagini/menu/continua_partita.png"));
        ContinuaPartita3.setBorder(null);
        ContinuaPartita3.setBorderPainted(false);
        ContinuaPartita3.setContentAreaFilled(false);
        ContinuaPartita3.setEnabled(false);
        ContinuaPartita3.setMargin(null);
        ContinuaPartita3.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/continua_partita_highlighted.png"));
        jPanel1.add(ContinuaPartita3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 367, 81));

        ContinuaPartita4.setIcon(new ImageIcon("./risorse/immagini/menu/continua_partita.png"));
        ContinuaPartita4.setBorder(null);
        ContinuaPartita4.setBorderPainted(false);
        ContinuaPartita4.setContentAreaFilled(false);
        ContinuaPartita4.setEnabled(false);
        ContinuaPartita4.setMargin(null);
        ContinuaPartita4.setRolloverIcon(new ImageIcon("./risorse/immagini/menu/continua_partita_highlighted.png"));
        jPanel1.add(ContinuaPartita4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 367, 81));

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

    private void ContinuaPartita1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuaPartita1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContinuaPartita1ActionPerformed

    private void SceltaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SceltaSiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SceltaSiActionPerformed

    private void SceltaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SceltaNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SceltaNoActionPerformed

    private void AnnullaSalvataggioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnullaSalvataggioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnnullaSalvataggioActionPerformed

    private void ChiudiGraficaAppCellulareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChiudiGraficaAppCellulareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChiudiGraficaAppCellulareActionPerformed

    private void PulsanteAppDinamico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PulsanteAppDinamico1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PulsanteAppDinamico1ActionPerformed

    private void PulsanteAppDinamico2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PulsanteAppDinamico2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PulsanteAppDinamico2ActionPerformed

    private void PulsanteAppDinamico3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PulsanteAppDinamico3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PulsanteAppDinamico3ActionPerformed

    private void PulsanteAppDinamico4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PulsanteAppDinamico4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PulsanteAppDinamico4ActionPerformed

    private void PulsanteAppDinamico5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PulsanteAppDinamico5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PulsanteAppDinamico5ActionPerformed

    private void PulsanteAppDinamico6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PulsanteAppDinamico6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PulsanteAppDinamico6ActionPerformed

    private void PulsanteAppDinamico7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PulsanteAppDinamico7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PulsanteAppDinamico7ActionPerformed

    private void PulsanteAppDinamico8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PulsanteAppDinamico8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PulsanteAppDinamico8ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnnullaSalvataggio;
    private javax.swing.JButton Apri;
    private javax.swing.JButton ApriEditor;
    private javax.swing.JButton ApriMovimento;
    private javax.swing.JButton ApriTelefono;
    private javax.swing.JScrollPane CasellaTesto;
    private javax.swing.JButton ChiudiCaso;
    private javax.swing.JButton ChiudiGraficaAppCellulare;
    private javax.swing.JButton ContinuaPartita1;
    private javax.swing.JButton ContinuaPartita2;
    private javax.swing.JButton ContinuaPartita3;
    private javax.swing.JButton ContinuaPartita4;
    private javax.swing.JButton CreaSalvataggioEsci;
    private javax.swing.JLabel CreaSalvataggioLabel;
    private javax.swing.JButton Destra;
    private javax.swing.JLabel ErroreMaxCaratteri;
    private javax.swing.JLabel ErroreNoCaratteri;
    private javax.swing.JButton Esci;
    private javax.swing.JButton Flash;
    private javax.swing.JButton Fotocamera;
    private javax.swing.JButton Giu;
    private javax.swing.JLabel GraficaAppCellulare;
    private javax.swing.JLabel GraficaCellulare;
    private javax.swing.JLabel GraficaEditor;
    private javax.swing.JLabel GraficaMovimento;
    private javax.swing.JButton Incastra;
    private javax.swing.JButton IniziaPartita;
    private javax.swing.JButton Interroga;
    private javax.swing.JButton Inventario;
    private javax.swing.JLabel MappaLabel;
    private javax.swing.JLabel MediaLabel;
    private javax.swing.JTextField NomePartita;
    private javax.swing.JButton NuovaPartita1;
    private javax.swing.JButton NuovaPartita2;
    private javax.swing.JButton NuovaPartita3;
    private javax.swing.JButton NuovaPartita4;
    private javax.swing.JButton Osserva;
    private javax.swing.JButton Prendi;
    private javax.swing.JButton PulsanteAppDinamico1;
    private javax.swing.JButton PulsanteAppDinamico2;
    private javax.swing.JButton PulsanteAppDinamico3;
    private javax.swing.JButton PulsanteAppDinamico4;
    private javax.swing.JButton PulsanteAppDinamico5;
    private javax.swing.JButton PulsanteAppDinamico6;
    private javax.swing.JButton PulsanteAppDinamico7;
    private javax.swing.JButton PulsanteAppDinamico8;
    private javax.swing.JButton PulsanteCrediti;
    private javax.swing.JButton PulsanteEsci;
    private javax.swing.JButton PulsanteIndaga;
    private javax.swing.JLabel SaltaFilmatoLabel;
    private javax.swing.JButton Salva;
    private javax.swing.JButton SalvaEVaiAMenu;
    private javax.swing.JLabel SalvaLabel;
    private javax.swing.JButton SalvataggiEsci;
    private javax.swing.JButton SceltaNo;
    private javax.swing.JButton SceltaSi;
    private javax.swing.JTextArea ScritturaTesto;
    private javax.swing.JTextField ScriviTesto;
    private javax.swing.JButton Sinistra;
    private javax.swing.JButton Su;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void inizializzaFinestra() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void attivaFinestraOpzioniSiNo(){
        SaltaFilmatoLabel.setEnabled(true);
        SaltaFilmatoLabel.setVisible(true);
        SceltaSi.setEnabled(true);
        SceltaSi.setVisible(true);
        SceltaNo.setEnabled(true);
        SceltaNo.setVisible(true);
    }
    
    public void chiediSaltaIntroduzione(){
        SaltaFilmatoLabel.setIcon( new ImageIcon("./risorse/immagini/menu/salta_intro.png"));
        attivaFinestraOpzioniSiNo();
        
        SceltaSi.setActionCommand("VISUALIZZA_FILMATO");
        SceltaNo.setActionCommand("SALTA_FILMATO");
    }
    
    public void chiediConfermaChiusuraCasoFinaleCorretto(){
        SaltaFilmatoLabel.setIcon( new ImageIcon("./risorse/immagini/menu/chiudi_caso.png"));
        attivaFinestraOpzioniSiNo();
        SceltaSi.setActionCommand("CHIUDI_CASO_FINALE_CORRETTO");
        SceltaNo.setActionCommand("ANNULLA_CHIUDI_CASO");
    }
    
    public void chiediConfermaChiusuraCasoFinaleAlternativo(){
        SaltaFilmatoLabel.setIcon( new ImageIcon("./risorse/immagini/menu/chiudi_caso.png"));
        attivaFinestraOpzioniSiNo();
        SceltaSi.setActionCommand("CHIUDI_CASO_FINALE_ALTERNATIVO");
        SceltaNo.setActionCommand("ANNULLA_CHIUDI_CASO");
    }
    
    public void disattivaFinestraOpzioniSiNo(){
        SaltaFilmatoLabel.setEnabled(false);
        SaltaFilmatoLabel.setVisible(false);
        SceltaSi.setEnabled(false);
        SceltaSi.setVisible(false);
        SceltaNo.setEnabled(false);
        SceltaNo.setVisible(false);
    }
    
    public void saltaFilmatoIntroduzione(){
        saltaFilmatoIntroduzione = true;
        stoppaAudio();
        disattivaPulsantiMenu();
        inizializzaInterfacciaUtente();
    }
    
    public void nonSaltareFilmatoIntroduzione(){
        saltaFilmatoIntroduzione = false;
    }
    
    public void caricaPartiteSalvate(boolean[] partite) {
        for (int i = 0; i < MAX_PARTITE_SALVATE; i++) {
            this.partiteSalvate[i] = partite[i];
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

    public void stoppaAudio() {
        audio.close();
        audio.stop();
    }

    public void creaNuovaPartita() {
        chiudiSelettorePartita();
        creazioneNuovaPartita = true;
    }

    public void inizializzaFinaleCorretto(){
        riproduzioneFinaleCorretto = true;
    }
    
    public void inizializzaFinaleAlternativo(){
        riproduzioneFinaleAlternativo = true;
    }
    
    public void caricaPartita() {
        saltaFilmatoIntroduzione = true;
        stoppaAudio();
        disattivaPulsantiMenu();
        chiudiSelettorePartita();
        inizializzaInterfacciaUtente();
        mostraTesto("Vediamo... dove ero rimasto? Ah ecco!");
    }

    public boolean controllaStatoIntroduzione() {
        while (!creazioneNuovaPartita && !riproduzioneFinaleCorretto && !riproduzioneFinaleAlternativo) {
            if (!creazioneNuovaPartita) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (creazioneNuovaPartita && !saltaFilmatoIntroduzione) { 
                creazioneNuovaPartita = false;
                return true;
            }
        }
        return false;
    }
    
    public boolean controllaStatoFinale() {
        while (!riproduzioneFinaleCorretto && !riproduzioneFinaleAlternativo) {
            if (!riproduzioneFinaleCorretto) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (riproduzioneFinaleCorretto) {
            riproduzioneFinaleCorretto = false;
            return true;
        } else {
            riproduzioneFinaleAlternativo = false;
            return false;
        }
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
        MediaLabel.setIcon(new ImageIcon("./risorse/gif/videointroduzione.gif"));
        riproduciAudio("videointroduzione");
        try {
            TimeUnit.SECONDS.sleep(38);
        } catch (InterruptedException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        }
        inizializzaInterfacciaUtente();
    }
    
    public void riproduciFinaleCorretto() {
        stoppaAudio();
        disattivaInterfacciaUtente();
        MediaLabel.setIcon(new ImageIcon("./risorse/gif/videofinale.gif"));
        riproduciAudio("videofinale");
        try {
            TimeUnit.SECONDS.sleep(44);
        } catch (InterruptedException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        }
        stoppaAudio();
        inizializzaMenu();
    }
    
    public void riproduciFinaleAlternativo() {
        stoppaAudio();
        disattivaInterfacciaUtente();
        MediaLabel.setIcon(new ImageIcon("./risorse/gif/videofinalealternativo.gif"));
        riproduciAudio("videofinalealternativo");
        try {
            TimeUnit.SECONDS.sleep(22);
        } catch (InterruptedException ex) {
            Logger.getLogger(Interfaccia.class.getName()).log(Level.SEVERE, null, ex);
        }
        stoppaAudio();
        inizializzaMenu();
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
        if (partiteSalvate[0]) {
            ContinuaPartita1.setEnabled(true);
            ContinuaPartita1.setVisible(true);
        } else {
            NuovaPartita1.setEnabled(true);
            NuovaPartita1.setVisible(true);
        }
        if (partiteSalvate[1]) {
            ContinuaPartita2.setEnabled(true);
            ContinuaPartita2.setVisible(true);
        } else {
            NuovaPartita2.setEnabled(true);
            NuovaPartita2.setVisible(true);
        }
        if (partiteSalvate[2]) {
            ContinuaPartita3.setEnabled(true);
            ContinuaPartita3.setVisible(true);
        } else {
            NuovaPartita3.setEnabled(true);
            NuovaPartita3.setVisible(true);
        }
        if (partiteSalvate[3]) {
            ContinuaPartita4.setEnabled(true);
            ContinuaPartita4.setVisible(true);
        } else {
            NuovaPartita4.setEnabled(true);
            NuovaPartita4.setVisible(true);
        }
        SalvataggiEsci.setVisible(true);
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
        ContinuaPartita1.setEnabled(false);
        ContinuaPartita2.setEnabled(false);
        ContinuaPartita3.setEnabled(false);
        ContinuaPartita4.setEnabled(false);
        SalvataggiEsci.setVisible(false);
        NuovaPartita1.setVisible(false);
        NuovaPartita2.setVisible(false);
        NuovaPartita3.setVisible(false);
        NuovaPartita4.setVisible(false);
        ContinuaPartita1.setVisible(false);
        ContinuaPartita2.setVisible(false);
        ContinuaPartita3.setVisible(false);
        ContinuaPartita4.setVisible(false);
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
        ContinuaPartita1.setEnabled(false);
        ContinuaPartita2.setEnabled(false);
        ContinuaPartita3.setEnabled(false);
        ContinuaPartita4.setEnabled(false);
        ErroreMaxCaratteri.setEnabled(false);
        ErroreNoCaratteri.setEnabled(false);
        SalvataggiEsci.setVisible(false);
        NuovaPartita1.setVisible(false);
        NuovaPartita2.setVisible(false);
        NuovaPartita3.setVisible(false);
        NuovaPartita4.setVisible(false);
        ContinuaPartita1.setVisible(false);
        ContinuaPartita2.setVisible(false);
        ContinuaPartita3.setVisible(false);
        ContinuaPartita4.setVisible(false);
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
    }

    //Inizializza l'interfaccia grafica sul quale si gioca
    public void inizializzaInterfacciaUtente() {
        if (!GraficaMovimento.isVisible()) {
            ApriMovimento.setVisible(true);
            ApriMovimento.setEnabled(true);
        }
        if (!GraficaEditor.isVisible()) {
            ApriEditor.setVisible(true);
            ApriEditor.setEnabled(true);
        }
        if (!GraficaCellulare.isVisible()) {
            ApriTelefono.setVisible(true);
            ApriTelefono.setEnabled(true);
        }
        if (!MediaLabel.getName().equals("BackgroundInterfaccia")) {
            MediaLabel.setIcon(new ImageIcon("./risorse/immagini/interfaccia/sfondo.png"));
        }
    }

    //Disattiva l'interfaccia utente
    public void disattivaInterfacciaUtente() {
        disattivaPulsantiDinamici();
        
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
        SalvaEVaiAMenu.setVisible(false);
        SalvaEVaiAMenu.setEnabled(false);
        Interroga.setVisible(false);
        Interroga.setEnabled(false);
        Osserva.setVisible(false);
        Osserva.setEnabled(false);
        Prendi.setVisible(false);
        Prendi.setEnabled(false);
        Salva.setVisible(false);
        Salva.setEnabled(false);
        ChiudiCaso.setVisible(false);
        ChiudiCaso.setEnabled(false);
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

    public void disattivaPulsantiDinamici(){
        PulsanteAppDinamico1.setVisible(false);
        PulsanteAppDinamico2.setVisible(false);
        PulsanteAppDinamico3.setVisible(false);
        PulsanteAppDinamico4.setVisible(false);
        PulsanteAppDinamico5.setVisible(false);
        PulsanteAppDinamico6.setVisible(false);
        PulsanteAppDinamico7.setVisible(false);
        PulsanteAppDinamico8.setVisible(false);
        
        PulsanteAppDinamico1.setEnabled(false);        
        PulsanteAppDinamico2.setEnabled(false);        
        PulsanteAppDinamico3.setEnabled(false);
        PulsanteAppDinamico4.setEnabled(false);
        PulsanteAppDinamico5.setEnabled(false);
        PulsanteAppDinamico6.setEnabled(false);
        PulsanteAppDinamico7.setEnabled(false);
        PulsanteAppDinamico8.setEnabled(false);
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
        SalvaEVaiAMenu.setVisible(true);
        SalvaEVaiAMenu.setEnabled(true);
        Interroga.setVisible(true);
        Interroga.setEnabled(true);
        Osserva.setVisible(true);
        Osserva.setEnabled(true);
        Prendi.setVisible(true);
        Prendi.setEnabled(true);
        Salva.setVisible(true);
        Salva.setEnabled(true);
        ChiudiCaso.setVisible(true);
        ChiudiCaso.setEnabled(true);
        Apri.setEnabled(true);
    }

    public void disattivaCellulare() {
        GraficaCellulare.setEnabled(false);
        GraficaCellulare.setVisible(false);

        Esci.setVisible(false);
        Esci.setEnabled(false);
        Flash.setVisible(false);
        Flash.setEnabled(false);
        Fotocamera.setVisible(false);
        Fotocamera.setEnabled(false);
        Incastra.setVisible(false);
        Incastra.setEnabled(false);
        Inventario.setVisible(false);
        Apri.setVisible(false);
        Inventario.setEnabled(false);
        SalvaEVaiAMenu.setVisible(false);
        SalvaEVaiAMenu.setEnabled(false);
        Interroga.setVisible(false);
        Interroga.setEnabled(false);
        Osserva.setVisible(false);
        Osserva.setEnabled(false);
        Prendi.setVisible(false);
        Prendi.setEnabled(false);
        Salva.setVisible(false);
        Salva.setEnabled(false);
        ChiudiCaso.setVisible(false);
        ChiudiCaso.setEnabled(false);
        Apri.setEnabled(false);
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

    public void mostraInterfacciaMovimento() {
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

    public void disattivaInterfacciaSalvataggio() {
        SalvaLabel.setVisible(false);
        AnnullaSalvataggio.setEnabled(false);
        SceltaSi.setEnabled(false);
        SceltaNo.setEnabled(false);
        AnnullaSalvataggio.setVisible(false);
        SceltaSi.setVisible(false);
        SceltaNo.setVisible(false);
    }

    public void mostraInterfacciaSalvataggio() {
        SalvaLabel.setVisible(true);
        AnnullaSalvataggio.setEnabled(true);
        SceltaSi.setEnabled(true);
        SceltaNo.setEnabled(true);
        AnnullaSalvataggio.setVisible(true);
        SceltaSi.setVisible(true);
        SceltaNo.setVisible(true);
    }

    public void impostaSalvataggioSenzaUscita() {
        SceltaSi.setActionCommand("SALVA_SI");

        SceltaNo.setActionCommand("SALVA_NO");
    }

    public void impostaSalvataggioConUscita() {
        SceltaSi.setActionCommand("SALVA_SI_ED_ESCI");

        SceltaNo.setActionCommand("SALVA_NO_ED_ESCI");
    }

    public void impostaSalvataggioConMenu() {
        SceltaSi.setActionCommand("SALVA_SI_E_VAI_AL_MENU");

        SceltaNo.setActionCommand("SALVA_NO_E_VAI_AL_MENU");
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

    public String getNomePartita() {
        return NomePartita.getText();
    }

    public void mostraTesto(String messaggio) {
        ScritturaTesto.setText(messaggio + "\n");
    }

    public void aggiungiTesto(String messaggio) {
        ScritturaTesto.append(messaggio + "\n");
    }

    public void tornaAMenuIniziale() {
        disattivaCellulare();
        disattivaInterfacciaUtente();
        inizializzaMenu();
    }

    public void resettaTesto() {
        ScritturaTesto.setText(null);
    }

    public void disattivaInterfacciaGraficaAppCellulare() {
        GraficaAppCellulare.setVisible(false);
        GraficaAppCellulare.setEnabled(false);

        ChiudiGraficaAppCellulare.setVisible(false);
        ChiudiGraficaAppCellulare.setEnabled(false);
        
        PulsanteAppDinamico1.setEnabled(false);
        PulsanteAppDinamico1.setVisible(false);
        
        PulsanteAppDinamico2.setEnabled(false);
        PulsanteAppDinamico2.setVisible(false);
        
        PulsanteAppDinamico3.setEnabled(false);
        PulsanteAppDinamico3.setVisible(false);
        
        PulsanteAppDinamico4.setEnabled(false);
        PulsanteAppDinamico4.setVisible(false);
        
        PulsanteAppDinamico5.setEnabled(false);
        PulsanteAppDinamico5.setVisible(false);
        
        PulsanteAppDinamico6.setEnabled(false);
        PulsanteAppDinamico6.setVisible(false);
        
        PulsanteAppDinamico7.setEnabled(false);
        PulsanteAppDinamico7.setVisible(false);
        
        PulsanteAppDinamico8.setEnabled(false);
        PulsanteAppDinamico8.setVisible(false);
        
        MappaLabel.setEnabled(false);
        MappaLabel.setVisible(false);
    }

    public void chiudiInterfacciaGraficaAppCellulare() {
        mostraCellulare();
        disattivaInterfacciaGraficaAppCellulare();
    }
    
    public void inizializzaInterfacciaGraficaAppCellulare() {
        disattivaCellulare();
        GraficaAppCellulare.setVisible(true);
        GraficaAppCellulare.setEnabled(true);

        ChiudiGraficaAppCellulare.setVisible(true);
        ChiudiGraficaAppCellulare.setEnabled(true);
    }

    public void mostraMappa(){
        disattivaPulsantiDinamici();
        inizializzaInterfacciaGraficaAppCellulare();
        MappaLabel.setEnabled(true);
        MappaLabel.setVisible(true);
    }
    
    public void inizializzaPulsantiApp(String azione,List<Oggetto> oggetti,AzioniEseguite azioniEseguite) {
        disattivaPulsantiDinamici();
        ListIterator<Oggetto> lit = oggetti.listIterator();
        Oggetto app;
        String nome,nomeFile;
        azione = azione.toUpperCase();
        for(int i=1;lit.hasNext();i++) {
            app = lit.next();
            if((!app.isRaccoglibile() && !azione.equals("EQUIPAGGIA")) || (azioniEseguite.verificaPresenzaAzione(Azione.GUANTI_EQUIPAGGIATI) && app.getNome().equals("guanti"))){
                i--;
                continue;
            }
            nome = app.getNome().toUpperCase();
            nomeFile = app.getNome();
            switch(i){
                case 1:
                    PulsanteAppDinamico1.setIcon(new ImageIcon("./risorse/immagini/oggetti/"+nomeFile+".png"));
                    PulsanteAppDinamico1.setEnabled(true);
                    PulsanteAppDinamico1.setVisible(true);
                    PulsanteAppDinamico1.setActionCommand(azione+"_"+nome);
                    break;
                case 2:
                    PulsanteAppDinamico2.setIcon(new ImageIcon("./risorse/immagini/oggetti/"+nomeFile+".png"));
                    PulsanteAppDinamico2.setEnabled(true);
                    PulsanteAppDinamico2.setVisible(true);
                    PulsanteAppDinamico2.setActionCommand(azione+"_"+nome);
                    break;
                case 3:
                    PulsanteAppDinamico3.setIcon(new ImageIcon("./risorse/immagini/oggetti/"+nomeFile+".png"));
                    PulsanteAppDinamico3.setEnabled(true);
                    PulsanteAppDinamico3.setVisible(true);
                    PulsanteAppDinamico3.setActionCommand(azione+"_"+nome);
                    break;
                case 4:
                    PulsanteAppDinamico4.setIcon(new ImageIcon("./risorse/immagini/oggetti/"+nomeFile+".png"));
                    PulsanteAppDinamico4.setEnabled(true);
                    PulsanteAppDinamico4.setVisible(true);
                    PulsanteAppDinamico4.setActionCommand(azione+"_"+nome);
                    break;
                case 5:
                    PulsanteAppDinamico5.setIcon(new ImageIcon("./risorse/immagini/oggetti/"+nomeFile+".png"));
                    PulsanteAppDinamico5.setEnabled(true);
                    PulsanteAppDinamico5.setVisible(true);
                    PulsanteAppDinamico5.setActionCommand(azione+"_"+nome);
                    break;
                case 6:
                    PulsanteAppDinamico6.setIcon(new ImageIcon("./risorse/immagini/oggetti/"+nomeFile+".png"));
                    PulsanteAppDinamico6.setEnabled(true);
                    PulsanteAppDinamico6.setVisible(true);
                    PulsanteAppDinamico6.setActionCommand(azione+"_"+nome);
                    break;
                case 7:
                    PulsanteAppDinamico7.setIcon(new ImageIcon("./risorse/immagini/oggetti/"+nomeFile+".png"));
                    PulsanteAppDinamico7.setEnabled(true);
                    PulsanteAppDinamico7.setVisible(true);
                    PulsanteAppDinamico7.setActionCommand(azione+"_"+nome);
                    break;
                case 8:
                    PulsanteAppDinamico8.setIcon(new ImageIcon("./risorse/immagini/oggetti/"+nomeFile+".png"));
                    PulsanteAppDinamico8.setEnabled(true);
                    PulsanteAppDinamico8.setVisible(true);
                    PulsanteAppDinamico8.setActionCommand(azione+"_"+nome);
                    break;
                default:
                    break;
            }
        }
    }

    public void inizializzaAppIncastra() {
        disattivaPulsantiDinamici();
        PulsanteAppDinamico1.setIcon(new ImageIcon("./risorse/immagini/incastra/incastra_vito.png"));
        PulsanteAppDinamico1.setEnabled(true);
        PulsanteAppDinamico1.setVisible(true);
        PulsanteAppDinamico1.setActionCommand("INCASTRA_VITO");
        
        PulsanteAppDinamico2.setIcon(new ImageIcon("./risorse/immagini/incastra/incastra_michele.png"));
        PulsanteAppDinamico2.setEnabled(true);
        PulsanteAppDinamico2.setVisible(true);
        PulsanteAppDinamico2.setActionCommand("INCASTRA_MICHELE");
        
        PulsanteAppDinamico3.setIcon(new ImageIcon("./risorse/immagini/incastra/incastra_vincenzo.png"));
        PulsanteAppDinamico3.setEnabled(true);
        PulsanteAppDinamico3.setVisible(true);
        PulsanteAppDinamico3.setActionCommand("INCASTRA_VINCENZO");
    }

    public JButton getPulsanteCrediti(){
        return PulsanteCrediti;
    }

    public JButton getAnnullaSalvataggio() {
        return AnnullaSalvataggio;
    }

    public JButton getApri() {
        return Apri;
    }

    public JButton getApriEditor() {
        return ApriEditor;
    }

    public JButton getApriMovimento() {
        return ApriMovimento;
    }

    public JButton getApriTelefono() {
        return ApriTelefono;
    }

    public JButton getChiudiCaso() {
        return ChiudiCaso;
    }

    public JButton getChiudiGraficaAppCellulare() {
        return ChiudiGraficaAppCellulare;
    }

    public JButton getContinuaPartita1() {
        return ContinuaPartita1;
    }

    public JButton getContinuaPartita2() {
        return ContinuaPartita2;
    }

    public JButton getContinuaPartita3() {
        return ContinuaPartita3;
    }

    public JButton getContinuaPartita4() {
        return ContinuaPartita4;
    }

    public JButton getCreaSalvataggioEsci() {
        return CreaSalvataggioEsci;
    }

    public JButton getDestra() {
        return Destra;
    }

    public JButton getEsci() {
        return Esci;
    }

    public JButton getFlash() {
        return Flash;
    }

    public JButton getFotocamera() {
        return Fotocamera;
    }

    public JButton getGiu() {
        return Giu;
    }

    public JButton getIncastra() {
        return Incastra;
    }

    public JButton getIniziaPartita() {
        return IniziaPartita;
    }

    public JButton getInterroga() {
        return Interroga;
    }

    public JButton getInventario() {
        return Inventario;
    }

    public JButton getNuovaPartita1() {
        return NuovaPartita1;
    }

    public JButton getNuovaPartita2() {
        return NuovaPartita2;
    }

    public JButton getNuovaPartita3() {
        return NuovaPartita3;
    }

    public JButton getNuovaPartita4() {
        return NuovaPartita4;
    }

    public JButton getOsserva() {
        return Osserva;
    }

    public JButton getPrendi() {
        return Prendi;
    }

    public JButton getPulsanteAppDinamico1() {
        return PulsanteAppDinamico1;
    }

    public JButton getPulsanteAppDinamico2() {
        return PulsanteAppDinamico2;
    }

    public JButton getPulsanteAppDinamico3() {
        return PulsanteAppDinamico3;
    }

    public JButton getPulsanteAppDinamico4() {
        return PulsanteAppDinamico4;
    }

    public JButton getPulsanteAppDinamico5() {
        return PulsanteAppDinamico5;
    }

    public JButton getPulsanteAppDinamico6() {
        return PulsanteAppDinamico6;
    }

    public JButton getPulsanteAppDinamico7() {
        return PulsanteAppDinamico7;
    }

    public JButton getPulsanteAppDinamico8() {
        return PulsanteAppDinamico8;
    }
    
    public JButton getPulsanteEsci() {
        return PulsanteEsci;
    }

    public JButton getPulsanteIndaga() {
        return PulsanteIndaga;
    }

    public JButton getSalva() {
        return Salva;
    }

    public JButton getSalvaEVaiAMenu() {
        return SalvaEVaiAMenu;
    }

    public JButton getSceltaNo() {
        return SceltaNo;
    }

    public JButton getSceltaSi() {
        return SceltaSi;
    }

    public JButton getSalvataggiEsci() {
        return SalvataggiEsci;
    }

    public JButton getSinistra() {
        return Sinistra;
    }

    public JButton getSu() {
        return Su;
    }
    
    
}
