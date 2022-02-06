package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = Array(n) { Array(n) { 0 } }
    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        for (j in 0 until n) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    var answer = Int.MAX_VALUE

    val visited = Array(n + 1) { false }

    fun dfs(start: Int, now: Int, sum: Int, cnt: Int) {
        if (cnt == n && start == now) {
            answer = sum.coerceAtMost(answer)
            return
        }

        if (sum > answer) {
            return
        }

        for (i in 0 until n) {
            if (visited[i]) continue
            if (map[now][i] == 0) continue
            visited[i] = true
            dfs(start, i, sum + map[now][i], cnt + 1)
            visited[i] = false
        }
    }

    for (i in 0 until n) {
        visited.fill(false)
        dfs(i, i, 0, 0)
    }

    println(answer)

}
