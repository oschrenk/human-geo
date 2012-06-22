package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.PointLineDistance;
import com.oschrenk.humangeo.core.Cartesian3dCoordinate;
import com.oschrenk.humangeo.cs.Vectors;

/**
 * Distance between a point and a line in euclidean space calculated using
 * vectors.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Euclidean3dPointLineDistance implements
		PointLineDistance<Cartesian3dCoordinate> {

	/*
	 * @see
	 * com.oschrenk.humangeo.api.PointLineDistance#distance(java.lang.Object,
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public double distance(final Cartesian3dCoordinate point,
			final Cartesian3dCoordinate from, final Cartesian3dCoordinate to) {

		// distance = |PA cross AB_0/ |
		final Cartesian3dCoordinate pa = Vectors.minus(point, from);
		final Cartesian3dCoordinate ab = Vectors.distance(from, to);
		final double abLength = Vectors.length(ab);
		final Cartesian3dCoordinate abUnit = Vectors.mult(1 / abLength, ab);

		return Vectors.length(Vectors.cross(pa, abUnit));
	}
}
