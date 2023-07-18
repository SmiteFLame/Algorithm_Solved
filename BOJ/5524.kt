package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    repeat(n){
        sb.append(readLine().toLowerCase()).append("\n")
    }
    println(sb.toString())
}
