package test

import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n + 1) { BigInteger.ZERO }
    array[0] = BigInteger.ONE
    array[1] = BigInteger.ONE
    if(n > 1) {
        array[2] = BigInteger.ONE
    }

    fun fibonacci(n: Int): BigInteger {
        if (array[n] != BigInteger.ZERO) return array[n]
        array[n] = fibonacci(n - 1) + fibonacci(n - 2)
        return array[n]
    }
    if (n < 3) {
        println(array[0])
    } else {
        println(fibonacci(n))
    }
}
