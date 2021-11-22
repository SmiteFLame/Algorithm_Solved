package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var answer = 0
    for(i in 0..n){
        for(j in i..n){
            answer += i + j
        }
    }
    print(answer)
}
