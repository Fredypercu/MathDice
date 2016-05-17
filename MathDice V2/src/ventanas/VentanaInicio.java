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


import com.mysql.jdbc.Connection;
import Modelo.ConexionBD;
import Modelo.JugadorBBDD;


public class VentanaInicio extends JFrame {

	private JPanel contentPane;

	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textEdad;
	private JTextField cajaMSN;
	private VentanaInicio ref;

	
	
	//Creamos la conexion a la BBDD.
	
		private ConexionBD conexion1 = new ConexionBD();
	
		private Connection conexion = (Connection) conexion1.getConexion();
		
		//Inicializar la clase JugadorBBDD,
		
		private JugadorBBDD jugadorBBDD = new JugadorBBDD(conexion);
	
	
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
		JLabel lblApellido1 = new JLabel("Apellido1");
		lblApellido1.setBounds(10, 81, 76, 14);
		contentPane.add(lblApellido1);

		// texto4
		JLabel lblApellido2 = new JLabel("Apellido2");
		lblApellido2.setBounds(10, 102, 80, 16);
		contentPane.add(lblApellido2);

		// texto5
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 129, 46, 14);
		contentPane.add(lblEdad);


		// caja Nombre
		textNombre = new JTextField();
		textNombre.setBounds(107, 47, 120, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		// caja Apellido1
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(107, 78, 145, 20);
		contentPane.add(textApellido1);
		
		// caja Apellido2
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(107, 99, 145, 20);
		contentPane.add(textApellido2);

		// caja Edad
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(107, 126, 40, 20);
		contentPane.add(textEdad);

		// caja MSN (Mensaje Nuevo Jugador)
		
		cajaMSN = new JTextField();
		cajaMSN.setBounds(10, 188, 414, 62);
		contentPane.add(cajaMSN);
		cajaMSN.setColumns(10);

		//referencia de la ventana
		
		ref=this;
		
		// Boton Jugar
		
		JButton btnAJUGAR = new JButton("A JUGAR");
		btnAJUGAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				try{				
					if (textNombre.getText().compareTo("")==0|| textApellido1.getText().compareTo("")==0|| textApellido2.getText().compareTo("")==0 ||textEdad.getText().compareTo("")==0) {
						cajaMSN.setText("Rellene todos los campos parea poder empezar el juego");
					} else {
						Jugador j = new Jugador(textNombre.getText(), textApellido1.getText(), textApellido2.getText(), Integer.valueOf(textEdad.getText()));
						cajaMSN.setText("Player " + j.getNombre() + " " + j.getApellido1() + " " + j.getApellido2() + " de edad " + j.getEdad() + " creado correctamente ");
						
			
						
						Login l =new Login(j);
						
						//Muestra la ventana
						
						l.setVisible(true); 
						
						//Cierra la ventana
						
						ref.dispose();
						
					
					}				
				} catch(Exception e) {
					cajaMSN.setText("Has introducido un valor de edad invalido");
					System.out.println(e);
				}
			}
		});
		btnAJUGAR.setBounds(10, 154, 383, 23);
		contentPane.add(btnAJUGAR);
		
		
	}

}
