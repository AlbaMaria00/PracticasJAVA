package classes;

public class Artista extends Persona{
	
	public String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Artista(String nombrePersona, String nombre) {
		super(nombrePersona);
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Artista [nombre=" + nombre + "]";
	}
	
	

}
