package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val arrayA = Array<Int>(10) { 0 }
    val arrayB = Array<Int>(10) { 0 }
    for (i in 0 until 10) {
        arrayA[i] = readLine().toInt()
    }
    for (i in 0 until 10) {
        arrayB[i] = readLine().toInt()
    }
    Arrays.sort(arrayA)
    Arrays.sort(arrayB)
    var sumA = 0
    var sumB = 0
    for(i in 9 downTo 7){
        sumA += arrayA[i]
        sumB += arrayB[i]
    }
    print("$sumA $sumB")
}
