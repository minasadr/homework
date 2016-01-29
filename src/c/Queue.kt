package c

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Queue is a data structure that stores some elements and these elements can be received in FIFO order.
 * That means the first element that is inserted to queue would be the first one that can be removed.
 *
 * Our queue has a limited capacity and can NOT store element more than its capacity.
 *
 * Note to developer:
 *     - define an array of integers to keep the queue elements.
 *     - you can initialize the array with (0) in the beginning
 *     - define a variable "head" to keep the index of first element that has been inserted to queue
 *     - define a variable "tail" to shows that index of free position to insert the new element.
 */
class MyQueue(capacity: Int) {
    val elements: Array<Int>
    var tail: Int

    init {
        this.elements = Array(capacity, { 0 })
        this.tail = 0
    }

    /**
     * Inserts the given number to the queue
     * @return true if the insert was successful, false if the queue was full
     */
    fun insert(n: Int): Boolean {
        if (!isFull()) {
            elements[tail] = n
            tail += 1
            return true
        }
        return false
    }

    /**
     * Removes the first element in the queue and returns it.
     * @return the first element in the queue, -1 if the queue is empty
     */
    fun remove(): Int {
        if (!isEmpty()) {
            val x = elements[0]
            for (n in 0..tail - 2) {
                elements[n] = elements[n + 1]
            }
            tail -= 1
            return x
        }
        return -1
    }

    /**
     * Returns the first element in the queue WITHOUT removing it.
     * @return the first element in the queue, -1 if the queue is empty
     */
    fun peek(): Int = if (!isEmpty()) elements[0] else -1

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    fun isEmpty(): Boolean = tail == 0

    /**
     * Checks if the queue capacity is full.
     * @return true if the queue is full, false otherwise
     */
    fun isFull(): Boolean = tail == elements.size

    override fun toString(): String = "my Queue has ${elements.size} capacity"

}

class QueueTest {

    @Test
    fun insertTest() {
        val e = MyQueue(2)
        assertTrue(e.insert(1))
        assertFalse(e.isFull())
        assertTrue(e.insert(2))
        assertFalse(e.insert(3))
        assertFalse(e.isEmpty())
        assertTrue(e.isFull())
    }

    @Test
    fun removeTest() {
        val e = MyQueue(1)
        assertTrue(e.insert(1))
        assertFalse(e.insert(2))
        assertEquals(1, e.peek())
        assertEquals(1, e.remove())
        assertEquals(-1, e.peek())
        assertEquals(-1, e.remove())
    }

}