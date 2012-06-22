package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.PointLineDestination;
import com.oschrenk.humangeo.core.Geographic2dCoordinate;
import com.oschrenk.humangeo.geom.Sphere;

/**
 * Calculates the coordinates of the interception point of the shortest line of
 * Point p towards the geodesic between points A and B.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class AlongTrackOrthodromeDestination implements
		PointLineDestination<Geographic2dCoordinate> {

	/** The sphere. */
	private final Sphere sphere;

	/**
	 * Instantiates a new along track orthodrome destination.
	 * 
	 * @param sphere
	 *            the sphere
	 */
	public AlongTrackOrthodromeDestination(final Sphere sphere) {
		super();
		this.sphere = sphere;
	}

	/*
	 * @see
	 * com.oschrenk.humangeo.api.PointLineDestination#destination(java.lang.
	 * Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public Geographic2dCoordinate destination(
			final Geographic2dCoordinate point,
			final Geographic2dCoordinate from, final Geographic2dCoordinate to) {

		final double initialBearing = new OrthodromeBearing().bearing(from, to);
		final double distance = new AlongTrackOrthodromeDistance(sphere)
				.distance(point, from, to);
		final Geographic2dCoordinate destination = new OrthodromeDestination(
				sphere).destination(from, initialBearing, distance);

		return destination;
	}
}
