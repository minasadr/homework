package a

import org.junit.Test
import kotlin.test.assertEquals


fun compares2(a: Array<Char>, b: Array<Char>): Int {
    val z = if (a.size > b.size) b.size else a.size
    for (n in 0..z - 1) {
        if (a[n] > b[n]) {
            return 1
        } else if (a[n] < b[n]) {
            return -1
        }
    }
    if (a.size < b.size) {
        return -1
    } else if (b.size < a.size) {
        return 1
    }
    return 0
}

class Eight2Test {
    @Test
    fun compareArrays1() {
        assertEquals(1, compares2(arrayOf('a', 'b', 'd'), arrayOf('a', 'b', 'c')))
    }

    @Test
    fun compareArrays2() {
        assertEquals(-1, compares2(arrayOf('c', 'a'), arrayOf('d')))
    }

    @Test
    fun compareArrays3() {
        assertEquals(1, compares2(arrayOf('b'), arrayOf('a', 'b', 'c', 'd', 'y')))
    }

    @Test
    fun compareArrays4() {
        assertEquals(-1, compares2(arrayOf('c', 'b', 'e'), arrayOf('c', 'b', 'e', 'a')))
    }

    @Test
    fun compareArrays5() {
        assertEquals(0, compares2(arrayOf('c', 'a', 'e'), arrayOf('c', 'a', 'e')))
    }

    @Test
    fun compareArrays6() {
        assertEquals(-1, compares2(arrayOf('e', 'a', 'd'), arrayOf('e', 'b')))
    }
}
