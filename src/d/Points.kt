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

    override fun equals(other: Any?): Boolean{
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
}