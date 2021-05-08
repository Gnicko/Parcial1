package main.java.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import main.java.Modelo.Datos;
import main.java.Modelo.Fecha;
import main.java.Modelo.RegistrarVentaRealizada;
import main.java.Modelo.TipoNafta;

public class BaseDeDatos implements RegistrarVentaRealizada {
	  private String url;
		    private String user;
		    private String password;
		    private Connection conector;
		   

	public BaseDeDatos() {
	
		try {
			conectar();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void conectar()throws SQLException {
		  
		        this.url = "jdbc:mysql://localhost:3306/epp_gomez?useSSL=false";
		        this.user = "root";
		        this.password = "";
		        try{
		        	   this.conector = DriverManager.getConnection(url, user, password);
		        }catch (SQLException e){
		           throw new RuntimeException("no se pudo conectarse con la base de datos");
		        }
		    }	
		@Override
		public void registrarVenta(double litros, double precio,LocalDateTime fecha) throws RuntimeException {
        try {
        	
            conectar();
            PreparedStatement st = conector.prepareStatement("insert into ventas(litros, precio, fecha) values(?,?,?)");
            
            st.setDouble(1,litros );
            st.setDouble(2, precio);
            st.setTimestamp(3, Timestamp.valueOf(fecha));
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar Participante");
        }catch (RuntimeException e1){
            throw e1;
        }
    }
	public List<Datos> ListadoPorFechas(LocalDate fechaInicio,LocalDate fechaFin)throws RuntimeException {
			List<Datos> datos = new ArrayList<Datos>();
			
			try {
				conectar();
	            PreparedStatement st = conector.prepareStatement("Select * FROM ventas ");
	            ResultSet result = st.executeQuery(); 
				while (result.next()) {
					if(estaEntreFechas(fechaInicio, fechaFin, result.getTimestamp("fecha").toLocalDateTime().toLocalDate()))
						datos.add(new Datos(result.getTimestamp("fecha").toLocalDateTime(),result.getDouble("precio"),result.getDouble("litros") ));
				}
				
			} catch (SQLException e) {
				throw new RuntimeException("no se pudo recuperar la lista",e);
			}
			return datos;
		}
	 public boolean estaEntreFechas(LocalDate desde,LocalDate hasta,LocalDate actual) {
	    	return actual.isBefore(hasta)&& actual.isAfter(desde)||(actual.equals(desde)||actual.equals(hasta));
	    }
	


}
