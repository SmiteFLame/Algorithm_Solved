package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    var left = 0
    var right = 0
    for(i in 0 until str.length / 2){
        left += str[i].toInt()
        right += str[i + str.length / 2].toInt()
    }
    if(left == right){
        print("LUCKY")
    } else{
        print("READY")
    }
}
