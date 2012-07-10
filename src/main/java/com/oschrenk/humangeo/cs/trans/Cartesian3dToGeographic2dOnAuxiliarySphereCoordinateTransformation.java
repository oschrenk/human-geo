package com.oschrenk.humangeo.cs.trans;

import com.oschrenk.humangeo.api.CoordinateTransformation;
import com.oschrenk.humangeo.core.Sphere;
import com.oschrenk.humangeo.cs.Cartesian3dCoordinate;
import com.oschrenk.humangeo.cs.Geographic2dCoordinate;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Cartesian3dToGeographic2dOnAuxiliarySphereCoordinateTransformation
		implements
		CoordinateTransformation<Cartesian3dCoordinate, Geographic2dCoordinate> {

	private final Sphere sphere;

	public Cartesian3dToGeographic2dOnAuxiliarySphereCoordinateTransformation(
			final Sphere sphere) {
		super();
		this.sphere = sphere;
	}

	/*
	 * @see
	 * com.oschrenk.humangeo.api.CoordinateTransformation#transform(java.lang
	 * .Object)
	 */
	@Override
	public Geographic2dCoordinate transform(final Cartesian3dCoordinate from) {
		final double latitude = Math.asin(from.getZ() / sphere.getRadius());
		final double longitude = Math.atan2(from.getY(), from.getX());
		return new Geographic2dCoordinate(latitude, longitude);
	}
}
