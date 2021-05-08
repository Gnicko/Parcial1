package Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.java.Modelo.Datos;
import main.java.Persistencia.PersistenciaEnMemoria;
import main.java.UI.VentanaInicio;

class RegistrarVentaRealizadaTest {

	@Test
	public void registrarVentaTest() {
	PersistenciaEnMemoria persistencia = new PersistenciaEnMemoria();
	VentanaInicio ventana = new VentanaInicio(persistencia);
	persistencia.registrarVenta(12, 50,LocalDateTime.now());
	
	assertEquals(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+", "+50.0+", "+12.0+"\n", persistencia.obtenerInformacionAlmacenada());	
	}
	
	
	@Test
	public void  ListadoPorFechasTest() {
		PersistenciaEnMemoria persistencia = new PersistenciaEnMemoria();
		VentanaInicio ventana = new VentanaInicio(persistencia);
		List<Datos>prueba = new ArrayList<>();
		
		prueba.add(new Datos(LocalDateTime.now(),12 , 50));
		prueba.add(new Datos(LocalDateTime.now().plusDays(1),15,100));
	
		persistencia.registrarVenta(12, 50,LocalDateTime.now().minusDays(2));
		persistencia.registrarVenta(12, 50,LocalDateTime.now());
		persistencia.registrarVenta(15, 100,LocalDateTime.now().plusDays(1));
		persistencia.registrarVenta(12, 50,LocalDateTime.now().minusDays(1));
		
		List<Datos>datos = persistencia.ListadoPorFechas(LocalDate.now(), LocalDate.now().plusDays(2));
		assertEquals(leerArreglo(prueba), leerArreglo(datos));
	}
	private String  leerArreglo(List<Datos> listaDatos) {
		String informacion="";
		for (Datos dato:listaDatos) {
			informacion+= dato.obtenerFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+", "+dato.obtenerPrecio()+", "+dato.obtenerLitros()+"\n";
			}
	 return informacion;
	}

}
