package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var ary = IntArray(5)
    var sum = 0
    for(i in 0 until 5){
        ary[i] = readLine().toInt()
        sum += ary[i]
    }
    println(sum / 5)
    Arrays.sort(ary)
    println(ary[2])
}