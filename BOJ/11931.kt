package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    repeat(readLine().toInt()){
        pq.offer(readLine().toInt())
    }
    while(!pq.isEmpty()){
        sb.append("${pq.poll()}\n")
    }
    print(sb.toString())
}
