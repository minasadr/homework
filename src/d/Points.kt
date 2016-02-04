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
    fun distance(point: Point): Double = Math.sqrt((x - point.x) * (x - point.x) + 0.0 + (y - point.y) * (y - point.y))

    /**
     * Returns a new Point, which is the addition of the current point with the given point.
     */
    fun add(point: Point): Point = Point(x + point.x, y + point.y)

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
        // is the same as
        assertFalse(p1.identityEquals(p3))
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

}