package b

fun main(args: Array<String>) {
    val i = IntArray(10)
    val b = BooleanArray(10)
    val c = DoubleArray(10)

    for (n in i) print(n)
    for (n in b) print(n)
    for (n in c) print(n)
    println()
    println("+++")
    print("Enter something:")
    val x = readLine()
    println("You Entered: $x")
}