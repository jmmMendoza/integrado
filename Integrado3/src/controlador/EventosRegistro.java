package controlador;

/**
 * 
 * @author Jorge Martos Mendoza
 * 
 *         Fecha: 15/12/2021
 * 
 *         Trabajo: Proyecto Integrado Seguridad Social Grupo 3
 * 
 *         Clase con los eventos que realiza el proceso de registro
 *
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Statement;

import javax.swing.JOptionPane;

import conexion.Conexion;
import vista.ViLogin;
import vista.ViRegistro;

public class EventosRegistro implements ActionListener, KeyListener {
	private Conexion conexion;
	private ViRegistro vista;
	private ViLogin vistaLogin;

	public EventosRegistro(ViRegistro vista, Conexion conexion, ViLogin vistaLogin) {
		this.vista = vista;
		this.conexion = conexion;
		this.vistaLogin = vistaLogin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sql = crearSQL();
		if (vista.getTxtNif().getText().trim().length() != 0 && vista.getTxtNombre().getText().trim().length() != 0
				&& vista.getTxtApellidos().getText().trim().length() != 0
				&& vista.getTxtCorreo().getText().trim().length() != 0
				&& vista.getPasswordFieldContra().getText().trim().length() != 0
				&& vista.getPasswordFieldConfirmar().getText().trim().length() != 0) {
			System.out.println("dsfssvzxxv");
			System.out.println(vista.getTxtNif().getText().length());
			if (vista.getPasswordFieldContra().getText().equals(vista.getPasswordFieldConfirmar().getText())) {
				vista.mostrarDialogoRegistro("boton pulsao");
				System.out.println(sql);

				if(conexion.modificarBADA(conexion.getState(conexion.getState().size()-1), sql)) {
					vista.mostrarDialogoRegistro("Registro completado");
					
					vista.dispose();
					vistaLogin.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "No se puede repetir el NIF");
				}
				
				
			} else {
				vista.mostrarDialogoRegistro("Las contraseñas no son iguales");
			}
		} else {
			vista.mostrarDialogoRegistro("No puede haber campos vacíos");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource().equals(vista.getCampos().get(0))) {
			int limite = 9;
			if (vista.getCampos().get(0).getText().length() == limite) {
				e.consume();
			}
		}

		else if (e.getSource().equals(vista.getCampos().get(1))) {
			int limite = 25;
			if (vista.getCampos().get(1).getText().length() == limite) {
				e.consume();
			}
		}

		else if (e.getSource().equals(vista.getCampos().get(2))) {
			int limite = 40;
			if (vista.getCampos().get(2).getText().length() == limite) {
				e.consume();
			}
		}

		else if (e.getSource().equals(vista.getCampos().get(3))) {
			int limite = 50;
			if (vista.getCampos().get(3).getText().length() == limite) {
				e.consume();
			}
		}

		else if (e.getSource().equals(vista.getContra().get(0))) {
			int limite = 20;
			if (vista.getContra().get(0).getText().length() == limite) {
				e.consume();
			}
		}

		else if (e.getSource().equals(vista.getContra().get(1))) {
			int limite = 20;
			if (vista.getContra().get(1).getText().length() == limite) {
				e.consume();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private String crearSQL() {
		String sql = "INSERT INTO USUARIOS  VALUES ('" + vista.getTxtNif().getText() + "', '"
				+ vista.getTxtNombre().getText() + "', '" + vista.getTxtApellidos().getText() + "', '"
				+ vista.getTxtCorreo().getText() + "', '" + vista.getPasswordFieldContra().getText() + "', '"
				+ vista.getComboBox().getSelectedItem() + "')";
		return sql;
	}
}
