package c

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * A Set is a data structure that contains multiple (zero or more) elements.
 *    - The elements in the Set are unique. (no duplication)
 *    - The elements in the Set are not kept in given order. (unordered)
 */
class MySet {
    /**
     * This property shows the number of elements that are currently available in the Set.
     */
    var size: Int = 0
    val elements = Array(10, { 0 })


    /**
     * Checks if the Set is empty.
     *
     * @return true if the Set is empty, false otherwise
     */
    fun isEmpty(): Boolean = size == 0

    /**
     * Checks if the given integer is available in the Set.
     *
     * @return true if the given element is available in the Set, false otherwise
     */
    fun contains(i: Int): Boolean = indexOf(i) != -1

    /**
     * Adds a new element to the Set.
     *
     * @return true if the element was not already in the Set, false otherwise
     */
    fun add(i: Int): Boolean {
        if (!contains(i)) {
            elements [size] = i
            size += 1
            return true
        }
        return false
    }

    /**
     * Removes the given element from the Set.
     *
     * @return true if the elements was in the Set, false otherwise
     */
    fun remove(i: Int): Boolean {
        val index = indexOf(i)
        if (index != -1) {
            elements[index] = elements[size - 1]
            size -= 1
            return true
        }
        return false
    }

    private fun indexOf(i: Int): Int {
        for (n in 0..size - 1) {
            if (i == elements[n]) {
                return n
            }
        }
        return -1
    }
}

class MySetTest {
    @Test
    fun isEmpty1() {
        val z = MySet()
        assertTrue(z.isEmpty())
    }

    @Test
    fun contains1() {
        val z = MySet()
        assertFalse(z.contains(2))
    }

    @Test
    fun add1() {
        val z = MySet()
        assertFalse(z.contains(0))
        assertTrue(z.add(1))
        assertTrue(z.contains(1))
        assertTrue(z.add(2))
        assertTrue(z.contains(2))
        assertTrue(z.remove(1))
        assertFalse(z.add(2))
        assertFalse(z.isEmpty())
        assertFalse(z.contains(3))
        assertTrue(z.remove(2))
        assertFalse(z.remove(3))
    }

    @Test
    fun add2() {
        val z = MySet()
        assertTrue(z.add(1))
        assertTrue(z.contains(1))
        assertTrue(z.add(2))
        assertTrue(z.contains(2))
        assertTrue(z.remove(1))
        assertTrue(z.add(3))
        assertTrue(z.contains(2))
    }

    @Test
    fun add3() {
        val z = MySet()
        assertTrue(z.add(2))
        assertEquals(1, z.size)
    }
}