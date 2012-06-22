package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.PointLineDistance;
import com.oschrenk.humangeo.core.Cartesian2dCoordinate;

/**
 * Distance between a point and a line in euclidean space calculated using
 * vectors.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class EuclideanPointLineDistance implements
		PointLineDistance<Cartesian2dCoordinate> {

	/*
	 * @see
	 * com.oschrenk.humangeo.api.PointLineDistance#distance(java.lang.Object,
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public double distance(final Cartesian2dCoordinate point,
			final Cartesian2dCoordinate from, final Cartesian2dCoordinate to) {
		// TODO PointLineDistance<Cartesian2dCoordinate>.distance()
		return 0;
	}

}
