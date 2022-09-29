package Practica0;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
public class HistoriaGrandSlams {
	private ArrayList<Resultado> resutadosl = new ArrayList<Resultado>();
	private HashMap<String, Torneo> Ntorneos =new HashMap<String, Torneo>();
	private HashMap<Integer, Torneo> Ctorneos = new HashMap<Integer, Torneo>();
	private TreeMap<String, Tenista> Ntenistas = new TreeMap<String, Tenista>();
	public HistoriaGrandSlams(ArrayList<Resultado> resutadosl, HashMap<String, Torneo> ntorneos,
		HashMap<Integer, Torneo> ctorneos, TreeMap<String, Tenista> ntenistas) {
		super();
		this.resutadosl = resutadosl;
		Ntorneos = ntorneos;
		Ctorneos = ctorneos;
		Ntenistas = ntenistas;
	}
	public HistoriaGrandSlams() {
		leerCsv("Open Australia");
		leerCsv("Grand Slams");
		leerCsv("Open French");
		leerCsv("US Open");
		leerCsv("Wimbledon UK");
	}
	public void leerCsv(String nombreTorneo) {
		try {
			Scanner sc = new Scanner(new File("src/Practica0/"+nombreTorneo+".csv"));
			Torneo tA;
			if(Ntorneos.containsKey(nombreTorneo)) tA=Ntorneos.get(nombreTorneo);
			else {
				tA = new Torneo(nombreTorneo, nombreTorneo.split(" ")[1]);
				Ntorneos.put(tA.getNombre(), tA);
				Ctorneos.put(tA.getCodT(), tA);
			}
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(",");
				String r = "";
				for(int i=7;i<campos.length;i++) {
					r+=", "+campos[i];
				}
				Tenista t1;
				Tenista t2;
				if(Ntenistas.containsKey(campos[1])) t1 = Ntenistas.get(campos[1]);
				else t1 = new Tenista(campos[1], campos[3]);
				if(Ntenistas.containsKey(campos[4])) t2 = Ntenistas.get(campos[4]);
				else t2 = new Tenista(campos[4], campos[6]);
				Ntenistas.put(t1.nombreC, t1);
				Ntenistas.put(t2.nombreC, t2);
				Resultado rA = new Resultado(Integer.parseInt(campos[0]), t1, Integer.parseInt(campos[2]), t2, Integer.parseInt(campos[5]), tA, r);
				resutadosl.add(rA);
			}
			sc.close();
			
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	public ArrayList<Resultado> getResutadosl() {
		return resutadosl;
	}
	public void setResutadosl(ArrayList<Resultado> resutadosl) {
		this.resutadosl = resutadosl;
	}
	public HashMap<String, Torneo> getNtorneos() {
		return Ntorneos;
	}
	public void setNtorneos(HashMap<String, Torneo> ntorneos) {
		Ntorneos = ntorneos;
	}
	public HashMap<Integer, Torneo> getCtorneos() {
		return Ctorneos;
	}
	public void setCtorneos(HashMap<Integer, Torneo> ctorneos) {
		Ctorneos = ctorneos;
	}
	public TreeMap<String, Tenista> getNtenistas() {
		return Ntenistas;
	}
	public void setNtenistas(TreeMap<String, Tenista> ntenistas) {
		Ntenistas = ntenistas;
	}
 }
