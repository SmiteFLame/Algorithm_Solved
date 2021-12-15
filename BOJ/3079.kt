package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val array = Array(n) { 0L }
    var answer = Long.MAX_VALUE
    var left = 0L
    var right = 0L
    for (i in 0 until n) {
        array[i] = readLine().toLong()
        right = right.coerceAtLeast(array[i])
    }

    right *= m

    while (left <= right) {
        val mid = (left + right) / 2
        var sum = 0L
        for (i in array) {
            if (sum >= m) break
            sum += mid / i
        }
        if (sum >= m) {
            answer = answer.coerceAtMost(mid)
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    print(answer)
}
