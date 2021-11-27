package test

fun main() = with(System.`in`.bufferedReader()) {
    val dp = Array(31){0L}
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2
    for(i in 3..30){
        for(j in 0 until i){
            dp[i] += dp[j] * dp[i - j - 1]
        }
    }

    val sb = StringBuilder()
    while(true){
        val n = readLine().toInt()
        if(n == 0) break
        sb.append("${dp[n]}\n")
    }
    print(sb.toString())
}
