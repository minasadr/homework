package c

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


@Suppress("UNREACHABLE_CODE")
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

class MyStack(capacity: Int) {
    val capacity: Int
    val myStack: Array<Int>
    var top: Int

    init {
        this.capacity = capacity
        this.myStack = Array(capacity, { 0 })
        this.top = -1
    }

    fun push(n: Int): Boolean {
        if (top < capacity - 1) {
            top += 1
            myStack[top] = n
            return true
        } else {
            return false
        }
    }

    fun pop(): Int {
        if (top > -1) {
            return myStack[top]
            top -= 1
        } else {
            return -1
        }
    }

    fun peek(): Int {
        return if (top > -1) return myStack[top] else -1
    }

    fun isEmpty(): Boolean {
        return if (top == -1) true else false
    }

    fun isFull(): Boolean {
        return if (capacity == top + 1) true else false
    }

    override fun toString(): String = "myStack has $capacity capacity}"
}

class MyStackTest() {
    @Test
    fun MyStack() {
        assertEquals("myStack has 20 capacity}", MyStack(20).toString())
    }

    @Test
    fun pushAnInt() {
        val e = MyStack(3)
        assertTrue(e.push(3))
        assertTrue(e.push(4))
        assertTrue(e.push(5))
        assertFalse(e.push(0))
        assertTrue(e.isFull())
    }

    @Test
    fun popAnInt() {
        val e = MyStack(1)
        assertTrue(e.push(3))
        assertEquals(3, e.pop())
        assertEquals(3, e.peek())
    }

    @Test
    fun isEmptyOrNot() {
        val e = MyStack(1)
        assertTrue(e.isEmpty())
    }
}