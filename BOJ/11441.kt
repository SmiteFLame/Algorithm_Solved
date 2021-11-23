package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n) { 0 }
    val sum = Array(n + 1) { 0 }

    var st = StringTokenizer(readLine())
    for (i in 0 until n) {
        array[i] = st.nextToken().toInt()
        sum[i + 1] = sum[i] + array[i]
    }

    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        st = StringTokenizer(readLine())
        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        sb.append("${sum[e] - sum[s - 1]}\n")
    }
    print(sb.toString())
}
