package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt() * 2
    val c = st.nextToken().toInt() * 3
    val array = Array(101) { 0 }
    val truck = Array(3) { Array(2) { 0 } }
    var min = 101
    var max = 0
    for (i in 0 until 3) {
        st = StringTokenizer(readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        for(j in start until end){
            array[j]++
        }
        min = min.coerceAtMost(start)
        max = max.coerceAtLeast(end)
    }

    var answer = 0
    for(i in min until max){
        when(array[i]){
            1 -> answer += a
            2 -> answer += b
            3 -> answer += c
        }
    }

    print(answer)
}
