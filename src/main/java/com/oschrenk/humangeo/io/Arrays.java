package com.oschrenk.humangeo.io;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Arrays {

	private static final int FIRST = 3 << 4;

	private static final int SECOND = 3 << 2;

	private static final int THIRD = 3;

	/**
	 * Helper method to permutate a three dimensional array
	 * 
	 * @param original
	 *            the array to permutate
	 * @param from
	 *            permuation mask
	 * @param to
	 *            permuation mask
	 * @return permutated three dimensional array
	 */
	public static boolean[] map(final boolean[] original, final Mask from,
			final Mask to) {
		final boolean[] m = new boolean[3];

		m[(to.getMask() & FIRST) >> 4] = original[(from.getMask() & FIRST) >> 4];
		m[(to.getMask() & SECOND) >> 2] = original[(from.getMask() & SECOND) >> 2];
		m[(to.getMask() & THIRD)] = original[(from.getMask() & THIRD)];

		return m;
	}

	/**
	 * Helper method to permutate a three dimensional array
	 * 
	 * @param original
	 *            the array to permutate
	 * @param from
	 *            permuation mask
	 * @param to
	 *            permuation mask
	 * @return permutated three dimensional array
	 */
	public static byte[] map(final byte[] original, final Mask from,
			final Mask to) {
		final byte[] m = new byte[3];

		m[(to.getMask() & FIRST) >> 4] = original[(from.getMask() & FIRST) >> 4];
		m[(to.getMask() & SECOND) >> 2] = original[(from.getMask() & SECOND) >> 2];
		m[(to.getMask() & THIRD)] = original[(from.getMask() & THIRD)];

		return m;
	}

	/**
	 * Helper method to permutate a three dimensional array
	 * 
	 * @param original
	 *            the array to permutate
	 * @param from
	 *            permuation mask
	 * @param to
	 *            permuation mask
	 * @return permutated three dimensional array
	 */
	public static int[] map(final int[] original, final Mask from, final Mask to) {
		final int[] m = new int[3];

		m[(to.getMask() & FIRST) >> 4] = original[(from.getMask() & FIRST) >> 4];
		m[(to.getMask() & SECOND) >> 2] = original[(from.getMask() & SECOND) >> 2];
		m[(to.getMask() & THIRD)] = original[(from.getMask() & THIRD)];

		return m;
	}

	/**
	 * Helper method to permutate a three dimensional array
	 * 
	 * @param original
	 *            the array to permutate
	 * @param from
	 *            permuation mask
	 * @param to
	 *            permuation mask
	 * @return permutated three dimensional array
	 */
	public static long[] map(final long[] original, final Mask from,
			final Mask to) {
		final long[] m = new long[3];

		m[(to.getMask() & FIRST) >> 4] = original[(from.getMask() & FIRST) >> 4];
		m[(to.getMask() & SECOND) >> 2] = original[(from.getMask() & SECOND) >> 2];
		m[(to.getMask() & THIRD)] = original[(from.getMask() & THIRD)];

		return m;
	}

	/**
	 * Helper method to permutate a three dimensional array
	 * 
	 * @param original
	 *            the array to permutate
	 * @param from
	 *            permuation mask
	 * @param to
	 *            permuation mask
	 * @return permutated three dimensional array
	 */
	public static float[] map(final float[] original, final Mask from,
			final Mask to) {
		final float[] m = new float[3];

		m[(to.getMask() & FIRST) >> 4] = original[(from.getMask() & FIRST) >> 4];
		m[(to.getMask() & SECOND) >> 2] = original[(from.getMask() & SECOND) >> 2];
		m[(to.getMask() & THIRD)] = original[(from.getMask() & THIRD)];

		return m;
	}

	/**
	 * Helper method to permutate a three dimensional array
	 * 
	 * @param original
	 *            the array to permutate
	 * @param from
	 *            permuation mask
	 * @param to
	 *            permuation mask
	 * @return permutated three dimensional array
	 */
	public static double[] map(final double[] original, final Mask from,
			final Mask to) {
		final double[] m = new double[3];

		m[(to.getMask() & FIRST) >> 4] = original[(from.getMask() & FIRST) >> 4];
		m[(to.getMask() & SECOND) >> 2] = original[(from.getMask() & SECOND) >> 2];
		m[(to.getMask() & THIRD)] = original[(from.getMask() & THIRD)];

		return m;
	}

	public static String[] map(final String[] d, final Mask from, final Mask to) {
		final String[] m = new String[3];

		m[(to.getMask() & FIRST) >> 4] = d[(from.getMask() & FIRST) >> 4];
		m[(to.getMask() & SECOND) >> 2] = d[(from.getMask() & SECOND) >> 2];
		m[(to.getMask() & THIRD)] = d[(from.getMask() & THIRD)];

		return m;
	}

}
