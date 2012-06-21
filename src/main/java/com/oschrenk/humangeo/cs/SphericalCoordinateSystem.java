package com.oschrenk.humangeo.cs;

import com.oschrenk.humangeo.core.Cartesian3dCoordinate;
import com.oschrenk.humangeo.core.SphericalCoordinate;
import com.oschrenk.humangeo.geom.Sphere;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class SphericalCoordinateSystem {

	private final Sphere sphere;

	/**
	 * Instantiates a new spherical coordinate system.
	 * 
	 * @param sphere
	 *            the sphere
	 */
	public SphericalCoordinateSystem(final Sphere sphere) {
		this.sphere = sphere;
	}

	public int getDimensions() {
		return 3;
	}

	public Cartesian3dCoordinate toCartesianCoordinate(
			final SphericalCoordinate sphericalCoordinate) {

		return new Cartesian3dCoordinate(
				sphere.getRadius()
						* Math.sin(Math.toRadians(sphericalCoordinate
								.getTheta()))
						* Math.cos(Math.toRadians(sphericalCoordinate.getPhi())),
				sphere.getRadius()
						* Math.sin(Math.toRadians(sphericalCoordinate
								.getTheta()))
						* sphere.getRadius()
						* Math.sin(Math.toRadians(sphericalCoordinate.getPhi())),
				Math.cos(Math.toRadians(sphericalCoordinate.getTheta())));
	}

	public SphericalCoordinate fromCartesianCoordinate(
			final Cartesian3dCoordinate cartesianCoordinate) {

		final double r = Math.sqrt(cartesianCoordinate.getX()
				* cartesianCoordinate.getX() + cartesianCoordinate.getY()
				* cartesianCoordinate.getY() + cartesianCoordinate.getZ()
				* cartesianCoordinate.getZ());

		return new SphericalCoordinate(r, Math.atan(cartesianCoordinate.getY()
				/ cartesianCoordinate.getX()), Math.acos(cartesianCoordinate
				.getZ() / r));
	}

	/**
	 * To array.
	 * 
	 * @param sphericalCoordinate
	 *            the spherical coordinate
	 * @return the double [r, theta, phi]
	 */
	public double[] toArray(final SphericalCoordinate sphericalCoordinate) {
		return new double[] { sphericalCoordinate.getR(),
				sphericalCoordinate.getTheta(), sphericalCoordinate.getPhi() };
	}

	/**
	 * Build a spherical coordinate from an array.
	 * 
	 * @param sphericalCoordinate
	 *            [r, theta, phi] the spherical coordinate
	 * @return the spherical coordinate
	 */
	public SphericalCoordinate fromArray(final double[] sphericalCoordinate) {
		return new SphericalCoordinate(sphericalCoordinate[0],
				sphericalCoordinate[1], sphericalCoordinate[2]);
	}

}
