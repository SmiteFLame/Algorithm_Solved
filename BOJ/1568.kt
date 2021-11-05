package test

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()
    var cnt = 1
    var answer = 0
    while(n > 0){
        answer++
        if(n < cnt){
            cnt = 1
        }
        n -= cnt
        cnt++
    }
    print(answer)
}