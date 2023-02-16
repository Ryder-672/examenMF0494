/**
 * 
 */
package controlador;

import java.util.ArrayList;

import dao.SancionDAO;
import dao.InfractorDAO;
import modelo.Sancion;
import modelo.Infractor;
import vista.DialogoInsertarInfractor;
import vista.VentanaMostrarInfractores;

import vista.VentanaPpal;

/**
 * @author David
 *
 */
public class Controlador {

	// VEntanas del sistema
	private VentanaPpal ventanaPpal;
	private DialogoInsertarInfractor dialogoInsertarInfractor;

	
	// Objetos DAO o CRUD de la base de datos
	private SancionDAO sancionDAO;
	private InfractorDAO infractorDAO;


	
	public Controlador() {
		// Creamos las ventanas de la aplicaci�n
		ventanaPpal = new VentanaPpal();
		dialogoInsertarInfractor = new DialogoInsertarInfractor();
		
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		dialogoInsertarInfractor.setControlador(this);
		
		
		// Creamos los objetos DAO
		sancionDAO = new SancionDAO();
		infractorDAO = new InfractorDAO();
	}
	
	public void inciarPrograma() {
		ventanaPpal.setVisible(true);
	}

	public void mostrarInsertarInfractores () {
		ArrayList<Infractor> listaInfractores = new ArrayList<Infractor>();
		listaInfractores = infractorDAO.obtenerInfractores();
		dialogoInsertarInfractor.setListaInfratores(listaInfractores);
		dialogoInsertarInfractor.setVisible(true);
	}
	
	
}
