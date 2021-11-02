package test

import java.util.*
import kotlin.collections.ArrayList

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val x = st.nextToken().toInt()
    val arrayLists = Array(n + 1) { ArrayList<Int>() }
    val count = Array(n + 1) { Int.MAX_VALUE }
    repeat(m) {
        st = StringTokenizer(readLine())
        arrayLists[st.nextToken().toInt()].add(st.nextToken().toInt())
    }
    val queue = LinkedList<Int>()
    queue.add(x)
    count[x] = 0
    while (!queue.isEmpty()) {
        val now = queue.poll()
        arrayLists[now].forEach { next ->
            if (count[next] == Int.MAX_VALUE) {
                count[next] = count[now] + 1
                queue.add(next)
            }
        }
    }

    val answer = ArrayList<Int>()
    for(i in 1..n){
        if(count[i] == k){
            answer.add(i)
        }
    }
    if(answer.size == 0){
        print(-1)
    } else{
        answer.forEach { now ->
            println(now)
        }
    }
}