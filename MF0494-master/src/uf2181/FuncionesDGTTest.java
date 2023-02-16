package uf2181;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



class FuncionesDGTTest extends FuncionesDGT {
	private static FuncionesDGT utils;
 
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		utils = new FuncionesDGT();

	}

	@Test
	void testMediaPuntos() {
		int puntos [] = {1,5,10};
		int puntos2 [] = {-50,5,10};
		int puntos3 [] = {1,50,10};


		int puntosVacio [] = {};

		assertEquals(5.333333333333333, utils.mediaPuntos(puntos));
		assertEquals(-11.666666666666666, utils.mediaPuntos(puntos2));
		assertEquals(20.333333333333332, utils.mediaPuntos(puntos3));

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> utils.mediaPuntos(puntosVacio));

	}

	@Test
	void testMaximaTasaPermitida() {
		assertEquals(0.25, utils.maximaTasaPermitida("General", true));
		assertEquals(0.5, utils.maximaTasaPermitida("General", false));
		
		assertEquals(0.15, utils.maximaTasaPermitida("novel", true));
		assertEquals(0.3, utils.maximaTasaPermitida("novel", false));

		
		
	}

}
