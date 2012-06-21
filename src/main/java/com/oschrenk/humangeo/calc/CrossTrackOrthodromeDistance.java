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
 * Distance of a point from a great-circle path
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class CrossTrackOrthodromeDistance implements
		PointLineDistance<Geographic2dCoordinate> {

	private final Sphere sphere;

	public CrossTrackOrthodromeDistance(final Sphere sphere) {
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

		// dXt = Math.asin(Math.sin(d13/r)*Math.sin(b13-b12)) * r;

		final double r = sphere.getRadius();
		final double b12 = new OrthodromeBearing().bearing(from, to);
		final double b13 = new OrthodromeBearing().bearing(from, point);
		final double d13 = new HaversineDistance(sphere).distance(from, point);

		// @formatter:off
		final double dt = //
		Math.asin( //
		Math.sin(Math.toRadians(d13 / r)) //
				* Math.sin(Math.toRadians(b13 - b12)) //
		) * r; //
		// @formatter:on

		return dt;
	}
}