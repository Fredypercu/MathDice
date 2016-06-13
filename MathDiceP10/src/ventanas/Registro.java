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

import com.mysql.jdbc.Connection;

import Modelo.ConexionBBDD;
import Modelo.JugadorBBDD;
import juego.Jugador;

public class Registro extends JFrame {

	public JPanel contentPane;

	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textEdad;	
	private JTextField cajaMSN;
	private Registro ref;	
		
	

	//Crea un objeto de tipo Registro
	
	public Registro() {
		setTitle("Registro");

		// Propiedades de ventana
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// texto1
		
		JLabel texto1 = new JLabel("DATOS DEL JUGADOR");
		texto1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		texto1.setBounds(10, 11, 242, 25);
		contentPane.add(texto1);

		// texto2
		
		JLabel texto2 = new JLabel("Nombre");
		texto2.setBounds(10, 69, 46, 14);
		contentPane.add(texto2);

		// texto3
		
		JLabel texto3 = new JLabel("Primer Apellido");
		texto3.setBounds(10, 119, 131, 14);
		contentPane.add(texto3);

		// texto4
		
		JLabel texto4 = new JLabel("Edad");
		texto4.setBounds(10, 214, 46, 14);
		contentPane.add(texto4);
		
		//texto5
		
		JLabel texto5 = new JLabel("Segundo Apellido");
		texto5.setBounds(10, 163, 131, 14);
		contentPane.add(texto5);

		// caja Nombre
		
		textNombre = new JTextField();
		textNombre.setBounds(151, 66, 242, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		// caja Apellido1
		
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(151, 116, 242, 20);
		contentPane.add(textApellido1);

		// caja Apellido2
		
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(151, 211, 242, 20);
		contentPane.add(textApellido2);

		// caja Edad
		
		textEdad = new JTextField();
		textEdad.setBounds(10, 312, 414, 62);
		contentPane.add(textEdad);
		textEdad.setColumns(10);
		
		// ccaja MSN (Mensaje Nuevo Jugador)
		
		cajaMSN = new JTextField();
		cajaMSN.setColumns(10);
		cajaMSN.setBounds(151, 160, 242, 20);
		contentPane.add(cajaMSN);

		//referencia de esta ventana
		
		ref=this;
		
		// Boton
		
		JButton boton1 = new JButton("A JUGAR");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				try{				
					if (textNombre.getText().compareTo("")==0|| textApellido1.getText().compareTo("")==0 || cajaMSN.getText().compareTo("")==0 || textApellido2.getText().compareTo("")==0) {
						textEdad.setText("Rellene todos los campos");
					} else {
						Jugador j = new Jugador(textNombre.getText(), textApellido1.getText(), cajaMSN.getText(), Integer.valueOf(textApellido2.getText()));
						
						textEdad.setText("Player " + j.getNombre() + " " + j.getPrimerApellido() + " de edad " + j.getEdad() + " creado");
						
						
						//Introduce en la tabla de la base de datos el objeto jugador.
						
						JugadorBBDD.insertarJugador(j);
						
						VentanaPrincipal ju = new VentanaPrincipal();
						ju.inicializacion(j);
						
						
						//Cierra la ventana
						
						ref.dispose();
						
						//Abro la ventana de Juego
						
						ju.setVisible(true);
						
					}				
				} catch(Exception e) {
					textEdad.setText("Has introducido un valor de edad invalido");
					System.out.println(e);
					
				}
			}
		});
		boton1.setBounds(10, 278, 414, 23);
		contentPane.add(boton1);
		
		
				
			}
		
		
		
	}

