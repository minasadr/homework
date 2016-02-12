package d

/**
 */
fun main1(args: Array<String>) {
    val set = setOf('b', 'a', 'd', 'c', 'a')
    println("The set is: $set")

    set.forEach { println(it) }
    set.forEachIndexed { index, value -> println("the element in index $index is $value") }

    val updatableSet = hashSetOf(1, 2, 3)
    println("the new set is: $updatableSet")
    println("trying to add 12 to set: ${updatableSet.add(12)}")
    println("trying to add 2 to set: ${updatableSet.add(2)}") // there is no duplicate element in set
    println("the new set is: $updatableSet")
    updatableSet.remove(2)
    println("the new set is: $updatableSet")
    println("trying to add 2 to set: ${updatableSet.add(2)}")
    println("the new set is: $updatableSet")

    val l1 = listOf(1, 2, 3)
    val l2 = listOf(3, 1, 2)
    println(l1 == l2)  // in list order is important

    val s1 = setOf(1, 2, 3)
    val s2 = setOf(3, 1, 2)
    println(s1 == s2)  // in set order is not important
}