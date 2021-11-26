package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = StringTokenizer(readLine()).nextToken().toInt()
    val sb = StringBuilder()
    repeat(n){
        sb.append(readLine().reversed()).append("\n")
    }
    print(sb.toString())
}
