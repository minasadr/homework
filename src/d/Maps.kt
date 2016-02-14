package d

fun main(args: Array<String>) {
    val array = arrayOf("foo", "bar", "baz")
    val list = listOf("foo", "bar", "baz")

    println(array[2])
    println(list[1])

    val map = mapOf('x' to "foo", 'y' to "bar", 'z' to "baz")

    println(map['x'])

    val codes = arrayOf("IR", "DE", "CA")
    val countries = arrayOf("IRAN", "GERMANY", "CANADA")


    println("the country code of ${countries[0]} is ${codes[0]}.")
    println("the country code of ${countries[1]} is ${codes[1]}.")

    val ctoc = mapOf("IR" to "IRAN", "DE" to "GERMANY", "CA" to "CANADA")

    println(ctoc["CA"])

    ctoc.keys.forEach { println(it) }
    ctoc.values.forEach { println(it) }

    ctoc.keys.forEach { println(ctoc[it]) }

    if (ctoc.containsKey("IR")) {
        println("The key is available")
    }

    if (!ctoc.containsKey("ZE")) {
        println("The key is NOT available")
    }

    println(ctoc.size)

    val family = hashMapOf(
            "Mina"     to "Sadr",
            "Mohammad" to "Shamsi",
            "Omid"     to "Shamsi")

    println(family.size)
    family["Fancy"] = "Unknown" // since the key does not exist, it will add the new key with its value
    println(family.size)
    println(family["Mina"])
    family["Mina"] = "Shahidi Sadr"  //since the key already exists, it will update the value only
    println(family["Mina"])

    family.put("Mina", "Shahidi") // == hashmap["Mina"] = "Shahidi"

    val x: String? = family["Omid"] // the key may or may not exist. that is way "?" is used
    println("X is : $x")

    val y = family["Kiana"]
    println("Y is : $y")

    val z = family.remove("Fancy")
    println(family.size)
    println("Z is : $z")  // prints "Unknown", because the value of given key (Fancy) is "Unknown"

    val w = family.remove("Kiana")
    println("W is : $w")  // prints null, because there is not key as "Kiana"

    family.forEach { key, value -> println("The value of $key is $value") }

    val parish = mapOf(Pair("Mina", "Sadr"), Pair("Mohammad", "Shamsi"), Pair("Omid", "Shamsi"))
    println(parish["Omid"])
}