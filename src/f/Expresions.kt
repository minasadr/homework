package f

abstract class Expr {
    abstract fun eval(): Int
}

abstract class Unary(val expr: Expr) : Expr()

class Negate(expr: Expr) : Unary(expr) {
    override fun eval(): Int {
        return -expr.eval()
    }

    override fun toString(): String {
        return "-$expr"
    }
}

class Num(val num: Int) : Expr() {
    override fun eval(): Int {
        return num
    }

    override fun toString(): String {
        return "$num"
    }
}

abstract class Binary(val first: Expr, val second: Expr) : Expr()

class Sum(first: Expr, second: Expr) : Binary(first, second) {
    override fun eval(): Int {
        return first.eval() + second.eval()
    }

    override fun toString(): String {
        return "$first + $second"
    }
}

class Sub(first: Expr, second: Expr) : Binary(first, second) {
    override fun eval(): Int {
        return first.eval() - second.eval()
    }

    override fun toString(): String {
        return "$first - $second"
    }
}

class Mul(first: Expr, second: Expr) : Binary(first, second) {
    override fun eval(): Int {
        return first.eval() * second.eval()
    }

    override fun toString(): String {
        return "$first * $second"
    }
}

class Div(first: Expr, second: Expr) : Binary(first, second) {
    override fun eval(): Int {
        return first.eval() / second.eval()
    }

    override fun toString(): String {
        return "$first / $second"
    }
}

class Mod(first: Expr, second: Expr) : Binary(first, second) {
    override fun eval(): Int {
        return first.eval() % second.eval()
    }

    override fun toString(): String {
        return "$first % $second"
    }
}

fun main(args: Array<String>) {
    val x = Negate(Num(5))

    println(x)
    println(x.eval())

    val y = Sum(Num(5), Num(3))
    println(y)
    println(y.eval())

    val z = Sum(Num(5), Negate(Num(2)))
    println(z)
    println(z.eval())
    println(Negate(z).eval())

    // 4 + (3 * 2) - (11 % 3)
    val m = Sum(Num(4), Sub(Mul(Num(3), Num(2)), Mod(Num(11), Num(3))))
    println(m)
    println(m.eval())

    val d = Div(Num(4), Num(2))
    println(d)
    println(d.eval())

}