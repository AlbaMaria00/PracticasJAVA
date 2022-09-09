
public class Golosina {
	String nombreGolosina;
	String sabor;

	public String getNombreGolosina() {
		return nombreGolosina;
	}

	public void setNombreGolosina(String nombreGolosina) {
		this.nombreGolosina = nombreGolosina;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public Golosina(String nombreGolosina, String sabor) {
		super();
		this.nombreGolosina = nombreGolosina;
		this.sabor = sabor;
	}

	@Override
	public String toString() {
		return "Golosina [nombreGolosina=" + nombreGolosina + ", sabor=" + sabor + "]";
	}

}
