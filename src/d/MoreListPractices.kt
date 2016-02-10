package d

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Returns a new list which has all the elements of the given list in the reverse order.
 * Examples:
 *      - ['1', '2', '3'] -> ['3', '2', '1']
 *      - ['1']       -> ['1']
 */
fun myAsReversed(list: List<Int>): List<Int> {
    val result = arrayListOf<Int>()
    for (n in list.size - 1 downTo 0) {
        result.add(list[n])
    }
    return result
}

/**
 * Returns a new list which has the elements of both list.
 *      - [1, 2], [3, 4]   -> [1, 2, 3, 4]
 *      - [5, 2], [3]      -> [5, 2, 3]
 *      - [1, 3], [4, 3]   -> [1, 3, 4, 3]
 */
fun myPlus(first: List<Int>, second: List<Int>): List<Int> {
    val result = arrayListOf<Int>()
    for (n in first) {
        result.add(n)
    }
    for (m in second) {
        result.add(m)
    }
    return result
}

/**
 * Returns a new list which contains only the elements of the original list from index <from> to index <to>.
 *  - from is inclusive
 *  - to is exclusive
 *
 *  Examples:
 *      - [1.0, 2.0, 3.0], 0, 2  -> [1.0, 2.0]
 *      - [1.0, 2.0, 3.0], 1, 2  -> [2.0]
 *      - [1.0, 2.0, 3.0], 1, 3  -> [2.0, 3.0]
 */
fun mySubList(list: List<Double>, fromIndex: Int, toIndex: Int): List<Double> {
    val result = arrayListOf<Double>()
    for (n in fromIndex..toIndex - 1) {
        result.add(list[n])
    }
    return result
}

class testMoreList {

    @Test
    fun testMyAsReversed() {
        val r1 = listOf(1, 2, 3)
        val r2 = listOf(1)
        assertEquals(r1.asReversed(), myAsReversed(r1))
        assertEquals(r2.asReversed(), myAsReversed(r2))
    }

    @Test
    fun testMyPlus() {
        val p1 = listOf(1, 2)
        val p2 = listOf(3, 4)
        val p3 = listOf(5, 2)
        val p4 = listOf(3)
        val p5 = listOf(1, 3)
        val p6 = listOf(4, 3)

        assertEquals(p1.plus(p2), myPlus(p1, p2))
        assertEquals(p3.plus(p4), myPlus(p3, p4))
        assertEquals(p5.plus(p6), myPlus(p5, p6))
    }

    @Test
    fun testMySubList() {
        val s1 = listOf(1.0, 2.0, 3.0)
        val s2 = listOf(1.0, 2.0, 3.0)
        val s3 = listOf(1.0, 2.0, 3.0)

        assertEquals(s1.subList(0, 2), mySubList(s1, 0, 2))
        assertEquals(s2.subList(1, 2), mySubList(s2, 1, 2))
        assertEquals(s3.subList(1, 3), mySubList(s3, 1, 3))
    }

    @Test
    fun testAlaki() {
        val a = arrayOf(2, 3, 4)
        val b = arrayOf(2, 3, 4)
        val c = listOf(2, 3, 4)
        val d = listOf(2, 3, 4)
        println("a = $a")  // toString is NOT implemented
        println("b = $b")  // toString is NOT implemented
        println("c = $c")  // toString is implemented
        println("d = $d")  // toString is implemented
        println(a == b)    // equals and hashcode are NOT implemented
        println(c == d)    // equals and hashcode are implemented
    }
}