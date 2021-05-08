package main.java.Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Comun implements TipoNafta{
	private static final double PRECIO = 70;
	 private static final double DESCUETNO_5_PORCIENTO=(1-0.05);
	public Comun() {
		
	}

	@Override
	public double calularValor( LocalDateTime dia,double litros) {
		Fecha fecha = new Fecha(dia);
		if(fecha.estaEntre8y10())
			return litros*(PRECIO*DESCUETNO_5_PORCIENTO);
		return litros*PRECIO;
	}
}
