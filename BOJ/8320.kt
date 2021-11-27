package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var cnt = 0
    for (i in 1..n){
        for (j in 1..i){
            if (i * j <= n){
                cnt++
            }
        }
    }
    println(cnt)
}
