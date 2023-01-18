package test

import java.util.*
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = LinkedList<Pair<Int, Int>>()
    var maxDay = 0

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        val day = st.nextToken().toInt()
        val work = st.nextToken().toInt()
        list.add(Pair(day, work))
        maxDay = max(maxDay, day)
    }

    var sum = 0

    for (i in maxDay downTo 1) {
        var ans = Pair(0, 0)
        list.forEach { now ->
            if (now.first >= i) {
                if (ans.second < now.second) {
                    ans = now
                }
            }
        }
        sum += ans.second
        list.remove(ans)
    }
    println(sum)
}
