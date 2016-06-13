package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBBDD {
	
	//Un objeto de tipo connection que se inicializa a null (relacionado con el try catch)
	
	private static Connection connect = null;
	
	//Instanciar=crear objeto
	
	//No dejamos registrar mismo usuario en la BBDD mas de una vez
	
	private static ConexionBBDD INSTANCE = null;
	
	private ConexionBBDD() {
		try {
		     //Cargar la clase en ejecucion del driver que usemos 
			
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //En esta linea se realiza la conexion (login)
		      //jbdc = porque es driver que usamos
		      //mysql = porque es la base de datos que vamos a usar y es la que nos relaciona con el driver
		      //localhost=porque el servidor al que accedemos es un servidor local. Aqui se cambiaria por una IP en caso de conectarnos a un server remoto
		      //mathdicedam = Es el nombre de la base de datos 
		      
		      connect = DriverManager.getConnection("jdbc:mysql://localhost/mathdicedam?"
			      		+ "user=Alfredo&password=Marimba19");
		      System.out.println("Conexion realizada");
		      
		} catch (Exception e) {
			
			//Error que muestra Java
			
	        System.out.println(e);
	        System.out.println("La conexión ha fallado, revisa por favor");
	    } 
	}
	
	
	//Se recupera la conexion en curso.
	
	public static Connection getConexion(){
		if (INSTANCE==null){
			INSTANCE=new ConexionBBDD();
		}
		
			return connect;
	}

}