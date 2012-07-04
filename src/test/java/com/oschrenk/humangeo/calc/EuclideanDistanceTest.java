package com.oschrenk.humangeo.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.oschrenk.humangeo.api.Distance;
import com.oschrenk.humangeo.cs.Cartesian2dCoordinate;

public class EuclideanDistanceTest {

	@Test
	public void testDistance() {
		final Cartesian2dCoordinate a = new Cartesian2dCoordinate(0, 0);
		final Cartesian2dCoordinate b = new Cartesian2dCoordinate(3, 4);

		final Distance<Cartesian2dCoordinate, Cartesian2dCoordinate> distance = new EuclideanDistance();

		assertEquals(5, distance.distance(a, b), 0d);
	}
}
