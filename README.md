# README #

**human-geo** is a Java 1.6 project that tries to simplify the development of Geographic Information Systems, offering only the core concepts in an easy to understand API and trying to use class and method names that follow the naming principles of college level geometry and geodesy instead of introducing many abstraction layers.

It offers:

- Coordinate Systems
	- Support for Cartesian (2d, 3d), Polar, Cylindrical, Spherical, Spheroidal Coordinate Systems
	- Transformations between (most of) them
- Distances. Multiple algorithm variants depending on coordinate system and need for accuracy and speed
	- compute distances between two points (reverse geodetic problem)
	- compute distances between a point and a geodesic (the shortest line) between two points (cross track distance)
	- compute distance to the interception point of a point and a geodesic (along track distance)
	- compute coordinate of the interception point of a point and a geodesic
	- compute coordinate of the intersection point of two geodesics 
	- compute bearings of incoming and outgoing lines
	- compute coordinate of point in a specific distance in a specific bearing (forward geodetic problem)
- Helper
	- parse and format geographic coordinates
	- permutate three dimensional arrays
	- builder for spheroids
	- reference spheres and ellipsoids

It lacks:

- Projections. Although it offers coordinate systems and algorithms fpr each coordinate system and ways to transform between coordinate systems.


The library is in its early stages. If you find errors or think the API should be changed pleae open an issue or even better fork the project and create a pull request.