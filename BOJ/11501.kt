package test

import java.lang.StringBuilder
import java.util.*
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val tc = readLine().toInt()
    val sb = StringBuilder()
    (0 until tc).forEach { _ ->
        val n = readLine().toInt()
        val st = StringTokenizer(readLine())
        val array = Array(n) { 0 }
        (0 until n).forEach { i ->
            array[i] = st.nextToken().toInt()
        }
        var now = 0
        var sum = 0L
        (n - 1 downTo 0).forEach { i ->
            now = max(now, array[i])
            sum += now - array[i]
        }
        sb.append(sum).append("\n")
    }
    println(sb.toString())
}
