package b

import org.junit.Test
import kotlin.test.assertEquals

fun suzammen(a: Array<Int>, b: Array<Int>): Array<Int> {
    val n = Array(a.size + b.size, { 0 })
    for (e in 0..a.size - 1) {
        n[e] = a[e]
    }
    for (e in 0..b.size - 1) {
        n[e + a.size] = b[e]
    }
    return n
}

class SixthTest {
    @Test
    fun suzam1() {
        val z = suzammen(arrayOf(2, 4), arrayOf(6))
        assertEquals(3, z.size)
        assertEquals(2, z[0])
        assertEquals(4, z[1])
        assertEquals(6, z[2])
    }

    @Test
    fun suzam2() {
        val z = suzammen(arrayOf(2, 3, 1), arrayOf(7, 8))
        assertEquals(5, z.size)
        assertEquals(2, z[0])
        assertEquals(3, z[1])
        assertEquals(1, z[2])
        assertEquals(7, z[3])
        assertEquals(8, z[4])
    }
}

