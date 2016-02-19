package a

import org.junit.Test
import kotlin.test.assertEquals

/**
 * A:
 *  Given the same Student class that we have defined,
 *     Write a function to take an array of Students and return the **first name** of the student
 *     with **highest grade**.
 *
 *    Note 1: the function is defined outside of class and it doesn't need to be a member of student class.
 *    Note 2: Wirte at least three tests with different examples to
 *    prove that function is doing it's job correctly.
 *
 */


fun highestGrade(a: Array<Student>): String {
    var g = 0.0
    var p = "No one"
    for (m in a) {
        if (m.grade > g ) {
            g = m.grade
            p = m.firstName
        }
    }
    return p
}


class SixthTest {
    @Test
    fun highestGrade1() {
        assertEquals("Mina", highestGrade(arrayOf(Student("Mina", "Sadr", 3.0), Student("Mohammad", "Shams", 2.0))))
    }

    @Test
    fun highestGrade2() {
        val aa = Student("Minaa", "Sadr", 3.8)
        val bb = Student("Mi", "Sad", 3.0)
        val cc = Student("Min", "Sa", 2.9)
        assertEquals("Minaa", highestGrade(arrayOf(aa, bb, cc)))
    }

    @Test
    fun highestGrade3() {
        val aa = Student("Mohammad", "Shams", 0.8)
        val bb = Student("Mohamma", "Sham", 2.8)
        val cc = Student("Mohamm", "Sha", 3.8)
        val dd = Student("Moh", "Sh", 3.8)
        assertEquals("Mohamm", highestGrade(arrayOf(aa, bb, cc, dd)))
    }
}