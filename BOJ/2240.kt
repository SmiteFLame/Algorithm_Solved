package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val t = st.nextToken().toInt()
    val w = st.nextToken().toInt()
    val dp = Array(t + 1) { Array(w + 1) { 0 } }

    for (i in 1..t) {
        val now = readLine().toInt()
        for (j in 0..w) {
            if (j == 0) {
                dp[i][j] = if (now == 1) {
                    dp[i - 1][j] + 1
                } else {
                    dp[i - 1][j]
                }
                continue
            }

            dp[i][j] = if ((j + now) % 2 == 0) {
                dp[i - 1][j].coerceAtLeast(dp[i - 1][j - 1] + 1)
            } else {
                dp[i - 1][j - 1].coerceAtLeast(dp[i - 1][j] + 1)
            }
        }
    }

    var answer = 0

    for (i in 0..w) {
        answer = answer.coerceAtLeast(dp[t][i])
    }
    print(answer)
}
