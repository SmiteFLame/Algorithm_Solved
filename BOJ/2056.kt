package test

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = Array(n + 1){0}
    var answer = 0
    for (i in 1..n) {
        val st = StringTokenizer(readLine())
        val time: Int = st.nextToken().toInt()
        val num: Int = st.nextToken().toInt()
        dp[i] = time
        for (j in 0 until num) {
            val temp: Int = st.nextToken().toInt()

            dp[i] = dp[i].coerceAtLeast(dp[temp] + time)
        }
        answer = answer.coerceAtLeast(dp[i])
    }
    print(answer)
}