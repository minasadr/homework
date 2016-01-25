package c

import org.junit.Test
import kotlin.test.assertEquals

class Student(id: Long, name: String, grade: Double) {
    val id: Long
    val name: String
    val grade: Double

    init {
        this.id = id
        this.name = name
        this.grade = grade
    }

    override fun toString(): String = "Student with ID : $id and Name : $name has a Grade : $grade"
}

class studentTest {
    @Test
    fun studentDetail() {
        assertEquals("Student with ID : 160 and Name : Mina has a Grade : 3.4", Student(160, "Mina", 3.4).toString())
    }
}