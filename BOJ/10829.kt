package test

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toLong()
    val sb = StringBuilder()

    while (n > 0) {
        sb.insert(0, (n % 2).toInt())
        n /= 2
    }
    print(sb.toString())
}
