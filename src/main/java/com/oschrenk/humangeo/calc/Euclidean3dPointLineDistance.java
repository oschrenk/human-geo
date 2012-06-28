package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.Distance;
import com.oschrenk.humangeo.core.Segment;
import com.oschrenk.humangeo.core.Vectors;
import com.oschrenk.humangeo.cs.Cartesian3dCoordinate;

/**
 * Distance between a point and a line in euclidean space calculated using
 * vectors.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Euclidean3dPointLineDistance implements
		Distance<Cartesian3dCoordinate, Segment<Cartesian3dCoordinate>> {

	@Override
	public double distance(final Cartesian3dCoordinate point,
			final Segment<Cartesian3dCoordinate> segment) {
		final Cartesian3dCoordinate from = segment.getFrom();
		final Cartesian3dCoordinate to = segment.getTo();

		// distance = |PA cross AB_0/ |
		final Cartesian3dCoordinate pa = Vectors.minus(point, from);
		final Cartesian3dCoordinate ab = Vectors.distance(from, to);
		final double abLength = Vectors.length(ab);
		final Cartesian3dCoordinate abUnit = Vectors.mult(1 / abLength, ab);

		return Vectors.length(Vectors.cross(pa, abUnit));
	}
}
