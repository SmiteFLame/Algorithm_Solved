package test

import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val d = st.nextToken().toInt()
    println(abs((a + d) - (b + c)))
}
