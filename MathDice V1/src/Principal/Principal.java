package Principal;

import Ventanas.Juego;
import Ventanas.Login;


// Clase que contiene el m�todo main() e inicia la aplicaci�n
public class Principal {

	public static void main(String[] args) {
		//Todas las ventanas a utilizar
		Juego ventanaJuego = new Juego();
		
		Login login = new Login(ventanaJuego);
		login.setVisible(true);
		
		
				

	}

} // Fin de la clase Principal
