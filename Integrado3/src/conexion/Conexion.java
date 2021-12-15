package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.MoConexion;

/**
 * 
 * @author David Santos Casanova
 * 
 *         Fecha: 14/12/2021
 * 
 *         Trabajo: Proyecto Integrado Seguridad Social Grupo 3
 * 
 *         Clase con la conexion y todos los metodos referente a ella
 *
 */

public class Conexion {
	private MoConexion modelo = new MoConexion();
	private Connection conexion;
	private ArrayList<Statement> state = new ArrayList<>();
	private ArrayList<ResultSet> rs = new ArrayList<>();

	public Conexion() {
		try {
			Class.forName(modelo.getDriver());
			try {
				// Se crea la conexion
				conexion = DriverManager.getConnection(modelo.getIp(), modelo.getUsuario(), modelo.getPassword());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Metodo que sirve para crear un Statement
	public void crearStatement() {
		try {
			state.add(conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Metodo que sirve para crear un ResultSet
	public void crearConsulta(String sql, Statement st) {
		try {
			ResultSet consulta = st.executeQuery(sql);
			rs.add(consulta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Metodo para realizar insert,update,delete. Devuelve true si se realiza y
	// false en el caso contrario
	public boolean modificarBADA(Statement st, String query) {
		try {
			st.executeUpdate(query);
			System.out.println("Se ha actualizado la base de datos con la siguiente secuencia: " + query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Statement> getState() {
		return state;
	}

	public Statement getState(int indice) {
		return state.get(indice);
	}

	public void setState(ArrayList<Statement> state) {
		this.state = state;
	}

	public ArrayList<ResultSet> getRs() {
		return rs;
	}

	public ResultSet getRs(int indice) {
		return rs.get(indice);
	}

	public void setRs(ArrayList<ResultSet> rs) {
		this.rs = rs;
	}

	// Metodo para modificar un ResultSet
	public void setRs(int indice, Statement st, String sql) {
		try {
			ResultSet result = st.executeQuery(sql);
			rs.set(indice, result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Metodo para borrar un ResultSet
	public void removeRs(int indice) {
		rs.remove(indice);
	}

	public void vaciarRs() {
		rs.clear();
	}

	public void vaciarState() {
		state.clear();
	}

	// Metodo para vaciar la Conexion
	public void vaciarConex() {
		vaciarRs();
		vaciarState();
	}

	public void cerrarConexion() {
		vaciarRs();
		vaciarState();
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}