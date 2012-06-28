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
 * Calculates a destination given a start point, initial bearing and a distance
 * following the loxodrome path (on a rhumb line).
 * 
 * Sailors used to (and sometimes still) navigate along rhumb lines since it is
 * easier to follow a constant compass bearing than to be continually adjusting
 * the bearing, as is needed to follow a great circle. Rhumb lines are straight
 * lines on a Mercator Projection map (also helpful for navigation).
 * 
 * Rhumb lines are generally longer than great-circle (orthodrome) routes. For
 * instance, London to New York is 4% longer along a rhumb line than along a
 * great circle – important for aviation fuel, but not particularly to sailing
 * vessels. New York to Beijing – close to the most extreme example possible
 * (though not sailable!) – is 30% longer along a rhumb line.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class LoxodromeDestination implements
		Destination<Geographic2dCoordinate> {

	/** The sphere. */
	private final Sphere sphere;

	/**
	 * Instantiates a new loxodrome destination.
	 * 
	 * @param sphere
	 *            the sphere
	 */
	public LoxodromeDestination(final Sphere sphere) {
		this.sphere = sphere;
	}

	public Geographic2dCoordinate destination(final double latitude,
			final double longitude, final double initialBearing,
			final double distance) {

		final double b = Math.toRadians(initialBearing);
		final double d = distance / sphere.getRadius();
		final double lat1 = Math.toRadians(latitude);
		final double lon1 = Math.toRadians(longitude);

		double lat2 = lat1 + d * Math.cos(b);
		final double dLat = lat2 - lat1;
		final double dPhi = Math.log(Math.tan(lat2 / 2 + Math.PI / 4)
				/ Math.tan(lat1 / 2 + Math.PI / 4));
		final double q = (!Double.isNaN(dLat / dPhi)) ? dLat / dPhi : Math
				.cos(lat1); // E-W line gives dPhi=0

		final double dLon = d * Math.sin(b) / q;

		// check for some daft bugger going past the pole, normalise latitude if
		// so
		if (Math.abs(lat2) > Math.PI / 2) {
			lat2 = lat2 > 0 ? Math.PI - lat2 : -(Math.PI - lat2);
		}

		final double lon2 = (lon1 + dLon + Math.PI) % (2 * Math.PI) - Math.PI;

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
