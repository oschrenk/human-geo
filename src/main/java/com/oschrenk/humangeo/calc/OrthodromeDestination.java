/*
 * Adapted from <a
 * href="http://www.movable-type.co.uk/scripts/latlong.html">JavaScript
 * version</a> created by <a href="http://www.movable-type.co.uk/">Chris
 * Veness<a/> under the <a
 * href="http://creativecommons.org/licenses/by/3.0/">Create Commons Attribution
 * 3.0</a> licencse.
 */
package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.Destination;
import com.oschrenk.humangeo.core.Sphere;
import com.oschrenk.humangeo.cs.Geographic2dCoordinate;

/**
 * Calculates a destination given a start point, intitial bearing and a distance
 * following the orthodrome path (on a great circle arc).
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class OrthodromeDestination implements
		Destination<Geographic2dCoordinate> {

	/** The sphere. */
	private final Sphere sphere;

	/**
	 * Instantiates a new orthodrome destination.
	 * 
	 * @param sphere
	 *            the sphere
	 */
	public OrthodromeDestination(final Sphere sphere) {
		this.sphere = sphere;
	}

	public Geographic2dCoordinate destination(final double latitude,
			final double longitude, final double initialBearing,
			final double distance) {
		final double dr = distance / sphere.getRadius();
		final double b = Math.toRadians(initialBearing);
		final double lat1 = Math.toRadians(latitude);
		final double lon1 = Math.toRadians(longitude);

		final double lat2 = Math.asin(Math.sin(lat1) * Math.cos(dr)
				+ Math.cos(lat1) * Math.sin(dr) * Math.cos(b));
		final double lon2 = lon1
				+ Math.atan2(Math.sin(b) * Math.sin(dr) * Math.cos(lat1),
						Math.cos(dr) - Math.sin(lat1) * Math.sin(lat2));
		return new Geographic2dCoordinate(Math.toDegrees(lat2),
				Math.toDegrees(lon2));
	}

	@Override
	public Geographic2dCoordinate destination(
			final Geographic2dCoordinate coordinate,
			final double initialBearing, final double distance) {
		return destination(coordinate.getLatitude(), coordinate.getLongitude(),
				initialBearing, distance);
	}

}
