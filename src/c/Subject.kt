package c

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Subject(name: String, capacity: Int) {
    val name: String
    val capacity: Int
    var size: Int
    val students: Array<Student?>

    init {
        this.name = name
        this.capacity = capacity
        this.size = 0
        this.students = Array(capacity, { null })
    }

    fun registerNewStudent(student: Student): Boolean {
        if (hasFreeSeat()) {
            students[size] = student
            size += 1
            return true
        }
        return false
    }

    fun hasFreeSeat(): Boolean {
        return if (size < capacity) true else false
    }

    override fun toString(): String = "subject [name: $name, capacity: $capacity, size: $size]"

}

class SubjectTest() {
    @Test
    fun subjectDetails() {
        assertEquals("subject [name: Math, capacity: 20, size: 0]", Subject("Math", 20).toString())
    }


    @Test
    fun emptySubject() {
        val p: Subject = Subject("Math", 20)
        assertEquals(0, p.size)
        assertEquals(20, p.capacity)
        assertEquals("Math", p.name)
        assertTrue(p.hasFreeSeat())
    }

    @Test
    fun registerNewStudent() {
        val s = Subject("m", 3)
        assertEquals(true, s.registerNewStudent(Student(170, "Mina", 3.0)))
        assertEquals(1, s.size)
        assertTrue(s.registerNewStudent(Student(169, "Mohammad", 3.6)))
        assertEquals(2, s.size)
    }

    @Test
    fun registerNewStudentWhenCapacityIsFull() {
        val s = Subject("m", 1)
        assertEquals(true, s.registerNewStudent(Student(170, "Mina", 3.0)))
        assertEquals(1, s.size)
        assertFalse(s.hasFreeSeat())
        assertEquals(false, s.registerNewStudent(Student(169, "Mohammad", 3.6)))
        assertEquals(1, s.size)
        assertEquals(false, s.hasFreeSeat())
    }

}