package d

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/**
 * Finds the phone code of the given country.
 *
 * @param codes the map of codes to countries
 * @param country the country to find its code
 * @return the phone code of the given country
 * @throws IllegalArgumentException if the country is not in the map
 *
 * Example: {45 -> "Germany", 98 ->  "Iran"}
 *     - find code for Iran -> 98
 *     - find code for Germany -> 49
 *     - find code for Canada -> IllegalArgumentException("Canada is not found")
 */
fun findCode(codes: Map<Int, String>, country: String): Int {
    codes.forEach {
        if (it.value == country) {
            return it.key
        }
    }
    throw IllegalArgumentException ("$country is not found")
}

/**
 * Counts the characters in the given string.
 *
 * @param text the given string to count its characters
 * @return a map of characters to their number of occurrence in the text
 *
 * Example:
 *  "hello" -> { 'h' -> 1, 'e' -> 1, 'l' -> 2, 'o' -> 1 }
 *  "mohammad" -> { 'm' -> 3, 'o' -> 1, 'h' -> 1, 'a' -> 2, 'd' -> 1 }
 */
fun countChars(text: String): Map<Char, Int> {
    val result = hashMapOf<Char, Int>()
    for (c in text) {
        if (result.containsKey(c)) {
            var p = result[c]
            result[c] = p!! + 1
        } else {
            result[c] = 1
        }
    }
    return result
}

/**
 * Get a list of "city, country" and returns a map of countries with their cities.
 *
 * @param cities list of city, countries
 * @return a map of countries to their cities.
 *
 * Example:
 *    - [(Tehran, Iran), (Berlin, Germany), (Dresden, Germany), (Shiraz, Iran), (Munich, Germany) ]
 *          ->  { Iran -> [Tehran, Shiraz], Germany -> [ Dresden, Berlin,  Munich] }
 */
fun countryCities(cities: List<Pair<String, String>>): Map<String, Set<String>> {
    val result = hashMapOf<String, HashSet<String>>()
    cities.forEach {
        if (result.containsKey(it.second)) {
            val c: HashSet<String> = result[it.second]!!
            c.add(it.first)
        } else {
            result[it.second] = hashSetOf(it.first)
        }
    }
    return result
}


class MapTest {
    @Test
    fun testFindCode() {
        val fc = mapOf(Pair(98, "Iran"), Pair(49, "Germany"))
        assertEquals(98, findCode(fc, "Iran"))
        assertEquals(49, findCode(fc, "Germany"))
    }

    @Test (expected = IllegalArgumentException::class)
    fun testFindCodeNotFound() {
        val fc = mapOf(Pair(98, "Iran"), Pair(49, "Germany"))
        findCode(fc, "Canada")
    }

    @Test
    fun testCountChars() {
        val result = countChars("hello")
        assertEquals(1, result['h'])
        assertEquals(2, result['l'])
        assertEquals(1, result['e'])
        assertEquals(1, result['o'])
    }


    @Test
    fun testCountChars2() {
        val result = countChars("mohammad")
        assertEquals(3, result['m'])
        assertEquals(1, result['o'])
        assertEquals(1, result['h'])
        assertEquals(2, result['a'])
        assertEquals(1, result['d'])
    }

    @Test
    fun testCities() {
        val c = listOf<Pair<String, String>>(
                Pair("Tehran", "Iran"),
                Pair("Berlin", "Germany"),
                Pair("Dresden", "Germany"),
                Pair("Shiraz", "Iran"),
                Pair("Munich", "Germany"))
        val cToC = countryCities(c)
        val resultIran = cToC["Iran"]
        assertEquals(setOf("Tehran", "Shiraz"), resultIran)
        assertEquals(setOf("Berlin", "Dresden", "Munich"), cToC["Germany"])
    }
}