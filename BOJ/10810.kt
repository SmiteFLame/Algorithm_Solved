package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val array = Array(n){0}
    for(i in 0 until m){
        st = StringTokenizer(readLine())
        val left = st.nextToken().toInt() - 1
        val right = st.nextToken().toInt() - 1
        val ball = st.nextToken().toInt()
        for(j in left..right){
            array[j] = ball
        }
    }
    array.forEach { print("$it ") }
}
