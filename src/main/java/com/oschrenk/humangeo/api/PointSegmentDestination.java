package com.oschrenk.humangeo.api;

import com.oschrenk.humangeo.core.Segment;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * @param <T>
 */
public interface PointSegmentDestination<T> {

	T destination(final T point, final Segment<T> Segment);

}
