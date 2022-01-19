package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toInt() + 1
    val b = st.nextToken().toInt() + 1
    val c = st.nextToken().toInt() + 1
    print(a * b / c - 1)
}
