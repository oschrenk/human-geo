package com.oschrenk.humangeo.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.oschrenk.humangeo.core.Segment;
import com.oschrenk.humangeo.core.Spheres;
import com.oschrenk.humangeo.cs.Geographic2dCoordinate;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class CrossTrackOrthodromeDistanceTest {

	@Test
	public void testPointOnLine() {
		final Geographic2dCoordinate from = new Geographic2dCoordinate(0, 0);
		final Geographic2dCoordinate to = new Geographic2dCoordinate(90, 0);
		final Geographic2dCoordinate point = new Geographic2dCoordinate(45, 0);
		final double distance = new CrossTrackOrthodromeDistance(Spheres.EARTH)
				.distance(point, new Segment<Geographic2dCoordinate>(from, to));

		assertEquals(0.0, distance, 0d);
	}

	@Test
	public void testPointOnEquator() {
		final Geographic2dCoordinate from = new Geographic2dCoordinate(0, 0);
		final Geographic2dCoordinate to = new Geographic2dCoordinate(90, 0);
		final Geographic2dCoordinate point = new Geographic2dCoordinate(0, 45);
		final double distance = new CrossTrackOrthodromeDistance(Spheres.EARTH)
				.distance(point, new Segment<Geographic2dCoordinate>(from, to));

		final double circumferenceEarth = 2 * Math.PI
				* Spheres.EARTH.getRadius();

		assertEquals(circumferenceEarth / 8, distance, 0.000000001d);
	}

	@Test
	// cross check with R.geosphere package
	public void testPointOn45() {
		final Geographic2dCoordinate from = new Geographic2dCoordinate(0, 0);
		final Geographic2dCoordinate to = new Geographic2dCoordinate(90, 0);
		final Geographic2dCoordinate point = new Geographic2dCoordinate(45, 45);
		final double distance = new CrossTrackOrthodromeDistance(Spheres.EARTH)
				.distance(point, new Segment<Geographic2dCoordinate>(from, to));

		assertEquals(3335847.799, distance, 0.001d);
	}

	@Test
	// cross check with http://williams.best.vwh.net/avform.htm#Example
	public void testDtoLAXtoJFK() {
		// LAX: (33deg 57min N, 118deg 24min W)
		Geographic2dCoordinate LAX = new Geographic2dCoordinate(33 + 57d / 60,
				118 + 24d / 60);
		// JFK: (40deg 38min N, 73deg 47min W)
		Geographic2dCoordinate JFK = new Geographic2dCoordinate(40 + 38d / 60,
				73 + 47d / 60);
		// (D): N34:30 W116:30
		Geographic2dCoordinate D = new Geographic2dCoordinate(34 + 30d / 60,
				116 + 30d / 60);

		final double distance = new CrossTrackOrthodromeDistance(Spheres.EARTH)
				.distance(D, new Segment<Geographic2dCoordinate>(LAX, JFK));

		assertEquals(-13810.91, distance, 0.01d);
	}
}
