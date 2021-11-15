package test

fun main() = with(System.`in`.bufferedReader()) {
    val y = readLine().toInt()
    val m = readLine().toInt()
    print(2 * m - y)
}
