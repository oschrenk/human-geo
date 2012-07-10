package com.oschrenk.humangeo.cs.trans;

import com.oschrenk.humangeo.api.CoordinateTransformation;
import com.oschrenk.humangeo.cs.CylindricalCoordinate;
import com.oschrenk.humangeo.cs.SphericalCoordinate;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class SphericalToCylindricalCoordinateTransformation implements
		CoordinateTransformation<SphericalCoordinate, CylindricalCoordinate> {

	/*
	 * @see
	 * com.oschrenk.humangeo.api.CoordinateTransformation#transform(java.lang
	 * .Object)
	 */
	@Override
	public CylindricalCoordinate transform(
			final SphericalCoordinate sphericalCoordinate) {
		final double r = sphericalCoordinate.getR()
				* Math.sin(Math.toRadians(sphericalCoordinate.getTheta()));
		final double z = sphericalCoordinate.getR()
				* Math.cos(Math.toRadians(sphericalCoordinate.getTheta()));

		return new CylindricalCoordinate(r, sphericalCoordinate.getPhi(), z);
	}

}
