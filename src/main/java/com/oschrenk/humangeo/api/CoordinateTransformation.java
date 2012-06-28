package com.oschrenk.humangeo.api;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * @param <F>
 * @param <T>
 */
public interface CoordinateTransformation<F, T> {

	T transform(final F from);

}
