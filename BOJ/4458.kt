package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val str = readLine()
        sb.append("${str[0].toUpperCase()}${str.substring(1)}\n")
    }
    print(sb.toString())
}
