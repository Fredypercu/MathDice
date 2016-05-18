//P07

package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import juego.Jugador;


public class VentanaPrincipal extends JFrame {

	private Jugador jugador;
	public static JPanel contentPaneVentanaPrincipal;
	
	public static final String VENTANA1= "VENTANA 1";
	public static final String VENTANA2= "VENTANA 2";
	
	//Ventanas de Juego y Login
	
		Login lp ;
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
			
			lp = new Login(getPlayer());
			pj = new Perfil(getPlayer());
			
			//Las añadimos al cardlayout
			
			contentPaneVentanaPrincipal.add(lp, VENTANA1);
			contentPaneVentanaPrincipal.add(pj, VENTANA2);
			
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
		setBounds(325, 325, 650, 555);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu1 = new JMenu("Ventanas");
		menuBar.add(menu1);
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1= (CardLayout) (contentPaneVentanaPrincipal.getLayout());
				c1.show(contentPaneVentanaPrincipal, VENTANA2);
			}
		});
		menu1.add(mntmPerfil);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1= (CardLayout) (contentPaneVentanaPrincipal.getLayout());
				c1.show(contentPaneVentanaPrincipal, VENTANA1);
			}
		});
		menu1.add(mntmLogin);
		
		
		contentPaneVentanaPrincipal = new JPanel();
		contentPaneVentanaPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneVentanaPrincipal);
		contentPaneVentanaPrincipal.setLayout(new CardLayout(0, 0));
		
		
		
	}
}
