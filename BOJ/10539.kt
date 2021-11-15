package test

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n){0}
    val st = StringTokenizer(readLine())

    for(i in 0 until n){
        array[i] = st.nextToken().toInt()
    }

    var count = 2
    var sum = 0
    for(i in 1 until n){
        sum = array[i] * count
        for(j in 0 until i){
            sum -= array[j]
        }
        count++
        array[i] = sum
    }
    for(i in 0 until n){
        print("${array[i]} ")
    }
}
