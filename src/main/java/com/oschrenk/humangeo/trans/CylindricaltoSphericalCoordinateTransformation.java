package com.oschrenk.humangeo.trans;

import com.oschrenk.humangeo.api.CoordinateTransformation;
import com.oschrenk.humangeo.core.CylindricalCoordinate;
import com.oschrenk.humangeo.core.SphericalCoordinate;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class CylindricaltoSphericalCoordinateTransformation implements
		CoordinateTransformation<CylindricalCoordinate, SphericalCoordinate> {

	/*
	 * @see
	 * com.oschrenk.humangeo.api.CoordinateTransformation#transform(java.lang
	 * .Object)
	 */
	@Override
	public SphericalCoordinate transform(
			final CylindricalCoordinate cylindricalCoordinate) {
		final double r = Math.sqrt(cylindricalCoordinate.getR()
				* cylindricalCoordinate.getR() + cylindricalCoordinate.getZ()
				* cylindricalCoordinate.getZ());
		final double theta = Math.atan(cylindricalCoordinate.getR()
				/ cylindricalCoordinate.getZ());

		return new SphericalCoordinate(r, theta,
				cylindricalCoordinate.getTheta());
	}
}
