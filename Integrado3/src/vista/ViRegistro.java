package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
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
public class ViRegistro extends JFrame {

	private Conexion conexion;
	private JPanel contentPane;
	private JTextField txtNif;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtApellidos;
	private JButton btnRegistrar;
	private JPasswordField passwordFieldContra;
	private JPasswordField passwordFieldConfirmar;
	private ArrayList<JTextField> campos = new ArrayList<>();
	private ArrayList<JPasswordField> contra = new ArrayList<>();
	private ResultSet rs;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param conexion 
	 */
	public ViRegistro(Conexion conexion) {
		this.conexion = conexion;
		setTitle("Registro Seguridad Social");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	    panel.setBounds(228, 142, 205, 190);
	    contentPane.add(panel);
	    
	    JLabel lblNif = new JLabel("NIF");
	    lblNif.setFont(new Font("Tahoma", Font.BOLD, 10));
	    lblNif.setHorizontalAlignment(SwingConstants.CENTER);
	    panel.add(lblNif);
	    
	    txtNif = new JTextField();
	    campos.add(txtNif);
	    panel.add(txtNif);
	    txtNif.setColumns(20);
	    
	    JLabel lblNombre = new JLabel("Nombre");
	    lblNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
	    panel.add(lblNombre);
	    
	    txtNombre = new JTextField();
	    campos.add(txtNombre);
	    panel.add(txtNombre);
	    txtNombre.setColumns(20);
	    
	    JLabel lblApellidos = new JLabel("Apellidos");
	    lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 10));
	    panel.add(lblApellidos);
	    
	    txtApellidos = new JTextField();
	    campos.add(txtApellidos);
	    txtApellidos.setColumns(20);
	    panel.add(txtApellidos);
	    
	    JLabel lblRol = new JLabel("ROL");
	    panel.add(lblRol);
	    
	    comboBox = new JComboBox();
	    String sql = crearSQL();
		conexion.crearConsulta(sql, conexion.getState(0));
		int indice = conexion.getRs().size() - 1;
		rs = conexion.getRs(conexion.getRs().size() - 1);
		try {
			while (rs.next()) {
				comboBox.addItem(rs.getString(1));
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	    panel.add(comboBox);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setOpaque(false);
	    panel_1.setBounds(476, 142, 205, 190);
	    contentPane.add(panel_1);
	    
	    JLabel lblCorreo = new JLabel("Correo");
	    lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
	    lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 10));
	    panel_1.add(lblCorreo);
	    
	    txtCorreo = new JTextField();
	    campos.add(txtCorreo);
	    txtCorreo.setColumns(20);
	    panel_1.add(txtCorreo);
	    
	    JLabel lblContra = new JLabel("Contrase\u00F1a");
	    lblContra.setFont(new Font("Tahoma", Font.BOLD, 10));
	    panel_1.add(lblContra);
	    
	    passwordFieldContra = new JPasswordField();
	    passwordFieldContra.setEchoChar('*');
	    passwordFieldContra.setColumns(20);
	    contra.add(passwordFieldContra);
	    panel_1.add(passwordFieldContra);
	    
	    JLabel lblConfirmar = new JLabel("Confirmar contrase\u00F1a");
	    lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 10));
	    panel_1.add(lblConfirmar);
	    
	    passwordFieldConfirmar = new JPasswordField();
	    passwordFieldConfirmar.setEchoChar('*');
	    contra.add(passwordFieldConfirmar);
	    passwordFieldConfirmar.setColumns(20);
	    panel_1.add(passwordFieldConfirmar);
	    
	    JCheckBox chckbxMostrar = new JCheckBox("Mostrar Contrase\u00F1a");
	    chckbxMostrar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(chckbxMostrar.isSelected()) {
	    			passwordFieldContra.setEchoChar((char)0);
	    			passwordFieldConfirmar.setEchoChar((char)0);
	    		}else {
	    			passwordFieldContra.setEchoChar('*');
	    			passwordFieldConfirmar.setEchoChar('*');
	    		}
	    	}
	    });
	    panel_1.add(chckbxMostrar);
	    
	    btnRegistrar = new JButton("Registrarse");
	    btnRegistrar.setBackground(Color.BLACK);
	    btnRegistrar.setForeground(Color.WHITE);
	    panel_1.add(btnRegistrar);
	    lblNewLabel.setIcon(ico);
		contentPane.add(lblNewLabel);
		setVisible(true);
	}
	public void mostrarDialogoRegistro(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);

	}
	private String crearSQL() {
		String sql = "SELECT ROL FROM PRIVILEGIOS";
		return sql;
	}
	
	// GETTERS & SETTERS
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public ArrayList<JTextField> getCampos() {
		return campos;
	}

	public void setCampos(ArrayList<JTextField> campos) {
		this.campos = campos;
	}

	public ArrayList<JPasswordField> getContra() {
		return contra;
	}

	public void setContra(ArrayList<JPasswordField> contra) {
		this.contra = contra;
	}
	public JTextField getTxtNif() {
		return txtNif;
	}
	public void setTxtNif(JTextField txtNif) {
		this.txtNif = txtNif;
	}
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JTextField getTxtCorreo() {
		return txtCorreo;
	}
	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}
	public JTextField getTxtApellidos() {
		return txtApellidos;
	}
	public void setTxtApellidos(JTextField txtApellidos) {
		this.txtApellidos = txtApellidos;
	}
	public JPasswordField getPasswordFieldContra() {
		return passwordFieldContra;
	}
	public void setPasswordFieldContra(JPasswordField passwordFieldContra) {
		this.passwordFieldContra = passwordFieldContra;
	}
	public JPasswordField getPasswordFieldConfirmar() {
		return passwordFieldConfirmar;
	}
	public void setPasswordFieldConfirmar(JPasswordField passwordFieldConfirmar) {
		this.passwordFieldConfirmar = passwordFieldConfirmar;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
}
