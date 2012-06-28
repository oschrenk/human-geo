package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.Distance;
import com.oschrenk.humangeo.cs.Cartesian2dCoordinate;

/**
 * Calculates the distance of two points using euclidean distance.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class EuclideanDistance implements
		Distance<Cartesian2dCoordinate, Cartesian2dCoordinate> {

	/**
	 * Distance.
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
	public double distance(final double x1, final double y1, final double x2,
			final double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	/*
	 * @see
	 * com.oschrenk.humangeo.api.PointPointDistance#distance(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public double distance(final Cartesian2dCoordinate from,
			final Cartesian2dCoordinate to) {
		return distance(from.getX(), from.getY(), to.getX(), to.getY());
	}
}