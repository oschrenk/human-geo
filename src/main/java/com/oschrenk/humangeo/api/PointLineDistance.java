package com.oschrenk.humangeo.api;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * @param <T>
 */
public interface PointLineDistance<T> {

	double distance(final T point, final T from, final T to);

}
