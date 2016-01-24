package a

import org.junit.Test
import kotlin.test.assertEquals

/**
 * A function that takes TWO arrays of Integer, compares them and then returns:
 *  -  1, if the first array is greater than second one
 *  - -1, if the second array is greater tan first one
 *  -  0, if both arrays are the same.
 * How to Compare?
 *  Starting from index 0, compare the elements of both array in the same positions until you find one is bigger than the other.
 * Examples:
 *    - [1, 2, 3]  is bigger than [1, 2, 0]     then: return 1
 *    - [3, 1] is smaller than [4]             then: return -1
 *    - [2] is bigger than [1, 2, 3, 4, 16]     then: return 1
 *    - [3, 2, 5]  is smaller than [3, 2, 5, 0] then: return -1
 *    - [3, 1, 5] is equal to [3, 1, 5]         then: return 0
 */
fun compares(a: Array<Int>, b: Array<Int>): Int {
    val z = if (a.size > b.size) b.size else a.size

    //iterate - iteration - iterator - iterable
    for (n in 0..z - 1) {
        if (a[n] > b[n]) {
            return 1
        } else if (a[n] < b[n]) {
            return -1
        }
    }

    return when {
        a.size < b.size -> -1
        b.size < a.size -> 1
        else -> 0
    }
}

class EightTest {
    @Test
    fun compareArrays1() {
        assertEquals(1, compares(arrayOf(1, 2, 3), arrayOf(1, 2, 0)))
    }

    @Test
    fun compareArrays2() {
        assertEquals(-1, compares(arrayOf(3, 1), arrayOf(4)))
        assertEquals(1, compares(arrayOf(2), arrayOf(1, 2, 3, 4, 16)))
    }

    @Test
    fun compareArrays3() {
        assertEquals(1, compares(arrayOf(2), arrayOf(1, 2, 3, 4, 16)))
    }

    @Test
    fun compareArrays4() {
        assertEquals(-1, compares(arrayOf(3, 2, 5), arrayOf(3, 2, 5, 0)))
    }

    @Test
    fun compareArrays5() {
        assertEquals(0, compares(arrayOf(3, 1, 5), arrayOf(3, 1, 5)))
    }

    @Test
    fun compareArrays6() {
        assertEquals(-1, compares(arrayOf(5, 1, 4), arrayOf(5, 2)))
    }

    @Test
    fun x() {
        val b = true
        val x = if (b) {
            println("asfdfd")
            println("asfdfd")
            println("asfdfd")
            1
        } else {
            println("asfdfd")
            println("asfdfd")
            2
        }
    }
}
