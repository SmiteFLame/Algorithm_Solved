package test

import java.lang.StringBuilder
import java.util.*



fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val array = Array<Int>(N) { 0 }
    var answer = 0L
    var minus = 0
    for (i in 0 until N) {
        array[i] = readLine().toInt()
        if(array[i] <= 0) minus++
    }
    Arrays.sort(array)

    for(i in 1 until minus step 2){
        answer += (array[i - 1] * array[i])
    }

    if(minus % 2 == 1){
        answer += array[minus - 1]
    }

    if((N - minus) % 2 == 1){
        answer += array[minus]
    }

    for(i in N - 1 downTo minus + 1 step 2){
        var mul = array[i] * array[i - 1]
        var sum = array[i] + array[i - 1]
        if(mul > sum){
            answer += mul
        } else{
            answer += sum
        }
    }
    print(answer)
}
