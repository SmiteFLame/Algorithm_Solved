package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val array = Array(c + 1) { false }
    for (i in 0 until n) {
        val x = readLine().toInt()
        for (j in 1..(c / x)) {
            array[j * x] = true
        }
    }
    var cnt = 0
    for (i in 1..c) {
        if (array[i]) {
            cnt++
        }
    }
    print(cnt)
} 
