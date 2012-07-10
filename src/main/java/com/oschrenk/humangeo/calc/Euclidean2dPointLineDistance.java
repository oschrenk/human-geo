package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.Distance;
import com.oschrenk.humangeo.core.Segment;
import com.oschrenk.humangeo.cs.Cartesian2dCoordinate;

/**
 * Distance between a point and a line in euclidean space calculated using
 * vectors.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Euclidean2dPointLineDistance implements
		Distance<Cartesian2dCoordinate, Segment<Cartesian2dCoordinate>> {

	/*
	 * @see com.oschrenk.humangeo.api.Distance#distance(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public double distance(final Cartesian2dCoordinate point,
			final Segment<Cartesian2dCoordinate> segment) {
		final Cartesian2dCoordinate from = segment.getFrom();
		final Cartesian2dCoordinate to = segment.getTo();

		final double normalLength = Math.sqrt((to.getX() - from.getX())
				* (to.getX() - from.getX()) + (to.getY() - from.getY())
				* (to.getY() - from.getY()));
		return Math.abs((point.getX() - from.getX())
				* (to.getY() - from.getY()) - (point.getY() - from.getY())
				* (to.getX() - from.getX()))
				/ normalLength;
	}

}
