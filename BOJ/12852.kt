package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()
    val dp = Array<Int>(n + 1) { Int.MAX_VALUE }
    val path = Array<Int>(n + 1) { 0 }
    dp[1] = 0
    for(i in 2..n){
        if(i % 3 == 0 && dp[i / 3] + 1 < dp[i]){
            dp[i] = dp[i / 3] + 1
            path[i] = i / 3
        }
        if(i % 2 == 0 && dp[i / 2] + 1 < dp[i]){
            dp[i] = dp[i / 2] + 1
            path[i] = i / 2
        }
        if(dp[i - 1] + 1 < dp[i]){
            dp[i] = dp[i - 1] + 1
            path[i] = i - 1
        }
    }

    val sb = StringBuilder()
    sb.append("${dp[n]}\n")
    while(n > 0){
        sb.append("$n ")
        n = path[n]
    }
    print(sb.toString())
}
