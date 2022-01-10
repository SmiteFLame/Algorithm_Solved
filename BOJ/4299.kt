package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    if( a < b){
        println(-1)
    } else{
        val x = (a + b) / 2
        val y = (a - b) / 2
        if(x + y == a && x - y == b){
            println("$x $y")
        } else{
            println(-1)
        }
    }
}
