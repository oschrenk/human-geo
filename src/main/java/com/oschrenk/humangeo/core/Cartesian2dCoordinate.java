package com.oschrenk.humangeo.core;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Cartesian2dCoordinate {

	private final double x;
	private final double y;

	public Cartesian2dCoordinate(final double x, final double y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cartesian2dCoordinate [x=" + x + ", y=" + y + "]";
	}

}
