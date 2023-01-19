package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    (0 until n).forEach { _ ->
        val st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        var count = 0

        for (j in n..m) {
            var t: Int = j
            if (t == 0) {
                count++
                continue
            }
            while (t > 1) {
                if (t % 10 == 0) {
                    count++
                }
                t /= 10
            }
        }
        sb.append(count).append("\n")
    }
    println(sb.toString())
}
