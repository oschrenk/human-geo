package com.oschrenk.humangeo.core;

import com.oschrenk.humangeo.cs.SphericalCoordinateSystem;

/**
 * A spherical coordinate
 * 
 * @see SphericalCoordinateSystem
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class SphericalCoordinate extends PolarCoordinate {

	private final double phi;

	/**
	 * @param r
	 *            the radius
	 * @param theta
	 *            the polar angle
	 */
	public SphericalCoordinate(final double r, final double theta) {
		super(r, theta);
		phi = 0;
	}

	/**
	 * Instantiates a new spherical coordinate.
	 * 
	 * @param r
	 *            the radius
	 * @param theta
	 *            the polar angle
	 * @param phi
	 *            the azimuthal angle
	 */
	public SphericalCoordinate(final double r, final double theta,
			final double phi) {
		super(r, theta);
		this.phi = phi;
	}

	/**
	 * @return the azimuthal angle
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
