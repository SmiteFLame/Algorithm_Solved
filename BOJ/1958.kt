package test

fun main() = with(System.`in`.bufferedReader()) {
    val a = readLine()
    val b = readLine()
    val c = readLine()

    val dp = Array(a.length + 1) { Array(b.length + 1) { Array(c.length + 1) { 0 } } }

    for (i in 1..a.length) {
        val ch1 = a[i - 1]
        for (j in 1..b.length) {
            val ch2 = b[j - 1]
            for (k in 1..c.length) {
                val ch3 = c[k - 1]
                dp[i][j][k] = if (ch1 == ch2 && ch2 == ch3) dp[i - 1][j - 1][k - 1] + 1
                else dp[i - 1][j][k].coerceAtLeast(dp[i][j - 1][k].coerceAtLeast(dp[i][j][k - 1]))
            }
        }
    }

    print(dp[a.length][b.length][c.length])
}
