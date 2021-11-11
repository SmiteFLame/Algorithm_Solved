package test

import java.lang.StringBuilder
import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val deque = ArrayDeque<Pair<Int, Int>>()
    for(i in 1..n){
        deque.add(Pair(i, st.nextToken().toInt()))
    }

    val sb = StringBuilder()
    while(!deque.isEmpty()){
        sb.append("${deque.first.first} ")
        var now = deque.poll().second
        if(deque.isEmpty()) break
        if(now > 0){
            now -= 1
            for(i in 0 until now){
                deque.addLast(deque.pollFirst())
            }
        } else{
            for(i in 0 until abs(now)){
                deque.addFirst(deque.pollLast())
            }
        }
    }
    print(sb.toString())
}
