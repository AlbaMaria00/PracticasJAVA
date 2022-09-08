public class Pelicula{
	private String nombre;
	private double recaudacion;

	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", recaudacion=" + recaudacion + "]";
	}

	public Pelicula(String nombre, double recaudacion) {
		super();
		this.nombre = nombre;
		this.recaudacion = recaudacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(int recaudacion) {
		this.recaudacion = recaudacion;
	}

}