//P08

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;



	public class ConexionBBDD {
		
		//Un objeto de tipo connection que se inicializa a null (relacionado con el try catch)
		
		private Connection connect = null;
		
		public ConexionBBDD() {
			try {
			     //Cargar la clase
				
			      Class.forName("com.mysql.jdbc.Driver");
			      
			      // Conexion (login)
			    
			      connect = DriverManager.getConnection("jdbc:mysql://localhost/mathdicedam?"
				      		+ "user=Alfredo&password=Marimba19");
			      
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
