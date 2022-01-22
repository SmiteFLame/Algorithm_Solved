package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val str = readLine()
    val sb = StringBuilder()
    for(i in str.indices step n){
        sb.append(str[i])
    }
    print(sb.toString())
}
