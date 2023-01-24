package test

import kotlin.text.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    (0 until n step 4).forEach { _ ->
        sb.append("long ")
    }
    sb.append("int")
    println(sb.toString())
}
