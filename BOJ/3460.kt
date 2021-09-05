package test

import java.lang.StringBuilder
import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        var now = readLine().toInt()
        var cnt = 0
        while (now > 0) {
            if (now % 2 == 1) {
                sb.append("$cnt ")
            }
            now /= 2
            cnt++
        }
        sb.append("\n")
    }
    print(sb.toString())
}
