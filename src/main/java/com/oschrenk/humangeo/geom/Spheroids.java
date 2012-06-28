package com.oschrenk.humangeo.geom;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Spheroids {

	public static final double eccentricity(final Spheroid spheroid) {
		return Math.sqrt(eccentricitySquared(spheroid));
	}

	public static final double eccentricitySquared(final Spheroid spheroid) {
		final double a = spheroid.getSemiMajorAxis();
		final double b = spheroid.getSemiMinorAxis();
		return 1 - (b * b / (a * a));
	}

	public static final double secondEccentricity(final Spheroid spheroid) {
		return Math.sqrt(secondEccentricitySquared(spheroid));
	}

	public static final double secondEccentricitySquared(final Spheroid spheroid) {
		final double a = spheroid.getSemiMajorAxis();
		final double b = spheroid.getSemiMinorAxis();
		return (a * a / (b * b)) - 1;
	}

	public static final double thirdEccentricity(final Spheroid spheroid) {
		final double a = spheroid.getSemiMajorAxis();
		final double b = spheroid.getSemiMinorAxis();

		final double nom = Math.sqrt(a * a - b * b);
		final double denom = Math.sqrt(a * a + b * b);

		return nom / denom;
	}
}
