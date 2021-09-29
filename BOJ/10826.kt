package test

import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    if (n < 2) {
        print(n)
    } else {
        val dp = Array<BigInteger>(n + 1) { BigInteger.ZERO }
        dp[1] = BigInteger.ONE
        for(i in 2..n){
            dp[i] = dp[i - 2].add(dp[i - 1])
        }
        print(dp[n])
    }
}