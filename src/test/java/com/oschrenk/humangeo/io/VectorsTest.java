package com.oschrenk.humangeo.io;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oschrenk.humangeo.core.Vectors;
import com.oschrenk.humangeo.cs.Cartesian2dCoordinate;
import com.oschrenk.humangeo.cs.Cartesian3dCoordinate;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class VectorsTest {

	/**
	 * Test method for
	 * {@link com.oschrenk.humangeo.core.Vectors#length(com.oschrenk.humangeo.cs.Cartesian2dCoordinate)}
	 * .
	 */
	@Test
	public void testLengthCartesian2dCoordinate() {
		assertEquals(4, Vectors.length(new Cartesian2dCoordinate(0, 4)), 0.0);
	}

	/**
	 * Test method for
	 * {@link com.oschrenk.humangeo.core.Vectors#length(com.oschrenk.humangeo.cs.Cartesian3dCoordinate)}
	 * .
	 */
	@Test
	public void testLengthCartesian3dCoordinate() {
		assertEquals(3, Vectors.length(new Cartesian3dCoordinate(2, 1, 2)),
				0.0d);
	}

	/**
	 * Test method for {@link com.oschrenk.humangeo.core.Vectors#length(double[])}
	 * .
	 */
	@Test
	public void testLengthDoubleArray() {
		assertEquals(4, Vectors.length(new double[] { 0, 0, 4 }), 0.0d);
	}

	/**
	 * Test method for
	 * {@link com.oschrenk.humangeo.core.Vectors#dot(com.oschrenk.humangeo.cs.Cartesian3dCoordinate, com.oschrenk.humangeo.cs.Cartesian3dCoordinate)}
	 * .
	 */
	@Test
	public void testDot() {
		final Cartesian3dCoordinate a = new Cartesian3dCoordinate(1, 2, 3);
		final Cartesian3dCoordinate b = new Cartesian3dCoordinate(-7, 8, 9);
		assertEquals(36, Vectors.dot(a, b), 0.0d);
	}

	/**
	 * Test method for
	 * {@link com.oschrenk.humangeo.core.Vectors#cross(com.oschrenk.humangeo.cs.Cartesian3dCoordinate, com.oschrenk.humangeo.cs.Cartesian3dCoordinate)}
	 * .
	 */
	@Test
	public void testCross() {
		final Cartesian3dCoordinate a = new Cartesian3dCoordinate(1, 2, 3);
		final Cartesian3dCoordinate b = new Cartesian3dCoordinate(-7, 8, 9);

		final Cartesian3dCoordinate c = new Cartesian3dCoordinate(-6, -30, 22);

		assertEquals(c, Vectors.cross(a, b));
	}

	/**
	 * Test method for
	 * {@link com.oschrenk.humangeo.core.Vectors#norm(com.oschrenk.humangeo.cs.Cartesian3dCoordinate)}
	 * .
	 */
	@Test
	public void testNorm() {
		final Cartesian3dCoordinate a = new Cartesian3dCoordinate(2, 1, 2);
		final Cartesian3dCoordinate normalizedA = Vectors.norm(a);

		assertEquals(1, Vectors.length(normalizedA), 0.0d);
	}

	/**
	 * Test method for
	 * {@link com.oschrenk.humangeo.core.Vectors#mult(double, com.oschrenk.humangeo.cs.Cartesian3dCoordinate)}
	 * .
	 */
	@Test
	public void testMult() {
		final Cartesian3dCoordinate a = new Cartesian3dCoordinate(1, 2, 3);
		final double constant = 3;

		final Cartesian3dCoordinate c = new Cartesian3dCoordinate(3, 6, 9);

		assertEquals(c, Vectors.mult(constant, a));
	}

	/**
	 * Test method for
	 * {@link com.oschrenk.humangeo.core.Vectors#minus(com.oschrenk.humangeo.cs.Cartesian3dCoordinate, com.oschrenk.humangeo.cs.Cartesian3dCoordinate)}
	 * .
	 */
	@Test
	public void testMinus() {
		final Cartesian3dCoordinate a = new Cartesian3dCoordinate(1, 2, 3);
		final Cartesian3dCoordinate b = new Cartesian3dCoordinate(3, 2, 1);

		final Cartesian3dCoordinate c = new Cartesian3dCoordinate(-2, 0, 2);

		assertEquals(c, Vectors.minus(a, b));
	}

	/**
	 * Test method for
	 * {@link com.oschrenk.humangeo.core.Vectors#distance(com.oschrenk.humangeo.cs.Cartesian3dCoordinate, com.oschrenk.humangeo.cs.Cartesian3dCoordinate)}
	 * .
	 */
	@Test
	public void testDistance() {
		final Cartesian3dCoordinate a = new Cartesian3dCoordinate(5, 1, 2);
		final Cartesian3dCoordinate b = new Cartesian3dCoordinate(1, 4, 0);

		final Cartesian3dCoordinate c = new Cartesian3dCoordinate(-4, 3, -2);

		assertEquals(c, Vectors.distance(a, b));
	}

}
