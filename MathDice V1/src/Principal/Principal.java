package Principal;

import java.awt.EventQueue;
import javax.swing.JFrame;

import Ventanas.Juego;
import Ventanas.Login;


// Clase que contiene el método main() e inicia la aplicación
public class Principal extends JFrame{

	public static void main(String[] args) {
		//Todas las ventanas a utilizar
		Juego ventanaJuego = new Juego();
		
		Login login = new Login(ventanaJuego);
		login.setVisible(true);
		
		
				

	}

} // Fin de la clase Principal
