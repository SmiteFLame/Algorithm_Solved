package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var winner = readLine().toInt()
    val pQ = PriorityQueue<Int>(reverseOrder())
    (1 until n).forEach { _ ->
        pQ.add(readLine().toInt())
    }

    var answer = 0
    while(pQ.isNotEmpty()){
        var now = pQ.poll()
        if(winner + answer > now){
            break
        }
        answer++
        pQ.add(now - 1)
    }

    println(answer)
}
