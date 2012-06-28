package com.oschrenk.humangeo.cs.trans;

import com.oschrenk.humangeo.api.CoordinateTransformation;
import com.oschrenk.humangeo.core.Sphere;
import com.oschrenk.humangeo.cs.Cartesian3dCoordinate;
import com.oschrenk.humangeo.cs.Geographic2dCoordinate;

/**
 * Every point that is expressed in ellipsoidal coordinates can be expressed as
 * an x y z (Cartesian) coordinate. Cartesian coordinates simplify many
 * mathematical calculations. The origin is usually the center of mass of the
 * earth, a point close to the Earth's center of figure.
 * 
 * <p>
 * With the origin at the center of the ellipsoid, the conventional setup is the
 * expected right-hand:
 * <ul>
 * <li>Z-axis along the axis of the ellipsoid, positive northward</li>
 * <li>X- and Y-axis in the plane of the equator, X-axis positive toward 0
 * degrees longitude and Y-axis positive toward 90 degrees east longitude</li>
 * </ul>
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Geographic3dToCartesian3dOnAuxiliarySphereCoordinateTransformation
		implements
		CoordinateTransformation<Geographic2dCoordinate, Cartesian3dCoordinate> {

	private final Sphere sphere;

	public Geographic3dToCartesian3dOnAuxiliarySphereCoordinateTransformation(
			final Sphere sphere) {
		this.sphere = sphere;
	}

	/*
	 * @see com.oschrenk.humangeo.api.Transformation#transform(java.lang.Object)
	 */
	@Override
	public Cartesian3dCoordinate transform(final Geographic2dCoordinate from) {
		final double x = sphere.getRadius()
				* Math.cos(Math.toRadians(from.getLatitude()))
				* Math.cos(Math.toRadians(from.getLongitude()));

		final double y = sphere.getRadius()
				* Math.cos(Math.toRadians(from.getLatitude()))
				* Math.sin(Math.toRadians(from.getLongitude()));

		final double z = sphere.getRadius()
				* Math.sin(Math.toRadians(from.getLatitude()));

		return new Cartesian3dCoordinate(x, y, z);
	}
}
