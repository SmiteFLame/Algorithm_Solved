package test

import java.util.*
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val test = readLine().toInt()
    val sb = StringBuilder()
    (0 until test).forEach { _ ->
        var st = StringTokenizer(readLine())
        val leftCount = st.nextToken().toInt()
        val rightCount = st.nextToken().toInt()
        val leftArray = Array(leftCount) { 0 }
        val rightArray = Array(rightCount) { 0 }

        st = StringTokenizer(readLine())
        (0 until leftCount).forEach { i ->
            leftArray[i] = st.nextToken().toInt()
        }

        st = StringTokenizer(readLine())
        (0 until rightCount).forEach { i ->
            rightArray[i] = st.nextToken().toInt()
        }
        rightArray.sort()

        var count = 0
        leftArray.forEach { i ->
            var start = 0
            var end = rightCount - 1
            var now = -1
            while (start <= end) {
                val mid = (start + end) / 2
                if (i > rightArray[mid]) {
                    start = mid + 1
                    now = max(now, mid)
                } else {
                    end = mid - 1
                }
            }
            count += now + 1
        }
        sb.append(count).append("\n")
    }
    println(sb.toString())
}
