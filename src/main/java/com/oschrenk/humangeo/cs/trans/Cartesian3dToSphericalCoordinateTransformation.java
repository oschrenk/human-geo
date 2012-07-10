package com.oschrenk.humangeo.cs.trans;

import com.oschrenk.humangeo.api.CoordinateTransformation;
import com.oschrenk.humangeo.cs.Cartesian3dCoordinate;
import com.oschrenk.humangeo.cs.SphericalCoordinate;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Cartesian3dToSphericalCoordinateTransformation implements
		CoordinateTransformation<Cartesian3dCoordinate, SphericalCoordinate> {

	/*
	 * @see com.oschrenk.humangeo.api.Transformation#transform(java.lang.Object)
	 */
	@Override
	public SphericalCoordinate transform(
			final Cartesian3dCoordinate cartesianCoordinate) {
		final double r = Math.sqrt(cartesianCoordinate.getX()
				* cartesianCoordinate.getX() + cartesianCoordinate.getY()
				* cartesianCoordinate.getY() + cartesianCoordinate.getZ()
				* cartesianCoordinate.getZ());

		return new SphericalCoordinate(r, Math.atan(cartesianCoordinate.getY()
				/ cartesianCoordinate.getX()), Math.acos(cartesianCoordinate
				.getZ() / r));
	}

}
