package b

fun main(args: Array<String>) {
    val i = IntArray(10)
    val b = BooleanArray(10)
    val c = DoubleArray(10)

    for (n in i) println(n)
    for (n in b) println(n)
    for (n in c) println(n)

    println()
    print("Enter something:")
    val x = readLine()
    println("You Entered: $x")
}