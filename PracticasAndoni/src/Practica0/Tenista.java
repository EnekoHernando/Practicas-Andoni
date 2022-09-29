package Practica0;

public class Tenista {
	
	public String nombreC;
	public String Nacionalidad;
	public int victorias;
	public Tenista(String nombreC, String nacionalidad) {
		super();
		this.nombreC = nombreC;
		Nacionalidad = nacionalidad;
		this.victorias = 0;
	}
	public String getNombreC() {
		return nombreC;
	}
	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public int getVictorias() {
		return victorias;
	}
	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}
	@Override
	public String toString() {
		return nombreC + ", " + Nacionalidad + ", victorias=" + victorias + "]";
	}
	@Override
	public boolean equals(Object obj) {
		Tenista t = (Tenista) obj;
		return this.nombreC.equals(t.nombreC);
	}
}
