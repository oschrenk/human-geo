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
public class AlongTrackOrthodromeDestinationTest {

	private static final double ONE_SECOND = 0.000277777778;

	@Test
	public void testOnEquator() {
		final Geographic2dCoordinate from = new Geographic2dCoordinate(0, 0);
		final Geographic2dCoordinate to = new Geographic2dCoordinate(90, 0);
		final Geographic2dCoordinate point = new Geographic2dCoordinate(0, 45);
		final Geographic2dCoordinate destination = new AlongTrackOrthodromeDestination(
				Spheres.EARTH).destination(point,
				new Segment<Geographic2dCoordinate>(from, to));

		assertEquals(new Geographic2dCoordinate(0, 0), destination);
	}

	@Test
	public void test() {
		final Geographic2dCoordinate from = new Geographic2dCoordinate(0, 0);
		final Geographic2dCoordinate to = new Geographic2dCoordinate(90, 0);
		final Geographic2dCoordinate point = new Geographic2dCoordinate(45, 45);
		final Geographic2dCoordinate destination = new AlongTrackOrthodromeDestination(
				Spheres.EARTH).destination(point,
				new Segment<Geographic2dCoordinate>(from, to));

		assertEquals(54 + 44d / 60 + 8d / 3600, destination.getLatitude(),
				ONE_SECOND);
		assertEquals(0, destination.getLongitude(), ONE_SECOND);

	}
}
