package b

fun main(args: Array<String>) {
    var x: String?
    do {
        println("answer with Yes or No")
        x = readLine()
    } while (x != "Yes" && x != "No")
    println(x)
}