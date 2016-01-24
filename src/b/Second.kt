package b

fun main(args: Array<String>) {
    val z = arrayOf("0", "1", "2", "3", "4", "5")
    var x: String? = ""
    do {
        println("please enter a number between 0 to 5")
        x = readLine()
    } while (x !in z)
    println(x)
}
