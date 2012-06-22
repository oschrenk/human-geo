package com.oschrenk.humangeo.core;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Cartesian3dCoordinate extends Cartesian2dCoordinate {

	private final double z;

	/**
	 * @param x
	 * @param y
	 */
	public Cartesian3dCoordinate(final double x, final double y) {
		super(x, y);
		z = 0;
	}

	public Cartesian3dCoordinate(final double x, final double y, final double z) {
		super(x, y);
		this.z = z;
	}

	/**
	 * @return the z
	 */
	public double getZ() {
		return z;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CartesianCoordinate [z=" + z + "]";
	}

}
