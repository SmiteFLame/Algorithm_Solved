package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()
    var answer = 0
    while(n > 0){
        if(n % 5 == 0){
            answer += n / 5
            break
        }
        n -= 2
        answer++
    }
    if(n < 0){
        print(-1)
    } else{
        print(answer)
    }
}
