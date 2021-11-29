package test

import java.util.*
import kotlin.math.abs


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val w = readLine().toInt()

    val dp = Array(w + 1) { Array(w + 1) { 0 } }
    val pos = Array(w + 1) { Pair(0, 0) }
    for (i in 1..w) {
        val st = StringTokenizer(readLine())
        pos[i] = Pair(st.nextToken().toInt(), st.nextToken().toInt())
    }

    fun distance(type: Int, start: Int, end: Int): Int {
        var xs: Int = pos[start].first
        var ys: Int = pos[start].second
        val xe: Int = pos[end].first
        val ye: Int = pos[end].second
        if (start == 0) {
            if (type == 1) {
                ys = 1
                xs = ys
            } else {
                ys = n
                xs = ys
            }
        }
        return abs(xs - xe) + abs(ys - ye)
    }

    fun policeSolution(event: Int, first: Int, second: Int): Int {
        if (event > w) return 0
        if (dp[first][second] != 0) return dp[first][second]
        val one: Int = policeSolution(event + 1, event, second) + distance(1, first, event)
        val two: Int = policeSolution(event + 1, first, event) + distance(2, second, event)
        dp[first][second] = one.coerceAtMost(two)
        return dp[first][second]
    }

    println(policeSolution(1, 0, 0))
    var firstidx = 0
    var secondidx = 0

    for (i in 1..w) {
        val dist1 = distance(1, firstidx, i)
        if (dp[firstidx][secondidx] - dist1 == dp[i][secondidx]) {
            firstidx = i
            println(1)
        } else {
            secondidx = i
            println(2)
        }
    }

}
