package com.oschrenk.humangeo.core;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Geographic3dCoordinate extends Geographic2dCoordinate {

	private final double height;

	/**
	 * @param latitude
	 * @param longitude
	 */
	public Geographic3dCoordinate(final double latitude, final double longitude) {
		super(latitude, longitude);
		height = 0;
	}

	public Geographic3dCoordinate(final double latitude,
			final double longitude, final double height) {
		super(latitude, longitude);
		this.height = height;
	}

	/**
	 * @return the height
	 * @category getter
	 */
	public double getHeight() {
		return height;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Geographic3dCoordinate [latitude=" + getLatitude()
				+ ", longitude=" + getLongitude() + ", height=" + height + "]";
	}

}
