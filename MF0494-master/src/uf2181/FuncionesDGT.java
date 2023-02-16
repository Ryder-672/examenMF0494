/**
 * 
 */
package uf2181;

/**
 * @author David
 *
 */
public class FuncionesDGT {
	/**
	 * Funcion que devuelve la media de un array de numeros dado
	 * @param puntos array de numeros
	 * @return devuelve la media en double de los numeros del array
	 */
	public double mediaPuntos(int puntos[]) {
		double suma = 0;
		
		for (int i = 0; i < puntos.length; i++) {
			suma = suma +puntos[i];
		}
		if (puntos.length==0) throw new ArrayIndexOutOfBoundsException();
		return suma/puntos.length;
	}
	/**
	 * funcion para determinar el limite de aire aspirado y limite en sangre de los condictores en funcion de si son generales o noveles y de si tienen aire o no
	 * @param tipoConductor tipo de conductor comprobado
	 * @param aire sitiene aire o no
	 * @return devuelve el limite de aire en sangre determinado 
	 */
	public double maximaTasaPermitida(String tipoConductor, boolean aire) {
		double tasa=0.25;
		if (tipoConductor.equalsIgnoreCase("General")) {
			if (aire) {
				tasa=0.25;
			} else {
				tasa=0.5;
			}
		} else {
			// profesionales y noveles
			if (aire) {
				tasa=0.15;
			} else {
				tasa=0.3;
			}
		}
		return tasa;
	}

	
}
