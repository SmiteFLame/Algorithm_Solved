package test

fun main() = with(System.`in`.bufferedReader()) {
    val now = readLine()
    println(now[readLine().toInt() - 1])
}
