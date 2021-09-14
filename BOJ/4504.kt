package test

import java.lang.StringBuilder
import java.util.*
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    while(true){
        val now = readLine().toInt()
        if(now == 0){
            print(sb.toString())
            return
        }
        if(now % n != 0){
            sb.append("$now is NOT a multiple of $n.\n")
        } else{
            sb.append("$now is a multiple of $n.\n")
        }
    }
}
