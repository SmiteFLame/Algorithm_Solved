package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val pair = Array(n + 1) { Array(n + 1) { false } }
    repeat(m) {
        st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        pair[x][y] = true
        pair[y][x] = true
    }

    var answer = 0
    for (i in 1..n) {
        for (j in (i + 1)..n) {
            if (pair[i][j]) continue
            for (k in (j + 1)..n) {
                if (pair[k][i] || pair[j][k]) continue
                answer++
            }
        }
    }
    print(answer)
}
