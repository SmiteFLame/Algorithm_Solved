package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val c = readLine().toInt()

    if (a + b < c * 2) {
        println(a + b)
    } else {
        println(a + b - c * 2)
    }
}
