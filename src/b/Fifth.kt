package b

fun main(args: Array<String>) {
    for (n in 'a'..'z')
        print("${n.toInt()} ")
    println()
    for (m in 'A'..'Z')
        print("${m.toInt()} ")
    println()
    for (x in '0'..'9')
        print("${x.toInt()} ")
    println()
    for (m in '0'..'z')
        print("$m ")
}