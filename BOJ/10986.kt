package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val array = Array(m) { 0L }

    var sum = 0
    st = StringTokenizer((readLine()))
    (0 until n).forEach { _ ->
        sum = (sum + st.nextToken().toInt()) % m
        array[sum]++
    }
    var answer = array[0]
    array.forEach { i ->
        answer += i * (i - 1) / 2
    }
    println(answer)
}
