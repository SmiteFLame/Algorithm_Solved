package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val array = Array(n + 1) { Array(n + 1) { 0 } }
    repeat(k){
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        array[a][b] = -1
        array[b][a] = 1
    }
    for(k in 1..n){
        for(i in 1..n){
            for(j in 1..n){
                if(array[i][j] != 0) continue
                if(array[i][k] == array[k][j]){
                    array[i][j] = array[i][k]
                }
            }
        }
    }
    val s = readLine().toInt()
    val sb = StringBuilder()
    repeat(s){
        st = StringTokenizer(readLine())
        sb.append("${array[st.nextToken().toInt()][st.nextToken().toInt()]}\n")
    }
    print(sb.toString())
}