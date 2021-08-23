package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var N = readLine().toInt()
    var sb = StringBuilder()
    for(i in 0 until N){
        for(j in 0 until N * 2){
            if((i + j) % 2 == 0){
                sb.append("*")
            } else{
                sb.append(" ")
            }
        }
        sb.append("\n")
    }
    print(sb.toString())
}