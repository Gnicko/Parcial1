package main.java.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.java.Modelo.Comun;
import main.java.Modelo.RegistrarVentaRealizada;
import main.java.Modelo.Super;
import main.java.Modelo.TipoNafta;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class VentanaCargarNafta extends JFrame {

    private JPanel contentPane;
    private JTextField litro_textField;


    public VentanaCargarNafta(RegistrarVentaRealizada registrarVentaRealizada) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 671, 354);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        litro_textField = new JTextField();
        litro_textField.setBounds(326, 60, 96, 19);
        contentPane.add(litro_textField);
        litro_textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Litros de Nafta");
        lblNewLabel.setBounds(62, 63, 96, 13);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Tipo de Nafta");
        lblNewLabel_1.setBounds(62, 120, 83, 25);
        contentPane.add(lblNewLabel_1);

        JComboBox nafta_comboBox = new JComboBox();
        nafta_comboBox.setBounds(326, 135, 96, 21);
        nafta_comboBox.addItem("Super");
        nafta_comboBox.addItem("Comun");
        contentPane.add(nafta_comboBox);
        JLabel monto_label = new JLabel("");
        monto_label.setBounds(325, 203, 68, 13);
        contentPane.add(monto_label);

        JButton btnNewButton = new JButton("Consultar Monto");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            		double litros = Double.parseDouble(litro_textField.getText());
            	
            		
            	String nafta=String.valueOf(nafta_comboBox.getSelectedItem());
            	TipoNafta tipoNafta;
            	if(esSuper(nafta)) {
            		tipoNafta = new Super();
            	}else 
            		tipoNafta = new Comun();
            
            monto_label.setText(String.valueOf(tipoNafta.calularValor(LocalDateTime.now(), litros)));
            }catch(Exception e1) {
            	JOptionPane.showMessageDialog(null, "ingrese un numero valido para los litros","error",JOptionPane.ERROR_MESSAGE);
   	}  	
            }});
        btnNewButton.setBounds(62, 199, 142, 21);
        contentPane.add(btnNewButton);

       
        JButton btnNewButton_1 = new JButton("Confirmar");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try{double litros =1;
            			litros= Double.parseDouble(litro_textField.getText());
            	String nafta=String.valueOf(nafta_comboBox.getSelectedItem());
            	TipoNafta tipoNafta;
            	if(esSuper(nafta)) {
            		tipoNafta = new Super();
            	}else 
            		tipoNafta = new Comun();
            	registrarVentaRealizada.registrarVenta(litros,calcularMonto(tipoNafta, litros), LocalDateTime.now());
            	JOptionPane.showMessageDialog(null,"Se guardo la venta","Exito",JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e1) {
            	JOptionPane.showMessageDialog(null, "ingrese un numero valido para los litros","error",JOptionPane.ERROR_MESSAGE);
   	}
           
            	
   	
            }
        });
        btnNewButton_1.setBounds(60, 258, 85, 21);
        contentPane.add(btnNewButton_1);
   
    }
    public boolean esSuper(String nafta) {
    	return nafta.equals("Super");
    }
    public double calcularMonto(TipoNafta tipoNafta,double litros) {
    	return tipoNafta.calularValor(LocalDateTime.now(),litros);
    }
   
}