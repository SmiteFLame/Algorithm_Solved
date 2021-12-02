package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pQueue = PriorityQueue(Comparator<Pair<Long, Long>>{ o1, o2 ->
        o1.first.compareTo(o2.first)
    })

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        pQueue.offer(Pair(st.nextToken().toLong(), st.nextToken().toLong()))
    }
    
    val first = pQueue.poll()
    var min = first.first
    var max = first.second

    var len = max - min
    while(!pQueue.isEmpty()){
        val now = pQueue.poll()
        len += if (min <= now.first && now.second <= max) {
            continue
        } else if (now.first < max) {
            now.second - max
        } else {
            now.second - now.first
        }
        min = now.first
        max = now.second
    }
    println(len)
}