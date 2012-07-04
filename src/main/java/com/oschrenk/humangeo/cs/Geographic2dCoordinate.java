package com.oschrenk.humangeo.cs;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
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
		Geographic2dCoordinate other = (Geographic2dCoordinate) obj;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		return true;
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
