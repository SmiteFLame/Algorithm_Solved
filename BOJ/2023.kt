package test

import kotlin.math.sqrt


fun main() = with(System.`in`.bufferedReader()) {

    val sb = StringBuilder()

    fun isPrime(num: Int): Boolean {
        if (num == 1) return false
        val sqrt = sqrt(num.toDouble()).toInt()
        for (i in 2..sqrt) {
            if (num % i == 0) return false
        }
        return true
    }
    fun dfs(idx: Int, num: String, n: Int) {
        if (idx == n) {
            sb.append("$num\n")
            return
        }
        for (i in 1..9) {
            if (isPrime(Integer.valueOf(num + i))) dfs(idx + 1, num + i, n)
        }
    }

    val n = readLine().toInt()
    dfs(0, "", n)
    print(sb.toString())
}
