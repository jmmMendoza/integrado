package modelo;

public class MoLogin {
	private String[] textos = { "Login", "Introduzca los siguientes campos", "Correo", "Contraseña" };

	public String[] getTextos() {
		return textos;
	}

	public String getTextos(int indice) {
		return textos[indice];
	}

	public void setTextos(String[] textos) {
		this.textos = textos;
	}
}