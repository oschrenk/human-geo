package com.oschrenk.humangeo.cs.trans;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oschrenk.humangeo.api.CoordinateTransformation;
import com.oschrenk.humangeo.cs.Cartesian3dCoordinate;
import com.oschrenk.humangeo.cs.Geographic2dCoordinate;
import com.oschrenk.humangeo.ref.Ellipsoids;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Cartesian2dToGeographic2dTomsCoordinateTransformationTest {

	// tested with results from
	// http://www.apsalin.com/convert-cartesian-to-geodetic.aspx
	@Test
	public void test() {
		// cartesian Paris
		final double x = 4202917;
		final double y = 171255;
		final double z = 4778378;

		final Cartesian3dCoordinate coordinate = new Cartesian3dCoordinate(x,
				y, z);

		final CoordinateTransformation<Cartesian3dCoordinate, Geographic2dCoordinate> transformation = new Cartesian3dToGeographic2dTomsCoordinateTransformation(
				Ellipsoids.WGS_84);

		final Geographic2dCoordinate paris = transformation
				.transform(coordinate);

		final double latitude = paris.getLatitude();
		final double longitude = paris.getLongitude();

		assertEquals(48.833336372266, latitude, 0.0000001);
		assertEquals(2.33332320203873, longitude, 0.0000001);

	}
}
