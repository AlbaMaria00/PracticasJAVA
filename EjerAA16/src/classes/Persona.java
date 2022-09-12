package classes;

public class Persona {
	String nombrePersona;

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	@Override
	public String toString() {
		return "Persona [nombrePersona=" + nombrePersona + "]";
	}

	public Persona(String nombrePersona) {
		super();
		this.nombrePersona = nombrePersona;
	}

}
