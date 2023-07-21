package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = ArrayList<Int>()
    repeat(n) {
        val now = readLine().toInt()
        array.add(now)
    }
    array.sort()
    val sb = StringBuilder()
    array.forEach { now ->
        sb.append("$now\n")
    }
    println(sb.toString())
}
