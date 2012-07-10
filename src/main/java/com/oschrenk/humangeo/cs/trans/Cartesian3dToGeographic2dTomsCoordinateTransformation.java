package com.oschrenk.humangeo.cs.trans;

import com.oschrenk.humangeo.api.CoordinateTransformation;
import com.oschrenk.humangeo.core.Spheroids;
import com.oschrenk.humangeo.core.Spheroid;
import com.oschrenk.humangeo.cs.Cartesian3dCoordinate;
import com.oschrenk.humangeo.cs.Geographic2dCoordinate;

/**
 * Every point that is expressed in ellipsoidal coordinates can be expressed as
 * an x y z (Cartesian) coordinate. Cartesian coordinates simplify many
 * mathematical calculations. The origin is usually the center of mass of the
 * earth, a point close to the Earth's center of figure.
 * 
 * <p>
 * With the origin at the center of the ellipsoid, the conventional setup is the
 * expected right-hand:
 * <ul>
 * <li>Z-axis along the axis of the ellipsoid, positive northward</li>
 * <li>X- and Y-axis in the plane of the equator, X-axis positive toward 0
 * degrees longitude and Y-axis positive toward 90 degrees east longitude</li>
 * </ul>
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Cartesian3dToGeographic2dTomsCoordinateTransformation implements
		CoordinateTransformation<Cartesian3dCoordinate, Geographic2dCoordinate> {

	/**
	 * Toms region 1 constant.
	 */
	private static final double AD_C = 1.0026000;

	private final Spheroid spheroid;

	private final double e2;

	private final double ep2;

	public Cartesian3dToGeographic2dTomsCoordinateTransformation(
			final Spheroid spheroid) {
		this.spheroid = spheroid;
		e2 = Spheroids.eccentricitySquared(spheroid);
		ep2 = Spheroids.secondEccentricitySquared(spheroid);
	}

	/**
	 * Converts geocentric coordinates (x, y, z) to geodetic coordinates
	 * (longitude, latitude, height), according to the current ellipsoid
	 * parameters. The method used here is derived from "An Improved Algorithm
	 * for Geocentric to Geodetic Coordinate Conversion", by Ralph Toms, Feb
	 * 1996.
	 */
	/*
	 * @see com.oschrenk.humangeo.api.Transformation#transform(java.lang.Object)
	 */
	@Override
	public Geographic2dCoordinate transform(final Cartesian3dCoordinate from) {
		final double x = from.getX(); // Toward prime meridian
		final double y = from.getY(); // Toward East
		final double z = from.getZ(); // Toward North

		// Note: The Java version of 'atan2' work correctly for x==0.
		// No need for special handling like in the C version.
		// No special handling neither for latitude. Formulas
		// below are generic enough, considering that 'atan'
		// work correctly with infinities (1/0).

		// Note: Variable names follow the notation used in Toms, Feb 1996
		final double W2 = x * x + y * y; // square of distance from Z axis
		final double W = Math.sqrt(W2); // distance from Z axis
		final double T0 = z * AD_C; // initial estimate of vertical
									// component
		final double S0 = Math.sqrt(T0 * T0 + W2); // initial estimate of
													// horizontal component
		final double sin_B0 = T0 / S0; // sin(B0), B0 is estimate of Bowring
										// aux variable
		final double cos_B0 = W / S0; // cos(B0)
		final double sin3_B0 = sin_B0 * sin_B0 * sin_B0; // cube of sin(B0)
		final double T1 = z + spheroid.getSemiMinorAxis() * ep2 * sin3_B0; // corrected
																			// estimate
																			// of
		// vertical component
		final double sum = W - spheroid.getSemiMajorAxis() * e2
				* (cos_B0 * cos_B0 * cos_B0); // numerator
		// of
		// cos(phi1)
		final double S1 = Math.sqrt(T1 * T1 + sum * sum); // corrected
															// estimate of
															// horizontal
															// component
		final double sin_p1 = T1 / S1; // sin(phi1), phi1 is estimated
										// latitude
		final double cos_p1 = sum / S1; // cos(phi1)

		final double longitude = Math.toDegrees(Math.atan2(y, x));
		final double latitude = Math.toDegrees(Math.atan(sin_p1 / cos_p1));

		return new Geographic2dCoordinate(latitude, longitude);
	}

}
