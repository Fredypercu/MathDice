//P07 Contenedor de Ventanas // Ventana 1 y Ventana 2

package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.Jugador;

import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	
	private Jugador jugador;
	public static JPanel contentPaneJuego;
	
	
	public static final String VENTANA1= "VENTANA 1";
	public static final String VENTANA2= "VENTANA 2";
	
	//Ventanas de Juego y Login
	
	Juego lp ;
	Perfil pj ;
	
	
	public void meterJugador(Jugador j){
		jugador=j;
	}
	
	public Jugador getPlayer(){
		return jugador;
	}
	
	//Metodo de inicializacion
	
	public void inicializacion(Jugador j){
		//Recogemos el Jugador
		
		this.meterJugador(j);
		
		//Creamos las ventanas
		
		lp = new Juego(getPlayer());
		pj = new Perfil(getPlayer());
		
		//Las añadimos al cardlayout
		
		contentPaneJuego.add(lp, VENTANA1);
		contentPaneJuego.add(pj, VENTANA2);
		
	}
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 700);
		
		//Creamos Opciones Menú
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu1 = new JMenu("Ventanas");
		menuBar.add(menu1);
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1= (CardLayout) (contentPaneJuego.getLayout());
				c1.show(contentPaneJuego, VENTANA2);
			}
		});
		menu1.add(mntmPerfil);
		
		JMenuItem mntmJuego = new JMenuItem("Juego");
		mntmJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1= (CardLayout) (contentPaneJuego.getLayout());
				c1.show(contentPaneJuego, VENTANA1);
			}
		});
		menu1.add(mntmJuego);
		
		
		contentPaneJuego = new JPanel();
		contentPaneJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneJuego);
		contentPaneJuego.setLayout(new CardLayout(0, 0));
		
		
		
		
		
	}

}