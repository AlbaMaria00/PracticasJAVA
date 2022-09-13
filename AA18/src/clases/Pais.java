package clases;

import interfaces.Genera;

public class Pais extends Continente {
	private String pais;
	private String clima;
	private int habitantes;
	private String capital;
	private double salarioMinimo;
	private double PBI;

	public double getPBI() {
		return PBI;
	}

	public void setPBI(double pBI) {
		PBI = pBI;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}

	public double getSalarioMinimo() {
		return salarioMinimo;
	}

	public void setSalarioMinimo(double salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	@Override
	public String toString() {
		return "Pais [pais=" + pais + ", clima=" + clima + ", habitantes=" + habitantes + ", capital=" + capital
				+ ", salarioMinimo=" + salarioMinimo + ", PBI=" + PBI + "]";
	}

	public Pais(String nombre, String pais, String clima, int habitantes, String capital, double salarioMinimo,
			double pBI) {
		super(nombre);
		this.pais = pais;
		this.clima = clima;
		this.habitantes = habitantes;
		this.capital = capital;
		this.salarioMinimo = salarioMinimo;
		PBI = pBI;
	}

	

}
