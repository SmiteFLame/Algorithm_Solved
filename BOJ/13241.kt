package test

import java.util.*

fun gcd(a: Long, b: Long): Long {
    var A = a
    var B = b
    while (B > 0) {
        val tmp = A
        A = B
        B = tmp % B
    }
    return A
}

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()

    print((a * b) / gcd(a.coerceAtLeast(b), a.coerceAtMost(b)))
}