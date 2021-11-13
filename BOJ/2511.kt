package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st1 = StringTokenizer(readLine())
    val st2 = StringTokenizer(readLine())
    var numA = 0
    var numB = 0
    var win = 'D'
    repeat(10){
        val left = st1.nextToken().toInt()
        val right = st2.nextToken().toInt()
        if(left < right){
            numB += 3
            win = 'B'
        } else if(left > right){
            numA += 3
            win = 'A'
        } else{
            numA++
            numB++
        }
    }
    println("$numA $numB\n$win")
}
