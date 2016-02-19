package a

import org.junit.Test
import kotlin.test.assertEquals

/**
 * - Define a class called "MyPoint" which has  "x" and "y" as cordinates of a point in the page.
 * - Define a class called "MyRect" which is a rectangle and it uses two points (of type MyPoint) to
 * represent the position.
 *     the first point is the top-left corner and the second point is the bottom-right.
 * - In the MyRect class, define two method (area and surface) to calculate the area and surface of the current
 * rectangle.
 * - Above functions (area and surface) should have automated tests to prove that calculation is correct.*
 */

class MyPoint(val x: Int, val y: Int) {

    override fun toString(): String = "${this.x}, ${this.y}"
    fun asString(): String = "${this.x}, ${this.y}"
}


class MyRect(val topLeft: MyPoint, val bottomRight: MyPoint) {

    override fun toString(): String = "$topLeft, $bottomRight" //????
    fun asString(): String = "$topLeft, $bottomRight" //????

    private fun length(): Int = if (topLeft.x > bottomRight.x) topLeft.x - bottomRight.x else bottomRight.x - topLeft.x

    private fun width(): Int = if ( bottomRight.y > topLeft.y ) bottomRight.y - topLeft.y else topLeft.y - bottomRight.y

    fun area(): Int {
        return (length() + width()) * 2
    }

    fun surface(): Int {
        return width() * length()
    }
}

class ForthTest {
    @Test
    fun myPoint() {
        val z = MyPoint(4, 2)
        assertEquals("4, 2", z.toString())
    }

    @Test
    fun myRec() {
        val z = MyRect(MyPoint(4, 0), MyPoint(0, 4))
        assertEquals("4, 0, 0, 4", z.toString())
    }

    @Test
    fun myRecArea() {
        val z = MyRect(MyPoint(3, 0), MyPoint(0, 3))
        assertEquals(12, z.area())
    }

    @Test
    fun myRecArea2() {
        val z = MyRect(MyPoint(0, 3), MyPoint(4, 0))
        assertEquals(14, z.area())
    }

    @Test
    fun myRecSurface() {
        val z = MyRect(MyPoint(0, 3), MyPoint(4, 0))
        assertEquals(12, z.surface())
    }
}