package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.Jugador;

import javax.swing.JLabel;

public class Login extends JFrame {
	
	//Atributos
  	private JPanel contentPane;
 	JLabel nombreJugador;
    private ImageIcon[] dados3=new ImageIcon[3];
 	private ImageIcon[] dados6=new ImageIcon[6];
    private ImageIcon[] dados12=new ImageIcon[12];
 
    private JLabel dado1,dado2,dado3;
    private JLabel dado4,dado5;
    private JLabel dado6;
	
	//Creacion de la ventana
	public Login(Jugador j) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Labeljugador que variará según el jugador introducido.
		JLabel labeljugador = new JLabel(" Bienvenido " + j.getNombre());
		labeljugador.setBounds(304, 0, 180, 25);
		contentPane.add(labeljugador);
		
		//Cargamos las imagenes en los arrays
				for(int i=0;i<dados3.length;i++){
					dados3[i]=new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i+1)+"_3.png"));
				}
				for(int i=0;i<dados6.length;i++){
					dados6[i]=new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i+1)+"_6.png"));
				}
				for(int i=0;i<dados12.length;i++){
					dados12[i]=new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i+1)+".png"));
				}
				
				//Creamos los numeros aleatorios
				
				//dados3
				int valordado1 = (int) Math.floor(Math.random()*(2-0+1)+0);
				int valordado2 = (int) Math.floor(Math.random()*(2-0+1)+0);
				
				
				//dados6
				int valordado3 = (int) Math.floor(Math.random()*(5-0+1)+0);
				int valordado4 = (int) Math.floor(Math.random()*(5-0+1)+0);
				int valordado5 = (int) Math.floor(Math.random()*(5-0+1)+0);
				
				//dodecaedro
				int valordado6 = (int) Math.floor(Math.random()*(11-0+1)+0);
				
				
				//Creamos JLabel en la ventana
				
				dado1 = new JLabel();
				dado1.setIcon(dados3[valordado1]);
				dado1.setBounds(10, 11, 125, 112);
				contentPane.add(dado1);
				
				dado2 = new JLabel();
				dado2.setIcon(dados3[valordado2]);
				dado2.setBounds(145, 11, 125, 112);
				contentPane.add(dado2);
				
				dado3 = new JLabel();
				dado3.setIcon(dados6[valordado3]);
				dado3.setBounds(10, 132, 125, 112);
				contentPane.add(dado3);
				
				dado4 = new JLabel();
				dado4.setIcon(dados6[valordado4]);
				dado4.setBounds(145, 132, 125, 112);
				contentPane.add(dado4);
				
				dado5 = new JLabel();
				dado5.setIcon(dados6[valordado5]);
				dado5.setBounds(280, 132, 125, 112);
				contentPane.add(dado5);
				
				dado6 = new JLabel();
				dado6.setIcon(dados12[valordado6]);
				dado6.setBounds(10, 255, 125, 112);
				contentPane.add(dado6);
	}
}
