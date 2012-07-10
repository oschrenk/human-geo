package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.PointSegmentDestination;
import com.oschrenk.humangeo.core.Segment;
import com.oschrenk.humangeo.core.Sphere;
import com.oschrenk.humangeo.cs.Geographic2dCoordinate;

/**
 * Calculates the coordinates of the interception point of the shortest line of
 * Point p towards the geodesic between points A and B.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class AlongTrackOrthodromeDestination implements
		PointSegmentDestination<Geographic2dCoordinate> {

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
			final Segment<Geographic2dCoordinate> segment) {

		final double initialBearing = new OrthodromeBearing().bearing(
				segment.getFrom(), segment.getTo());
		final double distance = new AlongTrackOrthodromeDistance(sphere)
				.distance(point, segment);
		final Geographic2dCoordinate destination = new OrthodromeDestination(
				sphere)
				.destination(segment.getFrom(), initialBearing, distance);

		return destination;
	}
}
