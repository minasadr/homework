package b

fun main(args: Array<String>) {
    var passWord: String = ""
    var invalid = true

    do {
        println("pick a password")
        passWord = readLine()!!
        if (passWord.length >= 8) {
            var hasUpperCase = false
            var hasLowerCase = false
            var hasDigit = false
            for (n in passWord) {
                if (n in 'a'..'z') {
                    hasLowerCase = true
                }
                if (n in 'A'..'Z') {
                    hasUpperCase = true
                }
                if (n in  '0'..'9') {
                    hasDigit = true
                }
            }
            if (hasDigit && hasUpperCase && hasLowerCase) {
                invalid = false
            }
        }
    } while (invalid )  // invalid == true
    println("your password ($passWord)is OK")
}