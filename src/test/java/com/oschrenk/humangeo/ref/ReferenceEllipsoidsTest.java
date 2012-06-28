package com.oschrenk.humangeo.ref;

import static com.oschrenk.humangeo.ref.Ellipsoids.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ReferenceEllipsoidsTest {

	@Test
	public void testFlattening() {
		assertEquals(0.00334085067870327, AIRY_1830.getFlattening(), 0.0);
		assertEquals(0.003352891899858333, AUSTRALIAN_1965.getFlattening(), 0.0);
		assertEquals(0.0033427731536659813, BESSEL_1841.getFlattening(), 0.0);
		assertEquals(0.003342773176894559, BESSEL_1841_NAMIBIA.getFlattening(),
				0.0);
		assertEquals(0.0033900753039287908, CLARKE_1866.getFlattening(), 0.0);
		assertEquals(0.003407561308111843, CLARKE_1880.getFlattening(), 0.0);
		assertEquals(0.0033244493186534527, EVEREST_1830_INDIA.getFlattening(),
				0.0);
		assertEquals(0.003324449343845343,
				EVEREST_1830_MALAYSIA.getFlattening(), 0.0);
		assertEquals(0.0033244493543833783, EVEREST_1956_INDIA.getFlattening(),
				0.0);
		assertEquals(0.003324449295589469,
				EVEREST_1964_MALAYSIA_SINGAPORE.getFlattening(), 0.0);
		assertEquals(0.0033244492833663726,
				EVEREST_1969_MALAYSIA.getFlattening(), 0.0);
		assertEquals(0.003324292418982392, EVEREST_PAKISTAN.getFlattening(),
				0.0);
		assertEquals(0.003352329944944847, FISHER_1960.getFlattening(), 0.0);
		assertEquals(1 / 298.247167427, GRS_67.getFlattening(), 0.0000000001);
		assertEquals(0.0033528106875095227, GRS_80.getFlattening(), 0.0);
		assertEquals(0.0033523298109184524, HELMERT_1906.getFlattening(), 0.0);
		assertEquals(0.0033670034351006867, HOUGH_1906.getFlattening(), 0.0);
		assertEquals(0.0033529256086395256, INDONESIAN_1974.getFlattening(),
				0.0);
		assertEquals(0.003367003387062615, INTERNATIONAL_1924.getFlattening(),
				0.0);
		assertEquals(0.0033523298336767685, KRASSOVSKY_1940.getFlattening(),
				0.0);
		assertEquals(0.0033408506318589907, MODIFIED_AIRY.getFlattening(), 0.0);
		assertEquals(0.003352891899858333, SOUTH_AMERICAN_1969.getFlattening(),
				0.0);
		assertEquals(0.00335277945669078, WGS_72.getFlattening(), 0.0);
		assertEquals(0.0033528106718309896, WGS_84.getFlattening(), 0.0);
	}
}
