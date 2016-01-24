package a

import org.junit.Test
import kotlin.test.assertEquals

class Person(f: String, l: String) {
    val firstName: String
    val lastName: String

    init {
        firstName = f
        lastName = l
    }
    fun asString(): String= "$lastName , $firstName"
}


class ThirdTest {
    @Test
    fun personDetails() {
        val r = Person("Mohammad", "Shams")
        val q = Person("Mina", "Sadr")
        println(r.asString())
        println(q.asString())
    }


    @Test
    fun personDetails1() {
        assertEquals("Shams", Person("Mohammad", "Shams").lastName)
        assertEquals("Mina", Person("Mina", "Sadr").firstName)
    }


    @Test
    fun personDetails2() {
        val r = Person("Mohammad", "Shams")
        val q = Person("Mina", "Sadr")
        assertEquals("Shams , Mohammad", r.asString())
        assertEquals("Sadr , Mina", q.asString())
    }
}