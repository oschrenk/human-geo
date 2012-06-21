package com.oschrenk.humangeo.calc;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.oschrenk.humangeo.api.Destination;
import com.oschrenk.humangeo.calc.EuclideanDestination;
import com.oschrenk.humangeo.core.Cartesian2dCoordinate;

public class EuclideanDestinationTest {

	private static Destination<Cartesian2dCoordinate> d;

	@BeforeClass
	public static void setup() {
		d = new EuclideanDestination();
	}

	@Test
	public void testPositiveVertical() {
		final Cartesian2dCoordinate a = new Cartesian2dCoordinate(0, 0);
		final double bearing = 0;
		final double distance = 10;

		assertEquals(10, d.destination(a, bearing, distance).getX(), 0.000001);
		assertEquals(0, d.destination(a, bearing, distance).getY(), 0.000001);
	}

	@Test
	public void testNegativeVertical() {
		final Cartesian2dCoordinate a = new Cartesian2dCoordinate(0, 0);
		final double bearing = 180;
		final double distance = 10;

		assertEquals(-10, d.destination(a, bearing, distance).getX(), 0.000001);
		assertEquals(0, d.destination(a, bearing, distance).getY(), 0.000001);
	}

	@Test
	public void testPositiveHorizontal() {
		final Cartesian2dCoordinate a = new Cartesian2dCoordinate(0, 0);
		final double bearing = 90;
		final double distance = 10;

		assertEquals(0, d.destination(a, bearing, distance).getX(), 0.000001);
		assertEquals(10, d.destination(a, bearing, distance).getY(), 0.000001);
	}

	@Test
	public void testNegativeHorizontal() {
		final Cartesian2dCoordinate a = new Cartesian2dCoordinate(0, 0);
		final double bearing = 270;
		final double distance = 10;

		assertEquals(0, d.destination(a, bearing, distance).getX(), 0.000001);
		assertEquals(-10, d.destination(a, bearing, distance).getY(), 0.000001);
	}

}
