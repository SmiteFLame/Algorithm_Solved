package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val st = StringTokenizer(readLine())
        val money = Array<Int>(n + 1) { 0 }
        for (i in 1..n) {
            money[i] = st.nextToken().toInt()
        }
        val want = readLine().toInt()
        val dp = Array<Int>(want + 1) { 0 }
        dp[0] = 1
        for(i in 1..n){
            for(j in money[i]..want){
                dp[j] += dp[j - money[i]]
            }
        }
        sb.append("${dp[want]}\n")
    }
    print(sb.toString())
}