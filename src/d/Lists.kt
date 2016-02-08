package d

import java.util.*

fun main(args: Array<String>) {
    val a: Array<String> = arrayOf("foo", "bar")
    val aa = arrayOf('a', 'b', 'c')

    println(a[0])
    println(aa[1])

    a[0] = "baz"
    aa[1] = 'x'

    println(a[0])
    println(aa[1])


    // list

    // emutable
    val l: List<String> = listOf("foo", "bar")
    val ll = listOf('a', 'b', 'c')

    println(l[0])
    println(ll[1])

    // mutable
    val al: ArrayList<String> = arrayListOf("foo", "bar")
    val all = arrayListOf('x', 'y', 'z')

    println(al[0])
    println(all[1])

    // replace with old value
    al[0] = "baz"

    println(al[0])

    println(all.size)
    all[0] = 'w'
    println(all.size)

    // add to the end of list
    all.add('v')
    println(all.size)

    // add to the given index (shifts all others from this index to the right)
    all.add(1, 'm')
    println(all.size)

    // remove the given value (the first one)
    all.remove('v')

    // remove the element in the given index
    val ddd = all.removeAt(0)
    println(ddd)
    println(all.size)

    // iterating list
    for (i in all) println(i)
    // iterating list indexes
    for (i in 0..all.size - 1) println(i)

    // another way of list iteration
    all.forEach { element -> println(element) }
    all.forEach { println(it) }

    // another way of iteration with index
    all.forEachIndexed { index, element ->  println("the element in index $index is: $element")}
}