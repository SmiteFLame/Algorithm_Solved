package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    var N = st.nextToken().toInt()
    var M = st.nextToken().toInt()
    var six = ArrayList<Int>(M)
    var one = ArrayList<Int>(M)
    repeat(M) {
        st = StringTokenizer(readLine())
        six.add(st.nextToken().toInt())
        one.add(st.nextToken().toInt())
    }
    six.sort()
    one.sort()
    print((((N / 6) + 1) * six[0]).coerceAtMost(((N / 6) * six[0] + (N % 6) * one[0]).coerceAtMost(N * one[0])))
}