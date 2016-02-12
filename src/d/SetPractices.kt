package d

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Returns a set of unique elements in the list
 */
fun removeDuplicates(list: List<Int>): Set<Int> {
    val result = hashSetOf<Int>()
    list.forEach { result.add (it) }
    return result
}

/**
 * Verifies if given character is available in the given set.
 */
fun myContains(set: Set<Char>, ch: Char): Boolean {
    set.forEach {
        if (ch == it) {
            return true
        }
    }
    return false
}

/**
 * Verifies if the given sets (a and b) are equal or not.
 */
/*fun myEquals(a: Set<Int>, b: Set<Int>): Boolean {
    if (a.size != b.size) {
        return false
    }
    for (n in a) {
        var found = false
        for (m in b) {
            if (n == m) {
                found = true
                break
            }
        }
        if (!found) {
            return false
        }
    }
    return true
}
*/

fun myEquals(a: Set<Int>, b: Set<Int>): Boolean {
    if (a.size != b.size) {
        return false
    }
    a.forEach {
        if (!b.contains(it)) {
            return false
        }
    }
    return true
}

/**
 * Returns the average of elements in the given set.
 */
fun myAverage(set: Set<Int>): Double {
    var sum = 0.0
    set.forEach { sum += it }
    return sum / set.size
}


class testPractice {
    @Test
    fun testRemoveDuplicates() {
        val r = arrayListOf(2, 3, 1, 2, 3, 5, 7, 1)
        assertEquals(setOf(2, 3, 1, 5, 7), removeDuplicates(r))
    }

    @Test
    fun testRemoveDuplicates1() {
        val r = arrayListOf(2, 2, 2, 2)
        assertEquals(setOf(2), removeDuplicates(r))
    }

    @Test
    fun testMyContains() {
        val r = setOf('a', 'b', 'c')
        assertEquals(r.contains('b'), myContains(r, 'b'))
    }

    @Test
    fun testMyContains1() {
        val r = setOf('a', 'b', 'c')
        assertEquals(r.contains('d'), myContains(r, 'd'))
    }

    @Test
    fun testMyEquals() {
        val r1 = setOf(1, 2, 3)
        val r2 = setOf(2, 1, 3)
        assertEquals(r1.equals(r2), myEquals(r1, r2))
    }

    @Test
    fun testMyEquals1() {
        val r1 = setOf(1, 2, 3)
        val r2 = setOf(1, 2)
        assertEquals(r1.equals(r2), myEquals(r1, r2))
    }

    @Test
    fun testMyEquals2() {
        val r1 = setOf(1, 2, 3)
        val r2 = setOf(1, 2, 3, 4)
        assertEquals(r1.equals(r2), myEquals(r1, r2))
    }


    @Test
    fun testMyAverage() {
        val r1 = setOf(1, 2, 3)
        val r2 = setOf(1, 2, 3, 4)
        assertEquals(r1.average(), myAverage(r1))
        assertEquals(r2.average(), myAverage(r2))
    }
}