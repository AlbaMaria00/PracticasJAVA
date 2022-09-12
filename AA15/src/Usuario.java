import java.time.LocalDate;

public class Usuario {
	String nombre;
	// Clase que uso para la composicion
	private Persona persona;
	private LocalDate fechaHoy;
	int id;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public LocalDate getFechaHoy() {
		return fechaHoy;
	}

	public void setFechaHoy(LocalDate fechaHoy) {
		this.fechaHoy = fechaHoy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", persona=" + persona + ", fechaHoy=" + fechaHoy + ", id=" + id + "]";
	}

	public Usuario(String nombre, Persona persona, LocalDate fechaHoy, int id) {
		super();
		this.nombre = nombre;
		this.persona = persona;
		this.fechaHoy = fechaHoy;
		this.id = id;
	}

}
