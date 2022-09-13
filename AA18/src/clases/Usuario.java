package clases;

import interfaces.Genera;

public class Usuario implements Genera{
	int id;
	String nombre;
	String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}

	public Usuario(int id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}
	
	@Override
	public void generaDatosUser() {
		Usuario user = new Usuario(1, "alba", "alba@gmail.com");
		System.out.println("El usuario es " + user.getNombre() + "  con id " + user.getId() + " y correo electronico "
				+ user.getEmail());
	}

}
