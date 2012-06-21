package com.oschrenk.humangeo.geom;


/**
 * The {@link SpheroidBuilder} helps build valid {@link Spheroid}s by specifying
 * the parameters.
 * 
 * When building with a given flattening, the last set axis will be used for
 * construction, overriding the other axis if given prior (which shouldn't be
 * done in any case).
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class SpheroidBuilder {

	/** The Constant NONE. */
	private static final byte NONE = 0;

	/** The Constant MAJOR. */
	private static final byte MAJOR = 1;

	/** The Constant MINOR. */
	private static final byte MINOR = -1;

	/** The semi major radius. */
	private double semiMajorRadius = Double.NaN;

	/** The semi minor radius. */
	private double semiMinorRadius = Double.NaN;

	/** The flattening. */
	private double flattening = Double.NaN;

	/** The last set axis. */
	private byte lastSetAxis = NONE;

	/**
	 * Specifies semi major axis.
	 * 
	 * @param semiMajorRadius
	 *            the semi major radius
	 * @return this spheroid builder
	 */
	public SpheroidBuilder withSemiMajorAxisOf(final double semiMajorRadius) {
		this.semiMajorRadius = semiMajorRadius;
		lastSetAxis = MAJOR;
		return this;
	}

	/**
	 * Specifies semi minor axis.
	 * 
	 * @param semiMinorRadius
	 *            the semi minor radius
	 * @return this spheroid builder
	 */
	public SpheroidBuilder withSemiMinorAxisOf(final double semiMinorRadius) {
		this.semiMinorRadius = semiMinorRadius;
		lastSetAxis = MINOR;
		return this;
	}

	/**
	 * Specifies flattening.
	 * 
	 * @param flattening
	 *            the flattening
	 * @return this spheroid builder
	 */
	public SpheroidBuilder withFlatteningOf(final double flattening) {
		this.flattening = flattening;
		return this;
	}

	/**
	 * Builds the spheroid.
	 * 
	 * @return the spheroid
	 * @throws IllegalStateException
	 *             if trying to build without flattening and one or more missing
	 *             axis, or when trying to build with flattening and no set
	 *             axis.
	 */
	public Spheroid build() {
		if (Double.isNaN(flattening)) {
			if (Double.isNaN(semiMajorRadius)) {
				throw new IllegalStateException("Semi major radius not set.");
			}
			if (Double.isNaN(semiMinorRadius)) {
				throw new IllegalStateException("Semi minor radius not set.");
			}
			flattening = (semiMajorRadius - semiMinorRadius) / semiMajorRadius;
		} else if (lastSetAxis == NONE) {
			throw new IllegalStateException("No set radius.");
		} else if (lastSetAxis == MAJOR) {
			semiMinorRadius = semiMajorRadius * (1 - flattening);
		} else if (lastSetAxis == MINOR) {
			semiMajorRadius = semiMinorRadius / (1 - flattening);
		}
		return new Spheroid(semiMajorRadius, semiMinorRadius, flattening);
	}

}
