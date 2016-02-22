package e

import org.junit.Test
import kotlin.test.assertEquals

/**
 * The person class should have following properties:
 *    - firstName (as String)
 *    - lastName  (as String)
 *    - gender    (as Char - M for male, F fo female)
 *    - age       (as Int)
 */
class Person(val firstName: String, val lastName: String, val gender: Char, val age: Int) {
    override fun toString(): String = "$firstName, $lastName, $gender, $age"
}

/**
 * Returns the youngest woman in the given list
 */
fun findYoungestWoman(persons: List<Person>): Person {
    var p = Person("m", "m", 'm', 1000)
    persons.forEach {
        if (it.gender == 'F' && it.age < p.age) {
            p = it
        }
    }
    if (p.age != 1000) {
        return p
    } else {
        throw Exception ("There is no woman in the list.")
    }
}

/**
 * Returns the oldest person in the given list
 */
fun findOldest(persons: List<Person>): Person {
    var p = persons[0]
    persons.forEach {
        if (p.age < it.age) {
            p = it
        }
    }
    return p
}

/**
 * Returns all men older (exclusive) than given age.
 */
fun findAllMenOlderThan(persons: List<Person>, age: Int): List<Person> {
    val o = arrayListOf<Person>()
    persons.forEach {
        if (it.gender == 'M' && it.age > age)
            o.add(it)
    }
    return o
}

/**
 * Returns all persons younger (exclusive) than given age.
 */
fun findAllYoungerThan(persons: List<Person>, age: Int): List<Person> {
    val y = arrayListOf<Person>()
    persons.forEach {
        if (it.age < age)
            y.add(it)
    }
    return y
}

/**
 * Returns all persons older (exclusive) than given age in the given sorted list.
 */
fun findAllOlderThanInSorted(persons: List<Person>, age: Int): List<Person> {
    val a = arrayListOf<Person>()
    var position = persons.size
    for (n in 0..persons.size - 1) {
        if (persons[n].age > age) {
            position = n
            break
        }
    }
        for (n in position..persons.size - 1) {
            a.add(persons[n])
        }
    return a
}

/**
 * Returns all persons younger (exclusive) than given age in the given sorted list.
 */
fun findAllYoungerThanInSorted(persons: List<Person>, age: Int): List<Person> {
    val y = arrayListOf<Person>()
    var position = -1
    for (n in persons.size - 1 downTo 0) {
        if (persons[n].age < age) {
            position = n
            break
        }
    }
    for (n in 0..position) {
        y.add(persons[n])
    }
    return y
}

/**
 * Returns the sorted list of the given list.
 */
fun sort(persons: List<Person>): List<Person> {
    val  a = arrayListOf<Person>()
    for (n in persons) {
        var isAdded = false
        for (m in 0..a.size - 1) {
            if (n.age < a[m].age) {
                a.add(m, n)
                isAdded = true
                break
            }
        }
        if (!isAdded) {
            a.add(n)
        }
    }
    return a
}

class PracticeTest {
    @Test
    fun testFindYoungestWoman() {
        val a = Person("Mina", "Sadr", 'F', 32)
        val b = Person("Mohammad", "Shams", 'M', 38)
        val c = Person("Omid", "Shams", 'M', 1)
        val d = Person("Kiana", "Sadr", 'F', 1)
        assertEquals(d, findYoungestWoman(arrayListOf(a, b, c, d)))
    }

    @Test (expected = Exception::class)
    fun testFindYoungestWoman1() {
        val a = Person("Mina", "Sadr", 'M', 32)
        val b = Person("Mohammad", "Shams", 'M', 38)
        val c = Person("Omid", "Shams", 'M', 1)
        val d = Person("Kiana", "Sadr", 'M', 1)
        assertEquals(d, findYoungestWoman(arrayListOf(a, b, c, d)))
    }

    @Test
    fun testFindOldest() {
        val a = Person("Mina", "Sadr", 'F', 32)
        val b = Person("Mohammad", "Shams", 'M', 38)
        val c = Person("Omid", "Shams", 'M', 1)
        val d = Person("Kiana", "Sadr", 'F', 1)
        assertEquals(b, findOldest(arrayListOf(a, b, c, d)))
    }

    @Test
    fun testFindAllMenOlderThan() {
        val a = Person("Mina", "Sadr", 'F', 32)
        val b = Person("Mohammad", "Shams", 'M', 38)
        val c = Person("Omid", "Shams", 'M', 1)
        val d = Person("Kiana", "Sadr", 'F', 1)
        val e = Person("mori", "Sadr", 'M', 34)
        assertEquals(listOf(b, e), findAllMenOlderThan(arrayListOf(a, b, c, d, e), 10))
    }

    @Test
    fun testFindAllYoungerThan() {
        val a = Person("Mina", "Sadr", 'F', 32)
        val b = Person("Mohammad", "Shams", 'M', 38)
        val c = Person("Omid", "Shams", 'M', 1)
        val d = Person("Kiana", "Sadr", 'F', 1)
        assertEquals(listOf(c, d), findAllYoungerThan(arrayListOf(a, b, c, d), 10))
    }

    @Test
    fun testFindAllOlderThanInSorted() {
        val a = Person("Mina", "Sadr", 'F', 32)
        val b = Person("Mohammad", "Shams", 'M', 38)
        val c = Person("Omid", "Shams", 'M', 1)
        val d = Person("Kiana", "Sadr", 'F', 1)
        val e = Person("mori", "Sadr", 'M', 34)
        assertEquals(listOf(a, e, b), findAllOlderThanInSorted(arrayListOf(c, d, a, e, b), 10))
    }

    @Test
    fun testFindAllOlderThanInSorted2() {
        val c = Person("Omid", "Shams", 'M', 1)
        val d = Person("Kiana", "Sadr", 'F', 1)
        assertEquals(listOf<Person>(), findAllOlderThanInSorted(arrayListOf(c, d), 10))
    }

    @Test
    fun testFindAllYoungerThanInSorted() {
        val a = Person("Mina", "Sadr", 'F', 32)
        val b = Person("Mohammad", "Shams", 'M', 38)
        val c = Person("Omid", "Shams", 'M', 1)
        val d = Person("Kiana", "Sadr", 'F', 1)
        val e = Person("mori", "Sadr", 'M', 34)
        assertEquals(listOf(c, d, a), findAllYoungerThanInSorted(arrayListOf(c, d, a, e, b), 33))
    }

    @Test
    fun testFindAllYoungerThanInSorted2() {
        val a = Person("Mina", "Sadr", 'F', 32)
        val e = Person("mori", "Sadr", 'M', 34)
        assertEquals(listOf(), findAllYoungerThanInSorted(arrayListOf(a, e), 30))
    }

    @Test
    fun testSort() {
        val a = Person("Mina", "Sadr", 'F', 32)
        val b = Person("Mohammad", "Shams", 'M', 38)
        val c = Person("Omid", "Shams", 'M', 1)
        val d = Person("Kiana", "Sadr", 'F', 1)
        val e = Person("mori", "Sadr", 'M', 34)
        assertEquals(listOf(c, d, a, e, b), sort(arrayListOf(a, b, c, d, e)))
    }

    @Test
    fun testSort2() {
        val a = Person("Mina", "Sadr", 'F', 32)
        assertEquals(listOf(a), sort(arrayListOf(a)))
    }

    @Test
    fun testSort3() {
        assertEquals(listOf(), sort(arrayListOf()))
    }
}