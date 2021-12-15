package vista;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.MoLogin;

public class ViLogin extends JFrame{
	private MoLogin modelo = new MoLogin();
	private JButton boton;
	private ArrayList<JLabel> textos = new ArrayList<>();
	private ArrayList<JPanel> paneles = new ArrayList<>();
	private JTextField nick;
	private JPasswordField password;
	private Box vertical = Box.createVerticalBox();

	public ViLogin() {
		panelTitulo();
		panelLogin();
		addPaneles();
		propiedadesVentana();
	}

	private void propiedadesVentana() {
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setTitle(modelo.getTitulo());
		setVisible(true);
		ajustarVentana();
	}

	private void ajustarVentana() {
		pack();
		
	}

	private void panelTitulo() {
		paneles.add(new JPanel(new FlowLayout()));
		textos.add(new JLabel(modelo.getTextos(0)));
		paneles.get(paneles.size() - 1).add(textos.get(textos.size() - 1));
	}

	private void panelLogin() {
		JPanel panel = new JPanel(new FlowLayout());
		Box vert = Box.createVerticalBox();
		// Se crea el panel de usuario
		LTexto nombre = new LTexto(modelo.getTextos(2));
		vert.add(nombre);
		nick = nombre.getCampo();
		// Se crea el panel del password
		JPanel panPassword = new JPanel(new FlowLayout());
		textos.add(new JLabel(modelo.getTextos(3)));
		panPassword.add(textos.get(textos.size() - 1));
		password = new JPasswordField(20);
		panPassword.add(password);
		vert.add(panPassword);
		boton = new JButton(modelo.getTextos(0));
		vert.add(boton);
		panel.add(vert);
		paneles.add(panel);
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

	public JTextField getNick() {
		return nick;
	}

	public String getNickText() {
		return nick.getText();
	}

	public void setNick(JTextField nick) {
		this.nick = nick;
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

}