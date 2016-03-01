package g

import org.junit.Test
import kotlin.test.assertEquals

abstract class Shape() {
    abstract fun surface(): Double

    abstract fun area(): Double
}

class Circle(val radios: Int) : Shape() {
    private val pi = 3.14

    override fun surface(): Double {
        return radios * radios * pi
    }

    override fun area(): Double {
        return radios * 2 * pi
    }

    override fun toString() = "Circle [r: $radios]"
}

class Triangle(val height: Int, val base: Int, val side: Int) : Shape() {
    override fun surface(): Double {
        return height * base / 2.0
    }

    override fun area(): Double {
        return height + base + side.toDouble()
    }

    override fun toString() = "Triangle [h: $height, b: $base, s: $side]"

}

open class Rectangle(val width: Int, val length: Int) : Shape() {
    override fun surface(): Double {
        return width * length.toDouble()
    }

    override fun area(): Double {
        return 2.0 * (width + length)
    }

    override fun toString() = "Rectangle [w: $width, l: $length]"
}

class Square(length: Int) : Rectangle(length, length) {
    override fun surface(): Double {
        return length * length.toDouble()
    }

    override fun area(): Double {
        return length * 4.0
    }

    override fun toString() = "Square [l: $length]"
}

fun maxArea(shapes: List<Shape>): Shape {
    var m = shapes[0].area()
    var sh = shapes[0]
    for (n in 1..shapes.size - 1) {
        if (shapes[n].area() > m) {
            m = shapes[n].area()
            sh = shapes[n]
        }
    }
    return sh
}

fun minSurface(shapes: List<Shape>): Shape {
    var mi = shapes[0].surface()
    var sh = shapes[0]
    for (n in shapes) {
        if (n.surface() < mi) {
            mi = n.surface()
            sh = n
        }
    }
    return sh
}

fun sortArea(shapes: Array<Shape>) {
    for (n in 0..shapes.size - 2) {
        for (m in n + 1..shapes.size - 1) {
            if (shapes[m].area() < shapes[n].area()) {
                val exchange = shapes[m]
                shapes[m] = shapes[n]
                shapes[n] = exchange
            }
        }
    }
}

fun sortSurface(shapes: Array<Shape>) {
    for (n in 0..shapes.size - 2) {
        for (m in n + 1..shapes.size - 1) {
            if (shapes[m].surface() < shapes[n].surface()) {
                val exchange = shapes[m]
                shapes[m] = shapes[n]
                shapes[n] = exchange
            }
        }
    }
}


class ShapeTest() {
    @Test
    fun circleTest() {
        val r = Circle(3)
        assertEquals(28.26, r.surface())
        assertEquals(18.84, r.area())
    }

    @Test
    fun triangleTest() {
        val t = Triangle(3, 2, 4)
        assertEquals(3.0, t.surface())
        assertEquals(9.0, t.area())
    }

    @Test
    fun rectangleTest() {
        val r = Rectangle(3, 4)
        assertEquals(12.0, r.surface())
        assertEquals(14.0, r.area())
    }

    @Test
    fun squareTest() {
        val s = Rectangle(3, 3)
        assertEquals(9.0, s.surface())
        assertEquals(12.0, s.area())

        val ss = Square(2)
        assertEquals(4.0, ss.surface())
        assertEquals(8.0, ss.area())
    }

    @Test
    fun maxAreaTest() {
        val circle = Circle(3)
        val m = listOf(circle, Triangle(3, 2, 4), Rectangle(3, 4), Square(2))
        val max = maxArea(m)
        assertEquals(circle, max)
    }

    @Test
    fun minSurfaceTest() {
        val triangle = Triangle(3, 2, 4)
        val m = listOf(Circle(3), triangle, Rectangle(3, 4), Square(2))
        val min = minSurface(m)
        assertEquals(triangle, min)
    }

    @Test
    fun sortAreaTest() {
        val t = Triangle(3, 2, 4)
        val c = Circle(3)
        val r = Rectangle(3, 4)
        val s = Square(2)
        val sort = sortArea(arrayOf(t, s, r, c))
        assertEquals(sort, sortArea(arrayOf(t, c, r, s)))
    }

    @Test
    fun sortSurfaceTest() {
        val t = Triangle(3, 2, 4)
        val c = Circle(3)
        val r = Rectangle(3, 4)
        val s = Square(2)
        val sort = sortArea(arrayOf(t, s, r, c))
        assertEquals(sort, sortSurface(arrayOf(t, c, r, s)))
    }
}