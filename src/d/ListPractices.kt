package d

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Returns the index of the first occurrence of the specified element in the list, or -1 if the specified element is not contained in the list.
 */
fun myIndexOf(list: List<Char>, ch: Char): Int {
    for (n in 0..list.size - 1) {
        if (list[n] == ch) {
            return n
        }
    }
    return -1
}

/**
 * Returns true if the specified element is in the list, or false if the specified element is not contained in the list.
 */
fun myContains(list: List<Char>, ch: Char): Boolean {
    for (n in list) {
        if (n == ch) {
            return true
        }
    }
    return false
}

/**
 * Returns that sum of integer elements in the given list.
 */
fun mySum(list: List<Int>): Int {
    var b = 0
    list.forEach { n -> b += n }
//    for (n in list) {
//        b += n
//    }
    return b
}

class PracticeTest {
    val chars = listOf('a', 'b', 'c')
    val numbers = listOf(1, 5, 3, 2, 1)

    @Test
    fun testIndexOf() {
        assertEquals(chars.indexOf('a'), myIndexOf(chars, 'a'))
    }

    @Test
    fun testIndexOfAgain() {
        assertEquals(chars.indexOf('b'), myIndexOf(chars, 'b'))
    }

    @Test
    fun testIndexOfNotFound() {
        assertEquals(chars.indexOf('e'), myIndexOf(chars, 'e'))
    }

    @Test
    fun testContains() {
        assertEquals(chars.contains('a'), myContains(chars, 'a'))
    }

    @Test
    fun testContainsAgain() {
        assertEquals(chars.contains('c'), myContains(chars, 'c'))
    }

    @Test
    fun testContainsNotFound() {
        assertEquals(chars.contains('e'), myContains(chars, 'e'))
    }

    @Test
    fun testSum() {
        assertEquals(numbers.sum(), mySum(numbers))
    }
}