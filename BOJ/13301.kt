package test

import java.util.*
import kotlin.collections.ArrayList

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val fibo = ArrayList<Long>()
    val answer = ArrayList<Long>()
    fibo.add(1L)
    fibo.add(1L)
    for(i in 2 until n){
        fibo.add(fibo[i - 1] + fibo[i - 2])
    }
    answer.add(4)
    for(i in 1 until n){
        answer.add(answer[i - 1] + 2 * fibo[i])
    }
    print(answer[n - 1])
}
