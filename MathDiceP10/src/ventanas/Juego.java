package ventanas;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.JugadorBBDD;
import juego.Jugador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Juego extends JPanel {

	//Atributos
	
	private ImageIcon[] dados3=new ImageIcon[3];
	private ImageIcon[] dados6=new ImageIcon[6];
	private ImageIcon[] dados12=new ImageIcon[12];
	
	private JLabel dado1,dado2,dado3;
	private JLabel dado4,dado5;
	private JLabel dado6;
	
	private int valordado1;
	private int valordado2;
	private int valordado3;
	private int valordado4;
	private int valordado5;
	private int valordado6;
	
	
	//Entrega p05
	private JTextField sumDados;
	private JButton botonMenos;
	private Boolean alternando = false;
	
	private Boolean botonPulsable = true;
	
	//Variables de las operaciones realizadas
	
	private int resultadoFinal = 0;
	private int controladorOperacion =2;
	private JLabel resultadoenTexto;
	private JButton botonRelanzar;
	
	//referenciamos a ventana Login Botón "Play Again!"
	
	private Juego ref;
	private JTextField puntuacion;

	private static JLabel labelBienvenida;
	
	//Se crea la ventana para jugador
	
	public Juego(Jugador j) {
		
		
		
		setBounds(100, 100, 850, 700);
		setLayout(null);
		
		//Label donde creamos usuario y mensaje de bienvenida
		
		labelBienvenida = new JLabel("Bienvenido al juego "+j.getNombre());
		labelBienvenida.setBounds(534, 79, 263, 14);
		add(labelBienvenida);
		
	
		//Carga imagenes en los arrays
		
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
		
		valordado1 = (int) Math.floor(Math.random()*(2-0+1)+0);
		valordado2 = (int) Math.floor(Math.random()*(2-0+1)+0);
		
		
		//dados6
		
		valordado3 = (int) Math.floor(Math.random()*(5-0+1)+0);
		valordado4 = (int) Math.floor(Math.random()*(5-0+1)+0);
		valordado5 = (int) Math.floor(Math.random()*(5-0+1)+0);
		
		//dodecaedro
		
		valordado6 = (int) Math.floor(Math.random()*(11-0+1)+0);
		
		
		//Creamos JLabel en la ventana
		
		dado1 = new JLabel();
		
		//SetIcon llama a la posicion valordado1 del array dados3 / generación icono
		
		dado1.setIcon(dados3[valordado1]);
		dado1.setBounds(10, 11, 150, 150);
		dado1.setText(String.valueOf(valordado1)); 
		add(dado1);
		
		dado1.addMouseListener(new ListenerDados());
		
		dado2 = new JLabel();
		dado2.setIcon(dados3[valordado2]);
		dado2.setText(String.valueOf(valordado2));
		dado2.setBounds(205, 11, 150, 150);
		add(dado2);
		
		dado2.addMouseListener(new ListenerDados());
		
		dado3 = new JLabel();
		dado3.setIcon(dados6[valordado3]);
		dado3.setText(String.valueOf(valordado3));
		dado3.setBounds(10, 200, 150, 150);
		add(dado3);
		
		dado3.addMouseListener(new ListenerDados());
		
		dado4 = new JLabel();
		dado4.setIcon(dados6[valordado4]);
		dado4.setText(String.valueOf(valordado4));
		dado4.setBounds(205, 200, 150, 150);
		add(dado4);
		
		dado4.addMouseListener(new ListenerDados());
		
		dado5 = new JLabel();
		dado5.setIcon(dados6[valordado5]);
		dado5.setText(String.valueOf(valordado5));
		dado5.setBounds(410, 200, 150, 150);
		add(dado5);
		
		dado5.addMouseListener(new ListenerDados());
		
		dado6 = new JLabel();
		dado6.setIcon(dados12[valordado6]);
		dado6.setBounds(10, 375, 150, 150);
		add(dado6);
		
		//Muestra suma valor de los dados
		
		sumDados = new JTextField();
		sumDados.setEditable(false);
		sumDados.setBounds(471, 431, 252, 48);
		add(sumDados);
		sumDados.setColumns(10);
		
		//Boton de suma
		
		JButton botonMas = new JButton("+");
		botonMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if (alternando==true){
					String aux=sumDados.getText(); //  Actualizador
					String aux2=aux + "+";
					sumDados.setText(aux2);
					alternando=false;
					controladorOperacion = 1; //sume nuevamente las operaciones
				}
			}
		});
		botonMas.setBounds(471, 389, 89, 23);
		add(botonMas);
		
		
		//Boton de resta
		
		botonMenos = new JButton("-");
		botonMenos.setBounds(634, 389, 89, 23);
		add(botonMenos);
		
		
		botonMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (alternando==true){
						String aux=sumDados.getText(); 
						String aux2=aux + "-";
						sumDados.setText(aux2);
						alternando=false;
						controladorOperacion = 0; 
				}
			}
		});
		
		//label que muestra el resultado
		
				JLabel labelResultado = new JLabel();
				labelResultado.setBounds(471, 561, 252, 23);
				add(labelResultado);
		
		//Boton "MATHDICE"
				
		JButton botonMathdice = new JButton("MATHDICE ");
		botonMathdice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				
										
				if(sumDados.getText().length()>=3){
					labelResultado.setText(String.valueOf(resultadoFinal));
					
					//comprobamos dodecaedro
					
					if(valordado6+1==resultadoFinal){
						resultadoenTexto.setText("ENHORABUENA PISTOLERO, HAS GANADO !");
						botonRelanzar.setEnabled(true);
						botonMas.setEnabled(false);
						botonMenos.setEnabled(false);
						labelResultado.setVisible(true);
						resultadoenTexto.setVisible(true);
						
						//Actualiza La Puntuacion del Jugador en la BBDD
						
						JugadorBBDD.jugadorGana(j);
						puntuacion.setText(String.valueOf(j.getPuntos()));
						Perfil.cambiarPuntosPantalla(String.valueOf(j.getPuntos()));
						
						
						
					}else if(!(valordado6+1==resultadoFinal)){ 
						resultadoenTexto.setText("LASTIMA, INTENTALO DE NUEVO !");
						botonRelanzar.setEnabled(true);
						botonMas.setEnabled(false);
						botonMenos.setEnabled(false);
						labelResultado.setVisible(true);
						resultadoenTexto.setVisible(true);
						
					}
				}
				
			}
		});
		botonMathdice.setBounds(471, 490, 252, 48);
		add(botonMathdice);
		
		
		//Jlabel que muestra si has ganado o no
		
		resultadoenTexto = new JLabel();
		resultadoenTexto.setBounds(471, 595, 252, 14);
		add(resultadoenTexto);
		
		//referenciamos la ventana actual
		
		ref=this;
		
		//boton para relanzar los dados
		
		botonRelanzar = new JButton("PLAY AGAIN !");
		botonRelanzar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				
				
				//reiniciamos todas las variables de control de elementos del juego.	
			
				alternando = false;				
				resultadoFinal = 0;
				controladorOperacion =2;
				botonMas.setEnabled(true);
				botonMenos.setEnabled(true);
				botonPulsable=true;
				sumDados.setText("");
				labelResultado.setVisible(false);
				resultadoenTexto.setVisible(false);
				botonRelanzar.setEnabled(false);
				dado1.setEnabled(true);
				dado2.setEnabled(true);
				dado3.setEnabled(true);
				dado4.setEnabled(true);
				dado5.setEnabled(true);
				
				//Volvemos a calcular un valor para los dados	
				
				valordado1 = (int) Math.floor(Math.random()*(2-0+1)+0);
				valordado2 = (int) Math.floor(Math.random()*(2-0+1)+0);
				valordado3 = (int) Math.floor(Math.random()*(5-0+1)+0);
				valordado4 = (int) Math.floor(Math.random()*(5-0+1)+0);
				valordado5 = (int) Math.floor(Math.random()*(5-0+1)+0);				
				valordado6 = (int) Math.floor(Math.random()*(11-0+1)+0);
				
				//Se cambia el dado
				
				dado1.setIcon(dados3[valordado1]);				
				dado1.setText(String.valueOf(valordado1));
				dado2.setIcon(dados3[valordado2]);
				dado2.setText(String.valueOf(valordado2));			
				dado3.setIcon(dados6[valordado3]);
				dado3.setText(String.valueOf(valordado3));
				dado4.setIcon(dados6[valordado4]);
				dado4.setText(String.valueOf(valordado4));
				dado5.setIcon(dados6[valordado5]);
				dado5.setText(String.valueOf(valordado5));
				dado6.setIcon(dados12[valordado6]);
				dado6.setText(String.valueOf(valordado6));
				
				//Le volvemos a añadir los mouseListener
				
				dado1.addMouseListener(new ListenerDados());
				dado2.addMouseListener(new ListenerDados());
				dado3.addMouseListener(new ListenerDados());				
				dado4.addMouseListener(new ListenerDados());
				dado5.addMouseListener(new ListenerDados());
				
				
				
				
			}
		});
		botonRelanzar.setEnabled(false);
		botonRelanzar.setBounds(244, 444, 169, 23);
		add(botonRelanzar);
		
		
		//Para ver la puntuacion del jugador
		
		puntuacion = new JTextField();
		puntuacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		puntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		puntuacion.setEditable(false);
		puntuacion.setBounds(497, 104, 240, 48);
		add(puntuacion);
		puntuacion.setColumns(10);
		puntuacion.setText(String.valueOf(j.getPuntos()));
	
	}
	
	public static void cambiarLabelNombre(String s){
		String cadena= "Bienvenido jugador "+s;
		labelBienvenida.setText(cadena);
	}
	
	// P06 INNERCLASS
	
	private class ListenerDados implements MouseListener {
		
		ListenerDados ref=this;
		
		public void mouseClicked(MouseEvent e) {
			
				JLabel j=(JLabel)e.getSource();
			
			//No deja volver a pulsar el botón
			
			if (alternando==false){
				
				//Valor del Dado
				
				int valorDado=Integer.valueOf(j.getText());
				botonPulsable = false ;
				j.setEnabled(botonPulsable);
				String aux=sumDados.getText(); 
				String aux2=aux + String.valueOf(valorDado+1); 
				sumDados.setText(aux2);
				
				j.removeMouseListener(ref);
				
				alternando=true;
				
				
				
				//1 eleccion pulsada
				
				if(resultadoFinal == 0) {
					resultadoFinal = valorDado+1;
					
					
					//Resto
					
					
				}else{
					if(controladorOperacion == 1){//==1 suma
						resultadoFinal = resultadoFinal + (valorDado+1);
					}else if (controladorOperacion == 0){//==0 resta
						resultadoFinal = resultadoFinal - (valorDado+1);
					}
				}
			}
			
		}
		

	
		public void mouseEntered(MouseEvent e) {
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			
		}
	
	}
}
