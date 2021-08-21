package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    var N = readLine()
    var DP = LongArray(N.length + 1)
    DP[0] = 1L
    DP[1] = 1L
    if(N[0] == '0'){
        print(0)
        return
    }
    for(i in 1 until  N.length){
        if(N[i] != '0'){
            DP[i + 1] += DP[i]
            DP[i + 1] %= 1000000L
        }
        if(N[i - 1] == '0' || (N[i - 1] =='2' && N[i] >'6') || N[i - 1] > '2') continue

        DP[i + 1] += DP[i - 1]
        DP[i + 1] %= 1000000L
    }
    print(DP[N.length])
}