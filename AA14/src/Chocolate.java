
public class Chocolate extends Golosina {
	String nombre;
	int produccion;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getProduccion() {
		return produccion;
	}

	public void setProduccion(int produccion) {
		this.produccion = produccion;
	}

	public Chocolate(String nombreGolosina, String sabor, String nombre, int produccion) {
		super(nombreGolosina, sabor);
		this.nombre = nombre;
		this.produccion = produccion;
	}

	@Override
	public String toString() {
		return "Chocolate [nombre=" + nombre + ", produccion=" + produccion + "]";
	}

}
