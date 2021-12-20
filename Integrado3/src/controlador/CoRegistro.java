package controlador;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import conexion.Conexion;
import vista.ViLogin;
import vista.ViRegistro;
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
	private ViLogin vistaLogin;

	public CoRegistro(Conexion conexion, ViLogin vistaLogin) {
		this.conexion = conexion;
		this.vista = new ViRegistro(conexion);
		this.vistaLogin = vistaLogin;
		// Se activan los eventos del boton de login
		activarEventos();
	}

	// Metodo para activar los eventos del boton de login
	private void activarEventos() {
		System.out.println(vista.getCampos().size());
		for (JTextField campo : vista.getCampos()) {
			campo.addKeyListener(new EventosRegistro(vista, conexion, vistaLogin));
		}
		for (JPasswordField contra : vista.getContra()) {
			contra.addKeyListener(new EventosRegistro(vista, conexion, vistaLogin));
		}
		vista.getBtnRegistrar().addActionListener(new EventosRegistro(vista, conexion, vistaLogin));
	}

}