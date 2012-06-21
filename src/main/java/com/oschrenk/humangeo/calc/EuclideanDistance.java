package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.PointPointDistance;
import com.oschrenk.humangeo.core.Cartesian2dCoordinate;

/**
 * Calculates the distance of two points using euclidean distance.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class EuclideanDistance implements
		PointPointDistance<Cartesian2dCoordinate> {

	public double distance(final double x1, final double y1, final double x2,
			final double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	@Override
	public double distance(final Cartesian2dCoordinate from,
			final Cartesian2dCoordinate to) {
		return distance(from.getX(), from.getY(), to.getX(), to.getY());
	}
}