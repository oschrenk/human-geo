package com.oschrenk.humangeo.cs;

import com.oschrenk.humangeo.core.Cartesian2dCoordinate;
import com.oschrenk.humangeo.core.Cartesian3dCoordinate;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@q2web.de>
 */
public class Vectors {

	/**
	 * Calculates p-a.
	 * 
	 * @param x1
	 *            the x1
	 * @param y1
	 *            the y1
	 * @param x2
	 *            the x2
	 * @param y2
	 *            the y2
	 * @return the point
	 */
	protected static final double[] distanceVector(final double x1,
			final double y1, final double x2, final double y2) {
		return new double[] { x2 - x1, y2 - y1 };
	}

	protected static final double length(
			final Cartesian2dCoordinate cartesian2dCoordinate) {
		return Math.sqrt(cartesian2dCoordinate.getX()
				* cartesian2dCoordinate.getX() + cartesian2dCoordinate.getY()
				* cartesian2dCoordinate.getY());
	}

	protected static final double length(
			final Cartesian3dCoordinate cartesianCoordinate) {
		return Math.sqrt(cartesianCoordinate.getX()
				* cartesianCoordinate.getX() + cartesianCoordinate.getY()
				* cartesianCoordinate.getY() + cartesianCoordinate.getZ()
				+ cartesianCoordinate.getZ());
	}

	protected static final double length(final double[] v) {
		double distanceSquared = 0;
		for (final double element : v) {
			distanceSquared += element * element;
		}
		return Math.sqrt(distanceSquared);
	}

	/**
	 * Cross.
	 * 
	 * @param x1
	 *            the x1
	 * @param y1
	 *            the y1
	 * @param x2
	 *            the x2
	 * @param y2
	 *            the y2
	 * @return the point
	 */
	protected static final double[] cross(final double x1, final double y1,
			final double x2, final double y2) {
		final double[] c = new double[] { y1 * 0 - 0 * y2, 0 * x2 - x1 * 0,
				x1 * y2 - y1 * x2 };
		return c;
	}

	/**
	 * Dot.
	 * 
	 * @param x1
	 *            the x1
	 * @param y1
	 *            the y1
	 * @param x2
	 *            the x2
	 * @param y2
	 *            the y2
	 * @return the double
	 */
	protected static final double dot(final double x1, final double y1,
			final double x2, final double y2) {
		return x1 * x2 + y1 * y2;
	}

	protected static final double[] mult3d(final double c, final double[] v) {
		return new double[] { c * v[0], c * v[1], c * v[2] };
	}

	protected static final double[] minus3d(final double[] v, final double[] w) {
		return new double[] { v[0] - w[0], v[1] - w[1], v[2] - w[2] };
	}
}
