package test

import java.util.*




fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val array = Array(n) { Array(m) { 0 } }
    val dp = Array(n) { Array(m) { Array(3){0} } }

    for (i in 0 until n) {
        st = StringTokenizer(readLine())
        for (j in 0 until m) {
            array[i][j] = st.nextToken().toInt()
        }
    }

    dp[0][0][0] = array[0][0]
    for (i in 0 until m - 1) {
        dp[0][i + 1][0] = dp[0][i][0] + array[0][i + 1]
    }

    for (i in 1 until n) {
        dp[i][0][1] = dp[i - 1][0][0] + array[i][0]

        for (j in 1 until m) {
            dp[i][j][1] = dp[i - 1][j][0].coerceAtLeast(dp[i][j - 1][1]) + array[i][j]
        }

        dp[i][m - 1][2] = dp[i - 1][m - 1][0] + array[i][m - 1]

        for (j in m - 2 downTo -1 + 1) {
            dp[i][j][2] = dp[i - 1][j][0].coerceAtLeast(dp[i][j + 1][2]) + array[i][j]
        }

        for (j in 0 until m) {
            dp[i][j][0] = dp[i][j][1].coerceAtLeast(dp[i][j][2])
        }
    }
    print(dp[n - 1][m - 1][0])
}
