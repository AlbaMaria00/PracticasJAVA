package classes;


public class Cancion extends Artista implements Recaudacion{
	String titulo;
	int recaudacion;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(int recaudacion) {
		this.recaudacion = recaudacion;
	}

	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", recaudacion=" + recaudacion + "]";
	}

	public Cancion(String nombrePersona, String nombre, String titulo, int recaudacion) {
		super(nombrePersona, nombre);
		this.titulo = titulo;
		this.recaudacion = recaudacion;
	}

	@Override
	public int calcularRecaudacion(int reproducciones) {
		return reproducciones*2;
	}

}
