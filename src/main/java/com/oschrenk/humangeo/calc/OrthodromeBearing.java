/*
 * Adapted from <a
 * href="http://www.movable-type.co.uk/scripts/latlong.html">JavaScript
 * version</a> created by <a href="http://www.movable-type.co.uk/">Chris
 * Veness<a/> under the <a
 * href="http://creativecommons.org/licenses/by/3.0/">Create Commons Attribution
 * 3.0</a> licencse.
 */
package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.Bearing;
import com.oschrenk.humangeo.cs.Geographic2dCoordinate;

/**
 * Computes the initial bearing following the orthodrome path (on a great
 * circle).
 * 
 * For computing the final bearing just switch the parameters.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class OrthodromeBearing implements Bearing<Geographic2dCoordinate> {

	public double bearing(double lat1, final double lon1, double lat2,
			final double lon2) {

		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		final double deltaLongitude = Math.toRadians(lon2 - lon1);

		final double y = Math.sin(deltaLongitude) * Math.cos(lat2);
		final double x = Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1)
				* Math.cos(lat2) * Math.cos(deltaLongitude);

		return (Math.toDegrees(Math.atan2(y, x)) + 360) % 360;
	}

	@Override
	public double bearing(final Geographic2dCoordinate from,
			final Geographic2dCoordinate to) {
		return bearing(from.getLatitude(), from.getLongitude(),
				to.getLatitude(), to.getLongitude());
	}
}
