//P08

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;



	public class ConexionBD {
		
		//Un objeto de tipo connection que se inicializa a null (relacionado con el try catch)
		
		private Connection connect = null;
		
		public ConexionBD() {
			try {
			     //Cargar la clase
				
			      Class.forName("com.mysql.jdbc.Driver");
			      
			      // Conexion (login)
			    
			      connect = DriverManager.getConnection("jdbc:mysql://localhost/MathdiceDAM?user=Alfredo&password=");
			     System.out.println("Conexion realizada");
		    
			} catch (Exception e) {
				
				//Recoje el error que muestra
				
		        System.out.println(e);
		        System.out.println("Error en la Conexión");
		    } 
		}
		
		
		//Con este metodo recuperamos la conexion en curso.
		
		public Connection getConexion(){
				return connect;
		}

	}
