package vista;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LTexto extends JPanel {
	private JLabel etiqueta;
	private JTextField campo = new JTextField(20);
	private FlowLayout fw = new FlowLayout();

	public LTexto(String textoEtiqueta) {
		crearComponentes(textoEtiqueta);
		setLayout(fw);
	}

	private void crearComponentes(String textoEtiqueta) {
		etiqueta = new JLabel(textoEtiqueta);
		add(etiqueta);
		add(campo);
	}

	public void vaciarCampo() {
		getCampo().setText("");
	}

	public JLabel getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(JLabel etiqueta) {
		this.etiqueta = etiqueta;
	}

	public JTextField getCampo() {
		return campo;
	}

	public void setCampo(JTextField campo) {
		this.campo = campo;
	}

}