package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import juego.Jugador;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;

	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textEdad;
	private JTextField cajaMSN;

	//Crea un objeto de tipo VentanaInicio
	public VentanaInicio() {
		
		//Título Ventana
		setTitle("Login");

		// Propiedades de ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// texto1
		JLabel lblDTJ = new JLabel("DATOS DEL JUGADOR");
		lblDTJ.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDTJ.setBounds(10, 11, 242, 25);
		contentPane.add(lblDTJ);

		// texto2
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 50, 46, 14);
		contentPane.add(lblNombre);

		// texto3
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 81, 76, 14);
		contentPane.add(lblApellidos);

		// texto4
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 112, 46, 14);
		contentPane.add(lblEdad);

		// caja Nombre
		textNombre = new JTextField();
		textNombre.setBounds(107, 47, 286, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		// caja Apellidos
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(107, 78, 286, 20);
		contentPane.add(textApellidos);

		// caja Edad
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(107, 109, 76, 20);
		contentPane.add(textEdad);

		// caja MSN (Mensaje Nuevo Jugador)
		cajaMSN = new JTextField();
		cajaMSN.setBounds(10, 188, 414, 62);
		contentPane.add(cajaMSN);
		cajaMSN.setColumns(10);

		// Boton
		JButton btnAJUGAR = new JButton("A JUGAR");
		btnAJUGAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				try{				
					if (textNombre.getText().compareTo("")==0|| textApellidos.getText().compareTo("")==0 || textEdad.getText().compareTo("")==0) {
						cajaMSN.setText("Rellene todos los campos parea poder empezar el juego");
					} else {
						Jugador j = new Jugador(textNombre.getText(), textApellidos.getText(), Integer.valueOf(textEdad.getText()));
						cajaMSN.setText("Player " + j.getNombre() + " " + j.getApellidos() + " de edad " + j.getEdad() + " creado correctamente ");
						//Aqui creamos un objeto de tipo login(una ventana de login) pero no se va a ejecutar todavia
						Login l =new Login(j);
						//Con esta linea hacemos que la ventana se muestre.
						l.setVisible(true); 
					}				
				} catch(Exception e) {
					cajaMSN.setText("Has introducido un valor de edad invalido");
				}
			}
		});
		btnAJUGAR.setBounds(25, 154, 383, 23);
		contentPane.add(btnAJUGAR);
	}

}
