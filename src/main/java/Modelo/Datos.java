package main.java.Modelo;

import java.time.LocalDateTime;

public class Datos {
private double litros;
private double precio;
private LocalDateTime fecha;
public Datos(LocalDateTime fecha, double precio, double litros) {
	this.fecha= fecha;
	this.litros = litros;
	this.precio = precio;
}
public double obtenerLitros() {
	return litros;
}
public double obtenerPrecio() {
	return precio;
}
public LocalDateTime obtenerFecha() {
	return fecha;
}

}
