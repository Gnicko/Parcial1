package main.java.Persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import main.java.Modelo.Datos;
import main.java.Modelo.RegistrarVentaRealizada;

public class ArchivoTexto implements RegistrarVentaRealizada{
	private String direccion;
	 public ArchivoTexto(String direccion) {
	        Objects.requireNonNull(direccion, "La direccion ingresada es Null");
	        Path path = Paths.get(direccion);
	        if (Files.notExists(path)) {
	            throw new RuntimeException("La direccion ingresada no existe");
	        }
	        this.direccion = direccion;
	    }
	
	@Override
	public void registrarVenta(double litros, double precio, LocalDateTime fecha) {
       String dato=fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))+", "+precio+", "+litros+"\n";
		try {
	            Files.write(Paths.get(direccion), dato.getBytes(), StandardOpenOption.APPEND);
	        } catch (IOException e) {
	            throw new RuntimeException("No se pudo guardar el pago en el archivo de texto");
	        }
	   	
	}

	@Override
	public List<Datos> ListadoPorFechas(LocalDate fechaInicio, LocalDate fechaFin) {
		 List<Datos> listaDatos = new ArrayList<>();
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(direccion));
	            for (String dato : reader.lines().collect(Collectors.toList())) {
	                String[] info = dato.split(", ");
	               
	                Datos d = new Datos( LocalDateTime.parse(info[0],DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
	                		Double.parseDouble(info[1]),
	                		Double.parseDouble(info[2]));
	                if(estaEntreFechas(fechaInicio,
	                		fechaFin,
	                		LocalDateTime.parse(info[0],DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")).toLocalDate()))
	                	listaDatos.add(d);
	            }
	        } catch (FileNotFoundException e) {
	            throw new RuntimeException(e);
	        }
	        return listaDatos;
	    }
	 public boolean estaEntreFechas(LocalDate desde,LocalDate hasta,LocalDate actual) {
	    	return actual.isBefore(hasta)&& actual.isAfter(desde)||(actual.equals(desde)||actual.equals(hasta));
	}
	 }


