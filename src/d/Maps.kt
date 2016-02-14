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

    val hashmap = hashMapOf("Mina" to "Sadr", "Mohammad" to "Shamsi", "Omid" to "Shamsi")
    println(hashmap.size)
    hashmap["Fancy"] = "Unknown" // since the key does not exist, it will add the new key with its value
    println(hashmap.size)
    println(hashmap["Mina"])
    hashmap["Mina"] = "Shahidi Sadr"  //since the key already exists, it will update the value only
    println(hashmap["Mina"])

    hashmap.put("Mina", "Shahidi") // == hashmap["Mina"] = "Shahidi"

    val x:String? = hashmap["Omid"] // the key may or may not exist. that is way "?" is used
    println("X is : $x")

    val y = hashmap["Kiana"]
    println("Y is : $y")

    val z = hashmap.remove("Fancy")
    println(hashmap.size)
    println("Z is : $z")

    val w = hashmap.remove("Kiana")
    println("W is : $w")

    hashmap.forEach { key, value -> println("The value of $key is $value") }

    val parish = mapOf(Pair("Mina", "Sadr"), Pair("Mohammad", "Shamsi"), Pair("Omid", "Shamsi"))
    println(parish["Omid"])
}