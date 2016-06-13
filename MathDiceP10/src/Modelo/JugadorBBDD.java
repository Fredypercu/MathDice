package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import juego.Jugador;

public class JugadorBBDD {

	// Atributos necesarios de la conexion.
	
	private static Connection conexion;
	private static Statement orden = null;

	// Constructor BBDD
	
	
	public JugadorBBDD(Connection c) {
		this.conexion = c;
	}

	//  Se registra el usuario

	// Inserto usuario BBDD
	
	public static void insertarJugador(Jugador j) {
		Integer aux = 0;
		try {
			
			// Conectarse a la conexion
			
			
			orden = conexion.createStatement();
			
			
			// Sentencias SQL consultas a la BBDD
			
			
			String sql = "INSERT INTO registro (nombre,apellido1,apellido2,edad,puntos) " + "VALUES ('" + j.getNombre()
					+ "', '" + j.getPrimerApellido() + "', '" + j.getSegundoApellido() + "', " + j.getEdad() + ", "
					+ aux + ")";
			
			// Ejecutamos la sentencia SQL
			
			orden.executeUpdate(sql);
			System.out.println("Usuario registrado con exito");

			idNuevosJugadores(j);

		} catch (SQLException se) {
			
			// Errores de la consulta SQL
			
			se.printStackTrace();
		} catch (Exception e) {
			
			// Error de Java
			
			e.printStackTrace();
		} finally {
			
			// ESTE APARTADO SIRVE PARA CERRAR LA CONEXION
			/*
			 * try{ if(orden!=null) conexion.close(); }catch(SQLException se){ }
			 * try{ //Comprueba que la conexion SIGUE ABIERTA para cerrarla
			 * if(conexion!=null) conexion.close(); }catch(SQLException se){
			 * se.printStackTrace(); }
			 */
		}

	}

	
	// Almacenados el id de los jugadores que se registran en la BBDD
	

	public static void idNuevosJugadores(Jugador j) {
		ResultSet rs;
		try {
			orden = conexion.createStatement();
			String sql = "SELECT ID FROM registro ORDER BY `ID` DESC LIMIT 1";
			rs = orden.executeQuery(sql);
			
			// Cogemos los usuarios
			
			while (rs.next()) {
				j.setId(rs.getInt("ID"));
			}
			//  Cierro la conexion
			
			rs.close();
		} catch (SQLException se) {
			
			// Si se produce algún error con la consulta SQL
			
			se.printStackTrace();
		} catch (Exception e) {
			
			// Cualquier otro error
			
			e.printStackTrace();
		} finally {
		}
	}


	// Rellenamos el JComboBox a partir de los datos de la BBDD
	
	public static void extraerJugadoresBBDD(JComboBox jc) {
		ResultSet rs;
		try {
			orden = conexion.createStatement();
			String sql = "SELECT ID, nombre, apellido1, apellido2, puntos, edad FROM registro";
			rs = orden.executeQuery(sql);
			
			// Cogemos los usuarios
			
			while (rs.next()) {
				Integer idJugadorBBDD = rs.getInt("ID");
				String nombreJugadorBBDD = rs.getString("nombre");
				String apellido1JugadorBBDD = rs.getString("apellido1");
				String apellido2JugadorBBDD = rs.getString("apellido2");
				Integer edadJugadorBBDD = rs.getInt("edad");
				Integer puntosJugadorBBDD = rs.getInt("puntos");

				Jugador u = new Jugador(nombreJugadorBBDD, apellido1JugadorBBDD, apellido2JugadorBBDD, edadJugadorBBDD);
				u.setId(idJugadorBBDD);
				u.setPuntos(puntosJugadorBBDD);
				jc.addItem(u);

			}
			// Debemos cerrar la conexion
			
			rs.close();
		} catch (SQLException se) {
			
			// Si se produce algún error con la consulta SQL
			
			se.printStackTrace();
		} catch (Exception e) {
			
			// Cualquier otro error
			
			e.printStackTrace();
		} finally {

			/*
			 * //Cerramos los recursos try{ if(orden!=null) conexion.close();
			 * }catch(SQLException se){ } try{ if(conexion!=null)
			 * conexion.close(); }catch(SQLException se){ se.printStackTrace();
			 * }//end finally try
			 */
		}
	}

	//Se actualiza la puntuación cuando ganas

	public static void jugadorGana(Jugador u) {
		Integer puntosantiguos = u.getPuntos();
		Integer puntosnuevos = puntosantiguos + 5;
		u.setPuntos(puntosnuevos);
		try {
			orden = conexion.createStatement();

			String sql = "UPDATE registro " + "SET nombre = '" + u.getNombre() + "'" + ",apellido1 = '"
					+ u.getPrimerApellido() + "'" + ",apellido2 = '" + u.getSegundoApellido() + "'" + ",edad = "
					+ u.getEdad() + " " + ",puntos = " + puntosnuevos + " " + "WHERE id = " + u.getId();

			orden.executeUpdate(sql);
		} catch (SQLException se) {
			
			// Si se produce algún error con la consulta SQL
			
			se.printStackTrace();
		} catch (Exception e) {
			
			// Cualquier otro error
			
			e.printStackTrace();
		} finally {
			
			
			// Cerramos los recursos

		}
	}

	//Se actualizan los datos del jugador si gana en la BBDD

	public static void actualizarJugador(Jugador u) {

		try {
			orden = conexion.createStatement();

			String sql = "UPDATE registro " + "SET nombre = '" + u.getNombre() + "'" + ",apellido1 = '"
					+ u.getPrimerApellido() + "'" + ",apellido2 = '" + u.getSegundoApellido() + "'" + ",edad = "
					+ u.getEdad() + " " + ",puntos = " + u.getPuntos() + " " + "WHERE id = " + u.getId();

			orden.executeUpdate(sql);
		} catch (SQLException se) {
			
			// Si se produce algún error con la consulta SQL
			
			se.printStackTrace();
		} catch (Exception e) {
			
			// Se produce cualquier otro error
			
			e.printStackTrace();
		} finally {
			
			// Cerramos los recursos


		}
	}
}
