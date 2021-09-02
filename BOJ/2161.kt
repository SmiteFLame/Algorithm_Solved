package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var sb = StringBuilder()
    var queue = LinkedList<Int>()
    for(i in 1..readLine().toInt()){
        queue.add(i)
    }
    var boolean = false
    while(!queue.isEmpty()){
        if(boolean){
            queue.offer(queue.poll())
        } else{
            sb.append(queue.poll()).append(" ")
        }
        boolean = !boolean
    }
    print(sb.toString())
}