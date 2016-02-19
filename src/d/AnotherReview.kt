package d

class Student(val id: Int, val firstName: String, val lastName: String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (this.javaClass != other?.javaClass) return false

        other as Student

        return this.id == other.id
    }

    override fun hashCode(): Int = 31 + 17 * id

    override fun toString(): String = "Student[id: $id, firstName: $firstName, lastName: $lastName]"
}

fun main(args: Array<String>) {
    val first = Student(1, "Omid", "Shams")
    val second = Student(1, "Omid", "Shams")
    val third = second

    println(first)           // is exactly equal to: println(s.toString())
    println(first.toString())


    println(first == first)
    println(first === first)

    println(second == second)
    println(second === second)

    println("........................")
    println(first == second)   // true
    println(first === second)  // false

    println(second == third)   // true
    println(second === third)  // true
}


