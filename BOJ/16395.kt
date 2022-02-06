package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    fun combination(nt: Int, kt: Int): Int {
        if (nt == kt || kt == 0) return 1
        return combination(nt - 1, kt - 1) + combination(nt - 1, kt)
    }
    println(combination(n - 1, k - 1))
}
