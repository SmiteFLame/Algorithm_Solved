package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while(true){
        val st = StringTokenizer(readLine())
        val m = st.nextToken().toInt()
        val f = st.nextToken().toInt()
        if(m == 0 && f == 0) break
        sb.append("${m + f}\n")
    }
    print(sb.toString())
}