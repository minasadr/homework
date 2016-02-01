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
class MySetGeneric<T> {
    /**
     * This property shows the number of elements that are currently available in the Set.
     */
    var size: Int = 0
    val elements: Array<T> = Array<Any>(10, { "" }) as Array<T>

    /**
     * Checks if the Set is empty.
     *
     * @return true if the Set is empty, false otherwise
     */
    fun isEmpty(): Boolean = size == 0

    /**
     * Checks if the given element is available in the Set.
     *
     * @return true if the given element is available in the Set, false otherwise
     */
    fun contains(i: T): Boolean = indexOf(i) != -1

    /**
     * Adds a new element to the Set.
     *
     * @return true if the element was not already in the Set, false otherwise
     */
    fun add(i: T): Boolean {
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
    fun remove(i: T): Boolean {
        val index = indexOf(i)
        if (index != -1) {
            elements[index] = elements[size - 1]
            size -= 1
            return true
        }
        return false
    }

    private fun indexOf(i: T): Int {
        for (n in 0..size - 1) {
            if (i == elements[n]) {
                return n
            }
        }
        return -1
    }
}

class MySetGenericTest {
    @Test
    fun isEmpty() {
        val z = MySetGeneric<Int>()
        assertTrue(z.isEmpty())
    }

    @Test
    fun contains() {
        val z = MySetGeneric<Int>()
        assertFalse(z.contains(2))
    }

    @Test
    fun add1() {
        val z = MySetGeneric<Char>()
        assertTrue(z.add('c'))
        assertTrue(z.contains('c'))
        assertFalse(z.add('c'))
        assertFalse(z.isEmpty())
        assertTrue(z.remove('c'))
    }

    @Test
    fun add2() {
        val z = MySetGeneric<Boolean>()
        assertTrue(z.add(true))
        assertTrue(z.add(false))
        assertFalse(z.add(false))
    }

    @Test
    fun add3() {
        val z = MySetGeneric<String>()
        assertTrue(z.add("Mina"))
        assertTrue(z.add("Mohammad"))
        assertTrue(z.add("Omid -e- baba"))
        assertEquals(3, z.size)
    }
}