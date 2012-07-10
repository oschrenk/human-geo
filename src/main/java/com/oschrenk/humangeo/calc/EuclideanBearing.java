package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.Bearing;
import com.oschrenk.humangeo.cs.Cartesian2dCoordinate;

/**
 * Computes the initial bearing assuming the coordinates are points in
 * 2-dimensional euclidean space.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class EuclideanBearing implements Bearing<Cartesian2dCoordinate> {

	public double bearing(final double x1, final double y1, final double x2,
			final double y2) {
		return Math.toDegrees(Math.atan((y2 - y1) / (x2 - x1)));
	}

	@Override
	public double bearing(final Cartesian2dCoordinate from,
			final Cartesian2dCoordinate to) {
		return bearing(from.getX(), from.getY(), to.getX(), to.getY());
	}

}
