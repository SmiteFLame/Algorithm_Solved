package test

import java.lang.StringBuilder
import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    (1..3).forEach { _ ->
        val count = readLine().toInt()
        var sum = BigInteger.ZERO
        (0 until count).forEach { _ ->
            sum = sum.add(BigInteger(readLine()))
        }
        sb.append(
            if (sum.compareTo(BigInteger.ZERO) == -1) '-'
            else if (sum.compareTo(BigInteger.ZERO) == 1) '+'
            else 0
        ).append("\n")
    }
    println(sb.toString())
}
