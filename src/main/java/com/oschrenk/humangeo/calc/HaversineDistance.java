/*
 * Adapted from <a
 * href="http://www.movable-type.co.uk/scripts/latlong.html">JavaScript
 * version</a> created by <a href="http://www.movable-type.co.uk/">Chris
 * Veness<a/> under the <a
 * href="http://creativecommons.org/licenses/by/3.0/">Create Commons Attribution
 * 3.0</a> licencse.
 */
package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.Distance;
import com.oschrenk.humangeo.core.Sphere;
import com.oschrenk.humangeo.cs.Geographic2dCoordinate;

/**
 * Calculates distance of two points on a sphere in m using the Haversine
 * formula.
 * 
 * from: Haversine formula - R. W. Sinnott, "Virtues of the Haversine", Sky and
 * Telescope, vol 68, no 2, 1984
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class HaversineDistance implements
		Distance<Geographic2dCoordinate, Geographic2dCoordinate> {

	/** The sphere. */
	private final Sphere sphere;

	/**
	 * Instantiates a new haversine distance.
	 * 
	 * @param sphere
	 *            the sphere
	 */
	public HaversineDistance(final Sphere sphere) {
		this.sphere = sphere;
	}

	/**
	 * Distance.
	 * 
	 * @param latitudeFrom
	 *            the latitude from
	 * @param longitudeFrom
	 *            the longitude from
	 * @param latitudeTo
	 *            the latitude to
	 * @param longitudeTo
	 *            the longitude to
	 * @return the double
	 */
	public double distance(final double latitudeFrom,
			final double longitudeFrom, final double latitudeTo,
			final double longitudeTo) {
		final double deltaLatitude = Math.toRadians(latitudeFrom - latitudeTo);
		final double deltaLongitude = Math
				.toRadians((longitudeFrom - longitudeTo));

		final double sinusHalfDeltaLatitude = Math.sin(deltaLatitude / 2);
		final double sinusHalfDeltaLongitude = Math.sin(deltaLongitude / 2);

		final double a = sinusHalfDeltaLatitude * sinusHalfDeltaLatitude
				+ Math.cos(Math.toRadians(latitudeFrom))
				* Math.cos(Math.toRadians(latitudeTo))
				* sinusHalfDeltaLongitude * sinusHalfDeltaLongitude;
		final double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return sphere.getRadius() * c;
	}

	/*
	 * @see com.oschrenk.humangeo.api.Distance#distance(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public double distance(final Geographic2dCoordinate from,
			final Geographic2dCoordinate to) {
		return distance(from.getLatitude(), from.getLongitude(),
				to.getLatitude(), to.getLongitude());
	}
}
