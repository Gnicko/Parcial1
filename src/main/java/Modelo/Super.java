package main.java.Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Super implements TipoNafta{
 private static final double PRECIO = 90;
 private static final double LITROSDEPROMOCION = 20;
 private static final double DESCUETNODE_10_PORCIENTO=(1-0.1);
 private static final double DESCUETNODE_12_PORCIENTO=(1-0.12);
public Super() {
	
}
	@Override
	public double calularValor(LocalDateTime dia,double litros) {
		Fecha fecha = new Fecha(dia);
		if(fecha.esDomingo())
			return litros *(PRECIO*DESCUETNODE_10_PORCIENTO);
		if(fecha.esSabado()&&TienePromocionDe20Litros(litros)) {
			return litros*(PRECIO*DESCUETNODE_12_PORCIENTO);
			}
		return litros * PRECIO;
	}
	public boolean TienePromocionDe20Litros(double litros) {
		return litros>LITROSDEPROMOCION;
	}
}