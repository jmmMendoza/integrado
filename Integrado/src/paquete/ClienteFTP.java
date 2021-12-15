package paquete;

import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class ClienteFTP {

	public static void main(String[] args) {
		FTPClient cliente = new FTPClient();
		String ftp = "127.0.0.1";
		String user = "EmpresarioPrueba";
		String password = "empresario";
		
		try {
			cliente.connect(ftp);
			boolean login = cliente.login(user, password);
			cliente.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
			cliente.setFileTransferMode(FTP.BINARY_FILE_TYPE);
			cliente.enterLocalPassiveMode();
			String rutaRemota = "C:\\Users\\Alejandro\\Desktop\\ServidorFTP\\Seguridad social\\Empresarios";
			String rutaArchivo = "C:\\Users\\Alejandro\\Desktop\\miarchivo.txt";
			String archivo = "miarchivo.txt";
			FileInputStream fileIn = new FileInputStream(rutaArchivo);
			cliente.changeWorkingDirectory(rutaRemota);
			boolean uploadFile = cliente.storeFile(archivo,fileIn);
			if (!uploadFile) {
				throw new Exception("Error al subir el archivo.");
			}
			cliente.logout();
			cliente.disconnect();
		} catch (Exception e) {
		}
	}

}