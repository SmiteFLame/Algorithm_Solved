package test

import java.util.*
import kotlin.collections.ArrayList

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    val array = Array(n + 1) { ArrayList<Int>() }
    for (i in 1..n) {
        array[i] = ArrayList()
    }
    for (i in 0 until m) {
        st = StringTokenizer(readLine())
        val left = st.nextToken().toInt()
        val right = st.nextToken().toInt()
        array[left].add(right)
        array[right].add(left)
    }
    val answer = Array(n + 1){0}

    array.forEach { it.sort() }

    var count = 1
    val queue = LinkedList<Int>()
    queue.push(r)

    while(queue.isNotEmpty()){
        val now = queue.pop()
        if(answer[now] != 0) continue
        answer[now] = count++
        array[now].forEach {
            queue.add(it)
        }
    }


    for(i in 1..n){
        println(answer[i])
    }
}
