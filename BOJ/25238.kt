package test

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    println(if (a * (100 - b) >= 10000) "0" else "1")
}
