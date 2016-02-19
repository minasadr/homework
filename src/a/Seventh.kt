package a

import org.junit.Test
import kotlin.test.assertEquals

/*
B:
*   Given the same Student class that we have defined
*      Write a function to take an array of Students and sort them in descending order
*      (Highest grade to lowest grade)
*
*    Note 1: the function is defined outside of class and it doesn't need to be a member of student class.
*    Note 2: Write at least three tests with different examples to
*    prove that function is doing it's job correctly.
*/


fun highestGradeSort(a: Array<Student>) {
    for (s in 0..a.size - 2) {
        for (h in s + 1..a.size - 1) {
            if (a[s].grade < a[h].grade) {
                val replace = a[h]
                a[h] = a[s]
                a[s] = replace
            }
        }
    }
}

class SeventhTest {
    @Test
    fun gradeDescending() {
        val students = arrayOf(Student("Minaa", "Sadr", 3.8),
                Student("Mi", "Sad", 3.0),
                Student("Min", "Sa", 3.6))
        highestGradeSort(students)
        assertEquals(3.8, students[0].grade)
    }

    @Test
    fun gradeDescending1() {
        val students = arrayOf(Student("Minaa", "Sadr", 3.8),
                Student("Mi", "Sad", 3.0),
                Student("Min", "Sa", 3.6))
        highestGradeSort(students)
        assertEquals(3.0, students[2].grade)
    }
/*
        @Test
    fun highestgrade2() {
        val aa = Student("Minaa", "Sadr", 3.8)
        val bb = Student("Mi", "Sad", 3.0)
        val cc = Student("Min", "Sa", 2.9)
        highestGradeSort(arrayOf(aa, bb, cc))
        assertEquals(3.0, highestGrade[2].grade)
    }*/
}
