package a

import org.junit.Test
import kotlin.test.assertEquals

/**
 *  Created by  mina on 18.01.16.
 */

class Rectangle(w: Int, l: Int) {
    val width: Int
    val length: Int

    init {
        width = w
        length = l
    }

    fun area(): Int = 2 * (width + length)

    fun surface(): Int = width * length

    // to display the rectangle in a nice String.
    fun asString(): String = "Rectangle[width: $width, length: $length]"
}

fun area(width: Int, length: Int): Int = 2 * (width + length)

fun surface(width: Int, length: Int): Int = width * length

class SecondTest {
    @Test
    fun checkRectangleArea() {
        assertEquals(10, area(2, 3))
        assertEquals(6, area(1, 2))
        assertEquals(14, area(3, 4))
    }

    @Test
    fun checkRectangleSurface() {
        assertEquals(6, surface(2, 3))
        assertEquals(2, surface(1, 2))
        assertEquals(12, surface(3, 4))
    }

    @Test
    fun checkRectangleLengthAndWidth() {
        val r = Rectangle(2, 3)
        val x = Rectangle(3, 4)

        println("The length of r is: ${r.length}")
        println("The width of x is: ${x.width}")

        val rArea = r.area()
        println("the area of r is : $rArea")

        println("......................................")
        println(r.asString())
    }

    @Test
    fun checkRectangleAreaAgain() {
        val r = Rectangle(2, 3)
        assertEquals(10, r.area())

        assertEquals(6, Rectangle(1, 2).area())
        assertEquals(14, Rectangle(3, 4).area())
    }

    @Test
    fun checkRectangleSurfaceAgain() {
        assertEquals(6, Rectangle(2, 3).surface())
        assertEquals(2, Rectangle(1, 2).surface())
        assertEquals(12, Rectangle(3, 4).surface())
    }
}