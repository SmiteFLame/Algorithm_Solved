package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    repeat(n){
        val st = StringTokenizer(readLine())
      sb.append(2 - st.nextToken().toInt() + st.nextToken().toInt()).append("\n")
    }
    println(sb.toString())
}
