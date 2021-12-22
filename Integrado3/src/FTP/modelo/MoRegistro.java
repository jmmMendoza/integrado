package FTP.modelo;
/**
 * 
 * @author Jorge Martos Mendoza
 * 
 *         Fecha: 15/12/2021
 * 
 *         Trabajo: Proyecto Integrado Seguridad Social Grupo 3
 * 
 *         Clase con los datos incluidos en labels, buttons...
 *
 */
public class MoRegistro {
	private String[] textos = { "NIF", "Nombre", "Apellidos", "Correo", "Rol", "Contraseña" };
	private String[] pantalla = { "Registro", "Registrarse" };

	public String[] getTextos() {
		return textos;
	}

	public String getTextos(int indice) {
		return textos[indice];
	}

	public void setTextos(String[] textos) {
		this.textos = textos;
	}

	public String[] getPantalla() {
		return pantalla;
	}

	public String getPantalla(int indice) {
		return pantalla[indice];
	}

	public void setPantalla(String[] pantalla) {
		this.pantalla = pantalla;
	}
}