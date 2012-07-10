package com.oschrenk.humangeo.cs;

import com.oschrenk.humangeo.core.Sphere;
import com.oschrenk.humangeo.io.Arrays;

/**
 * A spherical coordinate system is a coordinate system for three-dimensional
 * space where the position of a point is specified by three numbers: the radial
 * distance of that point from a fixed origin, its polar angle measured from a
 * fixed zenith direction, and the azimuth angle of its orthogonal projection on
 * a reference plane that passes through the origin and is orthogonal to the
 * zenith, measured from a fixed reference direction on that plane.
 * 
 * <p>
 * The radial distance is also called the radius or radial coordinate. The polar
 * angle may be called colatitude, zenith angle, normal angle, or inclination
 * angle. The use of symbols and the order of the coordinates differs between
 * sources. Here it is defined as:
 * 
 * <ul>
 * <li><b>r</b> the radial distance</li>
 * <li><b>θ</b> (theta), the polar angle</li>
 * <li><b>φ</b> (phi), the azimuth angle</li>
 * </ul>
 * <p>
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class SphericalCoordinateSystem {

	/** The sphere. */
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

	/**
	 * Gets the dimensions.
	 * 
	 * @return the dimensions
	 */
	public int getDimensions() {
		return 3;
	}

	/**
	 * To cartesian coordinate.
	 * 
	 * @param sphericalCoordinate
	 *            the spherical coordinate
	 * @return the cartesian3d coordinate
	 */
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

	/**
	 * From cartesian coordinate.
	 * 
	 * @param cartesianCoordinate
	 *            the cartesian coordinate
	 * @return the spherical coordinate
	 */
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
	 * Build a spherical coordinate from a 3-dimensional array.
	 * 
	 * @param sphericalCoordinate
	 *            [r, theta, phi] the spherical coordinate
	 * @return the spherical coordinate
	 * 
	 @see Arrays#map(double[], com.oschrenk.humangeo.io.Mask,
	 *      com.oschrenk.humangeo.io.Mask)
	 */
	public SphericalCoordinate fromArray(final double[] sphericalCoordinate) {
		return new SphericalCoordinate(sphericalCoordinate[0],
				sphericalCoordinate[1], sphericalCoordinate[2]);
	}

}
