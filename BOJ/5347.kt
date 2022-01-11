package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    fun gcd(a: Long, b: Long): Long {
        if (a % b == 0L) {
            return b
        }
        return gcd(b, a % b)
    }

    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toLong()
        val b = st.nextToken().toLong()
        val gcd = if (a > b) gcd(a, b)
        else gcd(b, a)
        sb.append("${a * b / gcd}\n")
    }
    print(sb.toString())
}
