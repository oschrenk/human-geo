package com.oschrenk.humangeo.core;

import com.oschrenk.humangeo.cs.PolarCoordinateSystem;

/**
 * A polar coordinate is a coordinate in the {@link PolarCoordinateSystem}
 * 
 * <p>
 * The radial coordinate is denoted by r, and the angular coordinate by θ
 * (theta)
 * 
 * <p>
 * Angles in polar notation are generally expressed in degrees
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class PolarCoordinate {

	/** The polar angle theta. */
	private final double theta;

	/** The radius r. */
	private final double r;

	/**
	 * Instantiates a new polar coordinate.
	 * 
	 * @param r
	 *            the radius r
	 * @param theta
	 *            the polar angle theta
	 */
	public PolarCoordinate(final double r, final double theta) {
		super();
		this.theta = theta;
		this.r = r;
	}

	/**
	 * Gets the polar angle theta
	 * 
	 * @return the polar angle
	 */
	public double getTheta() {
		return theta;
	}

	/**
	 * Gets the radius r
	 * 
	 * @return the radius
	 */
	public double getR() {
		return r;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PolarCoordinate [r=" + r + ", theta=" + theta + "]";
	}

}
