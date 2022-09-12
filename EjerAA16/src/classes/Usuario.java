package classes;

public class Usuario {
	String usuario;
	int id;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", id=" + id + "]";
	}

	public Usuario(String usuario, int id) {
		super();
		this.usuario = usuario;
		this.id = id;
	}

}
