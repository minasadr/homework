package d

import org.junit.Test
import java.util.*
import kotlin.system.measureTimeNano
import kotlin.test.assertEquals

/**
 * Gets a map and returns only the keys as a set.
 */
fun myCodesAsSet(cities: Map<String, String>): Set<String> {
//    return HashSet(cities.keys)
    val c = hashSetOf<String>()
    cities.forEach {
        c.add(it.key)
    }
    return c
}

/**
 * Gets a map and returns only the keys as a set.
 */
fun myCodesAsList(cities: Map<String, String>): List<String> {
//    return ArrayList(cities.keys)
    val c: ArrayList<String> = arrayListOf()
    cities.forEach {
        c.add(it.key)
    }
    return c
}

/**
 * Gets a map and returns only the value as a list.
 */
fun myValuesAsList(cities: Map<String, String>): List<String> {
//    return ArrayList(cities.values)
    val c: ArrayList<String> = arrayListOf()
    cities.forEach {
        c.add(it.value)
    }
    return c
}

/**
 * Gets two map and returns a single map which contains non-duplicated keys, in both maps
 */
fun findUniques(first: Map<Int, String>, second: Map<Int, String>): Map<Int, String> {
    val c = hashMapOf<Int, String>()
    first.forEach {
        if (!second.containsKey(it.key)) {
            c.put(it.key, it.value)
        }
    }
    second.forEach {
        if (!first.containsKey(it.key)) {
            c.put(it.key, it.value)
        }
    }
    return c
}

/**
 * Gets two map and returns a single map which contains duplicated keys in both maps
 */
fun findShareds(first: Map<Int, String>, second: Map<Int, String>): Map<Int, String> {
    val c = hashMapOf<Int, String>()
    first.forEach {
        if (second.containsKey(it.key)) {
            c.put(it.key, it.value)
        }
    }
    return c
}

/**
 * Gets a sorted (ascending) array and finds the given 'n' in the array.
 * @return the index of the 'n' in the array, or -1 if the element is not in the array.
 */
fun binarySearch(numbers: Array<Int>, n: Int): Int {
    var first = 0
    var second = numbers.size
    while (first < second) {
        var middle = first + (second - first) / 2

        if (n > numbers[middle]) {
            first = middle
        } else if (n < numbers[middle]) {
            second = middle
        } else {
            return middle
        }
    }
    return -1
}

fun search(numbers: Array<Int>, n: Int): Int {
    for (i in 0..numbers.size - 1) {
        if (numbers[i] == n) {
            return i
        }
    }
    return -1
}

class MoreMapPracticesTest {
    @Test
    fun testMyCodesAsSet() {
        val c = mapOf("Ir" to "Iran", "Ca" to "Canada", "Fr" to "France")
        assertEquals(setOf("Ir", "Ca", "Fr"), myCodesAsSet(c))
    }

    @Test
    fun testMyCodesAsList() {
        val c = mapOf("Ir" to "Iran", "Ca" to "Canada", "Fr" to "France")
        assertEquals(listOf("Ir", "Ca", "Fr"), myCodesAsList(c))
    }

    @Test
    fun testMyValuesAsList() {
        val c = mapOf("Ir" to "Iran", "Ca" to "Canada", "Fr" to "France")
        assertEquals(listOf("Iran", "Canada", "France"), myValuesAsList(c))
    }

    @Test
    fun testFindUniques() {
        val c = mapOf(4 to "Mina", 1 to "Mohammad", 2 to "Fancy")
        val d = mapOf(4 to "Mina", 3 to "Omid")
        assertEquals(mapOf(1 to "Mohammad", 2 to "Fancy", 3 to "Omid"), findUniques(c, d))
    }

    @Test
    fun testFindShareds() {
        val c = mapOf(4 to "Mina", 1 to "Mohammad", 2 to "Fancy")
        val d = mapOf(4 to "Mina", 3 to "Omid")
        assertEquals(mapOf(4 to "Mina"), findShareds(c, d))
    }

    @Test
    fun testBinarySearch() {
        val c = arrayOf(3, 4, 5, 6, 7, 8)
        assertEquals(1, binarySearch(c, 4))
    }

    @Test
    fun testBinarySearch1() {
        val c = arrayOf(2)
        assertEquals(0, binarySearch(c, 2))
    }

    @Test
    fun testBinarySearch2() {
        val c = arrayOf<Int>()
        assertEquals(-1, binarySearch(c, 4))
    }

    @Test
    fun testBinarySearch3() {
        val c = arrayOf(3, 4, 5, 6, 7, 8)
        assertEquals(-1, binarySearch(c, 1))
    }

    @Test
    fun testSearch() {
        val c = arrayOf(3, 4, 5, 6, 7, 8)
        assertEquals(1, search(c, 4))
    }

    @Test
    fun testSearch1() {
        val c = arrayOf(2)
        assertEquals(0, search(c, 2))
    }

    @Test
    fun testSearch2() {
        val c = arrayOf<Int>()
        assertEquals(-1, search(c, 4))
    }


    @Test
    fun testSearch3() {
        val c = arrayOf(3, 4, 5, 6, 7, 8)
        assertEquals(-1, search(c, 1))
    }

    @Test
    fun testTime() {
        val m = 2000
        val array = Array(m, { it })

        val n = 10
        val bt = measureTimeNano {
            for (i in 0..n) {
                binarySearch(array, m - 1)
            }
        }

        val st = measureTimeNano {
            for (i in 0..n) {
                search(array, m - 1)
            }
        }

        println("Binary Search: ${bt / 1000000.0}")
        println("Normal Search: ${st / 1000000.0}")
    }
}
