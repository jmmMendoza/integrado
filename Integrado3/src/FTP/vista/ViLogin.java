package FTP.vista;

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

import FTP.modelo.MoLogin;

public class ViLogin extends JFrame {
	private MoLogin modelo = new MoLogin();
	private ArrayList<JButton> botones = new ArrayList<>();
	private ArrayList<JLabel> textos = new ArrayList<>();
	private ArrayList<JPanel> paneles = new ArrayList<>();
	private JTextField nick;
	private Box vertical = Box.createVerticalBox();

	public ViLogin() {
		panelTitulo();
		panelLogin();
		addPaneles();
		propiedadesVentana();
	}

	private void propiedadesVentana() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		// setTitle(modelo.getTitulo());
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
		textos.add(new JLabel(modelo.getTextos(3)));
		crearBotones(vert);
		panel.add(vert);
		paneles.add(panel);
	}

	private void crearBotones(Box vert) {
		for (int i=0; i<modelo.gettexBotones().length; i++) {
			botones.add(new JButton(modelo.gettexBotones(i)));
			vert.add(botones.get(i));
		}
	}

	public void mostrarDialogoLogin(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);

	}

	private void addPaneles() {
		for (JPanel panel : paneles) {
			vertical.add(panel);
		}
		getContentPane().add(vertical);
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
	
	public ArrayList<JButton> getBotones() {
		return botones;
	}

	public void setBotones(ArrayList<JButton> botones) {
		this.botones = botones;
	}
}