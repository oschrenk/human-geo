package com.oschrenk.humangeo.cs.trans;

import com.oschrenk.humangeo.api.CoordinateTransformation;
import com.oschrenk.humangeo.cs.Cartesian2dCoordinate;
import com.oschrenk.humangeo.cs.Cartesian3dCoordinate;
import com.oschrenk.humangeo.cs.SphericalCoordinate;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class SphericalToCartesian3dTransformation implements
		CoordinateTransformation<SphericalCoordinate, Cartesian2dCoordinate> {

	/*
	 * @see com.oschrenk.humangeo.api.Transformation#transform(java.lang.Object)
	 */
	@Override
	public Cartesian2dCoordinate transform(
			final SphericalCoordinate sphericalCoordinate) {
		return new Cartesian3dCoordinate(
				sphericalCoordinate.getR()
						* Math.sin(Math.toRadians(sphericalCoordinate
								.getTheta()))
						* Math.cos(Math.toRadians(sphericalCoordinate.getPhi())),
				sphericalCoordinate.getR()
						* Math.sin(Math.toRadians(sphericalCoordinate
								.getTheta()))
						* sphericalCoordinate.getR()
						* Math.sin(Math.toRadians(sphericalCoordinate.getPhi())),
				Math.cos(Math.toRadians(sphericalCoordinate.getTheta())));
	}

}
