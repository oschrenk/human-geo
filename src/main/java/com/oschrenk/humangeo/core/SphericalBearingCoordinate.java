package com.oschrenk.humangeo.core;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class SphericalBearingCoordinate extends SphericalCoordinate {

	/** The azimuth. */
	private final double azimuth;

	/**
	 * @param r
	 * @param theta
	 * @param phi
	 */
	public SphericalBearingCoordinate(final double r, final double theta,
			final double phi) {
		super(r, theta, phi);
		azimuth = 0;
	}

	public SphericalBearingCoordinate(final double r, final double theta,
			final double phi, final double azimuth) {
		super(r, theta, phi);
		this.azimuth = azimuth;
	}

	/**
	 * @return the azimuth
	 * @category getter
	 */
	public double getAzimuth() {
		return azimuth;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SphericalBearingCoordinate [r=" + getR() + ", phi=" + getPhi()
				+ ", theta=" + getTheta() + ", azimuth=" + azimuth + "]";
	}
}
