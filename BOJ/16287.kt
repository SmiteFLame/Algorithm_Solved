package test

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    val w = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    val weight = IntArray(n)
    val dp = IntArray(799995)
    st = StringTokenizer(readLine())
    for (i in 0 until n) weight[i] = st.nextToken().toInt()

    Arrays.sort(weight)

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val tmp = weight[i] + weight[j]
            if (tmp > w) continue
            dp[tmp] = j
            if (dp[w - tmp] != 0 && dp[w - tmp] > j) {
                println("YES")
                return
            }
        }
    }

    println("NO")
}
