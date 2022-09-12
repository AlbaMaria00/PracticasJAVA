
public class Capital {
	String nombreCapital;

	public String getNombreCapital() {
		return nombreCapital;
	}

	public void setNombreCapital(String nombreCapital) {
		this.nombreCapital = nombreCapital;
	}

	public Capital(String nombreCapital) {
		super();
		this.nombreCapital = nombreCapital;
	}

	@Override
	public String toString() {
		return "Capital [nombreCapital=" + nombreCapital + "]";
	}

	
}
