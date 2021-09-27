package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    for(i in 0..n){
        val nowA = a * i
        for(j in 0..n){
            val nowB = b * j
            for(k in 0..n){
                val nowC = c * k
                if(nowA + nowB + nowC == n){
                    print(1)
                    return
                }
            }
        }
    }
    print(0)
}