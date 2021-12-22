package FTP.controlador;

import FTP.vista.ViLogin;
import conexion.Conexion;

public class MainLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Prueba java");
		System.out.println("Prueba de commit");
		Conexion conexion = new Conexion();
		conexion.crearStatement();
		new CoLogin(conexion);
	}

}
