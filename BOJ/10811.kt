package test

import java.util.*
import java.util.stream.Collector

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val array = Array(n + 1) { 0 }
    for (i in 1..n) {
        array[i] = i
    }

    repeat(m) {
        st = StringTokenizer(readLine())
        val left = st.nextToken().toInt()
        val right = st.nextToken().toInt() + 1
        val temp = Array(right - left + 1) { 0 }
        for(i in 0 until (right - left)){
            temp[i] = array[left + i]
        }
        for(i in 0 until (right - left)){
            array[right - i - 1] = temp[i]
        }
    }
    for (i in 1..n) {
        print("${array[i]} ")
    }
}
