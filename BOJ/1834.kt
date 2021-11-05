package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toLong()
    var sum = 0L
    for (i in 1 until n) {
        sum += (n + 1) * i
    }
    print(sum)
}