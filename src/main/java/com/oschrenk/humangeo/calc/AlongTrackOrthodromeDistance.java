/*
 * Adapted from <a
 * href="http://www.movable-type.co.uk/scripts/latlong.html">JavaScript
 * version</a> created by <a href="http://www.movable-type.co.uk/">Chris
 * Veness<a/> under the <a
 * href="http://creativecommons.org/licenses/by/3.0/">Create Commons Attribution
 * 3.0</a> licencse.
 */
package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.PointLineDistance;
import com.oschrenk.humangeo.core.Geographic2dCoordinate;
import com.oschrenk.humangeo.geom.Sphere;

/**
 * The along-track distance, is the distance from the start point to the closest
 * point on the path to the third point along a great-circle path.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class AlongTrackOrthodromeDistance implements
		PointLineDistance<Geographic2dCoordinate> {

	private final Sphere sphere;

	public AlongTrackOrthodromeDistance(final Sphere sphere) {
		super();
		this.sphere = sphere;
	}

	/*
	 * @see
	 * com.oschrenk.humangeo.api.PointLineDistance#distance(java.lang.Object,
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public double distance(final Geographic2dCoordinate point,
			final Geographic2dCoordinate from, final Geographic2dCoordinate to) {

		// dAt = Math.acos(Math.cos(d13/r)/Math.cos(dXt/r)) * r;

		final double r = sphere.getRadius();
		final double d13 = new HaversineDistance(sphere).distance(from, point);
		final double dXt = new CrossTrackOrthodromeDistance(sphere).distance(
				point, from, to);

		// @formatter:off
		final double dAt = //
		Math.acos( //
		Math.cos(Math.toRadians(d13 / r)) //
				/ //
				Math.cos(Math.toRadians(dXt) / r) //
		) //
				* r;
		// @formatter:on

		return dAt;
	}
}
