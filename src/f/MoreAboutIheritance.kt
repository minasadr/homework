package f

open class Base {
    open fun sayHi(name: String): String {
        return "Hi $name"
    }
}

class Extended : Base() {
    override fun sayHi(name: String): String {
        return "Hallo $name"
    }
}


fun main(args: Array<String>) {
    val b = Base()
    val e = Extended()

    println(b.sayHi("Mina"))
    println(e.sayHi("Omid"))
}