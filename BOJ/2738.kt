package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val array = Array(n) { Array(m) { 0 } }
    repeat(2){
        for(i in 0 until n){
            val st = StringTokenizer(readLine())
            for(j in 0 until m){
                array[i][j] += st.nextToken().toInt()
            }
        }
    }
    val sb = StringBuilder()
    for(i in 0 until n){
        for(j in 0 until m){
            sb.append("${array[i][j]} ")
        }
        sb.append("\n")
    }
    print(sb.toString())
}
