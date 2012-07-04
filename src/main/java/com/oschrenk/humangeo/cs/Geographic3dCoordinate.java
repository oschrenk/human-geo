package com.oschrenk.humangeo.cs;

/**
 * A geographic coordinate using geodetic latitude and longitude and with an
 * height (altitude)
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
 * <p>
 * Instead of the radial distance, geographers commonly use <b>altitude</b>
 * above some reference surface, which may be the sea level or "mean" surface
 * level for planets without liquid oceans. The radial distance r can be
 * computed from the altitude by adding the mean radius of the planet's
 * reference surface.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Geographic3dCoordinate extends Geographic2dCoordinate {

	private final double height;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(height);
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
		Geographic3dCoordinate other = (Geographic3dCoordinate) obj;
		if (Double.doubleToLongBits(height) != Double
				.doubleToLongBits(other.height))
			return false;
		return true;
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
