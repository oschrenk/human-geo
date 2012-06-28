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
import com.oschrenk.humangeo.core.Spheroid;
import com.oschrenk.humangeo.cs.Geographic2dCoordinate;

/**
 * Calculates distance of two points on a sphere in m using Thaddeus Vincenty's
 * inverse formula - <a href="http://www.ngs.noaa.gov/PUBS_LIB/inverse.pdf">T
 * Vincenty, "Direct and Inverse Solutions of Geodesics on the spheroid with
 * application of nested equations", Survey Review, vol XXII no 176, 1975</a>
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * 
 */
public class InverseVincentyDistance implements
		Distance<Geographic2dCoordinate, Geographic2dCoordinate> {

	/** The spheroid. */
	private final Spheroid spheroid;

	/**
	 * Instantiates a new inverse vincenty distance.
	 * 
	 * @param spheroid
	 *            the spheroid
	 */
	public InverseVincentyDistance(final Spheroid spheroid) {
		this.spheroid = spheroid;
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

		final double L = Math.toRadians(longitudeTo - longitudeFrom);
		final double U1 = Math.atan((1 - spheroid.getFlattening())
				* Math.tan(Math.toRadians(latitudeFrom)));
		final double U2 = Math.atan((1 - spheroid.getFlattening())
				* Math.tan(Math.toRadians(latitudeTo)));

		final double sinU1 = Math.sin(U1);
		final double cosU1 = Math.cos(U1);
		final double sinU2 = Math.sin(U2);
		final double cosU2 = Math.cos(U2);

		double cosSqareAlpha;
		double cos2SigmaM;
		double sinSigma;
		double cosSigma;
		double sigma;
		double lambdaP;

		double lambda = L;
		byte iterlimit = 100;
		do {
			final double sinLambda = Math.sin(lambda);
			final double cosLambda = Math.cos(lambda);
			sinSigma = Math.sqrt((Math.pow(cosU2 * sinLambda, 2))
					+ Math.pow(cosU1 * sinU2 - sinU1 * cosU2 * cosLambda, 2));

			if (sinSigma == 0) {
				return 0; // co-incident points
			}

			cosSigma = sinU1 * sinU2 + cosU1 * cosU2 * cosLambda;
			sigma = Math.atan2(sinSigma, cosSigma);
			final double sinAlpha = cosU1 * cosU2 * sinLambda / sinSigma;
			cosSqareAlpha = 1 - Math.pow(sinAlpha, 2);
			cos2SigmaM = cosSigma - 2 * sinU1 * sinU2 / cosSqareAlpha;

			if (Double.isNaN(cos2SigmaM)) {
				cos2SigmaM = 0; // equatorial line: cosSqAlpha=0 (§6)
			}

			final double C = spheroid.getFlattening() / 16 * cosSqareAlpha
					* (4 + spheroid.getFlattening() * (4 - 3 * cosSqareAlpha));
			lambdaP = lambda;
			lambda = L
					+ (1 - C)
					* spheroid.getFlattening()
					* sinAlpha
					* (sigma + C
							* sinSigma
							* (cos2SigmaM + C * cosSigma
									* (-1 + 2 * Math.pow(cos2SigmaM, 2))));
		} while (Math.abs(lambda - lambdaP) > 1e-12 && --iterlimit > 0);

		if (iterlimit == 0) {
			return Double.NaN; // formula failed to converge
		}

		final double uSq = cosSqareAlpha
				* (Math.pow(spheroid.getSemiMajorAxis(), 2) - Math.pow(
						spheroid.getSemiMinorAxis(), 2))
				/ Math.pow(spheroid.getSemiMinorAxis(), 2);
		final double A = 1 + uSq / 16384
				* (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
		final double B = uSq / 1024
				* (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));
		final double deltaSigma = B
				* sinSigma
				* (cos2SigmaM + B
						/ 4
						* (cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM) - B
								/ 6 * cos2SigmaM
								* (-3 + 4 * sinSigma * sinSigma)
								* (-3 + 4 * cos2SigmaM * cos2SigmaM)));

		return spheroid.getSemiMinorAxis() * A * (sigma - deltaSigma);
	}

	/*
	 * @see
	 * com.oschrenk.humangeo.api.PointPointDistance#distance(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public double distance(final Geographic2dCoordinate from,
			final Geographic2dCoordinate to) {
		return distance(from.getLatitude(), from.getLongitude(),
				to.getLatitude(), to.getLongitude());
	}
}
