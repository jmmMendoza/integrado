package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.Conexion;
import vista.ViLogin;

public class EventosLogin implements ActionListener {

	private ViLogin vista;
	private Conexion conexion;
	private ResultSet rs;

	public EventosLogin(ViLogin vista, Conexion conexion) {
		this.vista = vista;
		this.conexion = conexion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vista.getBotones().get(0))) {
			String sql = crearSQL();
			// Se busca si el usuario y contraseña introducidos existen
			conexion.crearConsulta(sql, conexion.getState(0));
			int indice = conexion.getRs().size() - 1;
			rs = conexion.getRs(conexion.getRs().size() - 1);
			try {
				// Si se encuentra al usuario
				if (rs.next()) {
					vista.mostrarDialogoLogin("Has iniciado sesion como " + rs.getString(2) + " " + rs.getString(3)
							+ ", actualmente tienes el rol de " + rs.getString(6) + ".");
					// Se crea el menu

				} else {
					JOptionPane.showMessageDialog(null, "Cuenta incorrecta");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			conexion.removeRs(indice);
			//Añadido por Jorge
		} else if (e.getSource().equals(vista.getBotones().get(1))) {
			new CoRegistro(conexion);
			System.out.println("Ventana Nueva");
		}
	}

	private String crearSQL() {
		String sql = "SELECT * FROM USUARIOS WHERE UPPER(CORREO) = '" + vista.getNickText().trim().toUpperCase()
				+ "' AND PASSWORD = '" + vista.getPasswordText() + "'";
		return sql;
	}
}
