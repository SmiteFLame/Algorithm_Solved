package test

import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    val item = Array(n) { 0 }
    val road = Array(n) { Array(n) { Int.MAX_VALUE } }

    st = StringTokenizer(readLine())
    (0 until n).forEach { i ->
        road[i][i] = 0
        item[i] = st.nextToken().toInt()
    }

    (0 until r).forEach { _ ->
        st = StringTokenizer(readLine())
        val left = st.nextToken().toInt() - 1
        val right = st.nextToken().toInt() - 1
        val number = st.nextToken().toInt()
        road[left][right] = number
        road[right][left] = number
    }

    (0 until n).forEach { k ->
        (0 until n).forEach { i ->
            (0 until n).forEach { j ->
                if (road[i][k] != Int.MAX_VALUE && road[k][j] != Int.MAX_VALUE) {
                    road[i][j] = min(road[i][j], road[i][k] + road[k][j])
                }
            }
        }
    }
    var maxItem = 0
    (0 until n).forEach { i ->
        var now = 0
        (0 until n).forEach{ j ->
            if(road[i][j] <= m){
                now += item[j]
            }
        }
        maxItem = max(now, maxItem)
    }

    println(maxItem)
}
