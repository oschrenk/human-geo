package com.oschrenk.humangeo.geom;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpheroidBuilderTest {

	private static final double WGS84_FLATTENING = 0.0033528106718309896;
	private static final double WGS84_MINOR = 6356752.3142;
	private static final double WGS84_MAJOR = 6378137.0;
	private SpheroidBuilder spheroidBuilder;

	@Before
	public void setUp() throws Exception {
		spheroidBuilder = new SpheroidBuilder();
	}

	@Test
	public void testBuildingWithBothAxis() {
		final Spheroid spheroid = spheroidBuilder
				.withSemiMajorAxisOf(WGS84_MAJOR)
				.withSemiMinorAxisOf(WGS84_MINOR).build();
		assertEquals(WGS84_MAJOR, spheroid.getSemiMajorAxis(), 0.0);
		assertEquals(WGS84_MINOR, spheroid.getSemiMinorAxis(), 0.0);
		assertEquals(WGS84_FLATTENING, spheroid.getFlattening(), 0.0);
	}

	@Test
	public void testBuildingWithMajorAxisAndFlattening() {
		final Spheroid spheroid = spheroidBuilder
				.withSemiMajorAxisOf(WGS84_MAJOR)
				.withFlatteningOf(WGS84_FLATTENING).build();
		assertEquals(WGS84_MAJOR, spheroid.getSemiMajorAxis(), 0.0);
		assertEquals(WGS84_MINOR, spheroid.getSemiMinorAxis(), 0.0);
		assertEquals(WGS84_FLATTENING, spheroid.getFlattening(), 0.0);
	}

	@Test
	public void testBuildingWithMinorAxisAndFlattening() {
		final Spheroid spheroid = spheroidBuilder
				.withSemiMinorAxisOf(WGS84_MINOR)
				.withFlatteningOf(WGS84_FLATTENING).build();
		assertEquals(WGS84_MAJOR, spheroid.getSemiMajorAxis(), 0.0);
		assertEquals(WGS84_MINOR, spheroid.getSemiMinorAxis(), 0.0);
		assertEquals(WGS84_FLATTENING, spheroid.getFlattening(), 0.0);
	}

}
