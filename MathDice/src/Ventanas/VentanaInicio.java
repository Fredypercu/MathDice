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
import java.security.Principal;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {

	//Variables
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textEdad;
	private JTextField cajaMSN;
	private VentanaInicio referencia;
	private VentanaPrincipal vPrincipal;
	private Object btnAJUGAR;
	private JTextField textMsj;
	
	// creo una referencia a la clase Login. Apunta al objeto login, no crea ningun objeto Login.
		private VentanaInicio referenciaVentanaInicio;
		private Principal ventanaPrincipal;
		
	// CREAR objeto jugador
		private Jugador nuevoJug;
	//Constructor 
	
	public VentanaInicio(VentanaPrincipal vP) {
		
		setTitle("Login");
		
		//Propiedades de ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.btnAJUGAR="A JUGAR";
		referencia=this;
		vPrincipal=vP;
		
		//texto1
		JLabel lblDTJ = new JLabel("DATOS DEL JUGADOR");
		lblDTJ.setBounds(10, 11, 242, 25);
		contentPane.add(lblDTJ);
		
		//texto2
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 50, 46, 14);
		contentPane.add(lblNombre);
		
		//caja de texto 1
		textNombre = new JTextField();
		textNombre.setBounds(107, 47, 286, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		//texto3
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 81, 76, 14);
		contentPane.add(lblApellidos);
		
		//caja de texto 2
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(107, 78, 286, 20);
		contentPane.add(textApellidos);
		
		//texto4
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 112, 46, 14);
		contentPane.add(lblEdad);
		
		//caja de texto 3
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(107, 109, 76, 20);
		contentPane.add(textEdad);
		
		//Boton 
		JButton btnAJUGAR = new JButton("A JUGAR");
		btnAJUGAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textNombre.getText().equals("") || textApellidos.getText().equals("") || textEdad.getText().equals("")){
					cajaMSN.setText("Por favor, rellene todos los campos para iniciar partida ");
				}else{
					Jugador j = new Jugador(textNombre.getText(), textApellidos.getText(), Integer.valueOf(textEdad.getText()));
					cajaMSN.setText("Player "+j.getNombre()+" "+j.getApellidos()+ " de edad "+j.getEdad()+" creado");
					
					vPrincipal.setVisible(true);
					referencia.setVisible(false);
				}
			}
		});
		btnAJUGAR.setBounds(25, 154, 383, 23);
		contentPane.add(btnAJUGAR);
		
		//caja de texto 4
		cajaMSN = new JTextField();
		cajaMSN.setBounds(10, 188, 414, 62);
		contentPane.add(cajaMSN);
		cajaMSN.setColumns(10);
		
		
	}
}
