package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val array = Array<Int>(n + 1) { 0 }
    val dp = Array<Int>(n + 1) { Int.MAX_VALUE }
    for (i in 1..n) {
        array[i] = st.nextToken().toInt()
    }
    dp[0] = 0
    for (i in 1..n) {
        for (j in 1..i) {
            dp[i] = dp[i].coerceAtMost(dp[i - j] + array[j])
        }
    }
    print(dp[n])
}
