package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val array = Array(n + 1){0}
    for(i in 1..n){
        array[i] = i
    }
    repeat(st.nextToken().toInt()){
        st = StringTokenizer(readLine())
        val i = st.nextToken().toInt()
        val j = st.nextToken().toInt()
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
    val sb = StringBuilder()
    for(i in 1..n){
        sb.append("${array[i]} ")
    }
    print(sb.toString())
}
