package test

import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dot = 1 + 2.0.pow(n.toDouble()).toLong()
    print(dot * dot)
}
