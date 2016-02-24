package f

open class Person(val name: String, val age: Int) : Any() {  // Any is the default parent, we don't need to mention it.
    override fun toString(): String {
        return "Person[name: $name, age: $age]"
    }
}

class Student(val id: Long, name: String, age: Int, val cgp: Double) : Person(name, age) {
    override fun toString(): String {
        val base = super.toString()
        return "$base - Student[id: $id, cgp: $cgp]"
    }
}

class Teacher(val id: Long, name: String, age: Int, val field: String) : Person(name, age) {
    override fun toString(): String {
        return "${super.toString()} - Teacher[id: $id, field: $field]"
    }
}


fun printMyName(person: Person) {
    println("Your name is: ${person.name}")
}

fun main(args: Array<String>) {
    val p = Person("Foo", 10)
    val s = Student(100, "Bar", 11, 12.4)
    val t = Teacher(2000, "Baz", 8, "Math")

    printMyName(p)
    printMyName(s)
    printMyName(t)

    println(p)
    println(s)
    println(t)

    println(t.toString())
}