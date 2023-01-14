package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    var sum = st.nextToken().toInt() * 56
    sum += st.nextToken().toInt() * 24
    sum += st.nextToken().toInt() * 14
    sum += st.nextToken().toInt() * 6
    println(sum)
}
