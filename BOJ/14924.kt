package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val s = st.nextToken().toInt()
    val t = st.nextToken().toInt()
    val d = st.nextToken().toInt()
    print(d / (2 * s) * t)
}
