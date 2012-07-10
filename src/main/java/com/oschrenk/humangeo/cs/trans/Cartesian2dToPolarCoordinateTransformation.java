package com.oschrenk.humangeo.cs.trans;

import com.oschrenk.humangeo.api.CoordinateTransformation;
import com.oschrenk.humangeo.cs.Cartesian2dCoordinate;
import com.oschrenk.humangeo.cs.PolarCoordinate;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Cartesian2dToPolarCoordinateTransformation implements
		CoordinateTransformation<Cartesian2dCoordinate, PolarCoordinate> {

	/*
	 * @see com.oschrenk.humangeo.api.Transformation#transform(java.lang.Object)
	 */
	@Override
	public PolarCoordinate transform(final Cartesian2dCoordinate from) {
		final double x = from.getX();
		final double y = from.getY();
		return new PolarCoordinate(Math.sqrt(x * x + y * y), Math.atan2(y, x));
	}
}
