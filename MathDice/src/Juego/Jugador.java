package Juego;

import javax.security.auth.callback.TextOutputCallback;
import javax.swing.JTextField;
/*
 * La definición de la clase mediante la palabra reservada Jugador
 * 
 * public class nombreClase
 */
public class Jugador {

		//Propiedades
		private String nombre;
		private String apellidos;
		private int edad;
		private int puntos;
		
		//Punto de entrada que se ejeuta al crear un objeto de tipo Jugador
		
		public Jugador(String nom, String ape, Integer eda) {
			
			nombre=nom;
			apellidos=ape;
			edad=eda;
			puntos=0;
		}
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nom){
			nombre = nom;
			
		}
		
		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String ape){
	        apellidos = ape;
			
		}
		
		public int getEdad() {
			return edad;
		}
		
		public void setEdad(int eda){
			edad = eda;
		
		}
		
		public int getPuntos() {
			return puntos;
		}

		public void setPuntos(int pun) {
			puntos = pun;
		}


		//Constructor
	   // Punto de entrada que se ejecuta al crear un objeto de tipo jugador
		public Jugador() {
			System.out.println("Jugador");
	}

}		
		
