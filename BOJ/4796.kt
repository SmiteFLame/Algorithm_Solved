package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var sb = StringBuilder("")
    var case = 1
    while(true){
        var st = StringTokenizer(readLine())
        var L = st.nextToken().toInt()
        var P = st.nextToken().toInt()
        var V = st.nextToken().toInt()
        if(L == 0 && P == 0 && V == 0) break
        var ans = 0
        while(V >= P){
            V -= P
            ans += L
        }
        if(V > L) ans += L
        else ans += V
        sb.append("Case $case: $ans\n")
        case++
    }
    println(sb.toString())
}