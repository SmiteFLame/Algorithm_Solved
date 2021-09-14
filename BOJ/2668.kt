package test

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

var array = IntArray(0)
var visited = BooleanArray(0)
var answer = ArrayList<Int>()

fun DFS(now: Int, next: Int) {
    if (!visited[array[now]]) {
        visited[array[now]] = true
        DFS(array[now], next)
        visited[array[now]] = false
    }
    if (array[now] == next) {
        answer.add(next)
    }
}


fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    visited = BooleanArray(N + 1)
    array = IntArray(N + 1)
    for (i in 1..N) {
        array[i] = readLine().toInt()
    }
    for (i in 1..N) {
        visited[i] = true
        DFS(i, i)
        visited[i] = false
    }
    answer.sorted()

    var sb = StringBuilder()
    sb.append("${answer.size}\n")
    answer.forEach { v ->
        sb.append("$v\n")
    }
    print(sb.toString())
}
