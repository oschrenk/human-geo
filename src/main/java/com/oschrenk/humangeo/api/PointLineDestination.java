package com.oschrenk.humangeo.api;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * @param <T>
 */
public interface PointLineDestination<T> {

	T destination(final T point, final T from, final T to);

}