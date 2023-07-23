package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var answer = 1L
    for(i in 1..n){
        answer *= i
    }
    println(answer)
}
