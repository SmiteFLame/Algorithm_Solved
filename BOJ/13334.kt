package test

import java.util.*
import kotlin.collections.ArrayList

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arrayList = ArrayList<Pair<Int, Int>>()

    for(i in 0 until n){
        val st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        if(x > y){
            arrayList.add(Pair(y, x))
        } else{
            arrayList.add(Pair(x, y))
        }
    }

    val d = readLine().toInt()

    arrayList.sortBy { it.second }

    val pQueue = PriorityQueue<Int>()
    var answer = 0
    for(i in 0 until n){
        pQueue.offer(arrayList[i].first)
        while(!pQueue.isEmpty() && pQueue.peek() < arrayList[i].second- d) pQueue.poll();
        answer = answer.coerceAtLeast(pQueue.size)
    }

    print(answer)
}


