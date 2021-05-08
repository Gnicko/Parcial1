package mains;

import main.java.Persistencia.ArchivoTexto;
import main.java.UI.VentanaInicio;

public class MainArchivo {
	public static void main(String[] args) {
		VentanaInicio ventana = new VentanaInicio(new ArchivoTexto("archivo"));
	}
}
	
