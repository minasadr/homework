package g

open class Bar(val name: String) {
    fun myName(): String = name
}

class Buz : Bar("Something")

interface Foo {
    fun sayHi(name: String): String
}

class Bux : Foo {  // implements Foo
    override fun sayHi(name: String): String = "Hallo $name"
}

class Dux : Bar("Something"), Foo {
    override fun sayHi(name: String): String = "Hello from me, $name"
}

interface Gux

interface Jux

class Mux : Bar("any thing"), Gux, Jux, Foo {
    override fun sayHi(name: String): String = "whatever, $name"
}


fun main(args: Array<String>) {
    val b = Buz()

    println(b.myName())

    val x = Bux()
    println(x.sayHi("Mina"))

    val d = Dux()
    println(d.sayHi("Omid"))
    println(d.myName())
    println(d.sayHi(d.myName()))
}