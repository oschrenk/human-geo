package com.oschrenk.humangeo.cs;

import com.oschrenk.humangeo.core.Geographic3dCoordinate;
import com.oschrenk.humangeo.geom.Sphere;
import com.oschrenk.humangeo.geom.Spheroid;

/**
 * A geographic coordinate system is a coordinate system that enables every
 * location on the Earth to be specified by a set of numbers.
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
 * Instead of the radial distance, geographers commonly use altitude above some
 * reference surface, which may be the sea level or "mean" surface level for
 * planets without liquid oceans. The radial distance r can be computed from the
 * altitude by adding the mean radius of the planet's reference surface
 * 
 * @author Oliver Schrenk <oliver.schrenk@q2web.de>
 */
public class GeographicCoordinateSystem {

	private final Spheroid spheroid;
	private final Sphere helperSphere;

	/**
	 * Instantiates a new geographic coordinate system.
	 * 
	 * @param spheroid
	 *            the spheroid
	 * @param helperSphere
	 *            For approximate calculations
	 */
	public GeographicCoordinateSystem(final Spheroid spheroid,
			final Sphere helperSphere) {
		this.spheroid = spheroid;
		this.helperSphere = helperSphere;
	}

	public int getDimensions() {
		return 3;
	}

	/**
	 * To array.
	 * 
	 * @param geographic3dCoordinate
	 *            the geographic3d coordinate
	 * @return the double[] [latitude,longitude,height]
	 */
	public static double[] toArray(
			final Geographic3dCoordinate geographic3dCoordinate) {
		return new double[] { geographic3dCoordinate.getLatitude(),
				geographic3dCoordinate.getLongitude(),
				geographic3dCoordinate.getHeight() };
	}

	public static Geographic3dCoordinate fromArray(
			final double[] geographic3dCoordinate) {
		return new Geographic3dCoordinate(geographic3dCoordinate[0],
				geographic3dCoordinate[1], geographic3dCoordinate[2]);
	}

}
