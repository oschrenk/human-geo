package com.oschrenk.humangeo.cs;

import com.oschrenk.humangeo.core.Geographic3dCoordinate;
import com.oschrenk.humangeo.geom.Sphere;
import com.oschrenk.humangeo.geom.Spheroid;

/**
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
