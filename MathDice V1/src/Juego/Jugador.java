package Juego;
import javax.security.auth.callback.TextOutputCallback;
import javax.swing.JTextField;

public class Jugador {

	// PROPIEDADES del jugador
	private String nombre; // Almacenara el nombre de un jugador
	private String apellidos; // Almacenara los apellidos de un jugador
	private int puntuacion; // Almacenara la puntuacion del jugador
	private int edad; // Almacenara la edad del jugador

	public Jugador() {

	}// Fin del constructor.

	// METODOS setters y getters. 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {

		if (edad < 0) {
			this.edad = 1;

		} else {
			this.edad = edad;
		}

	}

}// Fin de la clase Jugador.
