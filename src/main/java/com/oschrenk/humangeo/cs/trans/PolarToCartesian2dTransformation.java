package com.oschrenk.humangeo.cs.trans;

import com.oschrenk.humangeo.api.CoordinateTransformation;
import com.oschrenk.humangeo.cs.Cartesian2dCoordinate;
import com.oschrenk.humangeo.cs.PolarCoordinate;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class PolarToCartesian2dTransformation implements
		CoordinateTransformation<PolarCoordinate, Cartesian2dCoordinate> {

	/*
	 * @see com.oschrenk.humangeo.api.Transformation#transform(java.lang.Object)
	 */
	@Override
	public Cartesian2dCoordinate transform(final PolarCoordinate from) {
		return new Cartesian2dCoordinate(from.getR()
				* Math.cos(Math.toRadians(from.getTheta())), from.getR()
				* Math.sin(Math.toRadians(from.getTheta())));
	}
}
