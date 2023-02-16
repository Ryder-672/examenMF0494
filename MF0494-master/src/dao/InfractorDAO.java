package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import conexion.ConexionBD;
import modelo.Infractor;
import modelo.Sancion;


public class InfractorDAO {
	private ConexionBD conexion;
	
	  public InfractorDAO() {
	        this.conexion = new ConexionBD();
	    }
	
	public ArrayList<Infractor> obtenerInfractores() {
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Infractor> lista = new ArrayList<Infractor>();
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from infractores");
			
			while (resultado.next()) {
				String dni = resultado.getString("Dni");
				String nombre = resultado.getString("Nombre");
				String apellidos= resultado.getString("Apellidos");
				int antiguedad = resultado.getInt("Antiguedad");
				double sancion = resultado.getDouble("sancion");
				int puntos = resultado.getInt("puntos");
				
				Infractor i = new Infractor(dni, nombre, apellidos, antiguedad, sancion, puntos);
				lista.add(i);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error al realizar la consulta sobre sanciones: "+e.getMessage());

		}finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return lista;

	}
	
	
	public Infractor obtenerInfractor( String dni) {
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Infractor i = null;
		
		try {
			consulta = con.prepareStatement("select * from infractores"
				+ " where dni = ?");
		consulta.setString(1, dni);
		resultado=consulta.executeQuery();
		
			if (resultado.next()) {
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("nombre");
				int antiguedad = resultado.getInt("Antiguedad");
				double sancion = resultado.getDouble("sancion");
				int puntos = resultado.getInt("puntos");
				
				i = new Infractor(dni, nombre ,apellidos, antiguedad, sancion, puntos );

			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error al realizar la consulta sobre un infractor: "
			         +e.getMessage());
		}finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return i;
	}
	
	 public int insertarInfractor(Infractor i) {
	    	// Obtenemos una conexion a la base de datos.
			Connection con = conexion.getConexion();
			PreparedStatement consulta = null;
			int resultado=0;
				
			try {
				consulta = con.prepareStatement("insert into infractores (dni, nombre, apellidos, antiguedad, sancion, puntos) "
						+ "VALUES"
						+ "(?,?,?,?,?,?)");
				
				consulta.setString(1, i.getDni());
				consulta.setString(2, i.getNombre());
				consulta.setString(3, i.getApellidos());
				consulta.setInt(4, i.getAntiguedad());
				consulta.setDouble(5, i.getSancion());
				consulta.setInt(6, i.getPuntos());

				resultado=consulta.executeUpdate();
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Error al realizar la inserci�n de una infratores "
				        +e.getMessage());
			}finally {
				try {
					consulta.close();
					conexion.desconectar();
				} catch (SQLException e) {
					System.out.println("Error al liberar recursos: "+e.getMessage());
				} catch (Exception e) {
					
				}
			}
			return resultado;
	 }
	
	


}
