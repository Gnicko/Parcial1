package main.java.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.java.Modelo.RegistrarVentaRealizada;
import main.java.Modelo.TipoNafta;
import main.java.Persistencia.BaseDeDatos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {

	private RegistrarVentaRealizada registsRegistrarVentaRealizada;
	private JPanel contentPane;

	
	public VentanaInicio(RegistrarVentaRealizada registrarVentaRealizada) {
		this.registsRegistrarVentaRealizada= registrarVentaRealizada;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton cargarCombustible_btnNewButton = new JButton("Cargar Combustible");
		cargarCombustible_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCargarNafta pantalla = new VentanaCargarNafta(registrarVentaRealizada);
				pantalla.setVisible(true);
			}
		});
		cargarCombustible_btnNewButton.setBounds(37, 147, 155, 21);
		contentPane.add(cargarCombustible_btnNewButton);
		
		JButton consutlarVemtas_btnNewButton_1 = new JButton("Consultar Ventas");
		consutlarVemtas_btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaVentas ventana = new VentanaVentas(registrarVentaRealizada);
				ventana.setVisible(true);
			}
		});
		consutlarVemtas_btnNewButton_1.setBounds(244, 147, 149, 21);
		contentPane.add(consutlarVemtas_btnNewButton_1);
	}

}
