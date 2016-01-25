package c

fun main(args: Array<String>) {
    val math = Subject("Math", 5)
    val firstStudent = Student(140, "Omid", 3.2)
    val secondStudent = Student(141, "Saam", 3.0)
    math.registerNewStudent(firstStudent)
    math.registerNewStudent(secondStudent)
    //    math.show()
    do {
        val r = menu()
        when (r) {
            "1" -> math.show()
            "2" -> {
                val b = math.registerNewStudent(firstStudent)
                if (b == true) {
                    println("Registration is done ")
                } else {
                    println("no free seat")
                }
            }
            "0" -> println("Goodbye")
        }
    } while (r != "0")
}

fun menu(): String {
    println("please choose any of following options:")
    println("     - enter 1 to display current students")
    println("     - enter 2 to register new student")
    println("     - enter 0 to exit")
    println()
    var text: String?
    do {
        println("enter your option:")
        text = readLine()
    } while (text != "0" && text != "1" && text != "2" )

    return text
}