package com.oschrenk.humangeo.cs;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(r);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(theta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PolarCoordinate other = (PolarCoordinate) obj;
		if (Double.doubleToLongBits(r) != Double.doubleToLongBits(other.r))
			return false;
		if (Double.doubleToLongBits(theta) != Double
				.doubleToLongBits(other.theta))
			return false;
		return true;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PolarCoordinate [r=" + r + ", theta=" + theta + "]";
	}

}
