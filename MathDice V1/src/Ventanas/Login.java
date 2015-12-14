package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	// PROIEDADES o atributos de la clase VentanaPrincipal
	private JPanel contentPane;
	private JTextField textoNombre;
	private JTextField textoApellidos;
	private JTextField textoEdad;
	private JButton btnJugar;
	private JTextField textoMsj;

	// creo una referencia a la clase Login. Apunta al objeto login, no crea ningun objeto Login.
	private Login referenciaLogin;
	private Juego ventanaJuego;

	// CREAR objeto jugador
	private Jugador nuevoJug;

	// CONSTRUCTOR
	public Login(Juego vJ) {
		setTitle("Login");
		// ConfiguraciÃ³n
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Etiqueta Datos del Jugador
		JLabel lblDatosDelJugador = new JLabel("DATOS DEL JUGADOR");
		lblDatosDelJugador.setBounds(10, 11, 242, 25);
		contentPane.add(lblDatosDelJugador);

		// Etiqueta nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 50, 46, 14);
		contentPane.add(lblNombre);

		// Campo nombre del jugador
		textoNombre = new JTextField();
		textoNombre.setBounds(107, 47, 286, 20);
		contentPane.add(textoNombre);
		textoNombre.setColumns(10);

		// Etiqueta apellidos
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 81, 76, 14);
		contentPane.add(lblApellidos);

		// Campo para los apellidos del jugador
		textoApellidos = new JTextField();
		textoApellidos.setBounds(107, 78, 286, 20);
		contentPane.add(textoApellidos);
		textoApellidos.setColumns(10);

		// Etiqueta para la edad
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 112, 46, 14);
		contentPane.add(lblEdad);

		// Campo para la edad del jugador
		textoEdad = new JTextField();
		textoEdad.setBounds(107, 109, 76, 20);
		contentPane.add(textoEdad);
		textoEdad.setColumns(10);
		
		// ASIGNO this a referencia.Ahora referenciaLogin representa a toda la clase.Guardado una copia del objeto login.
		referenciaLogin = this;
		ventanaJuego=vJ;
		
							
		// Boton para iniciar juego
		btnJugar = new JButton("A JUGAR");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Primero valido los campos
				if (textoNombre.getText().length() == 0) {
					textoMsj.setText("Por favor, rellene todos los campos para iniciar partida ");
				} else if (textoApellidos.getText().length() == 0) {
					textoMsj.setText("Por favor, rellene todos los campos para iniciar partida ");
				} else if (textoEdad.getText().length() == 0) {
					textoMsj.setText("Por favor, rellene todos los campos para iniciar partida ");
				} else {
					// luego recojo los valores y los guardo
					nuevoJug.setNombre(textoNombre.getText());
					nuevoJug.setApellidos(textoApellidos.getText());
					//creo una variable intermedia para guardar el campo textoEdad que si es un String
					String edadString = textoEdad.getText();
					//si el campo contiene algo lo convierto en integer, lo guardo y pongo la edad
					if (edadString.length() > 0) {
						int edad = Integer.valueOf(edadString);
						nuevoJug.setEdad(edad);
					}
					// lanzo mensaje si todos los campos estan completos
					textoMsj.setText("El jugador " + nuevoJug.getNombre() + " " + nuevoJug.getApellidos() + " de edad "
							+ nuevoJug.getEdad() + " puede comenzar a jugar");
				
					
					//llamo al método todo dispose() y cierro la ventana login
					//referenciaLogin.dispose();//
					ventanaJuego.setVisible(true);
					
					referenciaLogin.setVisible(false);
				} // fin de else
				//ventanaJuego.setVisible(true);
				//referenciaLogin.setVisible(false);
				//ventanaJuego.setVisible(true);
			}
			
		});// fin botón

		btnJugar.setBounds(25, 154, 383, 23);
		contentPane.add(btnJugar);

		// Texto para los mensajes
		textoMsj = new JTextField();
		textoMsj.setEditable(false);
		textoMsj.setBounds(10, 188, 414, 62);
		contentPane.add(textoMsj);
		textoMsj.setColumns(10);

		// Inicializo un objeto jugador
		nuevoJug = new Jugador();

	}// Fin del constructor de la clase VentanaPrincipal
} // Fin de la clase VentanaPrincipal
