package main.java.Persistencia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import main.java.Modelo.Datos;
import main.java.Modelo.RegistrarVentaRealizada;

public class PersistenciaEnMemoria implements RegistrarVentaRealizada{
private String dato;

	@Override
	public void registrarVenta(double litros, double precio, LocalDateTime fecha) {
		 dato=fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+", "+precio+", "+litros+"\n";
	}

	@Override
	public List<Datos> ListadoPorFechas(LocalDate fechaInicio, LocalDate fechaFin) {
		List<Datos> listaDatos = new ArrayList<>();
		String[] info = dato.split(", ");
		  Datos d = new Datos( LocalDateTime.parse(info[0],DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
				  Double.parseDouble(info[1])
				  ,Double.parseDouble(info[2]));
		  if(estaEntreFechas(fechaInicio,
          		fechaFin,
          		LocalDateTime.parse(info[0],DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")).toLocalDate()))
          	listaDatos.add(d);
	return listaDatos;
	}
	 public boolean estaEntreFechas(LocalDate desde,LocalDate hasta,LocalDate actual) {
	    	return actual.isBefore(hasta)&& actual.isAfter(desde)||(actual.equals(desde)||actual.equals(hasta));
	}
	 
	 public String obtenerInformacionAlmacenada() {
		 return dato;
	 }
}
