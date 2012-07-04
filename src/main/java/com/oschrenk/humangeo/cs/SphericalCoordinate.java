package com.oschrenk.humangeo.cs;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(phi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SphericalCoordinate other = (SphericalCoordinate) obj;
		if (Double.doubleToLongBits(phi) != Double.doubleToLongBits(other.phi))
			return false;
		return true;
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
