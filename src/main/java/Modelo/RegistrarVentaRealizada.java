package main.java.Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RegistrarVentaRealizada  {
    public void registrarVenta(double litros,double precio,LocalDateTime fecha);
    public List<Datos> ListadoPorFechas(LocalDate fechaInicio,LocalDate fechaFin);
}
