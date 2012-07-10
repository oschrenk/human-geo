package com.oschrenk.humangeo.cs;


// TODO: Auto-generated Javadoc
/**
 * The polar coordinate system is a two-dimensional coordinate system in which
 * each point on a plane is determined by a distance from a fixed point and an
 * angle from a fixed direction.
 * 
 * <p>
 * The fixed point (analogous to the origin of a Cartesian system) is called the
 * pole, and the ray from the pole in the fixed direction is the polar axis. The
 * distance from the pole is called the radial coordinate or <i>radius</i>, and
 * the angle is the angular coordinate, <i>polar angle</i>, or azimuth.
 * 
 * <p>
 * The radial coordinate is denoted by r, and the angular coordinate by θ
 * (theta). Angles in polar notation are expressed in degrees.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class PolarCoordinateSystem {

	/**
	 * Gets the dimensions.
	 * 
	 * @return the dimensions
	 */
	public int getDimensions() {
		return 2;
	}

	/**
	 * Transforms a polar coordinate to cartesian coordinate.
	 * 
	 * @param polarCoordinate
	 *            the polar coordinate
	 * @return the cartesian coordinate
	 */
	public static Cartesian2dCoordinate toCartesianCoordinate(
			final PolarCoordinate polarCoordinate) {
		return new Cartesian2dCoordinate(polarCoordinate.getR()
				* Math.cos(Math.toRadians(polarCoordinate.getTheta())),
				polarCoordinate.getR()
						* Math.sin(Math.toRadians(polarCoordinate.getTheta())));
	}

	/**
	 * Transforms a cartesian coordinate to polar coordinate.
	 * 
	 * 
	 * @param cartesianCoordinate
	 *            the cartesian coordinate
	 * @return the polar coordinate
	 */
	public static PolarCoordinate fromCartesianCoordinate(
			final Cartesian2dCoordinate cartesianCoordinate) {
		return new PolarCoordinate(Math.sqrt(cartesianCoordinate.getX()
				* cartesianCoordinate.getX() + cartesianCoordinate.getY()
				* cartesianCoordinate.getY()), Math.atan2(
				cartesianCoordinate.getY(), cartesianCoordinate.getX()));
	}
}
