package d

import org.junit.Test
import java.util.*
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
 * Returns the index of the last occurrence of the specified element in the list, or -1 if the specified element is not contained in the list.
 */
fun myLastIndexOf(list: List<Char>, ch: Char): Int {
    for (n in list.size - 1 downTo 0) {
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

/**
 * Returns a list that contains all elements of the given list but WITHOUT any duplication
 * examples:
 *  - [1, 1, 1] -> [1]
 *  - [2, 1, 2] -> [2, 1]
 *  - [1, 2]    -> [1, 2]
 *
 *  @param list the list of elements to remove duplications
 *  @return the elements of the given list but without duplication
 */
fun unique(list: List<Int>): List<Int> {
    val u: ArrayList<Int> = arrayListOf()
    list.forEach {
        if (!u.contains(it)) {
            u.add(it)
        }
    }
    return u
}

/**
 * Returns the maximum of the given elements
 *
 * @param list the list of elements to search in
 * @return the element that has the maximum value among list elements
 */
fun myMax(list: List<Int>): Int {
    var ma = list[0]
    list.forEach {
        if (it > ma) {
            ma = it
        }
    }
    return ma
}

/**
 * Returns the minimum of the given elements
 *
 * @param list the list of elements to search in
 * @return the element that has the minimum value among list elements
 */
fun myMin(list: List<Int>): Int {
    var mi = list[0]
    list.forEach {
        if (it < mi) {
            mi = it
        }
    }
    return mi
}

/**
 * Returns the number of times that given character is occurred in the given list.
 *
 * @param list the list of elements to search in
 * @param c the character to find its occurrence
 * @return the number of occurrence or 0 if the element is not in the list
 */
fun myCount(list: List<Char>, c: Char): Int {
    var count = 0
    list.forEach { n ->
        if (n == c) {
            count += 1
        }
    }
    return count
}

/**
 * Checks if the list is empty
 */
fun myIsEmpty(list: List<String>): Boolean = list.size == 0


/**
 * Checks if the list is NOT empty
 */
fun myIsNotEmpty(list: List<String>): Boolean = !myIsEmpty(list)

/**
 * Returns the size of the given list
 */
fun mySize(list: List<String>): Int {
    var s = 0
    list.forEach {
        s += 1
    }
    return s
}

class PracticeTest {
    val chars = listOf('a', 'b', 'c')
    val numbers = listOf(1, 5, 3, 2, 1)
    val u1 = listOf(1, 1, 1)
    val u2 = listOf(2, 1, 2)
    val u3 = listOf(1, 2)

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

    @Test
    fun testUniqueU1() {
        assertEquals(listOf(1), unique(u1))
    }

    @Test
    fun testUniqueU2() {
        assertEquals(listOf(2, 1), unique(u2))
    }

    @Test
    fun testUniqueU3() {
        assertEquals(listOf(1, 2), unique(u3))
    }

    @Test
    fun testMyMaxNumbers() {
        assertEquals(numbers.max(), myMax(numbers))
    }

    @Test
    fun testMyMaxU1() {
        assertEquals(u1.max(), myMax(u1))
    }

    @Test
    fun testMyMaxU2() {
        assertEquals(u2.max(), myMax(u2))
    }

    @Test
    fun testMyMinNumbers() {
        assertEquals(numbers.min(), myMin(numbers))
    }

    @Test
    fun testMyMinU1() {
        assertEquals(u1.min(), myMin(u1))
    }

    @Test
    fun testMyMinU2() {
        assertEquals(u2.min(), myMin(u2))
    }

    @Test
    fun testMyCount() {
        val c = listOf('a', 'b', 'a', 'a', 'c', 'c')
        assertEquals(3, myCount(c, 'a'))
        assertEquals(1, myCount(c, 'b'))
        assertEquals(2, myCount(c, 'c'))
        assertEquals(0, myCount(c, 'e'))
    }

    @Test
    fun testMyIsEmpty() {
        val e1 = listOf("Mi", "Mo", "om")
        val e2 = listOf<String>()
        assertEquals(e1.isEmpty(), myIsEmpty(e1))
        assertEquals(e2.isEmpty(), myIsEmpty(e2))
    }

    @Test
    fun testMyIsNotEmpty() {
        val e1 = listOf("Mi", "Mo", "om")
        val e2 = listOf<String>()
        assertEquals(e1.isNotEmpty(), myIsNotEmpty(e1))
        assertEquals(e2.isNotEmpty(), myIsNotEmpty(e2))
    }

    @Test
    fun testMySize() {
        val e1 = listOf("Mi", "Mo", "om")
        val e2 = listOf<String>()
        assertEquals(e1.size, mySize(e1))
        assertEquals(e2.size, mySize(e2))
    }

    @Test
    fun testMyLastIndexOf() {
        val l1 = listOf('q', 'w', 'q', 'a', 'a', 'q')
        assertEquals(l1.lastIndexOf('q'), myLastIndexOf(l1, 'q'))
        assertEquals(l1.lastIndexOf('a'), myLastIndexOf(l1, 'a'))
        assertEquals(l1.lastIndexOf('w'), myLastIndexOf(l1, 'w'))
    }
}
