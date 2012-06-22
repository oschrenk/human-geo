package com.oschrenk.humangeo.io;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oschrenk.humangeo.core.Cartesian2dCoordinate;
import com.oschrenk.humangeo.core.Cartesian3dCoordinate;
import com.oschrenk.humangeo.cs.Vectors;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class VectorsTest {

	/**
	 * Test method for
	 * {@link com.oschrenk.humangeo.cs.Vectors#length(com.oschrenk.humangeo.core.Cartesian2dCoordinate)}
	 * .
	 */
	@Test
	public void testLengthCartesian2dCoordinate() {
		assertEquals(4, Vectors.length(new Cartesian2dCoordinate(0, 4)), 0.0);
	}

	/**
	 * Test method for
	 * {@link com.oschrenk.humangeo.cs.Vectors#length(com.oschrenk.humangeo.core.Cartesian3dCoordinate)}
	 * .
	 */
	@Test
	public void testLengthCartesian3dCoordinate() {
		assertEquals(4, Vectors.length(new Cartesian3dCoordinate(0, 4, 0)),
				0.0d);
	}

	/**
	 * Test method for {@link com.oschrenk.humangeo.cs.Vectors#length(double[])}
	 * .
	 */
	@Test
	public void testLengthDoubleArray() {
		assertEquals(4, Vectors.length(new double[] { 0, 0, 4 }), 0.0d);
	}

	/**
	 * Test method for
	 * {@link com.oschrenk.humangeo.cs.Vectors#dot(com.oschrenk.humangeo.core.Cartesian3dCoordinate, com.oschrenk.humangeo.core.Cartesian3dCoordinate)}
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
	 * {@link com.oschrenk.humangeo.cs.Vectors#cross(com.oschrenk.humangeo.core.Cartesian3dCoordinate, com.oschrenk.humangeo.core.Cartesian3dCoordinate)}
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
	 * {@link com.oschrenk.humangeo.cs.Vectors#mult(double, com.oschrenk.humangeo.core.Cartesian3dCoordinate)}
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
	 * {@link com.oschrenk.humangeo.cs.Vectors#minus(com.oschrenk.humangeo.core.Cartesian3dCoordinate, com.oschrenk.humangeo.core.Cartesian3dCoordinate)}
	 * .
	 */
	@Test
	public void testMinus() {
		final Cartesian3dCoordinate a = new Cartesian3dCoordinate(1, 2, 3);
		final Cartesian3dCoordinate b = new Cartesian3dCoordinate(3, 2, 1);

		final Cartesian3dCoordinate c = new Cartesian3dCoordinate(-2, 0, 2);

		assertEquals(c, Vectors.minus(a, b));
	}

}
