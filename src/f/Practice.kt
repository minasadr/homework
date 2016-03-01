package f

/**
 * define a class called: Animal with following properties:
 * - name: String
 * and following functions:
 * - makeSound(): String
 * - move(): String
 *
 * Define a class called Cat which extends from Animal.
 * override both functions an make them cat specific
 *
 * Define a class called Dog which extends from Animal.
 * override both functions an make them dog specific
 *
 * Define a class called Bird which extends from Animal.
 * override both functions an make them bird specific
 *
 * Define a class called Kangaroo which extends from Animal.
 * override both functions an make them kangaroo specific
 *
 * In all above classes, override toString method to explain the animal type and its name.
 *
 * Define a function which takes an Animal and prints both makeSound and move for the given animal.
 *
 * Write a main function to try all above definitions.
 */
open class Animal(val name: String) {

    open fun makeSound(): String {
        return "unknown animal named $name makes no sound"
    }

    open fun move(): String = "unknown animal named $name makes no move"

    override fun toString(): String = "Animal [$name]"

}

class Cat(name: String) : Animal(name) {

    override fun makeSound(): String {
        return "cat $name says mio"
    }

    override fun move(): String {
        return "cat $name jumps"
    }

    override fun toString(): String = "Cat [$name]"
}

class Dog(name: String) : Animal(name) {

    override fun makeSound(): String {
        return "dog $name barks"
    }

    override fun move(): String {
        return "dog $name runs"
    }

    override fun toString(): String = "Dog [$name]"
}

class Bird(name: String) : Animal(name) {

    override fun makeSound(): String {
        return "bird $name sings"
    }

    override fun move(): String {
        return "bird $name can fly"
    }

    override fun toString(): String = "Bird [$name]"
}

class Cangaroo(name: String) : Animal(name) {

    override fun makeSound(): String {
        return "cangaroo $name has no voice"
    }

    override fun move(): String {
        return "cangaroo $name jumps"
    }

    override fun toString(): String = "Cangaroo [$name]"
}

fun animalFuture(animal: Animal){
    println(animal.makeSound())
    println(animal.move())
}

fun main(args: Array<String>) {
    val a = Animal("Lo Lo")
    println(a.move())

    val c: Cat = Cat("Pishal")
    val d = Dog("Fancy")
    val b = Bird("Shokoh")
    val ca = Cangaroo("Skipi")

    println(c)
    println(d)
    println(b)
    println(ca)
    println("=========================")
    animalFuture(c)
    animalFuture(d)
    animalFuture(b)
    animalFuture(ca)
    println("=========================")

    println(c.makeSound())
    println(Cat("pi").makeSound())
}