package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    print((n / 2 + 1) * (n - n / 2 + 1))
}
