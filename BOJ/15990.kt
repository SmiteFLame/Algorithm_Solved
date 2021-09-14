package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var DP = Array<LongArray>(100001) { LongArray(4) }
    DP[1][1] = 1
    DP[2][2] = 1
    DP[3][1] = 1
    DP[3][2] = 1
    DP[3][3] = 1
    for(i in 4..100000){
        DP[i][1] = (DP[i - 1][2] + DP[i - 1][3]) % 1000000009
        DP[i][2] = (DP[i - 2][3] + DP[i - 2][1]) % 1000000009
        DP[i][3] = (DP[i - 3][1] + DP[i - 3][2]) % 1000000009
    }

    var sb = StringBuilder()
    repeat(readLine().toInt()) {
        val N = readLine().toInt()
        sb.append("${(DP[N][1] + DP[N][2] + DP[N][3]) % 1000000009}\n")
    }
    print(sb.toString())
}
