/*
 * Adapted from <a
 * href="http://www.movable-type.co.uk/scripts/latlong-vincenty.html">JavaScript
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
 * Calculates distance of two points on a sphere in m using the <a
 * href="http://en.wikipedia.org/wiki/Spherical_law_of_cosines">Spherical law of
 * cosines</a>
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class LawOfCosineDistance implements
		Distance<Geographic2dCoordinate, Geographic2dCoordinate> {

	/** The sphere. */
	private final Sphere sphere;

	/**
	 * Instantiates a new law of cosine distance.
	 * 
	 * @param sphere
	 *            the sphere
	 */
	public LawOfCosineDistance(final Sphere sphere) {
		super();
		this.sphere = sphere;
	}

	public double distance(final double latitudeFrom,
			final double longitudeFrom, final double latitudeTo,
			final double longitudeTo) {
		final double lat1 = Math.toRadians(latitudeFrom);
		final double lat2 = Math.toRadians(latitudeTo);

		final double lon1 = Math.toRadians(longitudeFrom);
		final double lon2 = Math.toRadians(longitudeTo);

		return Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1)
				* Math.cos(lat2) * Math.cos(lon2 - lon1))
				* sphere.getRadius();
	}

	@Override
	public double distance(final Geographic2dCoordinate from,
			final Geographic2dCoordinate to) {
		return distance(from.getLatitude(), from.getLongitude(),
				to.getLatitude(), to.getLongitude());
	}

}
