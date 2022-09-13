package clases;

public class Continente {
	String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Continente [nombre=" + nombre + "]";
	}

	public Continente(String nombre) {
		super();
		this.nombre = nombre;
	}
}
