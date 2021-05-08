package main.java.Modelo;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Fecha {
    private LocalDateTime fecha;
    public Fecha(LocalDateTime fecha){
        this.fecha = fecha;
    }
    public boolean esDomingo() {
    	return this.fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY);
 	
    }
    public boolean esSabado() {
    	return this.fecha.getDayOfWeek().equals(DayOfWeek.SATURDAY);
    }
    public boolean estaEntre8y10() {
    	return (fecha.getHour()>=8 && fecha.getHour() <=10);
    }
   
    
}
