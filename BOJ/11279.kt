package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val priorityQueue = PriorityQueue<Int>(reverseOrder())
    val sb = StringBuilder()
    for(i in 0 until n){
        val number = readLine().toInt()
        priorityQueue.add(number)
        if(number == 0){
            sb.append(priorityQueue.poll()).append("\n")
        }
    }
    println(sb.toString())
}
