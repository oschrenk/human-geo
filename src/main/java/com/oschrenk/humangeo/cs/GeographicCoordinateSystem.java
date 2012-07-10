package com.oschrenk.humangeo.cs;

import com.oschrenk.humangeo.core.Sphere;
import com.oschrenk.humangeo.core.Spheroid;
import com.oschrenk.humangeo.io.Arrays;

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
 * altitude by adding the mean radius of the planet's reference surface.
 * 
 * @author Oliver Schrenk <oliver.schrenk@q2web.de>
 */
public class GeographicCoordinateSystem {

	/** The spheroid. */
	private final Spheroid spheroid;

	/** The helper sphere. */
	private final Sphere auxiliarySphere;

	/**
	 * Instantiates a new geographic coordinate system.
	 * 
	 * @param spheroid
	 *            the spheroid
	 * @param auxiliarySphere
	 *            For approximate calculations
	 */
	public GeographicCoordinateSystem(final Spheroid spheroid,
			final Sphere auxiliarySphere) {
		this.spheroid = spheroid;
		this.auxiliarySphere = auxiliarySphere;
	}

	/**
	 * Gets the dimensions.
	 * 
	 * @return the dimensions
	 */
	public int getDimensions() {
		return 3;
	}

	/**
	 * Gets the spheroid.
	 * 
	 * @return the spheroid
	 */
	public Spheroid getSpheroid() {
		return spheroid;
	}

	/**
	 * Gets the helper sphere.
	 * 
	 * @return the auxiliary sphere
	 */
	public Sphere getAuxiliarySphere() {
		return auxiliarySphere;
	}

	/**
	 * Build a 3-dimensional array <code>[latitude,longitude,height]</code> from
	 * a {@link Geographic3dCoordinate}
	 * 
	 * @param geographic3dCoordinate
	 *            a 3-dimensional geographic coordinate
	 * @return geographic coordinate as a 3-dimensional array in form of
	 *         <code>[latitude,longitude,height]</code>
	 */
	public static double[] toArray(
			final Geographic3dCoordinate geographic3dCoordinate) {
		return new double[] { geographic3dCoordinate.getLatitude(),
				geographic3dCoordinate.getLongitude(),
				geographic3dCoordinate.getHeight() };
	}

	/**
	 * Build a {@link Geographic3dCoordinate} from a 3-dimensional array
	 * <code>[latitude,longitude,height]</code>
	 * 
	 * @param geographic3dCoordinate
	 *            geographic coordinate as a 3-dimensional array in form of
	 *            <code>[latitude,longitude,height]</code>
	 * 
	 * @return a 3-dimensional geographic coordinate
	 * 
	 * @see Arrays#map(double[], com.oschrenk.humangeo.io.Mask,
	 *      com.oschrenk.humangeo.io.Mask)
	 */
	public static final Geographic3dCoordinate fromArray(
			final double[] geographic3dCoordinate) {
		return new Geographic3dCoordinate(geographic3dCoordinate[0],
				geographic3dCoordinate[1], geographic3dCoordinate[2]);
	}

	/**
	 * Radius of a given latitude on auxiliary sphere (in degrees).
	 * 
	 * @param latitude
	 *            the latitude in degrees
	 * @return the radius of the auxiliary sphere
	 */
	public final double getRadiusOfLatitudeOnAuxiliarySphere(double latitude) {
		return auxiliarySphere.getRadius() * Math.cos(Math.toRadians(latitude));
	}
}
