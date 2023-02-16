/**
 * 
 */
package uf2178;

import java.util.Scanner;

/**
 * @author 
 *
 */
public class Ppal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		// Escribe aqu� las sentencias del apartado 3
		System.out.println("Introduce la tasa de alcholemia del conductor");
		double tasa = teclado.nextDouble();
		Funciones.calculaSancion(tasa);
		
		
		int vector1[] = new int[6];
		int vector2[] = new int[6];
		System.out.println("introduce los puntos de los 6 conducotres");
		Funciones.pedir_vector(vector1);
		System.out.println("introduce los puntos a retirarde los 6 conducotres");
		Funciones.pedir_vector(vector2);
		
		Funciones.restaPuntos(vector1, vector2);


		
	}

}
