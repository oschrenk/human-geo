package com.oschrenk.humangeo.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.oschrenk.humangeo.cs.Geographic2dCoordinate;

public class OrthodromeBearingTest {

	private static final double ONE_SECOND = 0.000277777778;

	/**
	 * Testing the bearing up to a second of correctness
	 */
	@Test
	public void initialBearingTest() {
		final Geographic2dCoordinate from = new Geographic2dCoordinate(
				51.5074089, -0.2080108);
		final Geographic2dCoordinate to = new Geographic2dCoordinate(
				51.5074343, -0.1081264);

		final double b = new OrthodromeBearing().bearing(from, to);

		assertEquals(89.9375, b, ONE_SECOND);
	}

	@Test
	public void bearingLAXtoJFK() {

		// LAX: (33deg 57min N, 118deg 24min W)
		// 33.96 N, 118.4
		Geographic2dCoordinate LAX = new Geographic2dCoordinate(33 + 57d / 60,
				118 + 24d / 60);
		// JFK: (40deg 38min N, 73deg 47min W)
		// 40.633333, 73.78333333 
		Geographic2dCoordinate JFK = new Geographic2dCoordinate(40 + 38d / 60,
				73 + 47d / 60);

		final double b = new OrthodromeBearing().bearing(LAX, JFK);

		assertEquals(294.1078, b, ONE_SECOND);
	}
	
	@Test
	public void bearingLAXtoD() {

		// LAX: (33deg 57min N, 118deg 24min W)
		// 33.96 N, 118.4 W
		Geographic2dCoordinate LAX = new Geographic2dCoordinate(33 + 57d / 60,
				118 + 24d / 60);
		// D: (34deg 30min N, 116deg 30min W)
		// 34.5 N, 116.5 W 
		Geographic2dCoordinate D = new Geographic2dCoordinate(34 + 30d / 60,
				116 + 30d / 60);

		final double b = new OrthodromeBearing().bearing(LAX, D);

		assertEquals(289.8277, b, ONE_SECOND);
	}
	
	@Test
	public void testJavaMath() {
		assertEquals(118.5, (118 + 30d / 60), 0.0d);
	}

}
