package uf2178;

import java.util.Scanner;

public class Funciones {
	
	/** 
	 * M�todo de la clase que pide un vector por teclado
	 * @param v int[] el vector a introducir por teclado
	 */
	public static void  pedir_vector(int v[]) {
		Scanner entrada = new Scanner(System.in);
		
		for (int i = 0; i < v.length; i++) {
			System.out.printf("Introduce el elemento %d: ", i);
			v[i] = entrada.nextInt();
		}
	}
	
	/**
	 * M�todo para mostrar por pantalla el vector pasado como par�metro
	 * @param v int [] el vector a mostrar en pantalla
	 */
	public static void  mostrar_vector(int v[]) {
		for (int i = 0; i < v.length; i++) {
			System.out.printf("%3d ", v[i]);
		}
		System.out.println();
	}
	
	// Escribe las sentencias de los apartados 1 y 2
	
	public static void calculaSancion(double tasa) {
		if (tasa<0.25) {
			System.out.println("El conducotr con tasa de alcholemia de "+ tasa+ " tiene no tiene sancion");
			
		}else if (tasa>=0.25 && tasa<0.5) {
			System.out.println("El conducotr con tasa de alcholemia de "+ tasa+ " tiene sancion de 500€ y perdida de 4 puntos");

		}else if (tasa>=0.5 && tasa<0.6) {
			System.out.println("El conducotr con tasa de alcholemia de "+ tasa+ " tiene sancion de 500€ y perdida de 4 puntos");

		}else if (tasa>=0.6) {
			System.out.println("El conducotr con tasa de alcholemia de "+ tasa+ " Retirada del carnet y de 3 a 6 meses de carcel");

		}
		
	}
	
	
	public static void restaPuntos(int puntos[],int sanciones[]) {
		int vectorPuntos [] = new int[puntos.length];
		
		if (puntos.length!=sanciones.length) 
			   throw new ArithmeticException("Los vectores deben tener el mismo tama�o");
		
		for (int i = 0; i < vectorPuntos.length; i++) {
			vectorPuntos[i]=puntos[i]-sanciones[i];
			if (vectorPuntos[i]<0) {
				vectorPuntos[i]=0;
			}
			System.out.println(vectorPuntos[i]);

		}
	}

}
