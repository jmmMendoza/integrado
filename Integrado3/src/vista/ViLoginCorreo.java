package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
/**
 * Proyecto Integrado Seguridad Social Grupo 3
 * @author Juan Carlos Gil Gil
 * Herramienta utilizada: Window Builder
 * Fecha: 17/12/2021
 */
public class ViLoginCorreo extends JFrame {

	private JPanel contentPane;
	private JTextField txtCorreo;
	private JTextField txtContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViLoginCorreo frame = new ViLoginCorreo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViLoginCorreo() {
		setTitle("Iniciar Sesi\u00F3n Correo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 560);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon("C:\\foto\\logingoogle.png"));
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/logingoogle.png")));
		lblNewLabel.setBounds(208, 10, 526, 503);
		//ImageIcon ico = new ImageIcon("C:\\foto\\logingoogle.png");
		ImageIcon ico = new ImageIcon(getClass().getResource("/logingoogle.png"));
	    Image image = (ico).getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
	    ico = new ImageIcon(image);
	    
	    JPanel panel = new JPanel();
	    panel.setOpaque(false);
	    panel.setBounds(353, 251, 230, 136);
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
	    
	    txtContra = new JTextField();
	    panel.add(txtContra);
	    txtContra.setColumns(20);
	    
	    JButton btnAcceder = new JButton("Acceder");
	    btnAcceder.setBackground(SystemColor.textHighlight);
	    btnAcceder.setForeground(new Color(255, 255, 255));
	    panel.add(btnAcceder);
	    lblNewLabel.setIcon(ico);
		contentPane.add(lblNewLabel);
	}
}