package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    (1..n).forEach { i ->
        sb.append("$i. ${readLine()}").append("\n")
    }
    println(sb.toString())
}
