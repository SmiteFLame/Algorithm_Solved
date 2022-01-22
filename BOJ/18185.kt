package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val array = Array(n) { 0 }
    for(i in 0 until n){
        array[i] = st.nextToken().toInt()
    }

    var answer = 0
    for(i in 0 until n - 2){
        if(array[i + 1] > array[i + 2]){
            val x = array[i].coerceAtMost(array[i + 1] - array[i + 2])
            answer += (x * 5)
            array[i] -= x
            array[i + 1] -= x
        }
        if(array[i] > 0 && array[i + 1] > 0 && array[i + 2] > 0){
            val x = array[i].coerceAtMost(array[i + 1])
            answer += (x * 7)
            array[i] -= x
            array[i + 1] -= x
            array[i + 2] -= x
        }
        if(array[i] > 0){
            answer += (array[i] * 3)
        }
    }
    val x = array[n - 2].coerceAtMost(array[n - 1])
    answer += (x * 5)
    array[n - 2] -= x
    array[n - 1] -= x
    answer += (array[n - 1] * 3)
    answer += (array[n - 2] * 3)
    print(answer)
}
