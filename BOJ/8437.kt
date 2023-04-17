package test

import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val total = BigInteger(readLine())
    val diff = BigInteger(readLine())
    println(total.subtract(diff).divide(BigInteger("2")).add(diff))
    println(total.subtract(diff).divide(BigInteger("2")))
}
