package b

import org.junit.Test
import kotlin.test.assertEquals


fun arrange(a: Array<Int>, b: Array<Int>): Array<Int> {
    val c = Array(a.size + b.size, { 0 })
    var posA = 0
    var posB = 0
    var posC = 0
    while (posA < a.size && posB < b.size) {
        if (a[posA] < b[posB]) {
            c[posC] = a[posA]
            posA += 1
        } else {
            c[posC] = b[posB]
            posB += 1
        }
        posC += 1
    }
    if (posA < a.size) {
        for (n in posA..a.size - 1) {
            c[posC] = a[n]
            posC += 1
        }
    }
    if (posB < b.size) {
        for (n in posB..b.size - 1) {
            c[posC] = b[n]
            posC += 1
        }
    }
    return c
}

class SeventhTest {
    @Test
    fun arrangeArray() {
        val z = arrange(arrayOf(2, 3, 4), arrayOf(6))
        assertEquals(4, z.size)
        assertEquals(2, z[0])
        assertEquals(3, z[1])
        assertEquals(4, z[2])
        assertEquals(6, z[3])
    }

    @Test
    fun arrangeArray1() {
        val z = arrange(arrayOf(1, 4, 7), arrayOf(2, 3, 8, 9, 9))
        assertEquals(8, z.size)
        assertEquals(1, z[0])
        assertEquals(2, z[1])
        assertEquals(3, z[2])
        assertEquals(4, z[3])
        assertEquals(7, z[4])
        assertEquals(8, z[5])
        assertEquals(9, z[6])
        assertEquals(9, z[7])
    }
}