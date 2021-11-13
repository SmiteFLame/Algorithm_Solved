package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine(), ",")
    var sum = 0
    while(st.hasMoreTokens()){
        sum += st.nextToken().toInt()
    }
    println(sum)
}
