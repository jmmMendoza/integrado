package correo.controlador;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnvioCorreo {

	public static void main(String[] args) {
		String remitente = "integradogrupo3@gmail.com";
		String password = "#Integradogrupo3";
		String destino = "equisdenigrante@gmail.com";
		
		Properties propiedades = new Properties();
		propiedades.put("mail.smtp.host", "smtp.gmail.com");
		propiedades.put("mail.smtp.port", "587");//Puerto por defecto
		propiedades.put("mail.smtp.auth", "true");
		propiedades.put("mail.smtp.starttls.enable", "true"); 
		propiedades.put("mail.smtp.starttls.required", "true");
		propiedades.put("mail.smtp.ssl.protocols", "TLSv1.2");
		propiedades.put("mail.smtp.user.", remitente);
		propiedades.put("mail.smtp.clave", password);
		
		Session sesion = Session.getDefaultInstance(propiedades);
		MimeMessage mensaje = new MimeMessage(sesion);
//		
//		try {
//			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
//			mensaje.setSubject("Esto es una prueba");
//			mensaje.setText("Mensaje de prueba");
//			
//			Transport transporte = sesion.getTransport("smtp");
//			transporte.connect("smtp.gmail.com", remitente, password);
//			transporte.sendMessage(mensaje, mensaje.getAllRecipients());//A todos los destinatarios
//			transporte.close();
//			System.out.println("Correo mandado");
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

//		try {
//			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
//			mensaje.setSubject("Esto es una prueba - HTML");
//			mensaje.setText("Mensaje </br>de <b>prueba</b>", "utf-8","html");
//			
//			Transport transporte = sesion.getTransport("smtp");
//			transporte.connect("smtp.gmail.com", remitente, password);
//			transporte.sendMessage(mensaje, mensaje.getAllRecipients());//A todos los destinatarios
//			transporte.close();
//			System.out.println("Correo mandado");
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

		try {
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
			mensaje.setSubject("Esto es una prueba");

			BodyPart parteTexto = new MimeBodyPart();
			parteTexto.setContent("Este mensaje es una <b>pruebaaaa</b>","text/html");
			
			BodyPart parteArchivo = new MimeBodyPart();
			parteArchivo.setDataHandler(new DataHandler(new FileDataSource("C:\\Users\\ardor\\Desktop\\ACDA1EVA\\apuntes\\Apuntes ACDA EXAMEN 1EVA.pdf")));
			parteArchivo.setFileName("Prueba.pdf");
			
			MimeMultipart todasLasPartes = new MimeMultipart();
			todasLasPartes.addBodyPart(parteTexto);
			todasLasPartes.addBodyPart(parteArchivo);
			
			mensaje.setContent(todasLasPartes);
			
			Transport transporte = sesion.getTransport("smtp");
			transporte.connect("smtp.gmail.com", remitente, password);
			transporte.sendMessage(mensaje, mensaje.getAllRecipients());//A todos los destinatarios
			transporte.close();
			System.out.println("Correo mandado");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
