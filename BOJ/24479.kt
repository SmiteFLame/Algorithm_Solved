package test

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    val visited = Array(n + 1) { false }
    val canVisited = Array(n + 1) { LinkedList<Int>() }
    val count = Array(n + 1) { 0 }
    var idx = 1

    (0 until m).forEach { _ ->
        st = StringTokenizer(readLine())
        val left = st.nextToken().toInt()
        val right = st.nextToken().toInt()
        canVisited[left].add(right)
        canVisited[right].add(left)
    }
    canVisited.forEach { i ->
        i.sort()
    }

    val sb = StringBuilder()
    fun dfs(now: Int){
        visited[now] = true
        count[now] = idx
        idx++
        canVisited[now].forEach { i ->
            if(!visited[i]){
                dfs(i)
            }
        }
    }

    dfs(r)
    (1..n).forEach { i ->
        sb.append("${count[i]}\n")
    }
    println(sb.toString())
}
