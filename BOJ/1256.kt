package test

import java.util.*

lateinit var dp: Array<Array<Double>>
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    dp = Array(n + 1) { Array(m + 1) { 0.0 } }

    if (k > check(m, m)) {
        sb.append("-1");
    } else {
        subset(n, m, (k - 1).toDouble());
    }

    print(sb.toString())

}

fun check(A: Int, Z: Int): Double {
    if (A == 0 || Z == 0) return 1.0
    return if (dp[A][Z] != 0.0) {
        dp[A][Z]
    } else {
        (check(A - 1, Z) + check(A, Z - 1)).coerceAtMost(1000000001.0)
            .also { dp[A][Z] = it }
    }
}

fun subset(A: Int, Z: Int, before: Double) {
    if (A == 0) {
        for (i in 0 until Z) sb.append("z")
        return
    }
    if (Z == 0) {
        for (i in 0 until A) sb.append("a")
        return
    }
    val tmp = check(A - 1, Z)
    if (before < tmp) {
        sb.append("a")
        subset(A - 1, Z, before)
    } else {
        sb.append("z")
        subset(A, Z - 1, before - tmp)
    }
}
