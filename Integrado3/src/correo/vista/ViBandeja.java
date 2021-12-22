package correo.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;

public class ViBandeja extends JFrame {
	private JTable tabla;
	private JScrollPane scroll;
	
	public ViBandeja() {
		propiedadesVentana();
	}

	private void propiedadesVentana() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 558, 394);
		setVisible(true);
		ajustarVentana();
	}
	
	public void ajustarVentana() {
		pack();
		getContentPane().setLayout(new GridLayout(1, 1, 20, 20));
	}
	
	public void crearJTable(String[] columnas, String[][] datos) {
		 tabla = new JTable(new DefaultTableModel(datos, columnas)) {
			@Override
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};
		scroll = new JScrollPane(tabla);
		getContentPane().add(scroll);
		ajustarVentana();
	}
	
	public void modificarJTable(int posicion,int indice,String texto) {
		tabla.setValueAt(texto, posicion, indice);	
	}
	
	public void addFilaJTable(String[] datos) {
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();
		model.addRow(datos);
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}
	
}