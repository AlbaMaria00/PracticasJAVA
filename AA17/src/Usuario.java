
public class Usuario {
	String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + "]";
	}

}
