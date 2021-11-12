package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = Array(n + 1) { 0 }
    dp[1] = 1
    for (i in 2..n) {
        var min = Int.MAX_VALUE
        var j = 1
        while (j * j <= i) {
            min = min.coerceAtMost(dp[i - j * j])
            j++
        }

        dp[i] = min + 1
    }
    print(dp[n])
}
