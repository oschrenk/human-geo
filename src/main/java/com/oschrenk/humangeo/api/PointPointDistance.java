package com.oschrenk.humangeo.api;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * @param <T>
 */
public interface PointPointDistance<T> {

	double distance(final T from, final T to);

}
