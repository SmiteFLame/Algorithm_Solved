package test

import java.lang.StringBuilder
import java.util.*

var N = 0
var DP = Array<IntArray>(0) { IntArray(0) }
var data = Array<IntArray>(0) { IntArray(0) }
val MAX = 16000000

fun DFS(now: Int, visit : Int) : Int{
    if(visit == (1 shl N) - 1){
        if(data[now][0] == 0) return MAX
        return data[now][0]
    }

    if(DP[now][visit] != MAX){
        return DP[now][visit]
    }

    for(i in 0 until N){
        if((visit and (1 shl i)) == 0 && data[now][i] != 0){
            DP[now][visit] = DP[now][visit].coerceAtMost(DFS(i, (visit or (1 shl i))) + data[now][i])
        }
    }
    return DP[now][visit]
}


fun main() = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    DP = Array<IntArray>(N) { IntArray((1 shl N) - 1) }
    data = Array<IntArray>(N) { IntArray(N) }
    for(i in 0 until N){
        Arrays.fill(DP[i], MAX)
        var st = StringTokenizer(readLine())
        for(j in 0 until N){
            data[i][j] = st.nextToken().toInt()
        }
    }

    print(DFS(0, 1))
}