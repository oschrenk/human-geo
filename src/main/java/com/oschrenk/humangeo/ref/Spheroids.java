package com.oschrenk.humangeo.ref;

import com.oschrenk.humangeo.geom.Spheroid;
import com.oschrenk.humangeo.geom.SpheroidBuilder;

/**
 * Holds default ellipsoids.
 * 
 * @see <a href="http://www.arsitech.com/mapping/geodetic_datum/">Arsitech
 *      Geodetic Datum</a>
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Spheroids {

	/** The Constant AIRY_1830. */
	public static final Spheroid AIRY_1830 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6377563.396).withSemiMinorAxisOf(6356256.909)
	.build();

	/** The Constant AUSTRALIAN_1 965. */
	public static final Spheroid AUSTRALIAN_1965 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378160.0).withSemiMinorAxisOf(6356774.719)
	.build();

	/** The Constant BESSEL_1841. */
	public static final Spheroid BESSEL_1841 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6377397.155).withSemiMinorAxisOf(6356078.963)
	.build();

	/** The Constant BESSEL_1841_NAMIBIA. */
	public static final Spheroid BESSEL_1841_NAMIBIA = new SpheroidBuilder()
	.withSemiMajorAxisOf(6377483.865).withSemiMinorAxisOf(6356165.383)
	.build();

	/** The Constant CLARKE_1866. */
	public static final Spheroid CLARKE_1866 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378206.4).withSemiMinorAxisOf(6356583.8)
	.build();

	/** The Constant CLARKE_1880. */
	public static final Spheroid CLARKE_1880 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378249.145).withSemiMinorAxisOf(6356514.87)
	.build();

	/** The Constant EVEREST_1830_INDIA. */
	public static final Spheroid EVEREST_1830_INDIA = new SpheroidBuilder()
	.withSemiMajorAxisOf(6377276.345).withSemiMinorAxisOf(6356075.413)
	.build();

	/** The Constant EVEREST_1830_MALAYSIA. */
	public static final Spheroid EVEREST_1830_MALAYSIA = new SpheroidBuilder()
	.withSemiMajorAxisOf(6377298.556).withSemiMinorAxisOf(6356097.55)
	.build();

	/** The Constant EVEREST_1956_INDIA. */
	public static final Spheroid EVEREST_1956_INDIA = new SpheroidBuilder()
	.withSemiMajorAxisOf(6377301.243).withSemiMinorAxisOf(6356100.228)
	.build();

	/** The Constant EVEREST_1964_MALAYSIA_SINGAPORE. */
	public static final Spheroid EVEREST_1964_MALAYSIA_SINGAPORE = new SpheroidBuilder()
	.withSemiMajorAxisOf(6377304.063).withSemiMinorAxisOf(6356103.039)
	.build();

	/** The Constant EVEREST_1969_MALAYSIA. */
	public static final Spheroid EVEREST_1969_MALAYSIA = new SpheroidBuilder()
	.withSemiMajorAxisOf(6377295.664).withSemiMinorAxisOf(6356094.668)
	.build();

	/** The Constant EVEREST_PAKISTAN. */
	public static final Spheroid EVEREST_PAKISTAN = new SpheroidBuilder()
	.withSemiMajorAxisOf(6377309.613).withSemiMinorAxisOf(6356109.571)
	.build();

	/** The Constant FISHER_1960. */
	public static final Spheroid FISHER_1960 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378155.0).withSemiMinorAxisOf(6356773.32)
	.build();

	/** The Constant GRS_67. */
	public static final Spheroid GRS_67 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378160.0).withSemiMinorAxisOf(6356774.516)
	.build();

	/** The Constant GRS_80. */
	public static final Spheroid GRS_80 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378137.0).withSemiMinorAxisOf(6356752.3141)
	.build();

	/** The Constant HELMERT_1906. */
	public static final Spheroid HELMERT_1906 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378200.0).withSemiMinorAxisOf(6356818.17)
	.build();

	/** The Constant HOUGH_1906. */
	public static final Spheroid HOUGH_1906 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378270.0).withSemiMinorAxisOf(6356794.343)
	.build();

	/** The Constant INDONESIAN_1974. */
	public static final Spheroid INDONESIAN_1974 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378160.0).withSemiMinorAxisOf(6356774.504)
	.build();

	/** The Constant INTERNATIONAL_1924. */
	public static final Spheroid INTERNATIONAL_1924 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378388.0).withSemiMinorAxisOf(6356911.946)
	.build();

	/** The Constant KRASSOVSKY_1940. */
	public static final Spheroid KRASSOVSKY_1940 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378245.0).withSemiMinorAxisOf(6356863.019)
	.build();

	/** The Constant MODIFIED_AIRY. */
	public static final Spheroid MODIFIED_AIRY = new SpheroidBuilder()
	.withSemiMajorAxisOf(6377340.189).withSemiMinorAxisOf(6356034.448)
	.build();

	/** The Constant SOUTH_AMERICAN_1969. */
	public static final Spheroid SOUTH_AMERICAN_1969 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378160.0).withSemiMinorAxisOf(6356774.719)
	.build();

	/** The Constant WGS_72. */
	public static final Spheroid WGS_72 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378135.0).withSemiMinorAxisOf(6356750.52)
	.build();

	/** WGS84 Ellipsoid. */
	public static final Spheroid WGS_84 = new SpheroidBuilder()
	.withSemiMajorAxisOf(6378137.0).withSemiMinorAxisOf(6356752.3142)
	.build();

}
