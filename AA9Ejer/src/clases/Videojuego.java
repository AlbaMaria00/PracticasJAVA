package clases;

public class Videojuego {
	String titulo;
	int cantidad_registros;
	double precio;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCantidad_registros() {
		return cantidad_registros;
	}

	public void setCantidad_registros(int cantidad_registros) {
		this.cantidad_registros = cantidad_registros;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Videojuego(String titulo, int cantidad_registros, double precio) {
		super();
		this.titulo = titulo;
		this.cantidad_registros = cantidad_registros;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", cantidad_registros=" + cantidad_registros + ", precio=" + precio
				+ "]";
	}
	
}
