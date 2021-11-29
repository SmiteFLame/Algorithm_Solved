package test

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arrayList = Array(n + 1) { ArrayList<Pair<Int, Int>>() }
    repeat(n - 1) {
        val st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        arrayList[x].add(Pair(y, w))
        arrayList[y].add(Pair(x, w))
    }

    val visited = Array(n + 1) { false }
    val level = Array(n + 1) { 0 }
    val dist = Array(n + 1) { 0 }
    val dp = Array(n + 1) { Array(17) { 0 } }
    fun dfs(now: Int, parent: Int) {
        visited[now] = true
        level[now] = level[parent] + 1
        arrayList[now].forEach { next ->
            if (!visited[next.first]) {
                visited[next.first] = true
                dp[next.first][0] = now
                dist[next.first] = dist[now] + next.second
                dfs(next.first, now)
            }
        }
    }
    dfs(1, 0)

    for (i in 1..16) {
        for (j in 1..n) {
            dp[j][i] = dp[dp[j][i - 1]][i - 1]
        }
    }

    fun lca(left: Int, right: Int): Int {
        var x = left
        var y = right
        for (i in 16 downTo 0) {
            if (2.0.pow(i) <= level[x] - level[y]) {
                x = dp[x][i]
            }
        }

        if (x == y) {
            return x
        }

        for (i in 16 downTo 0) {
            if (dp[x][i] != dp[y][i]) {
                x = dp[x][i]
                y = dp[y][i]
            }
        }
        return dp[x][0]
    }

    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        val answer = if(level[x] < level[y]){
            lca(y, x)
        } else{
            lca(x, y)
        }
        sb.append("${dist[x] + dist[y] - 2 * dist[answer]}\n")
    }
    print(sb.toString())
}


