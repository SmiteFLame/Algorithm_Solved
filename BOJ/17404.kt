package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n) { Array(3) { 0 } }
    val dp = Array(n) { Array(3) { 0L } }

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        for (j in 0 until 3) {
            array[i][j] = st.nextToken().toInt()
        }
    }

    var answer = Long.MAX_VALUE
    for (x in 0 until 3) {
        for (i in 0 until 3) {
            dp[0][i] = if (i == x) array[0][i].toLong()
            else Int.MAX_VALUE.toLong()
        }
        for(i in 1 until n){
            dp[i][0] = dp[i - 1][1].coerceAtMost(dp[i - 1][2]) + array[i][0]
            dp[i][1] = dp[i - 1][2].coerceAtMost(dp[i - 1][0]) + array[i][1]
            dp[i][2] = dp[i - 1][0].coerceAtMost(dp[i - 1][1]) + array[i][2]
        }

        for(i in 0 until 3){
            if(i != x) answer = answer.coerceAtMost(dp[n - 1][i])
        }

    }

    print(answer)
}
