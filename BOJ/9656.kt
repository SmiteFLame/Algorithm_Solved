package test

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val DP = IntArray(1010) { 0 }
    DP[1] = 0
    DP[2] = 1
    DP[3] = 0
    for(i in 4..N){
        if(DP[i - 1] == 0 || DP[i - 3] == 0) DP[i] = 1
        else DP[i] = 0
    }
    if(DP[N] == 1) print("SK")
    else print("CY")
}
