
public class Provincia extends Capital{
	String nombreProvincia;

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	
	public Provincia(String nombreCapital, String nombreProvincia) {
		super(nombreCapital);
		this.nombreProvincia = nombreProvincia;
	}

	@Override
	public String toString() {
		return "Provincia [nombreCapital " + nombreCapital + "      nombreProvincia "+nombreProvincia;
	}

}
