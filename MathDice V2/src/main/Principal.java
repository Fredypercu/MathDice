package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import ventanas.VentanaInicio;

public class Principal extends JFrame{
	public Principal() {
	}
	
	// Inicialización Aplicación
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Creamos objeto VentanaInicio
					
					VentanaInicio frame = new VentanaInicio();
					// Objeto Visible
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
