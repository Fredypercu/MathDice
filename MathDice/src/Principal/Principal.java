package Principal;

import Ventanas.VentanaInicio;
import Ventanas.VentanaPrincipal;

public class Principal{
	
	
	//La entrada a nuestro programa
	//Es el método main
	
	public static void main(String[] args) {
		//Todas las ventanas a utilizar
		
		VentanaPrincipal vPrincipal=new VentanaPrincipal();
		
		VentanaInicio frame = new VentanaInicio(vPrincipal);
		frame.setVisible(true);
		
	
    }
	
	public Principal() {
		
	}
	
}
