package com.oschrenk.humangeo.calc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oschrenk.humangeo.api.Destination;
import com.oschrenk.humangeo.calc.OrthodromeDestination;
import com.oschrenk.humangeo.core.Spheres;
import com.oschrenk.humangeo.cs.Geographic2dCoordinate;

public class OrthodromeDestinationTest {

	@Test
	public void getDestinationTest() {
		final Destination<Geographic2dCoordinate> orthodromeDestination = new OrthodromeDestination(
				Spheres.EARTH);
		final double distance = 124700; // 124,7km
		final double bearing = 96.03833333333333;

		final Geographic2dCoordinate p = new Geographic2dCoordinate(
				53.32055555555556, -1.7297222222222224);

		final Geographic2dCoordinate destination = orthodromeDestination
				.destination(p, bearing, distance);

		assertEquals(53.18806376112887, destination.getLatitude(), 0.000000001);
		assertEquals(0.1317176706645714, destination.getLongitude(),
				0.000000001);
	}
}
