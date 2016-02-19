package a

import org.junit.Test
import kotlin.test.assertEquals


class Student(val firstName: String, val lastName: String, val grade: Double) {

    override fun toString(): String = "$firstName, $lastName, $grade"

    fun compare(other: Student): Int {
        return when {
            grade > other.grade -> 1
            grade < other.grade -> -1
            else -> 0
        }
    }

}

fun compare(a: Student, b: Student): Int {
    return when {
        a.grade > b.grade -> 1
        a.grade < b.grade -> -1
        else -> 0
    }
}


class FifthTest {
    @Test
    fun studentGrade() {
        assertEquals("Mina, Sadr, 3.5", Student("Mina", "Sadr", 3.5).toString())
    }

    @Test
    fun studentGrade1() {
        //val z = Student("Mina", "Sadr", 3.5)
        //val c = Student("Mohammad", "Shams", 1.2)
        //assertEquals(1, (compare(z, c)))
        assertEquals(1, (compare(Student("Mina", "Sadr", 3.5), Student("Mohammad", "Shams", 1.2))))
    }

    @Test
    fun studentGrade2() {
        assertEquals(-1, (compare(Student("Mina", "Sadr", 3.5), Student("Mohammad", "Shams", 3.8))))
    }

    @Test
    fun studentGrade3() {
        assertEquals(0, (compare(Student("Mina", "Sadr", 3.5), Student("Mohammad", "Shams", 3.5))))
    }

    @Test
    fun studentGrade4() {
        val z = Student("Mina", "Sadr", 3.5)
        val c = Student("Mohammad", "Shams", 1.2)
        println (z.compare(c))
        println (c.compare(z))
        assertEquals(1, (z.compare(c)))
    }

    @Test
    fun studentGrade5() {
        assertEquals(-1, Student("Mina", "Sadr", 3.5).compare(Student("Mohammad", "Shams", 3.8)))
    }

    @Test
    fun studentGrade6() {
        assertEquals(0, Student("Mina", "Sadr", 3.5).compare(Student("Mohammad", "Shams", 3.5)))
    }
}