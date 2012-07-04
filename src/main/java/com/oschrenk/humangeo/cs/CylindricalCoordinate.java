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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(z);
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
		CylindricalCoordinate other = (CylindricalCoordinate) obj;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
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
