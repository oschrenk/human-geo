package com.oschrenk.humangeo.core;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class SphericalCoordinate extends PolarCoordinate {

	private final double phi;

	/**
	 * @param r
	 * @param theta
	 */
	public SphericalCoordinate(final double r, final double theta) {
		super(r, theta);
		phi = 0;
	}

	public SphericalCoordinate(final double r, final double theta,
			final double phi) {
		super(r, theta);
		this.phi = phi;
	}

	/**
	 * @return the phi
	 * @category getter
	 */
	public double getPhi() {
		return phi;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SphericalCoordinate [r=" + getR() + ", phi=" + phi + ", theta="
				+ getTheta() + "]";
	}

}
