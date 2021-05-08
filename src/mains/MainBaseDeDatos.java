package mains;

import main.java.Persistencia.BaseDeDatos;
import main.java.UI.VentanaInicio;

public class MainBaseDeDatos {
	public static void main(String[] args) {
	
		VentanaInicio ventana =new VentanaInicio(new BaseDeDatos());
		
	}
}
