package Practica0;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

public class Tabla extends JFrame{
	private static final long serialVersionUID = 1L;
	protected JList<Object> listaTenistas;
	protected DefaultListModel<Object> modeloTenistas;
	public Tabla(HistoriaGrandSlams hgs, TipoDato tabla) {
		this.setSize(400,400);
		modeloTenistas = new DefaultListModel<>();
		if(tabla.equals(TipoDato.Tenista)) {
			for (Tenista tenista : hgs.getNtenistas().values()) {
				modeloTenistas.addElement(tenista);
			}
		}
		else {  for (Resultado r : hgs.getResutadosl()) {
			modeloTenistas.addElement(r);
			}
		}
		listaTenistas = new JList<>(modeloTenistas);
		listaTenistas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollT = new JScrollPane(listaTenistas);
		this.getContentPane().add(scrollT, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
