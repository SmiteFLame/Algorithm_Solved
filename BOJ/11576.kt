package test

import java.lang.StringBuilder
import java.util.*
import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val n = readLine().toInt()
    st = StringTokenizer(readLine())
    var next = 0
    for (i in n - 1 downTo  0) {
        next += (st.nextToken().toInt() * a.toDouble().pow(i).toInt())
    }
    val answer = LinkedList<Int>()
    while (next != 0) {
        answer.add(next % b)
        next /= b
    }
    answer.reversed().forEach { now ->
        print("$now ")
    }
}