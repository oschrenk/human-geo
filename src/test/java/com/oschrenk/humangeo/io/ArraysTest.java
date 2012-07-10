package com.oschrenk.humangeo.io;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oschrenk.humangeo.io.Arrays;
import com.oschrenk.humangeo.io.Mask;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@q2web.de>
 */
public class ArraysTest {

	@Test
	public void testMap() {
		final int[] d = new int[] { 1, 2, 3 };
		final int[] m = new int[] { 3, 2, 1 };

		assertArrayEquals(m, Arrays.map(d, Mask._123, Mask._321));
	}

}
