package com.oschrenk.humangeo.calc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oschrenk.humangeo.core.Segment;
import com.oschrenk.humangeo.cs.Cartesian3dCoordinate;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Euclidean3dPointLineDistanceTest {

	@Test
	public void testDistance() {
		final Cartesian3dCoordinate from = new Cartesian3dCoordinate(1, 2, 3);
		final Cartesian3dCoordinate to = new Cartesian3dCoordinate(5, 7, 9);

		final Cartesian3dCoordinate point = new Cartesian3dCoordinate(6, 6, 6);

		final double distance = new Euclidean3dPointLineDistance().distance(
				point, new Segment<Cartesian3dCoordinate>(from, to));

		assertEquals(2.512, distance, 0.001d);
	}
}
