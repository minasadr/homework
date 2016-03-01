package f

import org.junit.Test
import kotlin.test.assertEquals

/**
 * write a class called: Rectangle
 * it has following properties:
 *  - width: Int
 *  - length: Int
 *
 * and following functions:
 *  - area(): Int  returns the are of the rectangle
 *  - surface(): Int returns the surface of the rectangle
 *
 *  Define a class called Square that extends the Rectangle
 *
 *  Don't forget to write test for both classes.
 */
abstract class Shape() {

    init {
        println("Creating a Shape")
    }

    abstract fun area(): Int

    abstract fun surface(): Int

    override fun toString(): String = "Shape"
}

open class Rectangle(val width: Int, val length: Int) : Shape() {
    init {
        println("Creating a Rectangle")
    }

    override fun area(): Int = (width + length) * 2

    override fun surface(): Int = length * width
}

class Square(width: Int) : Rectangle(width, width) {
    init {
        println("Creating a Square")
    }
}


class RectangleTest {
    @Test
    fun testRectangleArea() {
        val r = Rectangle(10, 12)
        assertEquals(44, r.area())
    }

    @Test
    fun testRectangleSurface() {
        val r = Rectangle(10, 12)
        assertEquals(120, r.surface())
    }

    @Test
    fun testSquareArea() {
        val r = Square(5)
        assertEquals(20, r.area())
    }

    @Test
    fun testSquareSurface() {
        val r = Square(5)
        assertEquals(25, r.surface())
    }
}

fun main(args: Array<String>) {
    val r = Rectangle(3, 5)
    println("width is equal to ${r.width} and length is equal to ${r.length}")
    println("................................")
    val s = Square(3)
    println("width is equal to ${s.width} and length is equal to ${s.length}")
}
