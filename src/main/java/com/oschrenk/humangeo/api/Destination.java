package com.oschrenk.humangeo.api;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * @param <T>
 */
public interface Destination<T> {

	T destination(final T point, final double initialBearing,
			final double distance);

}
