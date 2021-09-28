fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toLong()
    print((1 + 4 * n + 3 * n * (n - 1) / 2) % 45678)
}