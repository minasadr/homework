package d

fun main(args: Array<String>) {
    val i: Int = 0   // the final variables are defined as "val". which means they cannot be reassigned.
    var j: Int = 0  // a non-final variable can be reassigned.
    j = 45

    val b: Array<Int> = arrayOf(1, 2)  // initializing an array using a utility method.
    val bb: Array<Int> = Array(3, {0}) // initializing an array using its constructor

    val s: String = "the string"
    val ss: String = String(byteArrayOf(1, 2)) // initializing an string using its constructor

    val p: Person = Person("Omid")  // creating a Person using its constructor
    val pp: Person = personOf("Omid") // creating a Person using a utility function

    show() // calling a function without a parameter and return value
    println()
    show()

    val r = say()  // usually (most of the time) we use the result (return value) of the function
    println(r)

    println(say())  // we can simply pass the result of one function to another one

    add(2, 3)

    val rr = addAndReturn(3, 4)
    println(rr)

    println(addAndReturn(3, 1))  // the result of "addAndReturn" is simply passed to println function


    val x = Person("Omid")
    x.sayHi()

    val y = Person("Mohammad")
    y.sayHi()
}

/**
 * - Function always has a name. (for the time being)
 * - function name always starts with a lowercase character
 * - It may have 0 or more parameters. parameters are defined inside "()"
 * - It may return a result. the result type is defined after "()" and separated with a ":"
 */
fun personOf(name: String): Person {
    return Person(name)
}

fun show() {
    println("Hello, I am a function without any parameter and any return value")
}

fun say(): String {
    return "Hello, I am a function without any parameter that returns an String"
}

fun add(a: Int, b: Int) {
    println("The result of $a + $b is equal to ${a + b}")
}

fun addAndReturn(a: Int, b: Int): Int {
    return a + b
}

/**
 * - Class always has a name. (for the time being)
 * - Its name always start with a uppercase character
 * - It has ONE or MORE constructor.
 * - Its constructors may have parameters
 * - It has 0 or more properties (attribute)
 * - It has 0 or more functions (behaviour)
 */
class Person(name: String) {    // name is a parameter for class constructor
    val name: String   // name is a property here.

    init {
        this.name = name // assign the value of given parameter to the class property
    }

    fun sayHi() {
        println("Hello may name is ${this.foo()}")
    }

    fun foo(): String {
        return name
    }
}