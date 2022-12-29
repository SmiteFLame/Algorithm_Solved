package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val loop = readLine().toInt()
    var sum = 0
    for(i in 0 until loop){
        val str = StringTokenizer(readLine())
        val price = str.nextToken().toInt()
        val count = str.nextToken().toInt()
        sum += price * count
    }

    println(if(sum == n) "Yes" else "No")
}
