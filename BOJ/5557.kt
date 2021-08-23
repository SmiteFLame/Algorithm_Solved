package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var N = readLine().toInt()
    var DP = Array<LongArray>(N + 1) { LongArray(21) }
    var st = StringTokenizer(readLine())
    var array = Array<Int>(N + 1) { 0 }
    for (i in 1..N) {
        array[i] = st.nextToken().toInt()
    }
    DP[1][array[1]] = 1
    for(i in 2..N){
        for(j in 0..20){
            if(DP[i - 1][j] < 0) continue
            if(j - array[i] >= 0){
                DP[i][j - array[i]] += DP[i - 1][j]
            }
            if(j + array[i] <= 20){
                DP[i][j + array[i]] += DP[i - 1][j]
            }
        }
    }
    print(DP[N - 1][array[N]])
}