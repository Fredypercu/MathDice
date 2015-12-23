package juego;

public class Jugador {
	//Atributos (o propiedades)
		private String nombre;
		private String apellidos;
		private int edad;
		private int puntos;

		//Constructor 
		//Punto de entrada que se ejeuta al crear un objeto de tipo Jugador
		public Jugador(String nom, String ape, int eda) {
			
			if (eda<=0) {
				throw new IllegalArgumentException("Has introducido una edad invalida");
				
				
			}
			
			//Dentro del constructor, SE RELLENAN los atributos POR PRIMERA VEZ.
			this.nombre=nom;
			this.apellidos=ape;
			this.edad=eda;
			this.puntos=0;		
		
		}
		
			
		
		//Métodos getter
		
		//Obtiene el VALOR de una propiedad
		public String getNombre(){
			return nombre;
		}
		public String getApellidos(){
			return apellidos;
		}
		public int getEdad(){
			return edad;
		}
		public int getPuntos(){
			return puntos;
		}
		
		//Métodos setter
		
		//Modifica el VALOR de una propiedad
		public void setNombre(String nom){
			nombre=nom;
		}
		public void setApellidos(String ape){
			apellidos=ape;
		}
		public void setEdad (int eda){
			if (eda<=0) {
				throw new IllegalArgumentException("Has introducido una edad invalida");
			}
			edad=eda;
		}
		public void setPuntos (int pun){
			puntos=pun;
		}
		
}