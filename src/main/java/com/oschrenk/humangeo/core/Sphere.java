package com.oschrenk.humangeo.core;

/**
 * A sphere.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Sphere {

	/** The radius. */
	private final double radius;

	/**
	 * Instantiates a new sphere.
	 * 
	 * @param radius
	 *            the radius
	 */
	public Sphere(double radius) {
		super();
		this.radius = radius;
	}

	/**
	 * Gets the radius.
	 * 
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(radius);
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
		Sphere other = (Sphere) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
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
		return "Sphere [radius=" + radius + "]";
	}

}
