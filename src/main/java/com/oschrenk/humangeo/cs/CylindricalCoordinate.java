package com.oschrenk.humangeo.cs;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class CylindricalCoordinate extends PolarCoordinate {

	private final double z;

	/**
	 * @param r
	 * @param theta
	 */
	public CylindricalCoordinate(final double r, final double theta) {
		super(r, theta);
		z = 0;
	}

	public CylindricalCoordinate(final double r, final double theta,
			final double z) {
		super(r, theta);
		this.z = z;
	}

	/**
	 * @return the z
	 * @category getter
	 */
	public double getZ() {
		return z;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CylindricalCoordinate [r=" + getR() + ", theta=" + getTheta()
				+ ", z=" + z + "]";
	}

}
