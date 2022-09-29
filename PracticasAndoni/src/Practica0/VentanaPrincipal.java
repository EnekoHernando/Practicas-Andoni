package Practica0;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class VentanaPrincipal extends JFrame{
	private HistoriaGrandSlams baseDatos = new HistoriaGrandSlams();
	protected JList<Object> listaTenistas;
	protected DefaultListModel<Object> modeloTenistas;
	public VentanaPrincipal() {
		JPanel botonera = new JPanel();
		JButton torneo = new JButton("Torneos");
		JButton tenistas = new JButton("Tenistas");
		JButton resultados = new JButton("Resultados");
		JButton hilo = new JButton("Hilo");
		modeloTenistas = new DefaultListModel<>();
		tenistas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modeloTenistas.clear();
				for (Tenista tenista : baseDatos.getNtenistas().values())	modeloTenistas.addElement(tenista);
			}
		});
		resultados.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modeloTenistas.clear();
				for (Resultado r : baseDatos.getResutadosl())	modeloTenistas.addElement(r);
			}
		});
		torneo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modeloTenistas.clear();
				for (Torneo t : baseDatos.getNtorneos().values()) modeloTenistas.addElement(t);
			}
		});
		hilo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MiHiloRecursiva mhr = new MiHiloRecursiva(baseDatos, modeloTenistas, listaTenistas);
			}
		});
		botonera.add(torneo);
		botonera.add(tenistas);
		botonera.add(resultados);
		botonera.add(hilo);
		getContentPane().add(botonera, BorderLayout.NORTH);
		listaTenistas = new JList<>(modeloTenistas);
		listaTenistas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollT = new JScrollPane(listaTenistas);
		this.getContentPane().add(scrollT);
		this.setSize(800,800);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		VentanaPrincipal vp = new VentanaPrincipal();
	}
}

class MiHiloRecursiva extends Thread{
	private HistoriaGrandSlams hgs;
	private DefaultListModel<Object> listModel;
	protected JList<Object> listaTenistas;
	public MiHiloRecursiva(HistoriaGrandSlams hgs, DefaultListModel<Object> listM,JList<Object> listT) {
		this.hgs = hgs;
		this.listModel = listM;
		this.listaTenistas = listT;
		this.start();
	}
	@Override
	public void run() {
		listModel.clear();
		for (Tenista t : hgs.getNtenistas().values()) {
			t.setVictorias(recursiva(t, 1968, 2021,0));
			listModel.addElement(t);
			listaTenistas.repaint();
		}
		super.run();
	}
	public int recursiva(Tenista t, int añoI,int añoF, int victorias) {
		for(Resultado r : hgs.getResutadosl()) {
			if(r.getCampeon().equals(t))victorias++;
			System.out.print(""/*t+", "+victorias+","+añoI*/);
		}
		if(añoI<=añoF) this.recursiva(t,++añoI, añoF, victorias);
		
		return victorias;
	}
}