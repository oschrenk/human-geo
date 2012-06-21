package com.oschrenk.humangeo.core;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Geographic2dCoordinate {

	private final double latitude;

	private final double longitude;

	public Geographic2dCoordinate(final double latitude, final double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 * @category getter
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 * @category getter
	 */
	public double getLongitude() {
		return longitude;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GeographicCoordinate [latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}

}
