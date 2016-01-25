package c

import org.junit.Test
import kotlin.test.assertEquals

class Subject(name: String, capacity: Int) {
    val name: String
    val capacity: Int
    var size: Int

    init {
        this.name = name
        this.capacity = capacity
        this.size = 0
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
    }
}