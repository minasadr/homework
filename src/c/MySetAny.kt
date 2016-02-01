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
class MySetAny {
    /**
     * This property shows the number of elements that are currently available in the Set.
     */
    var size: Int = 0
    val elements: Array<Any> = Array(10, { false })


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
    fun contains(i: Any): Boolean = indexOf(i) != -1

    /**
     * Adds a new element to the Set.
     *
     * @return true if the element was not already in the Set, false otherwise
     */
    fun add(i: Any): Boolean {
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
    fun remove(i: Any): Boolean {
        val index = indexOf(i)
        if (index != -1) {
            elements[index] = elements[size - 1]
            size -= 1
            return true
        }
        return false
    }

    private fun indexOf(i: Any): Int {
        for (n in 0..size - 1) {
            if (i == elements[n]) {
                return n
            }
        }
        return -1
    }
}

class MySetAnyTest {
    @Test
    fun isEmpty() {
        val z = MySetAny()
        assertTrue(z.isEmpty())
    }

    @Test
    fun contains() {
        val z = MySetAny()
        assertFalse(z.contains(2))
        assertFalse(z.contains(false))
        assertFalse(z.contains("Mina"))
        assertFalse(z.contains(12.5))
        assertFalse(z.contains('a'))
    }

    @Test
    fun add1() {
        val z = MySetAny()
        assertFalse(z.contains(0))
        assertTrue(z.add(1))
        assertTrue(z.contains(1))
        assertTrue(z.add('c'))
        assertTrue(z.contains('c'))
        assertTrue(z.remove(1))
        assertFalse(z.add('c'))
        assertFalse(z.isEmpty())
        assertFalse(z.contains("Mina"))
        assertTrue(z.remove('c'))
        assertFalse(z.remove("Ok"))
    }

    @Test
    fun add2() {
        val z = MySetAny()
        assertTrue(z.add(1))
        assertTrue(z.contains(1))
        assertTrue(z.add(2))
        assertTrue(z.contains(2))
        assertTrue(z.remove(1))
        assertTrue(z.add(true))
        assertTrue(z.add(false))
        assertFalse(z.add(false))
        assertTrue(z.contains(2))
    }

    @Test
    fun add3() {
        val z = MySetAny()
        assertTrue(z.add(2))
        assertTrue(z.add("Omidi"))
        assertEquals(2, z.size)
    }
}