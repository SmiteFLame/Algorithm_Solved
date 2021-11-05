package test

import java.lang.StringBuilder
import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    repeat(n){
        val st = StringTokenizer(readLine())
        val left = st.nextToken()
        val right = st.nextToken()
        sb.append("Distances: ")
        for(i in left.indices){
            var now = right[i] - left[i]
            if(now < 0){
                now += 26
            }
            sb.append("$now ")
        }
        sb.append("\n")
    }
    print(sb.toString())
}