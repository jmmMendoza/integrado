package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Proyecto Integrado Seguridad Social Grupo 3
 * @author Juan Carlos Gil Gil
 * Herramienta utilizada: Window Builder
 * Fecha: 17/12/2021
 */
public class ViLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtCorreo;
	private ArrayList<JButton> botones = new ArrayList<>();
	private JPasswordField passwordFieldContra;
	private JCheckBox chckbxMostrar;
	/**
	 * Create the frame.
	 */
	public ViLogin() {
		setTitle("Inicio Sesión Seguridad Social");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 560);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/fondo_seguridad.png")));
		lblNewLabel.setBounds(10, 10, 926, 503);
		ImageIcon ico = new ImageIcon(getClass().getResource("/fondo_seguridad.png"));
	    Image image = (ico).getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
	    ico = new ImageIcon(image);
	    
	    JPanel panel = new JPanel();
	    panel.setOpaque(false);
	    panel.setBounds(333, 163, 210, 148);
	    contentPane.add(panel);
	    
	    JLabel lblCorreo = new JLabel("CORREO");
	    lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 10));
	    lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
	    panel.add(lblCorreo);
	    
	    txtCorreo = new JTextField();
	    panel.add(txtCorreo);
	    txtCorreo.setColumns(20);
	    
	    JLabel lblContra = new JLabel("CONTRASE\u00D1A");
	    lblContra.setFont(new Font("Tahoma", Font.BOLD, 10));
	    panel.add(lblContra);
	    
	    passwordFieldContra = new JPasswordField();
	    passwordFieldContra.setEchoChar('*');
	    passwordFieldContra.setColumns(20);
	    panel.add(passwordFieldContra);
	    
	    chckbxMostrar = new JCheckBox("Mostrar Contrase\u00F1a      ");
	    chckbxMostrar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(chckbxMostrar.isSelected()) {
	    			passwordFieldContra.setEchoChar((char)0);
	    		}else {
	    			passwordFieldContra.setEchoChar('*');
	    		}
	    	}
	    });
	    panel.add(chckbxMostrar);
	    
	    JButton btnEntrar = new JButton("ENTRAR");
	    btnEntrar.setBackground(new Color(0, 0, 0));
	    btnEntrar.setForeground(new Color(255, 255, 255));
	    botones.add(btnEntrar);
	    panel.add(btnEntrar);
	    
	    JButton btnRegistrar = new JButton("REG\u00CDSTRATE");
	    btnRegistrar.setForeground(new Color(255, 255, 255));
	    btnRegistrar.setBackground(new Color(0, 0, 0));
	    botones.add(btnRegistrar);
	    panel.add(btnRegistrar);
	    lblNewLabel.setIcon(ico);
		contentPane.add(lblNewLabel);
		setVisible(true);
	}
	public void mostrarDialogoLogin(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);

	}
	
	public ArrayList<JButton> getBotones() {
		return botones;
	}
	public void setBotones(ArrayList<JButton> botones) {
		this.botones = botones;
	}
	public JTextField getTxtCorreo() {
		return txtCorreo;
	}
	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}
	public JPasswordField getPasswordFieldContra() {
		return passwordFieldContra;
	}
	public void setPasswordFieldContra(JPasswordField passwordFieldContra) {
		this.passwordFieldContra = passwordFieldContra;
	}
	
}
