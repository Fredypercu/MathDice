package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import javax.swing.JLabel;

public class Juego extends JFrame {

	private JPanel contentPane;

	//Creacion de la ventana
	public Juego() {
		setTitle("Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Label1 - label que contiene "bienvenido jugador" esta no se cambia
		JLabel msjBienvenida = new JLabel("Bienvenido jugador");
		msjBienvenida.setBounds(10, 11, 150, 30);
		contentPane.add(msjBienvenida);
		
		
		
		
	}
}
