//P07

package ventanas;

import javax.swing.JPanel;

import juego.Jugador;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Perfil extends JPanel {
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textEdad;
	
	

	//Creaamos el Panel de la ventana Perfil
	
	
		public Perfil(Jugador j) {
			setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(34, 41, 85, 14);
			add(lblNombre);
			
			JLabel lblApellido1 = new JLabel("Apellido 1");
			lblApellido1.setBounds(34, 84, 100, 14);
			add(lblApellido1);
			
			JLabel lblApellido2 = new JLabel("Apellido 2");
			lblApellido2.setBounds(34, 129, 100, 14);
			add(lblApellido2);
			
			JLabel lblEdad = new JLabel("Edad");
			lblEdad.setBounds(34, 185, 85, 14);
			add(lblEdad);
			
			textNombre = new JTextField();
			textNombre.setBounds(171, 38, 422, 20);
			textNombre.setText(j.getNombre());
			add(textNombre);
			textNombre.setColumns(10);
			
			textApellido1 = new JTextField();
			textApellido1.setColumns(10);
			textApellido1.setBounds(171, 81, 422, 20);
			textApellido1.setText(j.getApellido1());
			add(textApellido1);
			
			textApellido2 = new JTextField();
			textApellido2.setColumns(10);
			textApellido2.setBounds(171, 126, 422, 20);
			textApellido2.setText(j.getApellido2());
			add(textApellido2);
			
			textEdad = new JTextField();
			textEdad.setColumns(10);
			textEdad.setBounds(171, 182, 422, 20);
			textEdad.setText(String.valueOf(j.getEdad()));
			add(textEdad);

		}

	}