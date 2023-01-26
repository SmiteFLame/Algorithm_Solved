package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var left = 0
    var right = 0
    var sum = 0
    var count = 0
    while (left <= n) {
        if (sum == n) {
            count++
            sum += right
            right++
        } else if (sum > n) {
            sum -= left
            left++
        } else {
            sum += right
            right++
        }
    }
    println(count)
}
