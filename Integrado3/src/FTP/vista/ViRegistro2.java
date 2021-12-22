package FTP.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

public class ViRegistro2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViRegistro2 frame = new ViRegistro2();
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
	public ViRegistro2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
//		 BufferedImage bufferedImage;
//		try {
//			
//			bufferedImage = ImageIO.read(new File(this.getClass().getResource("/header.png").getFile()));
//			Image image = bufferedImage.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
//			JLabel lblNewLabel = new JLabel("");
//			//Image img = new ImageIcon(this.getClass().getResource("/header.png")).getImage();
//			lblNewLabel.setIcon(new ImageIcon(image));
//			contentPane.add(lblNewLabel);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	     
		JLabel lblNewLabel = new JLabel("");

		lblNewLabel.setPreferredSize(new Dimension(this.getWidth(),40));
		
		Image img= new ImageIcon(getClass().getResource("/header.png")).getImage();
		ImageIcon img2=new ImageIcon(img.getScaledInstance(78, 124, Image.SCALE_SMOOTH));

		lblNewLabel.setIcon(img2);
		
		
		contentPane.add(lblNewLabel);
//		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/header.png"));
//        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblNewLabel.getWidth(),
//        		lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
//        Icon iconoEscalado = new ImageIcon(imgEscalada);
//        lblNewLabel.setIcon(iconoEscalado);
		
//		Image img= new ImageIcon("logo.png").getImage();
//		ImageIcon img2=new ImageIcon(img.getScaledInstance(78, 124, Image.SCALE_SMOOTH));
//
//		et1.setIcon(img2);

		//JLabel lblNewLabel = new JLabel("");
		//Image img = new ImageIcon(this.getClass().getResource("/header.png")).getImage();
		//lblNewLabel.setIcon(new ImageIcon(img));
		//contentPane.add(lblNewLabel);
	}

}
