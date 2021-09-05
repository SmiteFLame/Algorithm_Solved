package test

import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val mario = Stack<Int>()
    var sum = 0
    repeat(10){
        val now = readLine().toInt()
        mario.add(now)
        sum += now
    }
    var answer = sum
    while(!mario.isEmpty()){
        sum -= mario.pop()
        if(sum > 100){
            answer = sum
        } else{
            if(abs(answer - 100) > abs(sum - 100)){
                answer = sum
            }
            break
        }
    }
    print(answer)
}
