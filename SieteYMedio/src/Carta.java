
/*
 * La definición de la clase mediante la palabra reservada Carta
 * 
 * public class nombreClase
 */
public class Carta {
	
	//Propiedades
	private int numero;
	private String palo;

	//Constructor
   // Punto de entrada que se ejecuta al crear un objeto de tipo carta
	public Carta() {
		System.out.println("Creo un objeto de tipo Carta");
	}
	
	//FUNCIONES O METODOS
	//public/private OUT nombreMetodo (IN)
	public void setNumero(int numeroEntrada){
		numero=numeroEntrada;
	}
	
	public int getNumero(){
		return numero;
	}
	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}
}