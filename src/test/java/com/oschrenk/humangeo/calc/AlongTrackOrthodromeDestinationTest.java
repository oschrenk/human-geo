package com.oschrenk.humangeo.calc;

import org.junit.Test;

import com.oschrenk.humangeo.core.Geographic2dCoordinate;
import com.oschrenk.humangeo.ref.Spheres;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class AlongTrackOrthodromeDestinationTest {

	@Test
	// TODO
	public void test() {
		final Geographic2dCoordinate from = new Geographic2dCoordinate(0, 0);
		final Geographic2dCoordinate to = new Geographic2dCoordinate(90, 0);
		final Geographic2dCoordinate point = new Geographic2dCoordinate(10, 45);

		final Geographic2dCoordinate destination = new AlongTrackOrthodromeDestination(
				Spheres.EARTH).destination(point, from, to);

		System.out.println(destination);

	}

}
