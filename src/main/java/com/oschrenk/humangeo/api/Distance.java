package com.oschrenk.humangeo.api;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * @param <F>
 * @param <T>
 */
public interface Distance<F, T> {

	double distance(final F from, final T to);

}
