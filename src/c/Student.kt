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

    override fun toString(): String = "Student [id: $id, name: $name, grade: $grade]"
}

class studentTest {
    @Test
    fun studentDetail() {
        assertEquals("Student [id: 160, name: Mina, grade: 3.4]", Student(160, "Mina", 3.4).toString())
    }
}


