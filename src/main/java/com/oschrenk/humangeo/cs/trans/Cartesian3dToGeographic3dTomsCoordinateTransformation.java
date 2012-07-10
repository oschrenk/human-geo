package com.oschrenk.humangeo.cs.trans;

import com.oschrenk.humangeo.api.CoordinateTransformation;
import com.oschrenk.humangeo.core.Spheroids;
import com.oschrenk.humangeo.core.Spheroid;
import com.oschrenk.humangeo.cs.Cartesian3dCoordinate;
import com.oschrenk.humangeo.cs.Geographic3dCoordinate;

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
public class Cartesian3dToGeographic3dTomsCoordinateTransformation implements
		CoordinateTransformation<Cartesian3dCoordinate, Geographic3dCoordinate> {

	/**
	 * Maximal error tolerance in metres during assertions, in metres. If
	 * assertions are enabled (JDK 1.4 only), then every coordinates transformed
	 * with {@link #inverseTransform} will be transformed again with
	 * {@link #transform}. If the distance between the resulting position and
	 * the original position is greater than <code>MAX_ERROR</code>, then a
	 * {@link AssertionError} is thrown.
	 */
	private static final double MAX_ERROR = 0.01;

	/**
	 * Toms region 1 constant.
	 */
	private static final double AD_C = 1.0026000;

	/**
	 * Cosine of 67.5 degrees.
	 */
	private static final double COS_67P5 = 0.38268343236508977;

	private final Spheroid spheroid;

	private final double e2;

	private final double ep2;

	public Cartesian3dToGeographic3dTomsCoordinateTransformation(
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
	public Geographic3dCoordinate transform(final Cartesian3dCoordinate from) {

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
		final double height;

		final double rn = spheroid.getSemiMajorAxis()
				/ Math.sqrt(1 - e2 * (sin_p1 * sin_p1)); // Earth
		// radius at location
		if (cos_p1 >= +COS_67P5) {
			height = W / +cos_p1 - rn;
		} else if (cos_p1 <= -COS_67P5) {
			height = W / -cos_p1 - rn;
		} else {
			height = z / sin_p1 + rn * (e2 - 1.0);
		}

		// If assertion are enabled, then transform the
		// result and compare it with the input array.
		double distance;
		assert MAX_ERROR > (distance = checkTransform(new double[] { x, y, z,
				longitude, latitude, height })) : distance;

		return new Geographic3dCoordinate(latitude, longitude, height);
	}

	// TODO neccesary?
	/**
	 * Transform the last half if the specified array and returns the distance
	 * with the first half. Array <code>points</code> must have a length of 6.
	 */
	private double checkTransform(final double[] points) {
		transform(points, 3, points, 3, 1, true);
		final double dx = points[0] - points[3];
		final double dy = points[1] - points[4];
		final double dz = points[2] - points[5];
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}

	// TODO this looks like a direct method transform
	private void transform(final double[] srcPts, int srcOff,
			final double[] dstPts, int dstOff, int numPts, boolean hasHeight) {
		int step = 0;
		final int dimSource = 3;
		hasHeight |= (dimSource >= 3);
		if (srcPts == dstPts && srcOff < dstOff
				&& srcOff + numPts * dimSource > dstOff) {
			step = -dimSource;
			srcOff -= (numPts - 1) * step;
			dstOff -= (numPts - 1) * step;
		}
		while (--numPts >= 0) {
			final double L = Math.toRadians(srcPts[srcOff++]); // Longitude
			final double P = Math.toRadians(srcPts[srcOff++]); // Latitude
			final double h = hasHeight ? srcPts[srcOff++] : 0; // Height above
																// the ellipsoid
																// (m)

			final double cosLat = Math.cos(P);
			final double sinLat = Math.sin(P);
			final double rn = spheroid.getSemiMajorAxis()
					/ Math.sqrt(1 - e2 * (sinLat * sinLat));

			dstPts[dstOff++] = (rn + h) * cosLat * Math.cos(L); // X: Toward
																// prime
																// meridian
			dstPts[dstOff++] = (rn + h) * cosLat * Math.sin(L); // Y: Toward
																// East
			dstPts[dstOff++] = (rn * (1 - e2) + h) * sinLat; // Z: Toward North
			srcOff += step;
			dstOff += step;
		}
	}
}
