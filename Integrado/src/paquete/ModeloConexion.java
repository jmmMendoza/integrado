package paquete;

/**
 * 
 * @author David Santos Casanova
 * 
 *         Fecha: 14/12/2021
 * 
 *         Trabajo: Proyecto Integrado Seguridad Social Grupo 3
 * 
 *         Modelo de la conexion
 *
 */

public class ModeloConexion {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String ip = "jdbc:mysql://db4free.net:3306/grupo3integrado";
	private String usuario = "integradogrupo3";
	private String password = "#Integradogrupo3";

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}