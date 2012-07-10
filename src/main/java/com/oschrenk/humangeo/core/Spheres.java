package com.oschrenk.humangeo.core;


/**
 * Holds default spheres.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Spheres {

	/** The Constant EARTH_VOLUMETRIC_MEAN_RADIUS. */
	private static final int EARTH_VOLUMETRIC_MEAN_RADIUS = 6371000;

	/** The Constant MARS_VOLUMETRIC_MEAN_RADIUS. */
	private static final int MARS_VOLUMETRIC_MEAN_RADIUS = 3389500;

	/** The Constant MERCURY_VOLUMETRIC_MEAN_RADIUS. */
	private static final int MERCURY_VOLUMETRIC_MEAN_RADIUS = 2439700;

	/** The Constant VENUS_VOLUMETRIC_MEAN_RADIUS. */
	private static final int VENUS_VOLUMETRIC_MEAN_RADIUS = 6051800;

	/** The Constant MOON_VOLUMETRIC_MEAN_RADIUS. */
	private static final int MOON_VOLUMETRIC_MEAN_RADIUS = 1737100;

	/** The Constant JUPITER_VOLUMETRIC_MEAN_RADIUS. */
	private static final int JUPITER_VOLUMETRIC_MEAN_RADIUS = 69911000;

	/** The Constant SATURN_VOLUMETRIC_MEAN_RADIUS. */
	private static final int SATURN_VOLUMETRIC_MEAN_RADIUS = 58232000;

	/** The Constant URANUS_VOLUMETRIC_MEAN_RADIUS. */
	private static final int URANUS_VOLUMETRIC_MEAN_RADIUS = 25362000;

	/** The Constant NEPTUNE_VOLUMETRIC_MEAN_RADIUS. */
	private static final int NEPTUNE_VOLUMETRIC_MEAN_RADIUS = 24622000;

	/** The Constant PLUTO_VOLUMETRIC_MEAN_RADIUS. */
	private static final int PLUTO_VOLUMETRIC_MEAN_RADIUS = 1195000;

	/** The Constant NORMAL. */
	public static final Sphere NORMAL = new Sphere(1);

	/**
	 * The earth isn't spherical in nature. This class assumes a mean radius of
	 * 6371000 m. In reality the distances from the surface range from 6,353 km
	 * to 6,384 km.
	 * 
	 */
	public static final Sphere EARTH = new Sphere(EARTH_VOLUMETRIC_MEAN_RADIUS);

	/** The Constant MARS. */
	public static final Sphere MARS = new Sphere(MARS_VOLUMETRIC_MEAN_RADIUS);

	/** The Constant MERCURY. */
	public static final Sphere MERCURY = new Sphere(
			MERCURY_VOLUMETRIC_MEAN_RADIUS);

	/** The Constant VENUS. */
	public static final Sphere VENUS = new Sphere(VENUS_VOLUMETRIC_MEAN_RADIUS);

	/** The Constant MOON. */
	public static final Sphere MOON = new Sphere(MOON_VOLUMETRIC_MEAN_RADIUS);

	/** The Constant JUPITER. */
	public static final Sphere JUPITER = new Sphere(
			JUPITER_VOLUMETRIC_MEAN_RADIUS);

	/** The Constant SATURN. */
	public static final Sphere SATURN = new Sphere(
			SATURN_VOLUMETRIC_MEAN_RADIUS);

	/** The Constant URANUS. */
	public static final Sphere URANUS = new Sphere(
			URANUS_VOLUMETRIC_MEAN_RADIUS);

	/** The Constant NEPTUNE. */
	public static final Sphere NEPTUNE = new Sphere(
			NEPTUNE_VOLUMETRIC_MEAN_RADIUS);

	/** The Constant PLUTO. */
	public static final Sphere PLUTO = new Sphere(PLUTO_VOLUMETRIC_MEAN_RADIUS);

}
