package FTP.modelo;

public class MoLogin {
	private String[] textos = {"Login","Introduzca los siguientes campos", "Correo", "Contraseña" };
	private String[] texBotones = { "Iniciar sesión", "Registrarse"};

	public String[] getTextos() {
		return textos;
	}

	public String getTextos(int indice) {
		return textos[indice];
	}

	public void setTextos(String[] textos) {
		this.textos = textos;
	}

	public String[] gettexBotones() {
		return texBotones;
	}
	
	public String gettexBotones(int indice) {
		return texBotones[indice];
	}

	public void settexBotones(String[] texBotones) {
		this.texBotones = texBotones;
	}
	
}