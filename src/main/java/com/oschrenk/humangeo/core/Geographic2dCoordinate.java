package com.oschrenk.humangeo.core;

/**
 * A geographic coordinate using geodetic latitude and longitude
 * 
 * <p>
 * The <b>latitude<b> (abbreviation: Lat., φ, or phi) of a point on the Earth's
 * surface is the angle in the range −90° ≤ φ ≤ 90° between the equatorial plane
 * and a line that passes through that point and is normal to the surface of a
 * reference ellipsoid.
 * 
 * <p>
 * The <b>longitude</b> (abbreviation: Long., λ, or lambda) of a point on the
 * Earth's surface is the angle is −180° ≤ λ ≤ 180° east or west from a
 * reference meridian to another meridian that passes through that point.
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
