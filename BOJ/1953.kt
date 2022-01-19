package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n + 1) { LinkedList<Int>() }
    for (i in 1..n) {
        val st = StringTokenizer(readLine())
        repeat(st.nextToken().toInt()) {
            array[i].add(st.nextToken().toInt())
        }
    }
    val visited = Array(n + 1) { false }
    val blue = LinkedList<Int>()
    val white = LinkedList<Int>()

    val queue = LinkedList<Pair<Int, Boolean>>()
    for(i in 1..n) {
        if(visited[i]) continue
        blue.add(i)
        queue.add(Pair(i, true))
        visited[i] = true
        while (!queue.isEmpty()) {
            val now = queue.poll()
            array[now.first].forEach { next ->
                if (!visited[next]) {
                    if (now.second) {
                        white.add(next)
                    } else {
                        blue.add(next)
                    }
                    queue.add(Pair(next, !now.second))
                    visited[next] = true
                }
            }
        }
    }
    blue.sort()
    white.sort()
    val sb = StringBuilder()
    sb.append("${blue.size}\n")
    blue.forEach{ now ->
        sb.append("$now ")
    }
    sb.append("\n")
    sb.append("${white.size}\n")
    white.forEach{ now ->
        sb.append("$now ")
    }
    sb.append("\n")
    print(sb.toString())
}
