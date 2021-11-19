package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    print((st.nextToken().toInt() * st.nextToken().toInt()) + (st.nextToken().toInt() * st.nextToken().toInt()))
}
