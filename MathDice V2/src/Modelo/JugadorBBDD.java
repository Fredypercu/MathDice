package Modelo;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import juego.Jugador;

public class JugadorBBDD {

		
		//Atributos de la conexion.
	
		private static Connection conexion;
		private static Statement orden = null;
		
		//Constructor, que permite realizar las consultas a la BBDD/Mathdice/Alfredo
		
		public JugadorBBDD(Connection c) {
			this.conexion=c;
		}
		
		//Inserta un usuario en la BBDD
		
		public static void insertarJugador(Jugador j){
			try{
				//Conexion
				
				orden = conexion.createStatement();
				
				//Sentencia de tipo INSERT.
				
			    String sql = "INSERT INTO mathdice (nombre,apellido1,apellido2,edad) "+"VALUES ('"+j.getNombre()+"', '"+j.getApellido1()+"', '"+j.getApellido2()+"', "+j.getEdad()+")";
			    
			    //Ejecutamos sentencia Linea Anterior
			    
			    orden.executeUpdate(sql);
			    System.out.println("Usuario Registrado Correctamente");
			   }catch(SQLException se){	
				   	  // ERRORES DE SQL
				   
				      se.printStackTrace();
			   }catch(Exception e){	
				   
				   	  // ERRORES DE JAVA
				   
				      e.printStackTrace();
			   }finally{
				   
				     //Cierre conexión BBDD
				   
				      try{
				         if(orden!=null)
				        	 conexion.close();
				      }catch(SQLException se){
				      }
				      try{
				    
				    	  
				         if(conexion!=null)
				        	 conexion.close();
				      	 }catch(SQLException se){
				         se.printStackTrace();
				      }
				}
		}
	}
