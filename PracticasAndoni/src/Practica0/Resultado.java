package Practica0;

public class Resultado {
	private int anyo;
	private Tenista campeon;
	private int seedC;
	private Tenista subCampeon;
	private int seedSC;
	private Torneo torneo;
	private String resultado;
	
	public Resultado(int anyo,Tenista campeon, int seedC, Tenista subCampeon, int seedSC, Torneo torneo, String resultado) {
		super();
		this.anyo = anyo;
		this.campeon = campeon;
		this.seedC = seedC;
		this.subCampeon = subCampeon;
		this.seedSC = seedSC;
		this.torneo = torneo;
		this.resultado = resultado;
	}
	
	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public Tenista getCampeon() {
		return campeon;
	}
	public void setCampeon(Tenista campeon) {
		this.campeon = campeon;
	}
	public int getSeedC() {
		return seedC;
	}
	public void setSeedC(int seedC) {
		this.seedC = seedC;
	}
	public Tenista getSubCampeon() {
		return subCampeon;
	}
	public void setSubCampeon(Tenista subCampeon) {
		this.subCampeon = subCampeon;
	}
	public int getSeedSC() {
		return seedSC;
	}
	public void setSeedSC(int seedSC) {
		this.seedSC = seedSC;
	}
	public Torneo getTorneo() {
		return torneo;
	}
	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return anyo + "," + campeon + "," + seedC + "," + subCampeon
				+ "," + seedSC + "," + torneo + "," + resultado;
	}
	
}
