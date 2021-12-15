package vista;
/**
 * 
 * @author Jorge Martos Mendoza
 * 
 *         Fecha: 15/12/2021
 * 
 *         Trabajo: Proyecto Integrado Seguridad Social Grupo 3
 * 
 *         Clase con la vista sobre el proceso de registro
 *
 */
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import conexion.Conexion;
import modelo.MoRegistro;

public class ViRegistro extends JFrame {
	private MoRegistro modelo = new MoRegistro();
	private Conexion conexion;
	private JButton boton;
	private ArrayList<JLabel> textos = new ArrayList<>();
	private ArrayList<JPanel> paneles = new ArrayList<>();
	private ArrayList<JTextField> campos = new ArrayList<>();
	private JPasswordField password;
	private Box vertical = Box.createVerticalBox();
	private JComboBox combo;
	private ResultSet rs;

	public ViRegistro(Conexion conexion) {
		this.conexion = conexion;
		panelTitulo();
		panelLogin();
		addPaneles();
		propiedadesVentana();
	}

	private void propiedadesVentana() {
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// setTitle(modelo.getTitulo());
		setVisible(true);
		ajustarVentana();
	}

	private void ajustarVentana() {
		pack();

	}

	private void panelTitulo() {
		paneles.add(new JPanel(new FlowLayout()));
		textos.add(new JLabel(modelo.getPantalla(0)));
		paneles.get(paneles.size() - 1).add(textos.get(textos.size() - 1));
	}

	private void panelLogin() {
		JPanel panel = new JPanel(new FlowLayout());
		Box vert = Box.createVerticalBox();
		// Se crean los paneles
		crearPaneles(vert);
		// Se crea el panel del password
		JPanel panPassword = new JPanel(new FlowLayout());
		textos.add(new JLabel(modelo.getTextos(5)));
		panPassword.add(textos.get(textos.size() - 1));
		password = new JPasswordField(20);
		panPassword.add(password);
		vert.add(panPassword);
		rellenarCombo(vert);
		boton = new JButton(modelo.getPantalla(1));
		vert.add(boton);
		panel.add(vert);
		paneles.add(panel);
	}

	private void rellenarCombo(Box vert) {
		combo = new JComboBox();
		vert.add(combo);
		String sql = crearSQL();
		conexion.crearConsulta(sql, conexion.getState(0));
		int indice = conexion.getRs().size() - 1;
		rs = conexion.getRs(conexion.getRs().size() - 1);
		try {
			while (rs.next()) {
				combo.addItem(rs.getString(1));
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	private void crearPaneles(Box vert) {
		for (int i = 0; i < modelo.getTextos().length - 2; i++) {
			LTexto campo = new LTexto(modelo.getTextos(i));
			vert.add(campo);
			campos.add(campo.getCampo());
		}

	}

	public void mostrarDialogoLogin(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);

	}

	private void addPaneles() {
		for (JPanel panel : paneles) {
			vertical.add(panel);
		}
		add(vertical);
	}

	public JButton getBoton() {
		return boton;
	}

	public void setBoton(JButton boton) {
		this.boton = boton;
	}

	public ArrayList<JTextField> getCampos() {
		return campos;
	}

	public void setCampos(ArrayList<JTextField> campos) {
		this.campos = campos;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public String getPasswordText() {
		return password.getText();
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	private String crearSQL() {
		String sql = "SELECT ROL FROM PRIVILEGIOS";
		return sql;
	}
}
