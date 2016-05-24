//P07 Panel Perfil Usuario

package ventanas;

import javax.swing.JPanel;

import juego.Jugador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Modelo.JugadorBBDD;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Perfil extends JPanel {
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textEdad;
	private JButton actualizarDatos;
	private static JTextField puntuacion;
	private JTextField puntuacionHistorico;
	
	//Creaamos el Panel de la ventana Perfil

	public Perfil(Jugador j) {
		
		//setTitle("Perfil");
		
		setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(34, 53, 85, 14);
		add(lblNombre);

		JLabel lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setBounds(34, 84, 100, 14);
		add(lblPrimerApellido);

		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setBounds(34, 115, 100, 14);
		add(lblSegundoApellido);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(34, 177, 85, 14);
		add(lblEdad);

		textNombre = new JTextField();
		textNombre.setBounds(171, 50, 422, 20);
		textNombre.setText(j.getNombre());
		add(textNombre);
		textNombre.setColumns(10);

		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(171, 81, 422, 20);
		textApellido1.setText(j.getPrimerApellido());
		add(textApellido1);

		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(171, 112, 422, 20);
		textApellido2.setText(j.getSegundoApellido());
		add(textApellido2);

		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(171, 174, 422, 20);
		textEdad.setText(String.valueOf(j.getEdad()));
		add(textEdad);

		// Boton para actualizar los datos.
		
		actualizarDatos = new JButton(" Actualizar ");
		actualizarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
							
				
				try{				
					if (textNombre.getText().compareTo("")==0|| textApellido1.getText().compareTo("")==0 || textApellido2.getText().compareTo("")==0 || textEdad.getText().compareTo("")==0) {
						puntuacionHistorico.setText("Rellene todos los campos");
					} else {

						j.setNombre(textNombre.getText());
						j.setPrimerApellido(textApellido1.getText());
						j.setSegundoApellido(textApellido2.getText());
						j.setEdad(Integer.valueOf(textEdad.getText()));

						JugadorBBDD.actualizarJugador(j);
						puntuacionHistorico.setText("Perfil actualizado");
						Juego.cambiarLabelNombre(j.getNombre());
						
						
					}				
				} catch(Exception e) {
					puntuacionHistorico.setText("Has introducido un valor de edad invalido");
					System.out.println(e);
					
				}
			}
				
			
		});
		actualizarDatos.setBounds(79, 241, 127, 36);
		add(actualizarDatos);

		JLabel lblPuntos = new JLabel("Puntos");
		lblPuntos.setBounds(34, 146, 46, 14);
		add(lblPuntos);

		puntuacion = new JTextField();
		puntuacion.setEditable(false);
		puntuacion.setBounds(171, 143, 422, 20);
		add(puntuacion);
		puntuacion.setColumns(10);
		puntuacion.setText(String.valueOf(j.getPuntos()));
		
		puntuacionHistorico = new JTextField();
		puntuacionHistorico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		puntuacionHistorico.setHorizontalAlignment(SwingConstants.CENTER);
		puntuacionHistorico.setBounds(257, 228, 353, 49);
		add(puntuacionHistorico);
		puntuacionHistorico.setColumns(10);
		
		

	}
	
	public static void cambiarPuntosPantalla(String pnuevos){
		puntuacion.setText(pnuevos);
	}
}
