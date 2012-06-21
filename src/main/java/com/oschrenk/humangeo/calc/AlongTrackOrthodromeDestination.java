package com.oschrenk.humangeo.calc;

import com.oschrenk.humangeo.api.AlongTrackDestination;
import com.oschrenk.humangeo.core.Geographic2dCoordinate;
import com.oschrenk.humangeo.geom.Sphere;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class AlongTrackOrthodromeDestination implements
		AlongTrackDestination<Geographic2dCoordinate> {

	private final Sphere sphere;

	public AlongTrackOrthodromeDestination(final Sphere sphere) {
		super();
		this.sphere = sphere;
	}

	/*
	 * @see
	 * com.oschrenk.humangeo.api.AlongTrackDestination#distance(java.lang.Object
	 * , java.lang.Object, java.lang.Object)
	 */
	@Override
	public Geographic2dCoordinate destination(final Geographic2dCoordinate point,
			final Geographic2dCoordinate from, final Geographic2dCoordinate to) {

		final double initialBearing = new OrthodromeBearing().bearing(from, to);
		final double distance = new AlongTrackOrthodromeDistance(sphere).distance(point,
				from, to);
		final Geographic2dCoordinate destination = new OrthodromeDestination(
				sphere).destination(from, initialBearing, distance);

		return destination;
	}
}
