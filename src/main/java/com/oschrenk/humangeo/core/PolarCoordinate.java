package com.oschrenk.humangeo.core;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class PolarCoordinate {

	private final double theta;

	private final double r;

	public PolarCoordinate(final double r, final double theta) {
		super();
		this.theta = theta;
		this.r = r;
	}

	/**
	 * @return the theta
	 * @category getter
	 */
	public double getTheta() {
		return theta;
	}

	/**
	 * @return the r
	 * @category getter
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
