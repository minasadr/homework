package d

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/*
// Step 1
class Point1(x: Int, y: Int) {
    val x: Int
    val y: Int

    init {
        this.x = x
        this.y = y
    }
}

// Step 2
class Point2(x: Int, y: Int) {
    val x: Int = x
    val y: Int = y
}
*/

class Point(val x: Int, val y: Int) {

    /**
     * Calculates the distance of the current point from the given point
     */
    //    fun distance(point: Point): Double = Math.sqrt((x - point.x) * (x - point.x) + 0.0 + (y - point.y) * (y - point.y))
    fun distance(point: Point): Double = Math.sqrt(Math.pow (x - point.x + 0.0, 2.0) + Math.pow (y - point.y + 0.0, 2.0))

    /**
     * Returns a new Point, which is the addition of the current point with the given point.
     */
    fun add(point: Point): Point = Point(x + point.x, y + point.y)

    /**
     * Checks if the current point is among the given array of points.
     *
     * @return true if the current point is among the given array of points, otherwise false
     */
    fun includedIn(points: Array<Point>): Boolean {
        for (n in points) {
            if (this == n)
                return true
        }
        return false
    }

    /**
     * Finds the index of the current point in the given array of points.
     * @param points the given array to search in
     * @return the index of the current point in the given array, or -1 if the current point is not among the given points
     */
    fun indexIn(points: Array<Point>): Int {
        for (n in 0..points.size - 1) {
            if (this == points[n]) {
                return n
            }
        }
        return -1
    }

    /**
     * Finds the distance between current point to the given points and finds the one that is the closest to the current point.
     *
     * @return the closest point to the current point
     */
    fun closest(a: Point, b: Point): Point = if (distance(a) < distance(b)) a else b

    /**
     * Finds the point among the given array of points with closest distance to the current point
     *
     * @return the closest point to the current point
     */
    fun closest(points: Array<Point>): Point {
        var m = points[0]
        var dis = distance(m)
        for (n in 1..points.size - 1) {
            val d = distance(points[n])
            if (d < dis ) {
                dis = d
                m = points[n]
            }
        }
        return m
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != this.javaClass) return false

        other as Point

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int = 31 * x + 17 * y

    override fun toString(): String = "Point[$x, $y]"
}


class PointsTest {

    @Test
    fun testToString() {
        val x = 10
        val y = 25
        val p = Point(x, y)

        assertEquals("Point[$x, $y]", p.toString())
    }

    @Test
    fun testIdentity() {
        val p1 = Point(1, 1)
        val p2 = p1

        // identity : p1 and p2 are pointing to exactly same instance of a Point.
        assertTrue(p1 === p2)
        // by default (defined in Any class) two objects are equal only if they are pointing to the same instance.
        assertTrue(p1 == p2)
        assertTrue(p1.equals(p2))
    }

    @Test
    fun testEquality() {
        val p1 = Point(1, 1)
        val p3 = Point(1, 1)

        assertTrue(p1 == p3)
        // is the same as
        assertTrue(p1.equals(p3))

        assertFalse(p1 === p3)
    }

    @Test
    fun testDistance() {
        val first = Point(0, 0)
        val second = Point(0, 10)
        val third = Point(10, 0)
        val forth = Point(10, 10)

        assertEquals(10.0, first.distance(second))
        assertEquals(10.0, first.distance(third))
        assertEquals(14.142135623730951, first.distance(forth))
    }

    @Test
    fun testAdd() {
        assertEquals(Point(0, 0), Point(1, 1).add(Point(-1, -1)))

        val p1 = Point(3, 5)
        val p2 = Point(7, 10)

        assertEquals(Point(10, 15), p1.add(p2))
    }

    @Test
    fun testIncludedIn() {
        val p = arrayOf(Point(2, 3), Point(1, 2))
        val p2 = Point(2, 3)
        assertTrue(p2.includedIn(p))
    }

    @Test
    fun testIncludedInNotFound() {
        assertFalse(Point(0, 3).includedIn(arrayOf(Point(2, 3), Point(1, 2))))
    }

    @Test
    fun testIndexIn() {
        val p = arrayOf(Point(2, 3), Point(1, 2))
        val p2 = Point(2, 3)
        val p3 = Point(1, 2)
        val p4 = Point(0, 2)
        assertEquals(0, p2.indexIn(p))
        assertEquals(1, p3.indexIn(p))
        assertEquals(-1, p4.indexIn(p))
    }


    @Test
    fun testClosest() {
        val p = Point(2, 3)
        val p1 = Point(1, 2)
        val p2 = Point(0, 2)
        assertEquals(1.4142135623730951, p.distance(p1))
        assertEquals(2.23606797749979, p.distance(p2))
        assertEquals(Point(1, 2), p.closest(p1, p2))
    }

    @Test
    fun testClosestArray() {
        val p = Point(2, 3)
        val p1 = arrayOf(Point(1, 2), Point(0, 2))
        assertEquals(Point(1, 2), p.closest(p1))
    }
}