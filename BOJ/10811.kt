package test

import java.util.*
import java.util.stream.Collector

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val array = Array(n + 1) {0}
    for(i in 1..n){
        array[i] = i
    }

    repeat(m){
        st = StringTokenizer(readLine())
        val left = st.nextToken().toInt()
        val right = st.nextToken().toInt()
        val temp = array[left]
        array[left] = array[right]
        array[right] = temp
    }
    for(i in 1..n){
        print("${array[i]} ")
    }
}
