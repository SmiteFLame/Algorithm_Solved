package test

import java.util.*
import kotlin.Comparator
import kotlin.math.pow
import kotlin.math.sqrt

data class Star(
    val n: Int,
    val x: Double,
    val y: Double
)

data class Edge(
    val s: Int,
    val e: Int,
    val c: Double
)

var parent = Array<Int>(0) { 0 }

fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int): Boolean {
    val px = find(x)
    val py = find(y)
    if (px == py) return false
    parent[px] = py
    return true
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val stars = Array<Star>(n) { Star(0, 0.0, 0.0) }
    parent = Array<Int>(n + 1) { 0 }
    for (i in 0 until n) {
        parent[i] = i
    }
    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        stars[i] = Star(i, st.nextToken().toDouble(), st.nextToken().toDouble())
    }
    val pQueue = PriorityQueue { p1: Edge, p2 : Edge ->
        p1.c.compareTo(p2.c)
    }

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            pQueue.offer(Edge(i, j, sqrt((stars[i].x - stars[j].x).pow(2.0) + (stars[i].y - stars[j].y).pow(2.0))))
        }
    }

    var answer = 0.0
    while (!pQueue.isEmpty()) {
        val now = pQueue.poll()
        if (union(now.s, now.e)) {
            answer += now.c
        }
    }
    print(String.format("%.2f", answer))
}
