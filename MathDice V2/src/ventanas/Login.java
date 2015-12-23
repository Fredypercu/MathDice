package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.Jugador;

import javax.swing.JLabel;

public class Login extends JFrame {

	private JPanel contentPane;

	//Creacion de la ventana
	public Login(Jugador j) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Labeljugador que variará según el jugador introducido.
		JLabel labeljugador = new JLabel(" Bienvenido " + j.getNombre());
		labeljugador.setBounds(244, 11, 180, 25);
		contentPane.add(labeljugador);
	}
}
