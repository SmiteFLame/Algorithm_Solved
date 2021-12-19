package test

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    val n = str.length
    val visited = Array(n + 1) { Array(n + 1) { false } }

    for(i in 1..n){
        for(j in i..n){
            var check = true
            var start = i - 1
            var end = j - 1
            while(start <= end){
                if(str[start++] != str[end--]){
                    check = false
                    break
                }
            }
            if(check){
                visited[i][j] = true
            }
        }
    }

    val dp = Array(n + 1) { Int.MAX_VALUE }
    dp[0] = 0
    for(i in 1..n){
        for(j in 1..i){
            if(visited[j][i]){
                dp[i] = dp[i].coerceAtMost(dp[j - 1] + 1)
            }
        }
    }

    print(dp[n])

}
