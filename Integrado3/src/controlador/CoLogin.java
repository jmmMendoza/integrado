package controlador;

import conexion.Conexion;
import vista.ViLogin;

public class CoLogin {
	private Conexion conexion;
	private ViLogin vista;

	public CoLogin(Conexion conexion) {
		this.conexion = conexion;
		this.vista = new ViLogin();
		// Se activan los eventos del boton de login
		activarEventos();
	}

	// Metodo para activar los eventos del boton de login
	private void activarEventos() {
		vista.getBoton().addActionListener(new EventosLogin(vista, conexion));
	}

}
