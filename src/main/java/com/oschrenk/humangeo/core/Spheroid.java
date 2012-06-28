package com.oschrenk.humangeo.core;

/**
 * A spheroid, or ellipsoid of revolution is a quadric surface obtained by
 * rotating an ellipse about one of its principal axes; in other words, an
 * ellipsoid with two equal semi-diameters.
 * 
 * If the ellipse is rotated about its major axis, the result is a prolate
 * (elongated) spheroid, like a rugby ball. If the ellipse is rotated about its
 * minor axis, the result is an oblate (flattened) spheroid, like a lentil. If
 * the generating ellipse is a circle, the result is a sphere.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Spheroid {

	/** The semi major axis. */
	double semiMajorAxis;

	/** The semi minor axis. */
	double semiMinorAxis;

	/** The flattening. */
	double flattening;

	Spheroid(double semiMajorAxis, double semiMinorAxis, double flattening) {
		this.semiMajorAxis = semiMajorAxis;
		this.semiMinorAxis = semiMinorAxis;
		this.flattening = flattening;
	}

	/**
	 * Gets the semi major axis.
	 * 
	 * @return the semi major axis
	 */
	public double getSemiMajorAxis() {
		return semiMajorAxis;
	}

	/**
	 * Gets the semi minor axis.
	 * 
	 * @return the semi minor axis
	 */
	public double getSemiMinorAxis() {
		return semiMinorAxis;
	}

	/**
	 * Gets the flattening.
	 * 
	 * @return the flattening
	 */
	public double getFlattening() {
		return flattening;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(semiMinorAxis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(flattening);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(semiMajorAxis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spheroid other = (Spheroid) obj;
		if (Double.doubleToLongBits(semiMinorAxis) != Double.doubleToLongBits(other.semiMinorAxis))
			return false;
		if (Double.doubleToLongBits(flattening) != Double.doubleToLongBits(other.flattening))
			return false;
		if (Double.doubleToLongBits(semiMajorAxis) != Double.doubleToLongBits(other.semiMajorAxis))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Spheroid [semiMajorAxis=" + semiMajorAxis + ", semiMinorAxis=" + semiMinorAxis + ", flattening=" + flattening
				+ "]";
	}

}
