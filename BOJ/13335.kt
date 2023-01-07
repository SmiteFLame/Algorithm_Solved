package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val w = st.nextToken().toInt()
    val l = st.nextToken().toInt()

    val truck = LinkedList<Int>()
    st = StringTokenizer(readLine())

    (0 until n).forEach { _ ->
        truck.push(st.nextToken().toInt())
    }

    var time = 0
    var weight = 0

    val queue = LinkedList<Int>()
    (0 until w).forEach { _ ->
        queue.add(0)
    }

    while(!queue.isEmpty()){
        time++
        weight -= queue.poll()
        if(!truck.isEmpty()){
            val next = truck.peek()
            if(next + weight <= l){
                weight += next
                queue.add(truck.poll())
            } else {
                queue.add(0)
            }
        }
    }
    println(time)
}
