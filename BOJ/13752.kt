package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        repeat(readLine().toInt()){
            sb.append("=")
        }
        sb.append("\n")
    }
    print(sb.toString())
}
