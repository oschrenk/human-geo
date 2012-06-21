package com.oschrenk.humangeo.calc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oschrenk.humangeo.api.Bearing;
import com.oschrenk.humangeo.calc.EuclideanBearing;
import com.oschrenk.humangeo.core.Cartesian2dCoordinate;

public class EuclideanBearingTest {

	@Test
	public void testGetBearing() {
		final Cartesian2dCoordinate a = new Cartesian2dCoordinate(0, 0);
		final Cartesian2dCoordinate b = new Cartesian2dCoordinate(10, 10);

		final Bearing<Cartesian2dCoordinate> bearing = new EuclideanBearing();

		assertEquals(45, bearing.bearing(a, b), 0.000001);
	}
}
