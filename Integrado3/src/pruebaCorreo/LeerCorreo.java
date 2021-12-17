package pruebaCorreo;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import vista.ViBandeja;

public class LeerCorreo {
	private static ViBandeja vista = new ViBandeja();
//	private String[] columnas;
	;

	public static void main(String[] args) {
		String remitente = "integradogrupo3@gmail.com";
		String password = "#Integradogrupo3";
		ArrayList<String> filas = new ArrayList<>();

		Properties propiedades = new Properties();
//		propiedades.setProperty("mail.pop3.starttls.enable", "false");
//		propiedades.setProperty("mail.pop3.socketFactory.class","javax.net.ssl.SSLSocketFactory" );
//		propiedades.setProperty("mail.pop3.socketFactory.fallback", "false");
//		propiedades.setProperty("mail.pop3.port","995");
//		propiedades.setProperty("mail.pop3.socketFactory.port", "995");
		// propiedades.put("mail.pop3.starttls.required", "false");
		// propiedades.put("mail.pop3.ssl.protocols", "TLSv1.2");
		propiedades.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		propiedades.put("mail.pop3.socketFactory.fallback", "false");
		propiedades.put("mail.pop3.socketFactory.port", "995");
		propiedades.put("mail.pop3.port", "995");
		propiedades.put("mail.pop3.host", "pop.gmail.com");
		propiedades.put("mail.pop3.user", remitente);
		propiedades.put("mail.store.protocol", "pop3");
		propiedades.put("mail.pop3.ssl.protocols", "TLSv1.2");

		Session sesion = Session.getDefaultInstance(propiedades);
		sesion.setDebug(true);

		Store store;
		try {
			store = sesion.getStore("pop3");
			try {
				store.connect("pop.gmail.com", remitente, password);
				Folder folder = store.getFolder("INBOX");
				folder.open(Folder.READ_ONLY);
				Message[] mensajes = folder.getMessages();

				for (int i = 0; i < mensajes.length; i++) {
					System.out.println("From:" + mensajes[i].getFrom()[0].toString());
					System.out.println("Subject:" + mensajes[i].getSubject());
					filas.add("De:" + mensajes[i].getFrom()[0].toString() + " " + "Asunto:" + mensajes[i].getSubject());
				}
				String[] columnas = new String[] { "Correo electrónico" };
				String[][] datos = new String[mensajes.length][1];
				for (int i = 0; i < filas.size(); i++) {
					for (int j = 0; j < columnas.length; j++) {
						System.out.println(filas.get(i));
						System.out.println(i + "," + j);
						datos[i][j] = filas.get(filas.size()-i-1);
					}
				}
				vista.crearJTable(columnas, datos);

				for (int i = 0; i < mensajes.length; i++) {
					if (mensajes[i].isMimeType("text/*")) {
						// mensaje de texto simple
						try {
							System.out.println(mensajes[i].getContent());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					if (mensajes[i].isMimeType("multipart/*")) {
						// mensaje compuesto
						Multipart multi;
						try {
							multi = (Multipart)mensajes[i].getContent();
							for (int j=0;j<multi.getCount();j++) {
								Part unaParte = multi.getBodyPart(j);
								if(unaParte.isMimeType("text/plain")) {
									System.out.println("ASFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
									System.out.println(unaParte.getContent());
								}
								else if (unaParte.isMimeType("image/*")) {
									JFrame v = new JFrame();
									ImageIcon icono = new ImageIcon(ImageIO.read(unaParte.getInputStream()));
									JLabel l = new JLabel(icono);
									v.getContentPane().add(l);
									v.pack();
									v.setVisible(true);
								}
								else if (unaParte.isMimeType("text/html")){
									System.out.println("holaaa");
									System.out.println(unaParte);
									
								}
								else if (unaParte.getContent() instanceof MimeMultipart) {
									System.out.println("Adios");
									System.out.println(((MimeMultipart)unaParte.getContent()));
								}
							}
							System.out.println("Complejo");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
