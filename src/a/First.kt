package a


fun main(args: Array<String>) {
    val a: Int = 2
    val b: Int = 0b11111111  // 0b or 0B is binary indicator
    val x: Int = 0xff   // 0x or 0X is hexadecimal indicator

    println("the value of a is '$a' and the value of b is '$b'.")
    // println("the value of a is '" + a + "' and the value of b is '" + b + "'.")
    println("the value of x is '$x'.")
}