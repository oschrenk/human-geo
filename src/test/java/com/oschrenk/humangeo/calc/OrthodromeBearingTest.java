package com.oschrenk.humangeo.calc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oschrenk.humangeo.calc.OrthodromeBearing;
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

}
