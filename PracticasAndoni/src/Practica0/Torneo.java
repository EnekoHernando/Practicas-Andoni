package Practica0;

public class Torneo {
	private static int cont=0;
	private int codT;
	private String nombre;
	private String ciudad;
	public Torneo(String nombre, String ciudad) {
		super();
		this.codT=cont++;
		this.nombre = nombre;
		this.ciudad = ciudad;
	}
	public static int getCont() {
		return cont;
	}
	public static void setCont(int cont) {
		Torneo.cont = cont;
	}
	public int getCodT() {
		return codT;
	}
	public void setCodT(int codT) {
		this.codT = codT;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return nombre;
	}
	
}
