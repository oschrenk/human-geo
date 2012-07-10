package com.oschrenk.humangeo.core;

/**
 * A spheroid, or ellipsoid of revolution is a quadric surface obtained by
 * rotating an ellipse about one of its principal axes; in other words, an
 * ellipsoid with two equal semi-diameters.
 * 
 * If the ellipse is rotated about its major axis, the result is a prolate
 * (elongated) spheroid, like a rugby ball. If the ellipse is rotated about its
 * minor axis, the result is an oblate (flattened) spheroid, like a lentil. If
 * the generating ellipse is a circle, the result is a sphere.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Spheroid {

	/** The semi major axis. */
	double semiMajorAxis;

	/** The semi minor axis. */
	double semiMinorAxis;

	/** The flattening. */
	double flattening;

	Spheroid(double semiMajorAxis, double semiMinorAxis, double flattening) {
		this.semiMajorAxis = semiMajorAxis;
		this.semiMinorAxis = semiMinorAxis;
		this.flattening = flattening;
	}

	/**
	 * Gets the semi major axis.
	 * 
	 * @return the semi major axis
	 */
	public double getSemiMajorAxis() {
		return semiMajorAxis;
	}

	/**
	 * Gets the semi minor axis.
	 * 
	 * @return the semi minor axis
	 */
	public double getSemiMinorAxis() {
		return semiMinorAxis;
	}

	/**
	 * Gets the flattening.
	 * 
	 * @return the flattening
	 */
	public double getFlattening() {
		return flattening;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(semiMinorAxis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(flattening);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(semiMajorAxis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spheroid other = (Spheroid) obj;
		if (Double.doubleToLongBits(semiMinorAxis) != Double
				.doubleToLongBits(other.semiMinorAxis))
			return false;
		if (Double.doubleToLongBits(flattening) != Double
				.doubleToLongBits(other.flattening))
			return false;
		if (Double.doubleToLongBits(semiMajorAxis) != Double
				.doubleToLongBits(other.semiMajorAxis))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Spheroid [semiMajorAxis=" + semiMajorAxis + ", semiMinorAxis="
				+ semiMinorAxis + ", flattening=" + flattening + "]";
	}

	public static Builder withSemiMajorAxisOf(double semiMajorAxis) {
		return new Builder().withSemiMajorAxisOf(semiMajorAxis);
	}

	public static Builder withSemiMinorAxisOf(double semiMinorAxis) {
		return new Builder().withSemiMinorAxisOf(semiMinorAxis);
	}

	public static Builder withFlattening(double flattening) {
		return new Builder().withFlatteningOf(flattening);
	}

	/**
	 * The {@link SpheroidBuilder} helps build valid {@link Spheroid}s by
	 * specifying the parameters.
	 * 
	 * When building with a given flattening, the last set axis will be used for
	 * construction, overriding the other axis if given prior (which shouldn't
	 * be done in any case).
	 * 
	 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
	 */
	static class Builder {

		/** The Constant NONE. */
		private static final byte NONE = 0;

		/** The Constant MAJOR. */
		private static final byte MAJOR = 1;

		/** The Constant MINOR. */
		private static final byte MINOR = -1;

		/** The semi major axis. */
		private double semiMajorAxis = Double.NaN;

		/** The semi minor axis. */
		private double semiMinorAxis = Double.NaN;

		/** The flattening. */
		private double flattening = Double.NaN;

		/** The last set axis. */
		private byte lastSetAxis = NONE;

		/**
		 * Specifies semi major axis.
		 * 
		 * @param semiMajorAxis
		 *            the semi major axis
		 * @return this spheroid builder
		 */
		public Builder withSemiMajorAxisOf(final double semiMajorAxis) {
			this.semiMajorAxis = semiMajorAxis;
			lastSetAxis = MAJOR;
			return this;
		}

		/**
		 * Specifies semi minor axis.
		 * 
		 * @param semiMinorAxis
		 *            the semi minor axis
		 * @return this spheroid builder
		 */
		public Builder withSemiMinorAxisOf(final double semiMinorAxis) {
			this.semiMinorAxis = semiMinorAxis;
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
		public Builder withFlatteningOf(final double flattening) {
			this.flattening = flattening;
			return this;
		}

		/**
		 * Builds the spheroid.
		 * 
		 * @return the spheroid
		 * @throws IllegalStateException
		 *             if trying to build without flattening and one or more
		 *             missing axis, or when trying to build with flattening and
		 *             no set axis.
		 */
		public Spheroid build() {
			if (Double.isNaN(flattening)) {
				if (Double.isNaN(semiMajorAxis)) {
					throw new IllegalStateException(
							"Semi major radius not set.");
				}
				if (Double.isNaN(semiMinorAxis)) {
					throw new IllegalStateException(
							"Semi minor radius not set.");
				}
				flattening = (semiMajorAxis - semiMinorAxis) / semiMajorAxis;
			} else if (lastSetAxis == NONE) {
				throw new IllegalStateException("No set radius.");
			} else if (lastSetAxis == MAJOR) {
				semiMinorAxis = semiMajorAxis * (1 - flattening);
			} else if (lastSetAxis == MINOR) {
				semiMajorAxis = semiMinorAxis / (1 - flattening);
			}
			return new Spheroid(semiMajorAxis, semiMinorAxis, flattening);
		}

	}
}
