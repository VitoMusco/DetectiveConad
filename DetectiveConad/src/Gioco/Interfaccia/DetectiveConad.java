package Gioco.Interfaccia;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class DetectiveConad {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetectiveConad window = new DetectiveConad();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DetectiveConad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBackground(new Color(240, 240, 240));
		frame.setSize(1220, 710);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(237, 38, 740, 512);
		frame.getContentPane().add(scrollPane);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setEditable(false);
		textField.setBorder(null);
		textField.setBackground(new Color(0, 0, 0));
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(null);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(238, 41, 739, 511);
		frame.getContentPane().add(textArea);
		
		JButton Usa = new JButton("");
		Usa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Usa.setContentAreaFilled(false);
		Usa.setBorder(null);
		Usa.setBounds(990, 475, 39, 40);
		frame.getContentPane().add(Usa);
		
		JButton Osserva = new JButton("");
		Osserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Osserva.setContentAreaFilled(false);
		Osserva.setBorder(null);
		Osserva.setBounds(990, 411, 39, 40);
		frame.getContentPane().add(Osserva);
		
		JButton Inventario = new JButton("");
		Inventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Inventario.setContentAreaFilled(false);
		Inventario.setBorder(null);
		Inventario.setBounds(990, 239, 39, 40);
		frame.getContentPane().add(Inventario);
		
		JButton Mappa = new JButton("");
		Mappa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Mappa.setContentAreaFilled(false);
		Mappa.setBorder(null);
		Mappa.setBounds(990, 174, 39, 40);
		frame.getContentPane().add(Mappa);
		
		JButton Menu = new JButton("");
		Menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Menu.setContentAreaFilled(false);
		Menu.setBorder(null);
		Menu.setBounds(155, 471, 39, 40);
		frame.getContentPane().add(Menu);
		
		JButton Freccia_in_alto = new JButton("");
		Freccia_in_alto.setContentAreaFilled(false);
		Freccia_in_alto.setBorder(null);
		Freccia_in_alto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Freccia_in_alto.setBounds(107, 167, 39, 47);
		frame.getContentPane().add(Freccia_in_alto);
		
		JButton Freccia_in_basso = new JButton("");
		Freccia_in_basso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Freccia_in_basso.setContentAreaFilled(false);
		Freccia_in_basso.setBorder(null);
		Freccia_in_basso.setBounds(107, 259, 39, 47);
		frame.getContentPane().add(Freccia_in_basso);
		
		JButton Freccia_a_destra = new JButton("");
		Freccia_a_destra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Freccia_a_destra.setContentAreaFilled(false);
		Freccia_a_destra.setBorder(null);
		Freccia_a_destra.setBounds(145, 217, 49, 38);
		frame.getContentPane().add(Freccia_a_destra);
		
		JButton Freccia_a_sinistra = new JButton("");
		Freccia_a_sinistra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Freccia_a_sinistra.setContentAreaFilled(false);
		Freccia_a_sinistra.setBorder(null);
		Freccia_a_sinistra.setBounds(58, 215, 49, 40);
		frame.getContentPane().add(Freccia_a_sinistra);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DetectiveConad.class.getResource("/Gioco/Interfaccia/Console.png")));
		lblNewLabel.setBounds(1, 0, 1194, 668);
		frame.getContentPane().add(lblNewLabel);
	}
}
