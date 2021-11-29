package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    print(n * (n - 1))
}
