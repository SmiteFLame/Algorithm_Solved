package test

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.roundToInt

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var sum = 0
    val array = Array(n) { 0 }
    val map = HashMap<Int, Int>()
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE

    for (i in 0 until n) {
        val now = readLine().toInt()
        sum += now
        array[i] = now
        map.putIfAbsent(now, 0)
        map[now] = map[now]!! + 1
        max = max.coerceAtLeast(now)
        min = min.coerceAtMost(now)
    }

    var maxN = 0
    val maxList = ArrayList<Int>()

    map.forEach{ (k,v) ->
        if(v > maxN){
            maxN = v
            maxList.clear()
            maxList.add(k)
        } else if(v == maxN){
            maxList.add(k)
        }
    }

    array.sort()

    val many = if(maxList.size == 1){
        maxList[0]
    } else{
        maxList.sort()
        maxList[1]
    }

    val sb = StringBuilder()
    sb.append("${(sum.toDouble() / n).roundToInt()}\n${array[n / 2]}\n$many \n${max - min}")
    print(sb.toString())
}
