package com.oschrenk.humangeo.calc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oschrenk.humangeo.api.Destination;
import com.oschrenk.humangeo.calc.LoxodromeDestination;
import com.oschrenk.humangeo.core.Spheres;
import com.oschrenk.humangeo.cs.Geographic2dCoordinate;

public class LoxodromeDestinationTest {

	@Test
	public void getDestinationTest() {
		final Destination<Geographic2dCoordinate> loxodromeDestination = new LoxodromeDestination(
				Spheres.EARTH);
		final Geographic2dCoordinate p = new Geographic2dCoordinate(
				51.12555555555556, 1.3380555555555556);
		final double distance = 40000; // 40,0km
		final double bearing = 116.61944444444444;
		final Geographic2dCoordinate destination = loxodromeDestination
				.destination(p, bearing, distance);

		assertEquals(50.96437463685213, destination.getLatitude(), 0.000000001);
		assertEquals(1.8495767409594122, destination.getLongitude(),
				0.000000001);
	}

}
