package c

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Stack is a data structure that stores some elements and these elements can be received in LIFO order.
 * That means the last element that is pushed to stack would be the first one that can be poped.
 *
 * Our stack has a limited capacity and can not store element more than its capacity.
 *
 * Note to developer:
 *     - define an array of integers to keep the stack elements.
 *     - you can initialize the array with (0) in the beginning
 *     - define a variable "top" to keep the index of last element that has been added to stack.
 *     ( -1 in the beginning )
 * Adds the given number to the stack
 * @return true if the push was successful, false if the stack was full
 * Removes the last element in the stack and returns it.
 * @return the last element in the stack, -1 if the stack is empty
 * Returns the last element in the stack WITHOUT removing it.
 * @return the last element in the stack, -1 if the stack is empty
 * Checks if the stack is empty.
 * @return true if the stack is empty, false otherwise
 * Checks if the stack capacity is full.
 * @return true if the stack is full, false otherwise
 */

class MyStackGeneric<T>(capacity: Int) {
    val elements: Array<T>
    var top: Int

    init {
        this.elements = Array<Any>(capacity, { "" }) as Array<T>
        this.top = -1
    }

    fun push(n: T): Boolean {
        if (!isFull()) {
            elements[++top] = n   //increment then use
            return true
        } else {
            return false
        }
    }

    fun pop(): T {
        if (!isEmpty()) {
            return elements[top--] // use then deduct
        } else {
            throw IllegalStateException("the stack is empty")
        }
    }

    fun peek(): T = if (!isEmpty()) elements[top] else throw IllegalStateException("the stack is empty")

    fun isEmpty(): Boolean = top == -1

    fun isFull(): Boolean = elements.size == top + 1

    override fun toString(): String = "myStack has ${elements.size} capacity}"
}

class MyStackTest() {
    @Test
    fun myStack() {
        assertEquals("myStack has 20 capacity}", MyStackGeneric<Boolean>(20).toString())
    }

    @Test
    fun pushAnInt() {
        val e = MyStackGeneric<Int>(3)
        assertTrue(e.push(3))
        assertTrue(e.push(4))
        assertFalse(e.isFull())
        assertTrue(e.push(5))
        assertTrue(e.isFull())
        assertFalse(e.push(0))
        assertTrue(e.isFull())
    }

    @Test
    fun popAnInt() {
        val e = MyStackGeneric<Char>(2)
        assertTrue(e.push('c'))
        assertTrue(e.push('b'))
        assertEquals('b', e.pop())
        assertEquals('c', e.pop())
    }

    @Test(expected = IllegalStateException::class)
    fun popEmptyStack() {
        val e = MyStackGeneric<Int>(2)
        e.pop()
    }

    @Test(expected = IllegalStateException::class)
    fun peekEmptyStack() {
        val e = MyStackGeneric<Long>(2)
        e.peek()
    }

    @Test
    fun peekAnInt() {
        val e = MyStackGeneric<Double>(2)
        assertTrue(e.push(3.0))
        assertTrue(e.push(2.0))
        assertEquals(2.0, e.peek())
    }

    @Test
    fun isEmptyOrNot() {
        val e = MyStackGeneric<Int>(1)
        assertTrue(e.isEmpty())
    }
}