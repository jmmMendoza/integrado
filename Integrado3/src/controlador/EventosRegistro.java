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

import conexion.Conexion;
import vista.ViRegistro;

public class EventosRegistro implements ActionListener, KeyListener {
	private Conexion conexion;
	private ViRegistro vista;

	public EventosRegistro(ViRegistro vista, Conexion conexion) {
		this.vista = vista;
		this.conexion = conexion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("boton pulsao");

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
		
		else if (e.getSource().equals(vista.getPassword())) {
			int limite = 20;
			if (vista.getPassword().getText().length() == limite) {
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

}
