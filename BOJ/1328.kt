package test

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val div = 1000000007
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val l = st.nextToken().toInt()
    val r = st.nextToken().toInt()

    val dp = Array(n + 1) { Array(n + 1) { Array(n + 1) { 0L } } }

    dp[1][1][1] = 1
    for (i in 2..n) {
        dp[i][1][i] = 1
        dp[i][i][1] = 1
        for (j in 1..l) {
            for (k in 1..r) {
                dp[i][j][k] = (dp[i - 1][j][k - 1] + dp[i - 1][j - 1][k]
                        + (dp[i - 1][j][k] * (i - 2))) % div;
            }
        }
    }
    println(dp[n][l][r])
}
