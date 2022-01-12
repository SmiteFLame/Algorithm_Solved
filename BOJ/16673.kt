package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val c = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val p = st.nextToken().toInt()
    print(k * c * (c + 1) / 2 + p * c * (c + 1) * (2 * c + 1) / 6)
}
