package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Juego extends JFrame {

	private JPanel contentPane;

	private JLabel msjBienvenida;

	/**
	 * Create the frame.
	 */
	public Juego() {
		setTitle("Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		msjBienvenida = new JLabel("");
		msjBienvenida.setBounds(228, 25, 159, 14);
		contentPane.add(msjBienvenida);
		
		
	}
}
