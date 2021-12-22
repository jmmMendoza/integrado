package FTP.controlador;

import javax.swing.JButton;
import javax.swing.JTextField;

import FTP.vista.ViRegistro;
import conexion.Conexion;
/**
 * 
 * @author Jorge Martos Mendoza
 * 
 *         Fecha: 15/12/2021
 * 
 *         Trabajo: Proyecto Integrado Seguridad Social Grupo 3
 * 
 *         Clase controlador sobre el registro de usuarios
 *
 */
public class CoRegistro {
	private Conexion conexion;
	private ViRegistro vista;

	public CoRegistro(Conexion conexion) {
		this.conexion = conexion;
		this.vista = new ViRegistro(conexion);
		// Se activan los eventos del boton de login
		activarEventos();
	}

	// Metodo para activar los eventos del boton de login
	private void activarEventos() {
		System.out.println(vista.getCampos().size());
		for (JTextField campo : vista.getCampos()) {
			campo.addKeyListener(new EventosRegistro(vista, conexion));
		}
		vista.getBoton().addActionListener(new EventosRegistro(vista, conexion));
		vista.getPassword().addKeyListener(new EventosRegistro(vista, conexion));
	}

}