package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val s = readLine()
    val dp = Array(m) { 0 }
    var ans = 0

    for (i in 1 until m - 1) {
        if (s[i] == 'O' && s[i + 1] == 'I') {
            dp[i + 1] = dp[i - 1] + 1
            if (dp[i + 1] >= n && s[i - 2 * n + 1] == 'I') ans++
        }
    }
    println(ans)
}
