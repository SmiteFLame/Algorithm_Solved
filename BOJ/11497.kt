package test

import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val st = StringTokenizer(readLine())
        val pQueue = PriorityQueue<Int>()
        repeat(n) {
            pQueue.add(st.nextToken().toInt())
        }

        val result = Array(n) { 0 }
        result[n / 2] = pQueue.poll()
        var left = n / 2 - 1
        var right = n / 2 + 1
        while (!pQueue.isEmpty()) {
            if (right < n) result[right++] = pQueue.poll()
            if (left >= 0) result[left--] = pQueue.poll()
        }

        var max = abs(result[0] - result[n - 1])
        for (i in 1 until n) {
            max = abs(result[i] - result[i - 1]).coerceAtLeast(max)
        }
        sb.append("$max\n")
    }
    print(sb.toString())
}
