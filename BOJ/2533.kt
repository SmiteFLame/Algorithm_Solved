package test

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

var dp = Array<Array<Int>>(0) { Array<Int>(2) { 0 } }
var list = Array<ArrayList<Int>>(0) { ArrayList() }

fun check(now: Int, parent: Int) {
    dp[now][0] = 0
    dp[now][1] = 1
    list[now].forEach { next ->
        if(next != parent){
            check(next, now)
            dp[now][0] += dp[next][1]
            dp[now][1] += min(dp[next][0], dp[next][1])
        }
    }

}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    dp = Array<Array<Int>>(n + 1) { Array<Int>(2) { 0 } }
    list = Array<ArrayList<Int>>(n + 1) { ArrayList() }
    for (i in 0 until n - 1) {
        val st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        list[x].add(y)
        list[y].add(x)
    }

    check(1, -1)

    print(min(dp[1][0], dp[1][1]))
}
