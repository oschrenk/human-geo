package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.Destination;
import com.oschrenk.humangeo.cs.Cartesian2dCoordinate;

/**
 * Calculates a destination given a start point, initial bearing and a distance
 * assuming the coordinates are points in 2-dimensional euclidean space.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class EuclideanDestination implements Destination<Cartesian2dCoordinate> {

	/**
	 * Destination.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param initialBearing
	 *            the initial bearing
	 * @param distance
	 *            the distance
	 * @return the cartesian2d coordinate
	 */
	public Cartesian2dCoordinate destination(final double x, final double y,
			final double initialBearing, final double distance) {
		final double a = Math.toRadians(initialBearing);

		final double x2 = x + Math.cos(a) * distance;
		final double y2 = y + Math.sin(a) * distance;

		return new Cartesian2dCoordinate(x2, y2);
	}

	/*
	 * @see com.oschrenk.humangeo.api.Destination#destination(java.lang.Object,
	 * double, double)
	 */
	@Override
	public Cartesian2dCoordinate destination(
			final Cartesian2dCoordinate coordinate,
			final double initialBearing, final double distance) {
		return destination(coordinate.getX(), coordinate.getY(),
				initialBearing, distance);
	}

}
