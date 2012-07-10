package com.oschrenk.humangeo.calc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oschrenk.humangeo.calc.InverseVincentyDistance;
import com.oschrenk.humangeo.core.Spheroids;
import com.oschrenk.humangeo.cs.Geographic2dCoordinate;

public class InverseVincentyDistanceTest {

	@Test
	public void testGetDistance() {
		final Geographic2dCoordinate from = new Geographic2dCoordinate(
				53.150555555555556, -1.8444444444444446);
		final Geographic2dCoordinate to = new Geographic2dCoordinate(
				52.20527777777778, -0.1425);

		assertEquals(155927.727,
				new InverseVincentyDistance(Spheroids.WGS_84)
						.distance(from, to), 0.1);

	}

}
