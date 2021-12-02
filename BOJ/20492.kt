package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    print("${(n * 0.78).toInt()} ${(n * 0.956).toInt()}")
}